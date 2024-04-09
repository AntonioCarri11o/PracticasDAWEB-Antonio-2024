import VueRouter from 'vue-router';
import Vue from 'vue';
Vue.use(VueRouter);

import Login from '../components/Login.vue';
import Admin from '../components/Admin.vue';
import Editor from '../components/Editor.vue';
import Viewer from '../components/Viewer.vue';
import Unauthorized from '../components/Unauthorized.vue';
import NotFound from '../components/NotFound.vue';
import { jwtDecode } from 'jwt-decode';

const routes = [
    {
        path: '/',
        redirect: '/login'
    },
    {
        name: 'login',
        path: 'login',
        component: Login
    },
    {
        name: 'admin',
        path: '/admin',
        component: Admin,
        meta: { role: 'admin '}
    },
    {
        name: 'editor',
        path: '/editor',
        component: Editor,
        meta: { role: 'editor '}
    },
    {
        name: 'viewer',
        path: '/viewer',
        component: Viewer,
        meta: { role: 'viewer'}
    },
    {
        path: '*',
        component: () => import('../components/Error.vue')
    },
    {
        name: 'unauthorized',
        path: '/unauthorized',
        component: Unauthorized
    },
    {
        path: '/:catchAll(.*)',
        name: 'NotFound',
        component: NotFound
    },
    {
        path: '/inicio',
        component: () => import('../components/inicio/Inicio.vue'),
        children: [
            {
                path: '/toys',
                name: 'toys',
                component: () => import('../components/tienda/ToyStore.vue')
            },
            {
                path: '/toys/electronics',
                name: 'electronics',
                component: () => import('../components/tienda/ElectronicToys.vue')
            },
            {
                path: '/toys/electronics/videogames',
                name: 'videogames',
                component: () => import('../components/tienda/Videogames.vue')
            },
            {
                path: '/appliances',
                name: 'appliances',
                component: () => import('../components/tienda/HomeAppliances.vue')
            },
            {
                path: '/appliances/kitchen',
                name: 'kitchen',
                component: () => import('../components/tienda/Kitchen.vue')
            },
            {
                path: '/appliances/kitchen/stoves',
                name: 'stoves',
                component: () => import('../components/tienda/Stoves.vue')
            },
            {
                path: '/homeProducts',
                name: 'homeProducts',
                component: () => import('../components/tienda/HomeProducts.vue')
            },
            {
                path: '/homeProducts/cleanProducts',
                name: 'cleanProducts',
                component: () => import('../components/tienda/CleanProducts.vue')
            },
            {
                path: '/homeProducts/cleanProducts/industrial',
                name: 'industrial',
                component: () => import('../components/tienda/Industrial.vue')
            },
            {
                path: '/form',
                name: 'form',
                component: () => import('../components/Formulario.vue')
            },
            {
                path: '/paginacion',
                name: 'paginacion',
                component: () => import('../components/Persona.vue')
            },
            {
                path: '/estilos',
                name: 'estilos',
                component: () => import('../components/ManejoEstilos.vue')
            },
        ]
    }
]
const router =  new VueRouter({ routes });
router.beforeEach((to, from, next) => {
    const publicPages = ['/login', '/', '/unauthorized'];
    const authRequired = !publicPages.includes(to.path);
    const loggedIn = localStorage.getItem('token');

    if(authRequired && !loggedIn) {
        return next('/login');
    }

    if (loggedIn) {
        const decoded = jwtDecode(loggedIn);
        const role = decoded.role;
        if (to.meta.role && to.meta.role !== role) {
            return next('/unauthorized');
        }
    }
    next();
});
export default router;
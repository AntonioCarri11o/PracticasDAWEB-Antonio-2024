import VueRouter from 'vue-router';
import Vue from 'vue';
Vue.use(VueRouter);
const routes = [
    {
        path: '/',
        component: () => import('../components/LandPage.vue')
    },
    {
        path: '*',
        component: () => import('../components/Error.vue')
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
        ]
    }
]
const router =  new VueRouter({ routes });
export default router;
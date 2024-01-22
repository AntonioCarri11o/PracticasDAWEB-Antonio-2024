import VueRouter from 'vue-router';
import Vue from 'vue';
Vue.use(VueRouter);
const routes = [
    {
        path: '/',
        redirect: '/inicio'
    },    
    {
        path: '/',
        component: {
            render(c) {
                return c('router-view');
            },
        },
        children: [
            {
                path: '/inicio',
                name: 'inicio',
                component: () => import('../components/inicio/Inicio.vue')
            },
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
            }
        ]
    },
]
const router =  new VueRouter({ routes });
export default router;
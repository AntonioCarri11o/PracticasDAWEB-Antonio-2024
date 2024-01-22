<script>
import SmartBreadcrumb from '../navigation/SmartBreadCrumb.vue';
export default {
    components: {
        SmartBreadcrumb
    },
    data() {
        return {
            items: [
                {
                    text: 'Productos para el hogar',
                    href: '#/homeProducts',
                },
                {
                    text: 'Productos de limpieza',
                    href: '#/homeProducts/cleanProducts',
                },
            ]
        }
    }
}
</script>
<template>
    <div class="component-container">
        <SmartBreadcrumb :items="items"></SmartBreadcrumb>
        <div class="component-content">
                <router-link to="/homeProducts/cleanProducts/industrial">
                    <div class="item">
                        <img src="https://www.winterhalter.com/fileadmin/_processed_/8/7/csm_MX_-_CL_DETERGENTES_PARA_LAVAVAJILLAS_INDUSTRIALES_f00f360d8c.jpg" alt="">
                        <p>Detergentes industriales</p>
                    </div>
                </router-link>
        </div>
    </div>
</template>
<style scoped>
</style>

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
                    text: 'Electrodomésticos',
                    href: '#/appliances',
                },
                {
                    text: 'Para la cocina',
                    href: '#/appliances/kitchen'
                }
            ]
        }
    }
}
</script>
<template>
    <div class="component-container">
        <SmartBreadcrumb :items="items"></SmartBreadcrumb>
        <div class="component-content">
                <router-link to="/appliances/kitchen/stoves">
                    <div class="item">
                        <img src="https://wallpapercave.com/wp/wp4200186.jpg" alt="">
                        <p>Estufas</p>
                    </div>
                </router-link>
        </div>
    </div>
</template>
<style scoped>
</style>

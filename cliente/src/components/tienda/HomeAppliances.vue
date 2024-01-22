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
            ]
        }
    }
}
</script>
<template>
    <div class="component-container">
        <SmartBreadcrumb :items="items"></SmartBreadcrumb>
        <div class="component-content">
                <router-link to="/appliances/kitchen">
                    <div class="item">
                        <img src="https://wallpapercave.com/dwp1x/wp9492747.jpg" alt="">
                        <p>Para la cocina</p>
                    </div>
                </router-link>
        </div>
    </div>
</template>
<style scoped>
</style>

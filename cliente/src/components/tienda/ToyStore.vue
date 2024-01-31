<script>
import SmartBreadcrumb from '../navigation/SmartBreadCrumb.vue';
export default {
    components: {
        SmartBreadcrumb
    },
    data() {
        return {
            elements: [
                {
                    text: 'Tienda',
                    href: '#/toys',             
                },
            ]
        }
    }
}
</script>
<template>
    <div class="component-container">
        <SmartBreadcrumb :items="elements"></SmartBreadcrumb>
        <div class="component-content">
                <router-link to="/toys/electronics">
                    <div class="item">
                        <img src="https://wallpapercave.com/wp/wp13411596.jpg" alt="">
                        <p>Electrónicos</p>
                    </div>
                </router-link>
        </div>
    </div>
</template>
<style scoped>
</style>

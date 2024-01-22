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
                    text: 'Tienda',
                    href: '#/toys',             
                },
                {
                    text: 'Electronicos',
                    href: '#/toys/electronics'
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
                <router-link to="/toys/electronics/videogames">
                    <div class="item">
                        <img src="https://wallpapercave.com/wp/rrnueOV.jpg" alt="">
                        <p>Videojuegos</p>
                    </div>
                </router-link>
        </div>
    </div>
</template>
<style scoped>
</style>

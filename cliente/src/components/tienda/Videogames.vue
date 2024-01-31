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
                },
                {
                    text: 'Videojuegos',
                    href: '#/toys/electronics/videogames'
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
            <p>VideoGames component works</p>
        </div>
    </div>
</template>
<style scoped>
</style>

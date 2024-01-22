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
                },
                {
                    text: 'Estufas',
                    href: '#/appliances/kitchen/stoves'
                }
            ]
        }
    }
}
</script>
<template>
    <div class="component-container">
        <SmartBreadcrumb :items="items"></SmartBreadcrumb>
        <p>Stoves component works</p>
    </div>
</template>
<style scoped>
</style>

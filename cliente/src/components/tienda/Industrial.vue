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
                {
                    text: 'Detergetnes industriales',
                    href: '#/homeProducts/cleanProducts/industrial',
                },
            ]
        }
    }
}
</script>
<template>
    <div class="component-container">
        <SmartBreadcrumb :items="items"></SmartBreadcrumb>
        <p>Industrial component works</p>
    </div>
</template>
<style scoped>
</style>

<template>
    <div class="breadcrumb-container">
        <b-breadcrumb :items="items"></b-breadcrumb>
    </div>
</template>
<script>
export default {
    props: ['items'],
    data() {
        return{
            items: this.items
        }
    },
    name:"SmartBreadcrumb"
}
</script>
<style scoped>
.breadcrumb-container {
    width: 100%;
}
</style>
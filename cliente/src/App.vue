<script setup>
import Sidebar from './components/navigation/Sidebar.vue';
import SmartBreadcrumb from './components/navigation/SmartBreadCrumb.vue';
</script>

<template>
  <div id="app" class="principal">
    <Sidebar></Sidebar>
    <div class="content">
      <router-view></router-view>
    </div>
  </div>
</template>

<style scoped>
.principal {
  height: 100%;
  width: 100%;
  display: flex;
}
.content {
  width: 100%;
}
</style>
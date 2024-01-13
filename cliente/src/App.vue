<script setup>
import HelloWorld from './components/HelloWorld.vue'
import TheWelcome from './components/TheWelcome.vue'
</script>

<template>
  <div id="app">
    <div>

</div>
<div>
  <div class="sidebar-container">
    <b-sidebar id="sidebar-1" title="Sidebar" visible left no-header-close>
      <div class="px-3 py-2">
        <p>
          Esta es la primera así es la primera tony-sidebar en vue :D
        </p>
        <b-img src="https://picsum.photos/500/500/?image=54" fluid thumbnail></b-img>
      </div>
    </b-sidebar>
  </div>

    <div class="content">
      <b-nav>
    <b-nav-item active>Active</b-nav-item>
    <b-nav-item>Link</b-nav-item>
    <b-nav-item>Another Link</b-nav-item>
    <b-nav-item disabled>Disabled</b-nav-item>
  </b-nav>
    </div>

  </div>
  </div>
</template>

<style scoped>
.content {
  flex: 1;
  padding-left: 350px;
}
.sidebar-container {
  max-width: 300px;
}
</style>

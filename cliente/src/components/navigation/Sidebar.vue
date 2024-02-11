<template>
    <div class="sidebar-container">
      <b-sidebar id="sidebar-1" title="Menu" visible left no-header-close no-close-on-route-change>
        <div>
          <b-nav style="margin-top: 70px;" vertical class="w-25">
            <b-nav-item active>
              <router-link to="/inicio">Inicio</router-link>
            </b-nav-item>
            <b-nav-item>
              <router-link to="/toys">Tienda</router-link>
            </b-nav-item>
            <b-nav-item>
              <router-link to="/appliances">Electrodomésticos</router-link>
            </b-nav-item>
            <b-nav-item>
              <router-link to="/homeProducts">Productos para el hogar</router-link>
            </b-nav-item>
            <b-nav-item>
              <router-link to="/Estilos">Manejo estilos</router-link>
            </b-nav-item>
          </b-nav>
        </div>
      </b-sidebar>
    </div>
</template>
<style scoped>
.sidebar-container {
  width: 15%;
}
.b-sidebar-outer {
  position: unset;
  height: 100%;
}
b-sidebar {
  position: unset !important;
}

</style>
<script>
export default {
  data() {
    return {
    }
  },
  name: "Sidebar",
}
</script>
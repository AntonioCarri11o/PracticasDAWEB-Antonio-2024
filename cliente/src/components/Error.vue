<template>
    <div class="principal-container flex-column fxa-center">
        <h1 class="super-title">Error 404</h1>
        <br>
        <h1 class="super-subtitle">
            Parece que la esta página no existe :(                
        </h1>
        <button @click="redirect">Volver</button>

    </div>
</template>
<script>
import Vue from 'vue';
export default Vue.extend({
    data() {
        return {};
    },
    methods: {
        redirect: function() {
            //window.location.href = '#/inicio'
            this.$router.push('/inicio')
        }
    }
})
</script>
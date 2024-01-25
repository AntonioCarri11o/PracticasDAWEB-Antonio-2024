<template>
    <div>
        <form id="person"
        @submit="checkForm"
        >
        <p v-if="errors.lenght">
            <b>Error</b>
            <ul>
                <li v-for="error in errors" :key="error">
                    {{ error }}
                </li>
            </ul>
        </p>
        </form>
    </div>
</template>
<script>
const person = new Vue({
    el: 'person',
    data: {
        errors: [],
        name: null,
        age: [],
        bornDate: null,
    },
    methods: {
        checkForm: function(e) {
            if (this.name && this.age) {
                return true;
            }
            if (!this.name) {
                error = true;
                this.errors.push('El nombre es obligatorio');
            }
            if (!this.age) {
                error = true;
                this.errors.push('La edad es obligatoria');                
            }
            e.preventDefault();            
        }
    }
})
</script>
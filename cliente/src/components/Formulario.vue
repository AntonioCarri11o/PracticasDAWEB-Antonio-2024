<template>
    <b-container>
      <div>
        <b-form
          @submit.prevent="checkForm"
          action="https://vuejs.org/"
          method="post"
          novalidate
        >
          <b-alert variant="danger" dismissible :show="errors.length > 0">
            <b>{{
              errors.length > 1
                ? "ATENCIÓN tienes los siguientes errores:"
                : "Cuidado tienes esl siguiente error:"
            }}</b>
            <ul>
              <li v-for="error in errors" :key="error">{{ error }}</li>
            </ul>
          </b-alert>
  
          <b-form-group
            id="name-group"
            label="Nombre"
            label-for="name"
            :state="name ? null : false"
          >
            <b-form-input
              id="name"
              v-model="name"
              type="text"
              name="name"
              required
            ></b-form-input>
          </b-form-group>

          <b-form-group
            id="cp-group"
            label="Código postal"
            label-for="cp"
            :state="cp ? null : false"
          >
            <b-form-input
                v-model="cp"
                type="number"
                name="cp"
                required
            ></b-form-input>
        </b-form-group>
        <b-form-group
            id="st-group"
            label="Calle"
            label-for="st"
            :state="street ? null : false"
          >
            <b-form-input
                v-model="street"
                type="text"
                name="street"
                required
            ></b-form-input>
        </b-form-group>
        <b-form-group
            id="date-group"
            label="Fecha de nacimiento"
            label-for="date"
            :state="validBornDate(bornDate) ? null : false"
          >
            <b-form-input
                v-model="bornDate"
                type="date"
                name="date"
                required
            ></b-form-input>
        </b-form-group>
        <b-form-group
            id="number-group"
            label="Número"
            label-for="number"
            :state="number ? null : false"
          >
            <b-form-input
                v-model="number"
                type="number"
                name="number"
                required
            ></b-form-input>
        </b-form-group>
        <b-form-group
            id="city-group"
            label="Ciudad"
            label-for="city"
            :state="number ? null : false"
          >
            <b-form-input
                v-model="city"
                type="text"
                name="city"
                required
            ></b-form-input>
        </b-form-group>
          <b-form-group
            id="email-group"
            label="Email"
            label-for="email"
            :state="validEmail(email) ? null : false"
          >
            <b-form-input
              id="email"
              v-model="email"
              type="email"
              name="email"
              required
            ></b-form-input>
          </b-form-group>
          <b-form-group
            id="phone-group"
            label="Número telefónico"
            label-for="phone"
            :state="phone_number ? null : false"
          >
            <b-form-input
              id="phone"
              v-model="phone_number"
              type="number"
              name="phone_number"
              required
            ></b-form-input>
          </b-form-group>
          <b-form-group
            id="file-group"
            label="Archivo"
            label-for="file"
          >
            <b-form-file
              id="file"
              v-model="file"
              name="file"
              required
              @change="handleFileChange"
            ></b-form-file>
          </b-form-group>
          <b-button type="submit" variant="primary">Submit</b-button>
        </b-form>
      </div>
    </b-container>
  </template>
  
  
  <script>
  import Vue from "vue";
  
  export default Vue.extend({
    data() {
      return {
        errors: [],
        name: null,
        cp: null,
        street: null,
        number: null,        
        city: null,
        bornDate: null,
        email: null,
        phone_number: null,
        image: null,
        file: null,
      };
    },
    methods: {
        handleFileChange(event) {
            this.file = event.target.files[0];
        },
      checkForm: function (e) {
  
        this.errors = [];
  
        if (!this.name) {
          this.errors.push("El nombre es requerido.");
        } else {
            if (!this.validCompleteName(this.name)) {
                this.errors.push("Es requerido al menos nombre y apellido paterno.");
            }
        }
        if (!this.cp) {
            this.errors.push("El código postal es requerido.");
        }
        if (!this.street) {
            this.errors.push("La calle es requerida.");
        }
        if (!this.city) {
            this.errors.push("La ciudad es requerida.");
        }
        if (!this.number) {
            this.errors.push("El número es requerido.");
        }
        if (!this.bornDate) {
            this.errors.push("La fecha de nacimiento es obligatoria.");
        } else {            
            if (!this.validBornDate(this.bornDate)) {
                this.errors.push("Debes ser mayor de 18 años para acceder.");
            }
            const today = new Date();
            const bornDateToDate = new Date(this.bornDate);
            if (bornDateToDate >= today) {
                this.errors.push("La fecha debe ser menor a la actual.");
            }
        }
        if (!email) {
            this.errors.push("Email requerido");
        } else {
            if (!this.validEmail(this.email)) {
                this.errors.push("Email inválido.");
            }
        }
        if (!this.phone_number) {
            this.errors.push("Número de teléfono requerido.");
        } else {
            if (this.phone_number.length < 10) {
            this.errors.push("Número de teléfono inválido.");
        }
        }
        if (!this.file) {
            this.errors.push("Archivo requerido.");
        } else {
            if (!this.validFile(this.file)) {
            this.errors.push("Formato de archivo inadecuado.");
        }
        }
        if (!this.errors.length) {
          return true;
        }
        e.preventDefault();
      },
  
      //custom validations
      validEmail: function (email) {
        var re =
          /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        return re.test(email);
      },
      validCompleteName: function (name) {
        const elements = name.split(' ');
        return elements.length >= 2;
      },
      validBornDate: function (date) {
        const fecha = new Date(date);
        console.log(fecha.toLocaleDateString());
        const limit = new Date();
        limit.setMonth((new Date().getMonth() - 216));
        return fecha <= limit;
      },
      validFile: function(file) {        
        return file.name.split('.').pop().toLowerCase() == 'png';
      }
    },
  });
  </script>
  
  <style>
  </style>
<template>
  <div class="row justify-content-center">
    <div class="col-md6 col-lg-4">
      <h3>Registro de contacto</h3>
      <br />
      <form v-on:submit.prevent="postRole">
        <div class="mb-3">
          <label for="name">Nombre : </label>
          <input
            id="name"
            name="name"
            type="text"
            placeholder="Digite su nombre "
            class="form-control"
            v-model="name"
          />
        </div>
        <div class="mb-3">
          <label for="lastname">Apellido : </label>
          <input
            id="lastname"
            name="lastname"
            type="text"
            placeholder="Digite su apellido "
            class="form-control"
            v-model="lastname"
          />
        </div>
        <div class="mb-3">
          <label for="phone">Teléfono : </label>
          <input
            id="phone"
            name="phone"
            type="number"
            placeholder="Digite su teléfono "
            class="form-control"
            v-model="phone"
          />
        </div>
        <div class="mb-3">
          <label for="email">Email : </label>
          <input
            id="email"
            name="email"
            type="email"
            placeholder="Digite su email "
            class="form-control"
            v-model="email"
          />
        </div>
        <div class="mb-3">
          <label for="datebirth">Fecha de nacimiento : </label>
          <input
            id="datebirth"
            name="datebirth"
            type="date"
            class="form-control"
            v-model="datebirth"
          />
        </div>

        <div class="text-end">
          <button class="btn btn-success" v-on:click="create()">
            <i class="fas fa-save"></i>&nbsp;Guardar
          </button>
          <a href="/" class="btn btn-light ms-2">
            <i class="fas fa-backward"></i>&nbsp;Cancelar
          </a>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import api from "../logic/api";

export default {
  name: "createContact",
  data() {
    return {
      name: "",
      lastname: "",
      phone: "",
      email: "",
      datebirth: "",
    };
  },
  methods: {
    async create() {
      try {
        if (
          this.name === "" ||
          this.lastname === "" ||
          this.phone === "" ||
          this.email === "" ||
          this.datebirth === ""
        ) {
          alert("Los campos no pueden estar vacios");
        } else {
          await api.create("contact", {
            name: this.name,
            lastname: this.lastname,
            phone: this.phone,
            email: this.email,
            datebirth: this.datebirth,
            created_at: Date.now(),
          });
          alert("Contacto creado");
          window.location = "http://localhost:8081";
        }
      } catch (err) {
        console.log(err);
        alert("El número de teléfono ya existe en la base de datos");
      }
    },
  },
};
</script>

<style scoped></style>

<template>
  <div class="row justify-content-center">
    <div class="col-md6 col-lg-4">
      <h3>Editar contacto</h3>
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
            v-model="contact.name"
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
            v-model="contact.lastname"
          />
        </div>
        <div class="mb-3">
          <label for="phone">Celular : </label>
          <input
            id="phone"
            name="phone"
            type="number"
            placeholder="Digite su celular "
            class="form-control"
            v-model="contact.phone"
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
            v-model="contact.email"
          />
        </div>
        <div class="mb-3">
          <label for="datebirth">Fecha de nacimiento : </label>
          <input
            id="datebirth"
            name="datebirth"
            type="date"
            class="form-control"
            v-model="contact.datebirth"
          />
        </div>

        <div class="text-end">
          <button class="btn btn-success" @click="save()">
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

function getIdContact() {
  const urlSearchParams = new URLSearchParams(window.location.search);
  const id = urlSearchParams.get("id");
  return id;
}

export default {
  name: "createContact",
  data: () => ({
    contact: {
      id: null,
      name: "",
      lastname: "",
      phone: "",
      email: "",
      datebirth: "",
    },
  }),
  async mounted() {
    await this.getContacts();
  },
  methods: {
    async getContacts() {
      try {
        const result = await api.getContact(`contact/${getIdContact()}`);
        const contact = await result.data.data;
        this.contact = {
          id: contact.id,
          name: contact.name,
          lastname: contact.lastname,
          phone: contact.phone,
          email: contact.email,
          datebirth: contact.datebirth,
          created_at: contact.created_at,
        };
      } catch (err) {
        console.log(err);
      }
    },
    async save() {
      try {
        await api.update(`${getIdContact()}`, {
          name: this.contact.name,
          lastname: this.contact.lastname,
          phone: this.contact.phone,
          email: this.contact.email,
          datebirth: this.contact.datebirth,
          created_at: this.contact.created_at,
          updated_at: Date.now(),
        });
        alert("Contacto editado");
        window.location = "http://localhost:8081";
      } catch (err) {
        console.log(err);
        alert("El número de telefono ya existe en la base de datos");
      }
    },
  },
};
</script>

<style scoped></style>

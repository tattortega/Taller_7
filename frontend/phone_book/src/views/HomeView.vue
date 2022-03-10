<template>
  <body>
    <div class="container">
      <h1>Lista de contactos</h1>
      <div class="text-center my-3">
        <a href="/CreateContact" class="btn btn-primary"
          ><i class="fas fa-user-plus"></i>&nbsp;Añadir contacto</a
        >
      </div>
      <table class="table table-hover">
        <thead>
          <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Celular</th>
            <th>Email</th>
            <th>Fecha de Nacimiento</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="contact in contacts" v-bind:key="contact">
            <td>{{ contact.id }}</td>
            <td>{{ contact.name }}</td>
            <td>{{ contact.lastname }}</td>
            <td>{{ contact.phone }}</td>
            <td>{{ contact.email }}</td>
            <td>{{ contact.datebirth }}</td>
            <td>
              <button class="btn btn-warning" @click="editContact(contact)">
                <i class="fas fa-save"></i>&nbsp;Editar
              </button>
              <button class="btn btn-danger" @click="deleteContact(contact)">
                <i class="fas fa-save"></i>&nbsp;Eliminar
              </button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </body>
</template>

<script>
import api from "../logic/api";

export default {
  data() {
    return {
      contacts: [],
    };
  },
  methods: {
    async getContacts() {
      const data = await api.list("contacts");
      this.contacts = data.data.data;
    },
    editContact(contact) {
      window.location.href = "/editContact/id?id=" + contact.id;
    },
    async deleteContact(contact) {
      try {
        await api.delete(`${contact.id}`);
        alert("Contacto eliminado");
        await this.getContacts();
      } catch (err) {
        console.log(err);
      }
    },
  },
  mounted() {
    this.getContacts();
  },
};
</script>

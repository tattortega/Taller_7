import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "../views/HomeView.vue";
import CreateContact from "@/views/CreateContact";
import EditContact from "@/views/EditContact";

Vue.use(VueRouter);

/**
 * Routes
 * @version 1.0.0 2022/03/09
 * @author Ricardo Ortega - tattortega.28@gmail.com
 * @since 1.0.0
 */
const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/createContact",
    name: "createContact",
    component: CreateContact,
  },
  {
    path: "/editContact/:id",
    name: "editContact",
    component: EditContact,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;

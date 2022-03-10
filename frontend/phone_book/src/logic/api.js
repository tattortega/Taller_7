import axios from "axios";

/**
 * Conection to API
 */
const API = "http://localhost:8080";

/**
 * Methods of API
 *
 * @version 1.0.0 2022/03/09
 * @author Ricardo Ortega - tattortega.28@gmail.com
 * @since 1.0.0
 */

export default {
  list(subdir) {
    const ax = `${API}/${subdir}`;
    return axios.get(ax);
  },
  getContact(subdir, object) {
    const ax = `${API}/${subdir}`;
    return axios.get(ax, object);
  },
  create(subdir, object) {
    const ax = `${API}/${subdir}`;
    return axios.post(ax, object);
  },
  update(subdir, object) {
    const ax = `${API}/contact/${subdir}`;
    return axios.put(ax, object);
  },
  delete(subdir) {
    const ax = `${API}/contact/${subdir}`;
    return axios.delete(ax);
  },
};

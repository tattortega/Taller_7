package com.sofka.controller;

import com.sofka.domain.Contact;
import com.sofka.service.ContactService;
import com.sofka.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.regex.Pattern;

/**
 * Routes CRUD
 *
 * @version 1.0.0 2022/03/09
 * @author Ricardo Ortega - tattortega.28@gmail.com
 * @since 1.0.0
 */
@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ContactController {

    @Autowired
    private ContactService contactService;
    private Response response = new Response();

    /**
     * GET Route index
     * @return String
     */
    @GetMapping(path = "/")
    public  String index(){
        return "Hola mundo desde un API";
    }

    /**
     * GET Route all contacts
     * @return List contacts
     */
    @GetMapping(path= ("/contacts"))
    public Response list(){
        try {
            response.data = contactService.list();
        } catch (Exception exc) {
            response.error = true;
            response.message = exc.getMessage();
            response.status = "ERROR 404, NOT FOUND";
        }
        return response;
    }

    /**
     * GET Route one contact
     * @param contact Object
     * @param id Id Object
     * @return contact
     */
    @GetMapping(path = "/contact/{id}")
    public Response findContact(Contact contact, @PathVariable("id") Long id){
        try {
            log.info("Contacto a encontrar: {}", contact);
            response.data = contactService.findContact(contact);
        } catch (Exception exc) {
            response.error = true;
            response.message = exc.getMessage();
            response.status = "ERROR 404, NOT FOUND";
        }
        return response;
    }

    /**
     * POST Route add contact
     * @param contact Object
     * @return contact
     */
    @PostMapping(path= ("/contact"))
    public ResponseEntity<Response> create(@RequestBody Contact contact){
        response.data = contact;
        try {
            log.info("Contacto a crear: {}", contact);
            contactService.save(contact);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception exc) {
            response.status = exc.getCause().toString();
            response.error = true;
            if (Pattern.compile("(contact.con_phone)").matcher(exc.getMessage()).find()) {
                response.message = "Contacto duplicado";
                return new ResponseEntity<>(response, HttpStatus.CONFLICT);
            } else {
                response.message = exc.getMessage();
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    /**
     * DELETE Route delete contact
     * @param contact Object
     * @return
     */
    @DeleteMapping(path= ("/contact/{id}"))
    public ResponseEntity<Contact> delete(Contact contact){
        try {
            log.info("Contacto a borrar: {}", contact);
            contactService.delete(contact);
            return new ResponseEntity<>(contact, HttpStatus.OK);
        } catch (Exception exc) {
            response.status = exc.getCause().toString();
            response.error = true;
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * PUT Route update contact
     * @param contact Object
     * @param id Id Object
     * @return contact
     */
    @PutMapping(path= ("/contact/{id}"))
    public ResponseEntity<Contact> update(@RequestBody Contact contact, @PathVariable("id") Long id){
        try {
            log.info("Contacto a actualizar: {}", contact);
            contactService.update(id, contact);
            return new ResponseEntity<>(contact, HttpStatus.OK);
        } catch (Exception exc) {
            response.status = exc.getCause().toString();
            response.error = true;
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * PATCH Route update name contact
     * @param contact Object
     * @param id Id Object
     * @return contact
     */
    @PatchMapping(path= ("/contact/name/{id}"))
    public ResponseEntity<Contact> updateName(Contact contact, @PathVariable("id") Long id){
        try {
            log.info("Contacto a actualizar nombre: {}", contact);
            contactService.updateName(id, contact);
            return new ResponseEntity<>(contact, HttpStatus.OK);
        } catch (Exception exc) {
            response.status = exc.getCause().toString();
            response.error = true;
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * PATCH Route update lastname contact
     * @param contact Object
     * @param id Id Object
     * @return contact
     */
    @PatchMapping(path= ("/contact/lastname/{id}"))
    public ResponseEntity<Contact> updateLastname(Contact contact, @PathVariable("id") Long id){
        try {
            log.info("Contacto a actualizar apellido: {}", contact);
            contactService.updateLastname(id, contact);
            return new ResponseEntity<>(contact, HttpStatus.OK);
        } catch (Exception exc) {
            response.status = exc.getCause().toString();
            response.error = true;
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * PATCH Route update phone contact
     * @param contact Object
     * @param id Id Object
     * @return contact
     */
    @PatchMapping(path= ("/contact/phone/{id}"))
    public ResponseEntity<Contact> updatePhone(Contact contact, @PathVariable("id") Long id){
        try {
            log.info("Contacto a actualizar telefono: {}", contact);
            contactService.updatePhone(id, contact);
            return new ResponseEntity<>(contact, HttpStatus.OK);
        } catch (Exception exc) {
            response.status = exc.getCause().toString();
            response.error = true;
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * PATCH Route update email contact
     * @param contact Object
     * @param id Id Object
     * @return contact
     */
    @PatchMapping(path= ("/contact/email/{id}"))
    public ResponseEntity<Contact> updateEmail(Contact contact, @PathVariable("id") Long id){
        try {
            log.info("Contacto a actualizar correo: {}", contact);
            contactService.updateEmail(id, contact);
            return new ResponseEntity<>(contact, HttpStatus.OK);
        } catch (Exception exc) {
            response.status = exc.getCause().toString();
            response.error = true;
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * PATCH Route update datebirth contact
     * @param contact Object
     * @param id Id Object
     * @return contact
     */
    @PatchMapping(path= ("/contact/datebirth/{id}"))
    public ResponseEntity<Contact> updateDateBirth(Contact contact, @PathVariable("id") Long id){
        try {
            log.info("Contacto a actualizar fecha de nacimiento: {}", contact);
            contactService.updateDatebirth(id, contact);
            return new ResponseEntity<>(contact, HttpStatus.OK);
        } catch (Exception exc) {
            response.status = exc.getCause().toString();
            response.error = true;
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

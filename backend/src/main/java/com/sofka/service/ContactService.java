package com.sofka.service;

import com.sofka.dao.ContactDao;
import com.sofka.domain.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Services of contact
 *
 * @version 1.0.0 2022/03/09
 * @author Ricardo Ortega - tattortega.28@gmail.com
 * @since 1.0.0
 */
@Service
public class ContactService implements IContactService {

    @Autowired
    private ContactDao contactDao;

    /**
     * Shows one contact
     * @param contact Object
     * @return contact
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Contact> findContact(Contact contact) {
        Optional<Contact> contacts = Optional.empty();
        try {
            contacts = contactDao.findById(contact.getId());
        } catch (Exception exc) {
            throw exc;
        }
        return contacts;
    }

    /**
     * Show list contacts
     * @return List
     */
    @Override
    @Transactional(readOnly = true)
    public List<Contact> list() {
        List<Contact> contacts = null;
        try {
            contacts = (List<Contact>) contactDao.findAll();
        } catch (Exception exc) {
            throw exc;
        }
        return contacts;
    }

    /**
     * Save contact
     * @param contact Object
     * @return contact
     */
    @Override
    @Transactional
    public Contact save(Contact contact) {
        Contact contacts = null;
        try {
            contacts = contactDao.save(contact);
        } catch (Exception exc) {
            throw exc;
        }
        return contacts;
    }

    /**
     * Update contact
     * @param id Long
     * @param contact Object
     * @return contact
     */
    @Override
    @Transactional
    public Contact update(Long id, Contact contact) {
        Contact contacts = null;
        try {
            contact.setId(id);
            contacts = contactDao.save(contact);
        } catch (Exception exc) {
            throw exc;
        }
        return contacts;
    }

    /**
     * Update name of contact
     * @param id Long
     * @param contact Object
     */
    @Transactional
    public void updateName(Long id, Contact contact){
        try {
            contactDao.updateName(id, contact.getName());
        } catch (Exception exc) {
            throw exc;
        }
    }

    /**
     * Update lastname of contact
     * @param id Long
     * @param contact Object
     */
    @Transactional
    public void updateLastname(Long id, Contact contact){
        try {
            contactDao.updateLastname(id, contact.getLastname());
        } catch (Exception exc) {
            throw exc;
        }
    }

    /**
     * Update phone of contact
     * @param id Long
     * @param contact Object
     */
    @Transactional
    public void updatePhone(Long id, Contact contact){
        try {
            contactDao.updatePhone(id, contact.getPhone());
        } catch (Exception exc) {
            throw exc;
        }
    }

    /**
     * Update email of contact
     * @param id Long
     * @param contact Object
     */
    @Transactional
    public void updateEmail(Long id, Contact contact){
        try {
            contactDao.updateEmail(id, contact.getEmail());
        } catch (Exception exc) {
        throw exc;
        }
    }

    /**
     * Update datebirth of contact
     * @param id Long
     * @param contact Object
     */
    @Transactional
    public void updateDatebirth(Long id, Contact contact){
        try {
            contactDao.updateDatebirth(id, contact.getDatebirth());
        } catch (Exception exc) {
            throw exc;
        }
    }

    /**
     * Delete contact
     * @param contact Object
     */
    @Override
    @Transactional
    public void delete(Contact contact) {
        try {
            contactDao.delete(contact);
        } catch (Exception exc) {
            throw exc;
        }
    }
}

package com.sofka.service;

import com.sofka.domain.Contact;
import java.util.List;
import java.util.Optional;

/**
 * Interface of services
 *
 * @version 1.0.0 2022/03/09
 * @author Ricardo Ortega - tattortega.28@gmail.com
 * @since 1.0.0
 */
public interface IContactService {


    /**
     * Show one contact
     * @param contact Object
     * @return contact
     */
    public Optional<Contact> findContact(Contact contact);

    /**
     * Show all contacts
     * @return List
     */
    public List<Contact> list();

    /**
     * Save contacts
     * @param contact Object
     * @return contact
     */
    public Contact save(Contact contact);

    /**
     * Update contacts
     * @param id Long
     * @param contact Object
     * @return contact
     */
    public Contact update(Long id, Contact contact);

    /**
     * Delete contacts
     * @param contact Object
     */
    public void delete(Contact contact);

}

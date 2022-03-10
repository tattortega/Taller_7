package com.sofka.dao;

import com.sofka.domain.Contact;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.time.LocalDate;

/**
 * Data Access Object (DAO)
 *
 * @version 1.0.0 2022/03/09
 * @author Ricardo Ortega - tattortega.28@gmail.com
 * @since 1.0.0
 */
public interface ContactDao extends CrudRepository<Contact, Long> {

    /**
     * Update name
     * @param id Long
     * @param name String
     */
    @Modifying
    @Query("update Contact con set con.name = :name where con.id = :id")
    public  void updateName(
            @Param(value = "id") Long id,
            @Param(value = "name") String name
    );

    /**
     * Update lastname
     * @param id Long
     * @param lastname String
     */
    @Modifying
    @Query("update Contact con set con.lastname = :lastname where con.id = :id")
    public  void updateLastname(
            @Param(value = "id") Long id,
            @Param(value = "lastname") String lastname
    );

    /**
     * Update phone
     * @param id Long
     * @param phone String
     */
    @Modifying
    @Query("update Contact con set con.phone = :phone where con.id = :id")
    public  void updatePhone(
            @Param(value = "id") Long id,
            @Param(value = "phone") String phone
    );

    /**
     * Update email
     * @param id Long
     * @param email String
     */
    @Modifying
    @Query("update Contact con set con.email = :email where con.id = :id")
    public  void updateEmail(
            @Param(value = "id") Long id,
            @Param(value = "email") String email
    );

    /**
     * Update datebirth
     * @param id Long
     * @param datebirth LocalDate
     */
    @Modifying
    @Query("update Contact con set con.datebirth = :datebirth where con.id = :id")
    public  void updateDatebirth(
            @Param(value = "id") Long id,
            @Param(value = "datebirth") LocalDate datebirth
    );
}

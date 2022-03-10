package com.sofka.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 * Object Relational Mapping (ORM)
 *
 * @version 1.0.0 2022/03/09
 * @author Ricardo Ortega - tattortega.28@gmail.com
 * @since 1.0.0
 */
@Data
@Entity
@Table(name= "contact")
public class Contact implements Serializable {

    private  static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "con_id")
    private Long id;

    @Column(name= "con_name")
    private String name;

    @Column(name= "con_lastname")
    private String lastname;

    @Column(name= "con_phone")
    private  String phone;

    @Column(name= "con_email")
    private  String email;

    @Column(name= "con_datebirth")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate datebirth;

    @Column(name= "con_created_at")
    private Date created_at;

    @Column(name= "con_updated_at")
    private Date updated_at;

    @Column(name= "con_deleted_at")
    private Date deleted_at;
}

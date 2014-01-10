package com.shm.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "CONTACTS")
public class Contact implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;

    @NotEmpty
    @Size(min = 2, max = 30)
    @Column(name = "FIRSTNAME")
    private String firstname;

    @NotEmpty
    @Size(min = 2, max = 30)
    @Column(name = "LASTNAME")
    private String lastname;

    @NotEmpty
    @Email
    @Column(name = "EMAIL")
    private String email;

    @NotEmpty
    @Size(min = 2, max = 30)
    @Column(name = "TELEPHONE")
    private String telephone;

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}

package com.realdolmen.fleet;

import org.hibernate.validator.constraints.Email;

import javax.persistence.Entity;

@Entity
public abstract class User extends AbstractEntity {
    @Email
    private String email;
    private String password;
}

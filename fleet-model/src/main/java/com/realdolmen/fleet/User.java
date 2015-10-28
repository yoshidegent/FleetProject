package com.realdolmen.fleet;

import org.hibernate.validator.constraints.Email;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.Collection;

@Entity
public abstract class User extends AbstractEntity {
    @Email
    private String email;
    private String password;

    @ElementCollection
    private Collection<String> roles;
}

package com.realdolmen.fleet;

import javax.persistence.Entity;

@Entity
public abstract class User extends AbstractEntity {
    private String email;
    private String password;
}

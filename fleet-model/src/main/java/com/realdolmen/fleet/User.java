package com.realdolmen.fleet;

import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Email;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
@Where(clause = "deleted = 0")
public abstract class User extends AbstractEntity {
    @NotNull
    @Email
    @Column(unique = true)
    private String email;

    @NotNull
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    private Collection<String> roles;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<String> getRoles() {
        return roles;
    }

    public void setRoles(Collection<String> roles) {
        this.roles = roles;
    }
}

package com.realdolmen.fleet;

import org.hibernate.annotations.Where;

import javax.persistence.Entity;

@Entity
@Where(clause = "deleted = false")
public class Admin extends User {
}

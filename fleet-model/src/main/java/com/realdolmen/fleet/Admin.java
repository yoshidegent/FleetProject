package com.realdolmen.fleet;

import org.hibernate.annotations.Where;

import javax.persistence.Entity;

@Entity
@Where(clause = "deleted = 0")
public class Admin extends Employee {
}

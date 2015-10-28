package com.realdolmen.fleet;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class AbstractEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Long version;


    public Long getId() {
        return id;
    }

    public Long getVersion() {
        return version;
    }
}

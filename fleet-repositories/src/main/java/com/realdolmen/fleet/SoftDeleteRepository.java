package com.realdolmen.fleet;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@NoRepositoryBean
public interface SoftDeleteRepository <T, ID extends Serializable> extends JpaRepository<T, ID> {
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE #{#entityName} t SET t.deleted = true WHERE t.id = ?1")
    void softDelete(ID id);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("UPDATE #{#entityName} t SET t.deleted = true WHERE t = ?1")
    void softDelete(T entity);
}

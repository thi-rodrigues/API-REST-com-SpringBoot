package com.establishment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.establishment.entities.Uf;

@Repository
public interface UfRepository extends JpaRepository<Uf, Long>{

}

package com.exemplo.crudpato.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.exemplo.crudpato.model.PatoCrud;

@Repository
public interface PatoRepository extends JpaRepository<PatoCrud, Long> {
  
}

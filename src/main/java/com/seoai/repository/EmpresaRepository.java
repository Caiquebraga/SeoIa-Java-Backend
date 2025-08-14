package com.seoai.repository;

import com.seoai.domain.empresa.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    boolean existsByDominioIgnoreCase(String dominio);
}

package com.seoai.repository;

import com.seoai.domain.palavra.PalavraChave;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PalavraChaveRepository extends JpaRepository<PalavraChave, Long> {
    Page<PalavraChave> findByEmpresaId(Long empresaId, Pageable pageable);
    boolean existsByEmpresaIdAndTermoIgnoreCase(Long empresaId, String termo);
}

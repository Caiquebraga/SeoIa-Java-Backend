package com.seoai.service;

import com.seoai.domain.empresa.Empresa;
import com.seoai.repository.EmpresaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmpresaService {

    private final EmpresaRepository repo;

    @Transactional(readOnly = true)
    public List<Empresa> listar() { return repo.findAll(); }

    @Transactional
    public Empresa criar(Empresa e) {
        if (repo.existsByDominioIgnoreCase(e.getDominio()))
            throw new IllegalArgumentException("Domínio já cadastrado");
        return repo.save(e);
    }

    @Transactional(readOnly = true)
    public Empresa buscar(Long id){
        return repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Empresa não encontrada"));
    }
}

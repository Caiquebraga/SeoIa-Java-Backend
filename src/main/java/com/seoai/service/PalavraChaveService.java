package com.seoai.service;

import com.seoai.domain.empresa.Empresa;
import com.seoai.domain.palavra.PalavraChave;
import com.seoai.repository.PalavraChaveRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PalavraChaveService {

    private final PalavraChaveRepository repo;
    private final EmpresaService empresaService;

    public PalavraChaveService(PalavraChaveRepository repo, EmpresaService empresaService) {
        this.repo = repo;
        this.empresaService = empresaService;
    }

    @Transactional(readOnly = true)
    public Page<PalavraChave> listarPorEmpresa(Long empresaId, Pageable pageable){
        return repo.findByEmpresaId(empresaId, pageable);
    }

    @Transactional
    public PalavraChave criar(Long empresaId, String termo){
        Empresa empresa = empresaService.buscar(empresaId);
        if (repo.existsByEmpresaIdAndTermoIgnoreCase(empresaId, termo))
            throw new IllegalArgumentException("Palavra já cadastrada para esta empresa");

        PalavraChave p = new PalavraChave();
        p.setTermo(termo);
        p.setEmpresa(empresa);
        return repo.save(p);
    }
}

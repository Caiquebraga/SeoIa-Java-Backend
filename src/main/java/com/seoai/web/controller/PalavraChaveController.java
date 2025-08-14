package com.seoai.web.controller;

import com.seoai.domain.palavra.PalavraChave;
import com.seoai.service.PalavraChaveService;
import com.seoai.web.dto.PalavraChaveCreateDTO;
import com.seoai.web.dto.PalavraChaveDTO;
import com.seoai.web.mapper.PalavraChaveMapper;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/empresas/{empresaId}/palavras")
public class PalavraChaveController {

    private final PalavraChaveService service;

    public PalavraChaveController(PalavraChaveService service) { this.service = service; }

    @GetMapping
    public Page<PalavraChaveDTO> listar(@PathVariable Long empresaId, Pageable pageable){
        return service.listarPorEmpresa(empresaId, pageable).map(PalavraChaveMapper::toDTO);
    }

    @PostMapping
    public ResponseEntity<PalavraChaveDTO> criar(@PathVariable Long empresaId,
                                                 @Valid @RequestBody PalavraChaveCreateDTO dto){
        PalavraChave p = service.criar(empresaId, dto.termo());
        return ResponseEntity.ok(PalavraChaveMapper.toDTO(p));
    }
}

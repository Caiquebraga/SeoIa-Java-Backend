package com.seoai.web.controller;

import com.seoai.domain.empresa.Empresa;
import com.seoai.service.EmpresaService;
import com.seoai.web.dto.EmpresaCreateDTO;
import com.seoai.web.dto.EmpresaDTO;
import com.seoai.web.mapper.EmpresaMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaController {

    private final EmpresaService service;

    public EmpresaController(EmpresaService service) { this.service = service; }

    @GetMapping
    public List<EmpresaDTO> listar(){
        return service.listar().stream().map(EmpresaMapper::toDTO).toList();
    }

    @PostMapping
    public ResponseEntity<EmpresaDTO> criar(@Valid @RequestBody EmpresaCreateDTO dto){
        Empresa saved = service.criar(EmpresaMapper.toEntity(dto));
        return ResponseEntity
                .created(URI.create("/api/empresas/" + saved.getId()))
                .body(EmpresaMapper.toDTO(saved));
    }
}

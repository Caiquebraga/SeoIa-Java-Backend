package com.seoai.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EmpresaCreateDTO(
        @NotBlank @Size(max=255) String nome,
        @NotBlank @Size(max=255) String dominio
) {}

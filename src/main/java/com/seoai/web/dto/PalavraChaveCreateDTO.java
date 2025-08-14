package com.seoai.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PalavraChaveCreateDTO(@NotBlank @Size(max=255) String termo) {}

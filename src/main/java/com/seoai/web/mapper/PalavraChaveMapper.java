package com.seoai.web.mapper;

import com.seoai.domain.palavra.PalavraChave;
import com.seoai.web.dto.PalavraChaveDTO;

public class PalavraChaveMapper {
    public static PalavraChaveDTO toDTO(PalavraChave p){
        return new PalavraChaveDTO(p.getId(), p.getTermo(),
                p.getEmpresa() != null ? p.getEmpresa().getId() : null);
    }
}

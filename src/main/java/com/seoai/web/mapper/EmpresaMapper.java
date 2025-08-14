package com.seoai.web.mapper;

import com.seoai.domain.empresa.Empresa;
import com.seoai.web.dto.EmpresaCreateDTO;
import com.seoai.web.dto.EmpresaDTO;

public class EmpresaMapper {
    public static Empresa toEntity(EmpresaCreateDTO dto){
        Empresa e = new Empresa();
        e.setNome(dto.nome());
        e.setDominio(dto.dominio());
        return e;
    }
    public static EmpresaDTO toDTO(Empresa e){
        return new EmpresaDTO(e.getId(), e.getNome(), e.getDominio());
    }
}

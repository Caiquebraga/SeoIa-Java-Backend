package com.seoai.domain.empresa;

import com.seoai.domain.palavra.PalavraChave;
import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
@ToString(exclude = "palavras")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity @Table(name = "empresa")
public class Empresa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable=false, length=255)
    private String nome;

    @Column(nullable=false, length=255)
    private String dominio;

    @Column(name="created_at", nullable=false,
            columnDefinition = "timestamptz default now()")
    private OffsetDateTime createdAt;

    @Builder.Default
    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PalavraChave> palavras = new ArrayList<>();

    public void addPalavra(PalavraChave p){
        p.setEmpresa(this);
        this.palavras.add(p);
    }
    public void removePalavra(PalavraChave p){
        p.setEmpresa(null);
        this.palavras.remove(p);
    }
}

package com.seoai.domain.palavra;

import com.seoai.domain.empresa.Empresa;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
        name = "palavra_chave",
        uniqueConstraints = @UniqueConstraint(
                name = "ux_palavra_empresa_termo",
                columnNames = {"empresa_id", "termo"}
        )
)
@Getter
@Setter
public class PalavraChave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String termo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;
}

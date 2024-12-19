package com.join.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.List;

@Entity
@Table
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoria_id_seq")
    @SequenceGenerator(name = "categoria_id_seq", allocationSize = 1)
    @Column(updatable = false, unique = true, nullable = false)
    private Long id;

    @Column(nullable = false, length = 100, unique = true)
    private String nome;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String descricao;

    @CreationTimestamp
    @Column(name = "data_criacao", updatable = false, nullable = false)
    private Instant dataCriacao;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Produto> produtos;

}

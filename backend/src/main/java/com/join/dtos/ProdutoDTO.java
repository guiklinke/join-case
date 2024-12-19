package com.join.dtos;

import java.math.BigDecimal;

public record ProdutoDTO(
        Long id,
        String nome,
        String descricao,
        BigDecimal preco,
        String dataCriacao,
        Long categoriaId
) {
}

package com.join.mappers;

import com.join.dtos.ProdutoDTO;
import com.join.entities.Produto;
import com.join.mappers.qualifiers.CategoriaQualifier;
import com.join.mappers.qualifiers.TimeQualifier;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        uses = {TimeQualifier.class, CategoriaQualifier.class}
)
public interface ProdutoMapper {
    @Mapping(target = "dataCriacao", source = "dataCriacao", qualifiedByName = "instantToString")
    @Mapping(target = "categoriaId", source = "categoria.id")
    ProdutoDTO toDTO(Produto produto);

    @Mapping(target = "categoria", source = "categoriaId", qualifiedByName = "idToCategoria")
    @Mapping(target = "dataCriacao", ignore = true)
    Produto toEntity(ProdutoDTO produtoDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "categoria", source = "categoriaId", qualifiedByName = "idToCategoria")
    @Mapping(target = "dataCriacao", ignore = true)
    Produto atualizaProduto(
            ProdutoDTO produtoDTO,
            @MappingTarget Produto produto
    );
}

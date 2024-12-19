package com.join.mappers;

import com.join.dtos.CategoriaDTO;
import com.join.entities.Categoria;
import com.join.mappers.qualifiers.TimeQualifier;
import org.mapstruct.*;

import java.math.BigDecimal;
import java.time.Instant;

@Mapper(
        componentModel = "spring",
        uses = {TimeQualifier.class},
        imports = {BigDecimal.class, Instant.class}
)
public interface CategoriaMapper {
    @Mapping(target = "dataCriacao", source = "dataCriacao", qualifiedByName = "instantToString")
    CategoriaDTO toDTO(Categoria categoria);

    @Mapping(target = "dataCriacao", ignore = true)
    Categoria toEntity(CategoriaDTO categoriaDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "dataCriacao", ignore = true)
    Categoria atualizaCategoria(
            CategoriaDTO categoriaDTO,
            @MappingTarget Categoria categoria
    );
}

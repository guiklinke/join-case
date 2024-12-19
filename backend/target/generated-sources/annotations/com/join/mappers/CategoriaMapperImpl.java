package com.join.mappers;

import com.join.dtos.CategoriaDTO;
import com.join.entities.Categoria;
import com.join.mappers.qualifiers.TimeQualifier;
import java.math.BigDecimal;
import java.time.Instant;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-19T11:26:08-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class CategoriaMapperImpl implements CategoriaMapper {

    @Autowired
    private TimeQualifier timeQualifier;

    @Override
    public CategoriaDTO toDTO(Categoria categoria) {
        if ( categoria == null ) {
            return null;
        }

        String dataCriacao = null;
        Long id = null;
        String nome = null;
        String descricao = null;

        dataCriacao = timeQualifier.instantToString( categoria.getDataCriacao() );
        id = categoria.getId();
        nome = categoria.getNome();
        descricao = categoria.getDescricao();

        CategoriaDTO categoriaDTO = new CategoriaDTO( id, nome, descricao, dataCriacao );

        return categoriaDTO;
    }

    @Override
    public Categoria toEntity(CategoriaDTO categoriaDTO) {
        if ( categoriaDTO == null ) {
            return null;
        }

        Categoria.CategoriaBuilder categoria = Categoria.builder();

        categoria.id( categoriaDTO.id() );
        categoria.nome( categoriaDTO.nome() );
        categoria.descricao( categoriaDTO.descricao() );

        return categoria.build();
    }

    @Override
    public Categoria atualizaCategoria(CategoriaDTO categoriaDTO, Categoria categoria) {
        if ( categoriaDTO == null ) {
            return categoria;
        }

        if ( categoriaDTO.nome() != null ) {
            categoria.setNome( categoriaDTO.nome() );
        }
        if ( categoriaDTO.descricao() != null ) {
            categoria.setDescricao( categoriaDTO.descricao() );
        }

        return categoria;
    }
}

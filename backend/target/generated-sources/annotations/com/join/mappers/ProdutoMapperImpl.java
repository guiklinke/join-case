package com.join.mappers;

import com.join.dtos.ProdutoDTO;
import com.join.entities.Categoria;
import com.join.entities.Produto;
import com.join.mappers.qualifiers.CategoriaQualifier;
import com.join.mappers.qualifiers.TimeQualifier;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-12-19T11:26:08-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class ProdutoMapperImpl implements ProdutoMapper {

    @Autowired
    private TimeQualifier timeQualifier;
    @Autowired
    private CategoriaQualifier categoriaQualifier;

    @Override
    public ProdutoDTO toDTO(Produto produto) {
        if ( produto == null ) {
            return null;
        }

        String dataCriacao = null;
        Long categoriaId = null;
        Long id = null;
        String nome = null;
        String descricao = null;
        BigDecimal preco = null;

        dataCriacao = timeQualifier.instantToString( produto.getDataCriacao() );
        categoriaId = produtoCategoriaId( produto );
        id = produto.getId();
        nome = produto.getNome();
        descricao = produto.getDescricao();
        preco = produto.getPreco();

        ProdutoDTO produtoDTO = new ProdutoDTO( id, nome, descricao, preco, dataCriacao, categoriaId );

        return produtoDTO;
    }

    @Override
    public Produto toEntity(ProdutoDTO produtoDTO) {
        if ( produtoDTO == null ) {
            return null;
        }

        Produto.ProdutoBuilder produto = Produto.builder();

        if ( produtoDTO.categoriaId() != null ) {
            produto.categoria( categoriaQualifier.idToCategoria( produtoDTO.categoriaId().longValue() ) );
        }
        produto.id( produtoDTO.id() );
        produto.nome( produtoDTO.nome() );
        produto.descricao( produtoDTO.descricao() );
        produto.preco( produtoDTO.preco() );

        return produto.build();
    }

    @Override
    public Produto atualizaProduto(ProdutoDTO produtoDTO, Produto produto) {
        if ( produtoDTO == null ) {
            return produto;
        }

        if ( produtoDTO.categoriaId() != null ) {
            produto.setCategoria( categoriaQualifier.idToCategoria( produtoDTO.categoriaId().longValue() ) );
        }
        if ( produtoDTO.nome() != null ) {
            produto.setNome( produtoDTO.nome() );
        }
        if ( produtoDTO.descricao() != null ) {
            produto.setDescricao( produtoDTO.descricao() );
        }
        if ( produtoDTO.preco() != null ) {
            produto.setPreco( produtoDTO.preco() );
        }

        return produto;
    }

    private Long produtoCategoriaId(Produto produto) {
        if ( produto == null ) {
            return null;
        }
        Categoria categoria = produto.getCategoria();
        if ( categoria == null ) {
            return null;
        }
        Long id = categoria.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}

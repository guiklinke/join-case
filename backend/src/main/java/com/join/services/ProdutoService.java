package com.join.services;

import com.join.dtos.ProdutoDTO;
import com.join.entities.Produto;
import com.join.exceptions.NotFoundException;
import com.join.mappers.ProdutoMapper;
import com.join.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;

    @Transactional(rollbackFor = Exception.class)
    public ProdutoDTO createProduto(ProdutoDTO produtoDTO) {
        return produtoMapper.toDTO(
                produtoRepository.saveAndFlush(
                        produtoMapper.toEntity(produtoDTO)
                )
        );
    }

    @Transactional(readOnly = true)
    public List<ProdutoDTO> getAllProdutos() {
        return produtoRepository.findAll().stream()
                .map(produtoMapper::toDTO)
                .toList();
    }

    public ProdutoDTO getProdutoById(long id) {
        return produtoMapper.toDTO(
                produtoRepository.findById(id).orElseThrow(
                        () -> new NotFoundException("Produto não encontrado")
                )
        );
    }

    @Transactional
    public ProdutoDTO updateProdutoById(Long id, ProdutoDTO produtoDTO) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Produto não encontrado"));

        produtoMapper.atualizaProduto(produtoDTO, produto);

        return produtoMapper.toDTO(produtoRepository.save(produto));
    }

    @Transactional
    public void deleteProdutoById(long id) {
        produtoRepository.findById(id)
                .ifPresentOrElse(
                        produtoRepository::delete,
                        () -> {
                            throw new NotFoundException("Produto não encontrado");
                        }
                );
    }
}

package com.join.services;

import com.join.dtos.CategoriaDTO;
import com.join.entities.Categoria;
import com.join.exceptions.NotFoundException;
import com.join.mappers.CategoriaMapper;
import com.join.repositories.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    @Transactional(rollbackFor = Exception.class)
    public CategoriaDTO createCategoria(CategoriaDTO categoriaDTO) {
        return categoriaMapper.toDTO(
                categoriaRepository.saveAndFlush(
                        categoriaMapper.toEntity(categoriaDTO)
                )
        );

    }

    @Transactional(readOnly = true)
    public List<CategoriaDTO> getAllCategorias() {
        return categoriaRepository.findAll().stream()
                .map(categoriaMapper::toDTO)
                .toList();
    }

    public CategoriaDTO getCategoriaById(long id) {
        return categoriaMapper.toDTO(
                categoriaRepository.findById(id).orElseThrow(
                        () -> new NotFoundException("Categoria não encontrada")
                )
        );
    }

    @Transactional(rollbackFor = Exception.class)
    public CategoriaDTO updateCategoriaById(Long id, CategoriaDTO categoriaDTO) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Categoria não encontrada"));

        categoriaMapper.atualizaCategoria(categoriaDTO, categoria);

        return categoriaMapper.toDTO(categoriaRepository.save(categoria));
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteCategoriaById(long id) {
        categoriaRepository.findById(id)
                .ifPresentOrElse(
                        categoriaRepository::delete,
                        () -> {
                            throw new NotFoundException("Categoria não encontrada");
                        }
                );
    }

}

package com.join.controllers;

import com.join.dtos.CategoriaDTO;
import com.join.services.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categorias")
@RequiredArgsConstructor
public class CategoriaController {
    private final CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<CategoriaDTO> createCategoria(@RequestBody final CategoriaDTO categoriaDTO) {
        return ResponseEntity.ok().body(categoriaService.createCategoria(categoriaDTO));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> getAllCategories() {
        return ResponseEntity.ok().body(categoriaService.getAllCategorias());
    }

    @GetMapping("/{categoriaId}")
    public ResponseEntity<CategoriaDTO> getCategoryById(@PathVariable long categoriaId) {
        return ResponseEntity.ok().body(categoriaService.getCategoriaById(categoriaId));
    }

    @PutMapping("/{categoriaId}")
    public ResponseEntity<CategoriaDTO> updateCategoria(
            @PathVariable final long categoriaId,
            @Validated @RequestBody final CategoriaDTO categoriaDTO) {
        return ResponseEntity.ok().body(categoriaService.updateCategoriaById(categoriaId, categoriaDTO));
    }

    @DeleteMapping("/{categoriaId}")
    public ResponseEntity<CategoriaDTO> deleteCategoria(
            @PathVariable final long categoriaId
    ) {
        categoriaService.deleteCategoriaById(categoriaId);
        return ResponseEntity.noContent().build();
    }
}

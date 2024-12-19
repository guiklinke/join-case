package com.join.controllers;

import com.join.dtos.ProdutoDTO;
import com.join.services.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produtos")
@RequiredArgsConstructor
public class ProdutoController {
    private final ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoDTO> createProduto(
            @RequestBody @Validated final ProdutoDTO produtoDTO) {
        return ResponseEntity.ok().body(produtoService.createProduto(produtoDTO));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> getAllProdutos() {
        return ResponseEntity.ok().body(produtoService.getAllProdutos());
    }

    @GetMapping("/{produtoId}")
    public ResponseEntity<ProdutoDTO> getProdutoById(@PathVariable long produtoId) {
        return ResponseEntity.ok().body(produtoService.getProdutoById(produtoId));
    }

    @PutMapping("/{produtoId}")
    public ResponseEntity<ProdutoDTO> updateProdutoById(
            @PathVariable final long produtoId,
            @RequestBody @Validated  final ProdutoDTO produtoDTO) {
        return ResponseEntity.ok().body(produtoService.updateProdutoById(produtoId, produtoDTO));
    }

    @DeleteMapping("/{produtoId}")
    public ResponseEntity<Void> deleteProdutoById(@PathVariable final long produtoId) {
        produtoService.deleteProdutoById(produtoId);
        return ResponseEntity.noContent().build();
    }
}

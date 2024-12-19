import { Component, OnInit } from '@angular/core';
import { ProdutoService } from '../../services/produto.service';
import { Produto } from 'src/app/models/produto.model';

@Component({
  selector: 'app-produto-list',
  templateUrl: './produto-list.component.html',
})
export class ProdutoListComponent implements OnInit {
  produtos: Produto[] = [];

  constructor(private produtoService: ProdutoService) {}

  ngOnInit(): void {
    this.fetchProdutos();
  }

  fetchProdutos(): void {
    this.produtoService.getAllProdutos().subscribe((data) => (this.produtos = data));
  }

  deleteProduto(id: number): void {
    this.produtoService.deleteProduto(id).subscribe(() => {
      this.fetchProdutos();
    });
  }
}

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProdutoService } from '../../services/produto.service';
import { Produto } from 'src/app/models/produto.model';

@Component({
  selector: 'app-produto-form',
  templateUrl: './produto-form.component.html',
})
export class ProdutoFormComponent implements OnInit {
  produto: Produto = {
    nome: '',
    descricao: '',
    preco: 0,
    dataCriacao: '',
    categoriaId: 1,
  };
  isEditMode = false;

  constructor(
    private produtoService: ProdutoService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.params['id'];
    if (id) {
      this.isEditMode = true;
      this.produtoService.getProdutoById(id).subscribe((data) => (this.produto = data));
    }
  }

  saveProduto(): void {
    if (this.isEditMode) {
      this.produtoService.updateProduto(this.produto.id, this.produto).subscribe(() => {
        this.router.navigate(['/produtos']);
      });
    } else {
      this.produtoService.createProduto(this.produto).subscribe(() => {
        this.router.navigate(['/produtos']);
      });
    }
  }
}

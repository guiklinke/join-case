import { Component, OnInit } from '@angular/core';
import { CategoriaService } from '../../services/categoria.service';
import { Categoria } from 'src/app/models/categoria.model';

@Component({
  selector: 'app-categoria-list',
  templateUrl: './categoria-list.component.html',
})
export class CategoriaListComponent implements OnInit {
  categorias: Categoria[] = [];

  constructor(private categoriaService: CategoriaService) {}

  ngOnInit(): void {
    this.fetchCategorias();
  }

  fetchCategorias(): void {
    this.categoriaService.getAllCategorias().subscribe((data) => (this.categorias = data));
  }

  deleteCategoria(id: number): void {
    this.categoriaService.deleteCategoria(id).subscribe(() => {
      this.fetchCategorias();
    });
  }
}

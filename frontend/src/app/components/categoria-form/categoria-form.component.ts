import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CategoriaService } from '../../services/categoria.service';
import { Categoria } from 'src/app/models/categoria.model';

@Component({
  selector: 'app-categoria-form',
  templateUrl: './categoria-form.component.html',
})
export class CategoriaFormComponent implements OnInit {
  categoria: Categoria = {
    nome: '',
    descricao: '',
    dataCriacao: '',
  };
  isEditMode = false;

  constructor(
    private categoriaService: CategoriaService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.params['id'];
    if (id) {
      this.isEditMode = true;
      this.categoriaService.getCategoriaById(id).subscribe((data) => (this.categoria = data));
    }
  }

  saveCategoria(): void {
    if (this.isEditMode) {
      this.categoriaService.updateCategoria(this.categoria.id, this.categoria).subscribe(() => {
        this.router.navigate(['/categorias']);
      });
    } else {
      this.categoriaService.createCategoria(this.categoria).subscribe(() => {
        this.router.navigate(['/categorias']);
      });
    }
  }
}

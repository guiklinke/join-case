import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProdutoFormComponent } from './components/produto-form/produto-form.component';
import { ProdutoListComponent } from './components/produto-list/produto-list.component';
import { CategoriaListComponent } from './components/categoria-list/categoria-list.component';
import { CategoriaFormComponent } from './components/categoria-form/categoria-form.component';
import { RegistrarComponent } from './components/registrar/registrar.component';
import { LoginComponent } from './components/login/login.component';

const routes: Routes = [
  { path: '', redirectTo: 'produtos', pathMatch: 'full' },
  { path: 'produtos', component: ProdutoListComponent },
  { path: 'produtos/novo', component: ProdutoFormComponent },
  { path: 'produtos/editar/:id', component: ProdutoFormComponent },
  { path: 'categorias', component: CategoriaListComponent }, 
  { path: 'categorias/novo', component: CategoriaFormComponent }, 
  { path: 'categorias/editar/:id', component: CategoriaFormComponent },
  { path: 'registrar', component: RegistrarComponent },
  { path: 'login', component: LoginComponent },
  { path: '**', redirectTo: 'login' } 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}

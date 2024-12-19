import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Categoria } from '../models/categoria.model';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root',
})
export class CategoriaService {
  private baseUrl = 'http://localhost:8080/api/v1/categorias'; 

  constructor(private http: HttpClient, private authService: AuthService) {}

  getAllCategorias(): Observable<Categoria[]> {
    return this.http.get<Categoria[]>(this.baseUrl, {
      headers: this.authService.getAuthHeaders() 
    });
  }

  getCategoriaById(id: number): Observable<Categoria> {
    return this.http.get<Categoria>(`${this.baseUrl}/${id}`, {
      headers: this.authService.getAuthHeaders()
    });
  }

  createCategoria(categoria: Categoria): Observable<Categoria> {
    return this.http.post<Categoria>(this.baseUrl, categoria, {
      headers: this.authService.getAuthHeaders() 
    });
  }

  updateCategoria(id: number, categoria: Categoria): Observable<Categoria> {
    return this.http.put<Categoria>(`${this.baseUrl}/${id}`, categoria, {
      headers: this.authService.getAuthHeaders()
    });
  }

  deleteCategoria(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`, {
      headers: this.authService.getAuthHeaders()
    });
  }


}

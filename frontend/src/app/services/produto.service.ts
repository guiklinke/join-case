import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Produto } from '../models/produto.model';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root',
})
export class ProdutoService {
  private baseUrl = 'http://localhost:8080/api/v1/produtos';

  constructor(private http: HttpClient, private authService: AuthService) {}

  getAllProdutos(): Observable<Produto[]> {
    return this.http.get<Produto[]>(`${this.baseUrl}`, {
      headers: this.authService.getAuthHeaders() 
    });
  }

  getProdutoById(id: number): Observable<Produto> {
    return this.http.get<Produto>(`${this.baseUrl}/${id}`, {
      headers: this.authService.getAuthHeaders()
    });
  }

  createProduto(produto: Produto): Observable<void> {
    return this.http.post<void>(this.baseUrl, produto, {
      headers: this.authService.getAuthHeaders()
    });
  }

  updateProduto(id: number, produto: Produto): Observable<Produto> {
    return this.http.put<Produto>(`${this.baseUrl}/${id}`, produto, {
      headers: this.authService.getAuthHeaders()
    });
  }

  deleteProduto(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`, {
      headers: this.authService.getAuthHeaders()
    });
  }
}

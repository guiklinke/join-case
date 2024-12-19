import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { RegistrarResponseDTO } from '../models/registrar-response.model';
import { LoginResponseDTO } from '../models/login-response.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private baseUrl = 'http://localhost:8080/auth'; 
  
  constructor(private http: HttpClient) {}

  register(registerData: any): Observable<RegistrarResponseDTO> {
    return this.http.post<RegistrarResponseDTO>(`${this.baseUrl}/register`, registerData);
  }

  login(loginData: any): Observable<LoginResponseDTO> {
    return this.http.post<LoginResponseDTO>(`${this.baseUrl}/login`, loginData);
  }

  saveToken(token: string): void {
    localStorage.setItem('authToken', token);
  }

  logout(): void {
    localStorage.removeItem('authToken');
  }

  getAuthHeaders(): HttpHeaders {
    const token = localStorage.getItem('authToken');
    return new HttpHeaders({
      'Authorization': token ? `Bearer ${token}` : ''
    });
  }
}

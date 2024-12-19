import { Component } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { Router } from '@angular/router';
import { LoginResponseDTO } from 'src/app/models/login-response.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  loginData = {
    login: '',
    password: ''
  };

  message: string = '';

  constructor(private authService: AuthService, private router: Router) {}

  onLogin(): void {
    this.authService.login(this.loginData).subscribe({
      next: (response: LoginResponseDTO) => {  
      this.authService.saveToken(response.token);
      this.message = 'Login bem-sucedido!';
      this.router.navigate(['/dashboard']);
      },
      
      error: (error) => {
        console.error('Erro ao autenticar:', error);
        this.message = 'Credenciais inválidas.';
      },
      complete: () => {
        console.log('Login concluído com sucesso');
      }
    });
  }
}

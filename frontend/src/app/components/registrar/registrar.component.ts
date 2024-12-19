import { Component } from '@angular/core';
import { RegistrarResponseDTO } from 'src/app/models/registrar-response.model';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './registrar.component.html',
  styleUrls: ['./registrar.component.scss']
})
export class RegistrarComponent {
  registerData = {
    login: '',
    password: ''
  };

  message: string = '';

  constructor(private authService: AuthService) {}

  onRegister(): void {
    this.authService.register(this.registerData).subscribe({
      next: (response: RegistrarResponseDTO) => {  
        this.message = response.mensagem;
      },
      error: (error) => {
        console.error('Erro ao registrar:', error);
        this.message = 'Erro ao registrar usuário.';
      },
      complete: () => {
        console.log('Registro concluído com sucesso');
      }
    });
  }
  
}

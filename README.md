# Join case

Este é um projeto full-stack que combina um front-end desenvolvido com **Angular 16** e um back-end com **Java 17** usando o **Spring Boot**. O back-end utiliza **Spring Security** para autenticação e está configurado para trabalhar com um banco de dados **PostgreSQL**.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Angular 16**
- **Node.js 16**
- **PostgreSQL**
- **Maven**

## Como Rodar o Projeto

### Pré-requisitos

Antes de rodar o projeto, você precisa ter os seguintes itens instalados na sua máquina:

- **Java 17**: Baixe e instale a versão 17 do Java: https://www.oracle.com/br/java/technologies/downloads/. Você pode verificar a instalação com o comando:

  ```bash
  java -version

- **Node.js**: O Angular precisa do Node.js. Baixe e instale a versão 16.20.2: https://nodejs.org/en.

    ```bash
    node -v

- **Angular**: Baixe e instale a versão 16.2.16.
    ```bash
    npm install -g @angular/cli@16.2.16
    ng version
  
- **PostgreSQL**: Instale o PostgreSQL. Você pode usar o pgAdmin ou qualquer outro cliente para gerenciar o banco de dados.

- **Maven**: Para compilar o projeto back-end, utilize o Maven.

### Back-End (Spring Boot)
- Navegue até o diretório do back-end:
  ```bash
  cd backend

- Certifique-se de ter o PostgreSQL rodando e crie um banco de dados para a aplicação.
  ```bash
  CREATE DATABASE joindb;
  
- Configuração do application.yml: Edite o arquivo src/main/resources/application.properties para configurar a conexão com o banco de dados:

    ```bash
    spring.datasource.url=jdbc:postgresql://localhost:5432/joindb
    spring.datasource.username=seu_usuario
    spring.datasource.password=sua_senha

- Isso iniciará o servidor na porta 8080:
    ```bash
    mvn spring-boot:run

### Front-End (Angular)
- Navegue até o diretório do front-end:

    ```bash
    cd frontend

- Execute o comando para instalar todas as dependências do Angular:

    ```bash
    npm install
  
- Para iniciar o servidor de desenvolvimento Angular:

    ```bash
    ng serve
- Isso iniciará o servidor do Angular na porta 4200. A aplicação pode ser acessada através de http://localhost:4200.

- Acesse http://localhost:4200/register para se registrar e http://localhost:4200/login para efeturar login.
- Assim que o login for feito, será possível criar, visualizar, editar e excluir Categorias e Produtos.
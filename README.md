🏪 Sistema de Estoque e Caixa — Backend

Este projeto é um backend simples desenvolvido em Spring Boot, com funções de controle de produtos, usuários, estoque e vendas.
Foi criado para ser fácil de entender, rodar e integrar com qualquer frontend.

🚀 Tecnologias Utilizadas

Java 17

Spring Boot

Spring Web

Spring Data JPA

H2 Database (em memória)

Maven

▶️ Como Executar o Projeto
1. Pré-requisitos

Java 17 instalado

Maven instalado

2. Rodar o projeto

No terminal, dentro da pasta do projeto, execute:

mvn spring-boot:run


O backend iniciará em:

http://localhost:8080

🗄 Banco de Dados H2

Acesse o banco pelo navegador:

http://localhost:8080/h2-console


Configurações:

Campo	Valor
JDBC URL	jdbc:h2:mem:estoque
User	sa
Password	(vazio)
📌 Endpoints Principais
🔐 Login
POST /login

👤 Usuários
GET    /usuarios
POST   /usuarios
PUT    /usuarios/{id}
DELETE /usuarios/{id}

📦 Produtos
GET    /produtos
POST   /produtos
PUT    /produtos/{id}
DELETE /produtos/{id}

📊 Movimentos de Estoque
GET  /movimentos
POST /movimentos

🛒 Vendas
GET  /vendas
POST /vendas

📘 Sobre o Projeto

O objetivo deste backend é oferecer uma base simples, funcional e organizada para controle de estoque e caixa.
Ideal para estudos, evoluções futuras ou integração com um frontend.

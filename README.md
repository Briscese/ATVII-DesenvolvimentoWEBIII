## Gabriel Brosig Briscese
## Thiago Zanin 

# ATV - II
# Automanager - Microserviço de Cadastro de Clientes

O Automanager é um microserviço desenvolvido em Java com o framework Spring Boot para realizar o cadastro de dados de clientes, incluindo informações pessoais, documentos, endereço e telefones.



### Modelo de Maturidade de Richardson

Esta API segue o Modelo de Maturidade de Richardson (RMM) para serviços RESTful. Os níveis são:

Nível 0: O Pântano de POX (Plain Old XML)
Nível 1: Recursos
Nível 2: Verbos HTTP
Nível 3: Controles de Hipermeios
Esta API tem como objetivo atingir o Nível 3, fornecendo suporte a HATEOAS (Hypermedia As The Engine Of Application State).

### Requisitos

- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [MySQL](https://www.mysql.com/)

### Configuração do Banco de Dados

1. Crie um banco de dados chamado `atividadeGerson`.
2. Atualize as configurações do banco de dados no arquivo `src/main/resources/application.properties`.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/atividadeGerson?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=Topsp808!@
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect



## Endpoints da API

- **Obter Cliente por ID**
  - `GET /clientes/{id}`
  
- **Obter Todos os Clientes**
  - `GET /clientes`
  
- **Cadastrar Novo Cliente**
  - `POST /clientes`
  
- **Atualizar Cliente**
  - `PUT /clientes`
  
- **Excluir Cliente por ID**
  - `DELETE /clientes{id}`
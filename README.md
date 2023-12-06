## Gabriel Brosig Briscese
## Thiago Zanin 

# ATV - III
# Automanager - Microserviço de Cadastro de Clientes

O Automanager é um microserviço desenvolvido em Java com o framework Spring Boot para realizar o cadastro de dados de clientes, incluindo informações pessoais, documentos, endereço e telefones.



### Modelo de Maturidade de Richardson

Esta API segue o Modelo de Maturidade de Richardson (RMM) para serviços RESTful. Os níveis são:

#### Nível 0: O Pântano de POX (Plain Old XML)
#### Nível 1: Recursos
#### Nível 2: Verbos HTTP
#### Nível 3: Controles de Hipermeios
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


## Veículos

### Cadastro de Veículo

- **Endpoint:** `POST /veiculos`
- **Descrição:** Cadastra um novo veículo.
- **Corpo da Requisição:** Veículo no formato `VeiculoCadastro`.
- **Resposta:** Retorna o veículo cadastrado com links HATEOAS.

### Obter Veículo por ID

- **Endpoint:** `GET /veiculos/{id}`
- **Descrição:** Obtém as informações de um veículo específico pelo ID.
- **Parâmetro:** `id` (ID do veículo a ser obtido).
- **Resposta:** Retorna o veículo com links HATEOAS.

### Listar Veículos

- **Endpoint:** `GET /veiculos`
- **Descrição:** Lista todos os veículos cadastrados.
- **Resposta:** Retorna uma coleção de veículos com links HATEOAS.

### Atualizar Veículo por ID

- **Endpoint:** `PUT /veiculos/{id}`
- **Descrição:** Atualiza as informações de um veículo específico pelo ID.
- **Parâmetros:** `id` (ID do veículo a ser atualizado).
- **Corpo da Requisição:** Veículo no formato `VeiculoCadastro`.
- **Resposta:** Retorna o veículo atualizado com links HATEOAS.

### Excluir Veículo por ID

- **Endpoint:** `DELETE /veiculos/{id}`
- **Descrição:** Exclui um veículo específico pelo ID.
- **Parâmetro:** `id` (ID do veículo a ser excluído).
- **Resposta:** Retorna NO_CONTENT se a exclusão for bem-sucedida, ou NOT_FOUND se o veículo não for encontrado.
## Usuários

### Cadastrar Novo Usuário

- **Endpoint:** `POST /usuarios`
- **Descrição:** Cadastra um novo usuário.
- **Corpo da Requisição:** Usuário no formato `Usuario`.
- **Resposta:** Retorna o usuário cadastrado com links HATEOAS.

### Atualizar Usuário por ID

- **Endpoint:** `PUT /usuarios/{id}`
- **Descrição:** Atualiza as informações de um usuário específico pelo ID.
- **Parâmetros:** `id` (ID do usuário a ser atualizado).
- **Corpo da Requisição:** Usuário no formato `Usuario`.
- **Resposta:** Retorna o usuário atualizado com links HATEOAS.

### Obter Usuário por ID

- **Endpoint:** `GET /usuarios/{id}`
- **Descrição:** Obtém as informações de um usuário específico pelo ID.
- **Parâmetro:** `id` (ID do usuário a ser obtido).
- **Resposta:** Retorna o usuário com links HATEOAS.

### Excluir Usuário por ID

- **Endpoint:** `DELETE /usuarios/{id}`
- **Descrição:** Exclui um usuário específico pelo ID.
- **Parâmetro:** `id` (ID do usuário a ser excluído).
- **Resposta:** Retorna NO_CONTENT se a exclusão for bem-sucedida, BAD_REQUEST se houver um erro ao excluir, ou INTERNAL_SERVER_ERROR se ocorrer outro erro.
## Serviços

### Cadastrar Novo Serviço

- **Endpoint:** `POST /servicos`
- **Descrição:** Cadastra um novo serviço.
- **Corpo da Requisição:** Serviço no formato `ServicosCadastro`.
- **Resposta:** Retorna o serviço cadastrado com links HATEOAS.

### Obter Serviço por ID

- **Endpoint:** `GET /servicos/{id}`
- **Descrição:** Obtém as informações de um serviço específico pelo ID.
- **Parâmetro:** `id` (ID do serviço a ser obtido).
- **Resposta:** Retorna o serviço com links HATEOAS.

### Obter Todos os Serviços

- **Endpoint:** `GET /servicos`
- **Descrição:** Obtém todos os serviços cadastrados.
- **Resposta:** Retorna uma lista de serviços com links HATEOAS.

### Atualizar Serviço por ID

- **Endpoint:** `PUT /servicos/{id}`
- **Descrição:** Atualiza as informações de um serviço específico pelo ID.
- **Parâmetros:** `id` (ID do serviço a ser atualizado).
- **Corpo da Requisição:** Serviço no formato `ServicosCadastro`.
- **Resposta:** Retorna o serviço atualizado com links HATEOAS.

### Excluir Serviço por ID

- **Endpoint:** `DELETE /servicos/{id}`
- **Descrição:** Exclui um serviço específico pelo ID.
- **Parâmetro:** `id` (ID do serviço a ser excluído).
- **Resposta:** Retorna NO_CONTENT se a exclusão for bem-sucedida, ou NOT_FOUND se o serviço não for encontrado.

## Mercadorias

### Cadastrar Nova Mercadoria

- **Endpoint:** `POST /mercadorias`
- **Descrição:** Cadastra uma nova mercadoria.
- **Corpo da Requisição:** Mercadoria no formato `MercadoriaCadastro`.
- **Resposta:** Retorna a mercadoria cadastrada com links HATEOAS.

### Obter Mercadoria por ID

- **Endpoint:** `GET /mercadorias/{id}`
- **Descrição:** Obtém as informações de uma mercadoria específica pelo ID.
- **Parâmetro:** `id` (ID da mercadoria a ser obtida).
- **Resposta:** Retorna a mercadoria com links HATEOAS.

### Obter Todas as Mercadorias

- **Endpoint:** `GET /mercadorias`
- **Descrição:** Obtém todas as mercadorias cadastradas.
- **Resposta:** Retorna uma lista de mercadorias com links HATEOAS.

### Atualizar Mercadoria por ID

- **Endpoint:** `PUT /mercadorias/{id}`
- **Descrição:** Atualiza as informações de uma mercadoria específica pelo ID.
- **Parâmetros:** `id` (ID da mercadoria a ser atualizada).
- **Corpo da Requisição:** Mercadoria no formato `MercadoriaCadastro`.
- **Resposta:** Retorna a mercadoria atualizada com links HATEOAS.

### Excluir Mercadoria por ID

- **Endpoint:** `DELETE /mercadorias/{id}`
- **Descrição:** Exclui uma mercadoria específica pelo ID.
- **Parâmetro:** `id` (ID da mercadoria a ser excluída).
- **Resposta:** Retorna NO_CONTENT se a exclusão for bem-sucedida, ou NOT_FOUND se a mercadoria não for encontrada.

## Empresas

### Cadastrar Nova Empresa

- **Endpoint:** `POST /empresas`
- **Descrição:** Cadastra uma nova empresa.
- **Corpo da Requisição:** Empresa no formato `EmpresaDTO`.
- **Resposta:** Retorna a empresa cadastrada com links HATEOAS.

### Obter Empresa por ID

- **Endpoint:** `GET /empresas/{id}`
- **Descrição:** Obtém as informações de uma empresa específica pelo ID.
- **Parâmetro:** `id` (ID da empresa a ser obtida).
- **Resposta:** Retorna a empresa com links HATEOAS.

### Obter Todas as Empresas

- **Endpoint:** `GET /empresas`
- **Descrição:** Obtém todas as empresas cadastradas.
- **Resposta:** Retorna uma lista de empresas com links HATEOAS.

### Atualizar Empresa por ID

- **Endpoint:** `PUT /empresas/{id}`
- **Descrição:** Atualiza as informações de uma empresa específica pelo ID.
- **Parâmetros:** `id` (ID da empresa a ser atualizada).
- **Corpo da Requisição:** Empresa no formato `EmpresaDTO`.
- **Resposta:** Retorna a empresa atualizada com links HATEOAS.

### Excluir Empresa por ID

- **Endpoint:** `DELETE /empresas/{id}`
- **Descrição:** Exclui uma empresa específica pelo ID.
- **Parâmetro:** `id` (ID da empresa a ser excluída).
- **Resposta:** Retorna NO_CONTENT se a exclusão for bem-sucedida, ou NOT_FOUND se a empresa não for encontrada.



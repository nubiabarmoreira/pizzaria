# Pizzaria

🍕 Essa API permite o gerenciamento de clientes e pedidos.

## **Arquitetura do Projeto**

O projeto segue a **Arquitetura Hexagonal (Ports and Adapters)**, que promove a separação de responsabilidades e facilita a manutenção, testes e extensibilidade do sistema.

### **Princípios da Arquitetura Hexagonal**
1. **Isolamento do Domínio**: A camada de domínio (modelos e regras de negócio) é completamente independente de detalhes da infraestrutura.
2. **Interfaces e Implementações**: A comunicação entre o domínio e o mundo externo é feita por meio de **ports** (interfaces), que são implementadas por **adapters** (implementações concretas).

### **Estrutura do Projeto**
Abaixo está uma visão geral da estrutura do projeto, destacando as camadas e seus papéis:

```plaintext
src/
├── main/
│   ├── java/
│   │   ├── com/
│   │   │   ├── zup/
│   │   │   │   ├── pizzaria/
│   │   │   │   │   ├── controllers/   # Classes para expor os endpoints
│   │   │   │   │   ├── dtos/          # Vão servir para realizar transferencia de dados entre camadas da aplicação
│   │   │   │   │   ├── models/        # Entidades (Domínio)
│   │   │   │   │   ├── repository/    # Classes realiconadas a camada que se comunica com as Entidades
│   │   │   │   │   ├── services/      # Classes onde agrupam as regras de négocio.
│   ├── resources/                     # Configurações e arquivos estáticos
├── test/    
```
## **Pré-requisitos**

Certifique-se de ter as seguintes ferramentas instaladas antes de começar:
- Java 17
- Maven
- Thunder Client ou outro sotfware de requests HTTP
- Um navegador para acessar a documentação Swagger

## **Como rodar o projeto localmente**

Siga os passos abaixo para rodar o projeto pela primeira vez:

1. Clone o repositório:
   ```
   git clone git@github.com:nubiabarmoreira/pizzaria.git
    ```

2. Rode a aplicação
    ```mvn spring-boot:run```

## Banco de Dados H2
O projeto utiliza o banco de dados H2 rodando em memória local para facilitar o desenvolvimento e os testes. Não é necessário configurar um banco de dados externo.

### Acessando o Console do H2
Após iniciar a aplicação, acesse o console do H2 no navegador:

URL: http://localhost:8080/h2-console

Use as seguintes credenciais para login:

JDBC URL: jdbc:h2:mem:testdb

User Name: sa

Password: password

Nota: O banco de dados H2 é reiniciado toda vez que a aplicação é reiniciada, pois ele roda em memória.

## Documentação Swagger
A aplicação possui uma documentação interativa das APIs gerada pelo Swagger Automagicamente 🧙‍♂️.

Certifique-se de que a aplicação está rodando. Abra o navegador e acesse: http://localhost:8080/swagger-ui.html.
Na interface do Swagger, você pode:

- Visualizar todas as rotas disponíveis.
- Testar as APIs diretamente na interface.
# Projeto E-COMMERCE Backend

Este projeto é uma API para gerenciamento de produtos, utilizando **Spring Boot**, **PostgreSQL** e **MapStruct** para realizar operações de CRUD. Além disso, a API segue princípios de **12 Factor Apps**, com configurações externalizadas e organizadas no formato `application.yaml`.

## Funcionalidades

- **Criação de Produtos**: Endpoint para adicionar novos produtos ao banco de dados.
- **Leitura de Produtos**: Recupera um produto específico ou lista todos os produtos cadastrados.
- **Atualização de Produtos**: Atualiza as informações de um produto com base no seu ID.
- **Remoção de Produtos**: Deleta um produto pelo seu identificador único.

## Tecnologias Utilizadas

- **Java 17** 
- **Spring Boot 3.0**
- **PostgreSQL**
- **MapStruct** (para mapeamento de DTOs e Entidades)
- **Lombok** (para geração de getters/setters e simplificação do código)
- **Hibernate** (como ORM)
- **Swagger UI** (para documentação e teste dos endpoints)

## Estrutura do Projeto

O projeto está estruturado da seguinte forma:

1. **Controllers (Resources)**: Responsáveis por definir os endpoints da API.
2. **Services**: Contém a lógica de negócio, incluindo as operações de CRUD.
3. **Repositories**: Interface que define a comunicação com o banco de dados usando Spring Data JPA.
4. **DTOs (Data Transfer Objects)**: Objetos utilizados para trafegar dados entre as camadas do projeto.
5. **Mappers**: Classes que convertem entre DTOs e entidades do banco de dados, utilizando o MapStruct.

## Configurações no `application.yaml`

O arquivo `application.yaml` foi configurado seguindo os princípios de **12 Factor Apps**, facilitando a externalização de configurações e a personalização de ambientes.

### 1. **Informações do Projeto**
As informações do projeto, como nome, versão e descrição, são referenciadas diretamente a partir do arquivo `pom.xml`:
```yaml
project:
  name: '@project.artifactId@'
  version: '@project.version@'
  description: '@project.description@'
```

### 2. **Swagger UI**
O caminho customizado para acessar o Swagger UI é definido em:
```yaml
springdoc:
  swagger-ui:
    path: "/swagger-ui.html"
```

### 3. **Banco de Dados**
O projeto está configurado para usar o banco de dados **PostgreSQL**, com suporte a variáveis de ambiente para configurar a conexão:
```yaml
spring:
  datasource:
    driver-class-name: ${SPRING_DRIVER_CLASS_NAME:org.postgresql.Driver}
    url: ${DATABASE_JDBC_URL:jdbc:postgresql://localhost:5432/exemplo_back}
    username: ${DATABASE_USERNAME:postgres}
    password: ${DATABASE_PASSWORD:aluno}
```
- Para ambientes de produção, é recomendável externalizar as credenciais (`DATABASE_USERNAME` e `DATABASE_PASSWORD`) para variáveis de ambiente.

### 4. **Configurações do Hibernate**
O Hibernate está configurado para não alterar o esquema do banco de dados automaticamente (`ddl-auto: none`), e o log SQL está ativado para fins de depuração:
```yaml
jpa:
  hibernate:
    ddl-auto: none
  show-sql: true
  database-platform: org.hibernate.dialect.PostgreSQLDialect
```
- O valor de `ddl-auto` pode ser ajustado para `update` em desenvolvimento, permitindo a atualização automática do esquema com base nas entidades.

### 5. **Log de Execução**
As configurações de log estão ajustadas para fornecer detalhes importantes durante a execução, especialmente no ORM Hibernate:
```yaml
logging:
  level:
    br.edu.ipog.backend2.app: debug
    org.springframework.web: info
    org:
      hibernate:
        orm.jdbc.bind: trace
        SQL: info
        type: trace
```

## Executando o Projeto

### Pré-requisitos
- **JDK 17**
- **PostgreSQL**
- **Maven** para gerenciamento de dependências.

### Passos para execução:

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   ```
2. Instale as dependências:
   ```bash
   mvn clean install
   ```
3. Configure o banco de dados PostgreSQL e atualize as variáveis de ambiente conforme necessário.
4. Execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```

### Testando a API via Swagger

Acesse o Swagger UI no seguinte caminho após a execução da aplicação:
```
http://localhost:8080/swagger-ui.html
```

## Considerações Finais

Este projeto é um exemplo de uma API RESTful simples, com operações de CRUD para produtos. Sinta-se à vontade para personalizá-lo de acordo com suas necessidades e para experimentar diferentes configurações no arquivo `application.yaml`.

---

Esse formato de `README.md` organiza e apresenta todas as informações importantes do projeto, incluindo como ele utiliza as configurações no `application.yaml` e detalha a execução e os principais pontos de configuração.

# DevSena - API de Cadastro

![Java](https://img.shields.io/badge/Java-17-blue.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.2-brightgreen.svg)
![License](https://img.shields.io/github/license/marcelosenna1/devsena-srv-api-cadastro-react)

API desenvolvida em Java com Spring Boot para servir de backend a uma aplicação frontend em React. Este projeto visa demonstrar a integração entre backend e frontend em uma estrutura moderna e modular, com suporte a documentação automática via Swagger (OpenAPI).

---

## 🚀 Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.4.2**
  - Spring Web
  - Spring Data JPA
  - Spring Validation
- **Banco de dados em memória: H2**
- **MapStruct** – para mapeamento entre DTOs e entidades
- **Lombok** – para redução de boilerplate
- **Swagger (Springdoc OpenAPI)** – para documentação automática da API

---

## 📦 Como rodar o projeto

### Pré-requisitos

- Java 17 instalado
- Maven 3.8+
- IDE (IntelliJ, VSCode ou Eclipse)

### Passo a passo

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/devsena-srv-api-cadastro-react.git

# Acesse a pasta do projeto
cd devsena-srv-api-cadastro-react

# Execute a aplicação
./mvnw spring-boot:run
```

> A aplicação será iniciada em: `http://localhost:8080`

---

## 📑 Documentação da API

Acesse a interface Swagger em:

```
http://localhost:8080/swagger-ui.html
```

Ou:

```
http://localhost:8080/swagger-ui/index.html
```

---

## 🗃 Banco de Dados

Este projeto utiliza o banco **H2 em memória**, ideal para testes locais.

Acesse o console em:

```
http://localhost:8080/h2-console
```

- JDBC URL: `jdbc:h2:mem:testdb`
- User: `sa`
- Password: (deixe em branco)

---

## 📁 Estrutura do Projeto

```
src
├── main
│   ├── java/com/sena
│   │   └── ... (código da aplicação)
│   └── resources
│       └── application.properties
├── test
│   └── java/com/sena
```

---

## ✅ Status

🟢 Em desenvolvimento — funcionalidades básicas implementadas e integração com frontend React em andamento.

---

## 👨‍💻 Autor

**Marcelo Sena**  
Desenvolvedor de Software  
[LinkedIn](https://www.linkedin.com/in/marcelo-sena-497b23229) •

---

## 📝 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

> Projeto Devforce - Construindo soluções com propósito. ⚡

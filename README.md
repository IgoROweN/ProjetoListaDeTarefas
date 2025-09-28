# 📌 Lista de Tarefas (CRUD)

Aplicação desenvolvida como parte do **Projeto Avaliativo – 1º Bimestre – 6º DSM (LDM)** da FATEC Franca.  
Trata-se de uma API REST para gerenciamento de tarefas do dia a dia (**CRUD completo**), utilizando **Java Spring Boot** e **PostgreSQL**.

---

## 🚀 Tecnologias utilizadas
- **Java 17**  
- **Spring Boot 3.x**  
  - Spring Web  
  - Spring Data JPA  
  - Spring Validation  
- **PostgreSQL**  
- **Lombok**  
- **Maven**

---

## ⚙️ Funcionalidades
- Criar uma nova tarefa  
- Listar todas as tarefas  
- Buscar uma tarefa por ID  
- Atualizar uma tarefa existente  
- Deletar uma tarefa  

Cada tarefa possui:
- `id`  
- `nome`  
- `descricao`  
- `status` (`PENDENTE`, `EM_ANDAMENTO`, `CONCLUIDA`)  
- `observacoes`  
- `dataCriacao`  
- `dataAtualizacao`  

---

## 🛠️ Configuração do Projeto

### 1. Clonar o repositório
```bash
git clone https://github.com/seu-usuario/lista-de-tarefas.git
cd lista-de-tarefas
```

### 2. Configurar o banco de dados
Crie o banco de dados no PostgreSQL:
```sql
CREATE DATABASE tarefas;
```

### 3. Configurar `application.properties`
Crie o arquivo `src/main/resources/application.properties` (não versionado por segurança).  
Exemplo:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/tarefas
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

⚠️ Caso queira, use o arquivo `application-example.properties` como referência.

### 4. Rodar o projeto
No terminal:
```bash
./mvnw spring-boot:run
```

Ou na IDE (Eclipse/IntelliJ):
- Run as → Spring Boot Application  

A aplicação subirá em:
```
http://localhost:8080
```

---

## 📡 Endpoints da API

### ➕ Criar tarefa
```http
POST /api/tarefas
Content-Type: application/json

{
  "nome": "Estudar Spring Boot",
  "descricao": "Revisar anotações",
  "status": "PENDENTE",
  "observacoes": "Fazer até amanhã"
}
```

### 📋 Listar todas
```http
GET /api/tarefas
```

### 🔍 Buscar por ID
```http
GET /api/tarefas/{id}
```

### ✏️ Atualizar tarefa
```http
PUT /api/tarefas/{id}
Content-Type: application/json

{
  "nome": "Estudar Spring Boot",
  "descricao": "Praticar CRUD",
  "status": "EM_ANDAMENTO",
  "observacoes": "Ainda faltam alguns testes"
}
```

### 🗑️ Deletar tarefa
```http
DELETE /api/tarefas/{id}
```

---

## 📂 Estrutura do Projeto
```
src/main/java/com/igor_owen/lista_de_tarefas
 ├── controller
 │    └── TarefaController.java
 ├── model
 │    └── Tarefa.java
 ├── repository
 │    └── TarefaRepository.java
 ├── service
 │    ├── TarefaService.java
 │    └── TarefaServiceImpl.java
 ├── exception
 │    └── ResourceNotFoundException.java
 └── ListaDeTarefasApplication.java
```

---

## 👨‍💻 Autor
Projeto desenvolvido por **Igor Owen**  
Curso **DSM – Desenvolvimento de Software Multiplataforma**  
FATEC Franca – Prof. Alexandre  

## 🧩 ELO CRM – Sistema de Gerenciamento de Relacionamento com Clientes de Seguros
<br /> <div align="center"> <img src="https://ik.imagekit.io/Thalima23/Como-o-CRM-pode-ajudar-em-um-atendimento-personalizado.jpg?updatedAt=1761774183594" /> </div>

<br /><br />
## 📝 1. Descrição  

O **ELO CRM** é uma aplicação backend desenvolvida em **Java com Spring Boot**, voltada para o **setor de seguros**, com o objetivo de **centralizar e automatizar o relacionamento entre corretores, clientes e oportunidades de negócio**.  

O sistema foi criado para resolver um problema comum no setor: a **falta de organização e acompanhamento das oportunidades de venda**. Ele permite gerenciar clientes, oportunidades e usuários de forma eficiente, garantindo segurança e rastreabilidade em todos os processos.  

-----

A API RESTful do **ELO CRM** fornece endpoints seguros e padronizados para operações **CRUD** (Create, Read, Update, Delete) sobre **Usuários, Clientes e Oportunidades**, além de **autenticação JWT** para controle de acesso.

## ⚙️ 2. Sobre esta API  

A API RESTful do **ELO CRM** fornece endpoints seguros e padronizados para operações **CRUD** (Create, Read, Update, Delete) sobre **Usuários, Clientes e Oportunidades**, além de **autenticação JWT** para controle de acesso.

### 🔹 2.1. Principais Funcionalidades  

1. **Cadastro e autenticação de usuários (corretores)**  
   - Login e registro com validação de credenciais.  
   - Criptografia de senha com `BCrypt`.  
   - Geração de token JWT para segurança.  

2. **Gestão de clientes**  
   - CRUD completo de clientes.  
   - Associação entre cliente e oportunidade.  

3. **Gestão de oportunidades**  
   - Registro de novas oportunidades de negócio.  
   - Controle de status (em andamento, fechada, perdida).  
   - Valor potencial em `BigDecimal` com arredondamento automático.  
   - Filtros por tipo, cliente e corretor responsável.  

4. **Integração segura entre entidades**  
   - Relacionamentos configurados com `@ManyToOne` e `@OneToMany`.  
   - Tratamento de JSON com `@JsonIgnoreProperties` para evitar loops.  

5. **Validação de dados com Jakarta Validation (`@NotBlank`, `@Email`, `@Size`)**  

6. **Documentação automática com Swagger (OpenAPI 3.0)**  
---

## 🧱 3. Organização das Classes  


| 🧩 Classe | 💻 Tipo | 🧾 Atributos principais | 🧱 Descrição | 🎯 Requisitos atendidos |
|-----------|---------|-------------------------|--------------|--------------------------|
| **Usuario** | Model (Java) | id, nome, usuario, senha, email, foto | Representa o corretor/usuário do sistema. | CRUD + autenticação JWT |
| **Cliente** | Model (Java) | id, nome, telefone, email, endereço | Representa o cliente da corretora. | CRUD completo |
| **Oportunidade** | Model (Java) | id, descricao, status, valorPotencial, dataCriacao, tipoOportunidade | Registra uma oportunidade de venda. | CRUD + relacionamento com cliente e usuário |


---

## 🗃️ 4. Diagrama Entidade-Relacionamento (DER)  

<div align="center">
   <img src="https://ik.imagekit.io/Thalima23/image.png?updatedAt=1761775468699" width="70%"/>  
</div>

**Relacionamentos:**
- Um **Usuário** pode ter várias **Oportunidades**.  
- Um **Cliente** pode estar vinculado a várias **Oportunidades**.  
- Cada **Oportunidade** pertence a um único **Usuário** e um único **Cliente**.

---

## 🛠️ 5. Tecnologias Utilizadas  

| Tecnologia | Descrição |
|-------------|------------|
| ☕ **Java 17** | Linguagem de programação principal |
| 🌱 **Spring Boot 3** | Framework para desenvolvimento backend |
| 🧩 **Spring Data JPA / Hibernate** | Mapeamento objeto-relacional (ORM) |
| 🐬 **MySQL** | Banco de dados relacional |
| 🔐 **Spring Security + JWT** | Autenticação e segurança |
| ✅ **Jakarta Validation** | Validação de dados (`@NotBlank`, `@Email`, etc.) |
| 📘 **SpringDoc OpenAPI (Swagger)** | Documentação da API |
| ⚙️ **Maven** | Gerenciador de dependências |
| 💻 **Spring Tool Suite / IntelliJ IDEA** | IDEs utilizadas no desenvolvimento |

---

## 🌐 6. Endpoints Principais

| Método   | Endpoint                                  | Descrição                        |
| -------- | ----------------------------------------- | -------------------------------- |
| `POST`   | `/usuarios`                               | Cadastrar novo usuário           |
| `POST`   | `/usuarios/logar`                         | Autenticar usuário (login)       |
| `GET`    | `/usuarios`                               | Listar todos os usuários         |
| `POST`   | `/clientes`                               | Criar novo cliente               |
| `GET`    | `/clientes`                               | Listar todos os clientes         |
| `POST`   | `/oportunidades`                          | Criar nova oportunidade          |
| `GET`    | `/oportunidades`                          | Listar todas as oportunidades    |
| `PATCH`  | `/oportunidades/{id}/status/{novoStatus}` | Atualizar status da oportunidade |
| `DELETE` | `/oportunidades/{id}`                     | Excluir oportunidade             |

---
## 🤝 7. Contribuidores

<div align="center"> 💙 Feito pela <b>Equipe MavenTech</b> 👩‍💻🚀 </div> 
📚 Projeto desenvolvido para o Desafio Projeto Integrador – Back-End (Generation Brasil / 2025)




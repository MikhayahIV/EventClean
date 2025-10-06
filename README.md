# ⚡ Event Clean

[![Java](https://img.shields.io/badge/Java-17+-blue.svg)](https://www.java.com/pt-br/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.5-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Clean Architecture](https://img.shields.io/badge/Architecture-Clean-red.svg)]()
[![Swagger](https://img.shields.io/badge/API%20Doc-Swagger-85EA2D.svg)]()
[![GitHub Repo](https://img.shields.io/badge/GitHub-EventClean-blue?logo=github)](https://github.com/MikhayahIV/EventClean)

---

## 📝 Descrição do Projeto

**Event Clean** é uma aplicação de gerenciamento de eventos desenvolvida em **Java** e **Spring Boot**, seguindo rigorosamente os princípios da **Clean Architecture** (Arquitetura Limpa).

O objetivo principal do projeto é fornecer um serviço robusto e desacoplado para o **cadastro de novos eventos** e a **filtragem** eficiente desses eventos por seus identificadores.

## 🚀 Funcionalidades

* **Cadastro de Eventos:** Criação de novos registros de eventos com tipagem definida.
* **Filtro por Identificador:** Busca e recuperação de eventos específicos usando seus identificadores.
* **Listagem de Eventos:** Recuperação de todos os eventos cadastrados.

---

## 💻 Tecnologias

O projeto utiliza um conjunto de tecnologias modernas para garantir performance, escalabilidade e manutenibilidade:

| Tecnologia | Descrição |
| :--- | :--- |
| **Java 17+** | Linguagem de programação principal. |
| **Spring Boot** | Framework para rápido desenvolvimento de aplicações robustas. |
| **Spring Data JPA** | Persistência de dados com abstração e facilidade. |
| **PostgreSQL** | Banco de dados relacional robusto e escalável. |
| **Flyway** | Gerenciamento de versionamento e migração do banco de dados. |
| **Docker** | Containerização da aplicação e do banco de dados para ambientes consistentes. |
| **Lombok** | Redução de código *boilerplate* (getters, setters, construtores). |
| **JUnit e Mockito** | Testes unitários e de integração. |
| **Swagger/OpenAPI** | **Documentação automática e interativa das APIs.** |

---

## 🏗️ Arquitetura (Clean Architecture)

O projeto é estritamente estruturado em camadas para garantir o **desacoplamento** e a **independência** da regra de negócio (**Core**) em relação à infraestrutura.

### 🧩 Core (Regras de Negócio)

Esta camada contém as regras de negócio mais puras (as "Use Cases") e as entidades do domínio, **totalmente independentes** do framework e do banco de dados.

| Componente | Descrição |
| :--- | :--- |
| **`Evento`** (Record) | Entidade central do domínio. |
| **`TiposEventos`** (Enum) | Tipos permitidos para classificar eventos. |
| **`EventoGateway`** (Interface) | Porta de saída (Port) que o Core usa para interagir com o mundo externo (a persistência). |
| **Use Cases** | Classes que orquestram a regra de negócio: `CriarEventoUseCase`, `FiltrarIdentificadorEventoUseCase` e `ListarEventoUseCase`. |

### ⚙️ Infrastructure (Adapters e Detalhes Técnicos)

Esta camada é responsável pela implementação dos detalhes técnicos, adaptando o Core ao mundo real (banco de dados, web). Ela implementa a interface **`EventoGateway`** do Core, seguindo o Princípio de Inversão de Dependência.

| Componente | Pasta | Descrição |
| :--- | :--- | :--- |
| **`EventoController`** | `presentation` | Adaptador de entrada (Controller REST) que recebe requisições HTTP e as traduz para as Use Cases. |
| **`EventoDto`** (Record) | `dto` | Data Transfer Object para comunicação via API (Entrada/Saída dos `Controller`s). |
| **`EventoEntity`** | `persistence` | Entidade JPA mapeada para o banco de dados. |
| **`EventoRepository`** | `persistence` | Repositório do Spring Data JPA para operações CRUD no banco. |
| **`EventoRepositoryGateway`** | `gateway` | Adaptador que implementa o `EventoGateway` do Core, traduzindo o Core para o `EventoRepository`. |
| **Mappers** | `mapper` | Classes para traduzir dados entre as camadas (DTO $\leftrightarrow$ Core $\leftrightarrow$ Entity). |
| **Exceptions** | `exception` | Exceções específicas e o `ControllerExceptionHandler` para tratamento global de erros. |
| **`BeanConfiguration`** | `beans` | Configuração para injeção de dependências do Spring. |

### 🌍 Ponto de Partida

| Componente | Descrição |
| :--- | :--- |
| **`EventCleanApplication`** | Classe principal para inicialização da aplicação Spring Boot. |

---

## 🛠️ Instalação e Execução

Para rodar o projeto localmente, siga os seguintes passos:

### Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas:

* **Java 17+**
* **Docker** e **Docker Compose**
* **Maven** (ou use o wrapper incluso)

### Passos

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/MikhayahIV/EventClean](https://github.com/MikhayahIV/EventClean)
    cd EventClean
    ```

2.  **Inicie os containers com Docker Compose:**
    Este comando irá levantar o container da aplicação e o container do banco de dados PostgreSQL.
    ```bash
    docker-compose up --build
    ```
    *A aplicação estará acessível em `http://localhost:8080`.*

3.  **Acesse a Documentação da API (Swagger):**
    Com o servidor rodando, a documentação interativa do **Swagger/OpenAPI** estará disponível em:
    ```
    http://localhost:8080/swagger-ui.html
    ```

---

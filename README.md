
# CRUD com Spring Boot e MySQL

Este é um exemplo de aplicação CRUD utilizando **Spring Boot** com **MySQL**. O projeto permite a gestão de objetos do tipo **Pato** em um banco de dados MySQL.

## Estrutura do Projeto

```
pato-crud-spring
│
├── src
│   └── main
│       └── java
│           └── com
│               └── exemplo
│                   └── crudpato
│                       ├── controller
│                       │   └── PatoController.java
│                       ├── model
│                       │   └── PatoCrud.java
│                       ├── repository
│                       │   └── PatoRepository.java
│                       └── PatoApplication.java
└── pom.xml
```

## Passos para Configuração

### 1. **Model - PatoCrud.java**

A classe `PatoCrud.java` representa a tabela no banco de dados. Ela contém os atributos do Pato (nome, cor e idade) e mapeia a tabela no banco de dados MySQL.

```java
@Entity
public class PatoCrud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cor;
    private int idade;
    // Construtores, getters e setters
}
```

### 2. **Repository - PatoRepository.java**

O repositório `PatoRepository.java` estende a interface `JpaRepository` do Spring Data JPA, oferecendo os métodos de CRUD básicos.

```java
public interface PatoRepository extends JpaRepository<PatoCrud, Long> {
    // Métodos de CRUD básicos já disponíveis do Spring Data JPA
}
```

### 3. **Controller - PatoController.java**

A classe `PatoController.java` define os endpoints para o CRUD de patos. Ela usa o repositório para interagir com o banco de dados.

```java
@RestController
@RequestMapping("/patos")
public class PatoController {
    private final PatoRepository patoRepository;
    // Métodos POST, GET, PUT, DELETE
}
```

### 4. **Application - PatoApplication.java**

Esta é a classe principal da aplicação Spring Boot. Ela inicializa a aplicação.

```java
@SpringBootApplication
public class PatoApplication {
    public static void main(String[] args) {
        SpringApplication.run(PatoApplication.class, args);
    }
}
```

### 5. **pom.xml**

Este arquivo contém as dependências do Maven, como Spring Boot, JPA, MySQL, entre outras.

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <scope>runtime</scope>
    </dependency>
</dependencies>
```

### 6. **application.properties**

Arquivo de configuração do banco de dados MySQL.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/pato_db
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

## Como Executar o Projeto

1. **Configuração do Banco de Dados**
    - Crie um banco de dados no MySQL chamado `pato_db`.
  
2. **Executar a Aplicação**
    - No terminal, na raiz do projeto, execute o seguinte comando:
    
    ```bash
    mvn spring-boot:run
    ```

3. **Testar no Postman**

    - **Criar Pato (POST)**
        - Endpoint: `POST http://localhost:8080/patos`
        - Corpo:
        ```json
        {
            "nome": "Pato Donald",
            "cor": "Amarelo",
            "idade": 5
        }
        ```

    - **Listar Patos (GET)**
        - Endpoint: `GET http://localhost:8080/patos`

    - **Buscar Pato por ID (GET)**
        - Endpoint: `GET http://localhost:8080/patos/{id}`

    - **Atualizar Pato (PUT)**
        - Endpoint: `PUT http://localhost:8080/patos/{id}`
        - Corpo:
        ```json
        {
            "nome": "Pato Daffy",
            "cor": "Preto",
            "idade": 4
        }
        ```

    - **Excluir Pato (DELETE)**
        - Endpoint: `DELETE http://localhost:8080/patos/{id}`

## Dependências Utilizadas

- **Spring Boot**: Framework para criação de aplicações Java.
- **Spring Data JPA**: Para interação com o banco de dados utilizando JPA.
- **MySQL**: Banco de dados relacional utilizado para armazenar os dados.
- **Maven**: Ferramenta de automação de compilação e gerenciamento de dependências.
- **Maven**: Ferramenta de automação de compilação e gerenciamento de dependências.
- **Lombok**: Utilizado para simplificar a criação de getters, setters e outros métodos.
- **Spring** Validation: Para validação de dados na entrada.


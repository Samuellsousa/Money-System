# Money System

## Descrição
O **Money System** é um sistema de controle financeiro pessoal desenvolvido para auxiliar no gerenciamento das finanças pessoais. Com uma interface simples e intuitiva, o sistema permite que usuários acompanhem suas receitas, despesas, categorizem seus gastos, e mantenham um controle rigoroso sobre seu orçamento.

## Funcionalidades
- Adicionar receitas e despesas
- Categorizar transações financeiras
- Exibir gráficos de despesas e receitas por período
- Definir metas financeiras
- Acompanhar o saldo e o fluxo de caixa em tempo real

## Tecnologias Utilizadas
- **Java Spring Boot**: Para o desenvolvimento da API backend, com suporte a autenticação e controle de dados.
- **JWT (JSON Web Token)**: Para autenticação de usuários.
- **React.js**: Interface de usuário no frontend, proporcionando uma experiência de navegação rápida e fluida.
- **MySQL**: Banco de dados relacional utilizado para armazenar todas as informações financeiras.
- **Docker**: Utilizado para facilitar a distribuição e execução do sistema em qualquer ambiente.
- **Swagger**: Documentação da API para facilitar o desenvolvimento e integração com outras aplicações.

## Pré-requisitos
Antes de rodar o projeto localmente, certifique-se de que você tem os seguintes requisitos instalados:

- **JDK 11 ou superior**
- **Node.js (v18 ou superior)**
- **MySQL 8.x**
- **Docker** (opcional, para rodar com containers)
- **Git**

## Instalação e Execução
### Backend
1. Clone este repositório:
    ```bash
    git clone https://github.com/Samuellsousa/Money-System.git
    ```

2. Navegue até a pasta do backend:
    ```bash
    cd Money-System/backend
    ```

3. Configure o banco de dados no arquivo `application.properties`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/money_system
    spring.datasource.username=seu_usuario
    spring.datasource.password=sua_senha
    ```

4. Execute o seguinte comando para iniciar o backend:
    ```bash
    ./mvnw spring-boot:run
    ```

### Frontend
1. Navegue até a pasta do frontend:
    ```bash
    cd Money-System/frontend
    ```

2. Instale as dependências:
    ```bash
    npm install
    ```

3. Execute o frontend:
    ```bash
    npm start
    ```

4. O frontend estará disponível em `http://localhost:3000`.

### Utilizando Docker (Opcional)
Caso queira rodar todo o sistema com Docker, basta utilizar o comando:

```bash
docker-compose up

# 👥 LocateHub - Microserviço de Usuários (SQL Server)

Este microserviço é responsável pela gestão de usuários e perfis dentro do ecossistema LocateHub. Ele utiliza uma base de dados relacional (SQL) hospedada na nuvem para garantir a integridade e consistência dos dados cadastrais.

## 📐 Arquitetura e Validação Automatizada
Seguindo o padrão do projeto, este serviço utiliza **Clean Architecture** com **Vertical Slices**, garantindo que a lógica de usuários seja isolada e escalável.

### 🧪 Testes Unitários de Arquitetura (ArchUnit)
O projeto conta com validação arquitetural automatizada via código. Através de testes unitários estruturais, o sistema garante que as barreiras de isolamento entre camadas nunca sejam violadas (ex: impedindo que camadas internas dependam diretamente de Controllers).

### Diferencial Técnico:
Diferente do microserviço de itens, este módulo utiliza o **Spring Data JPA** para gerenciar a persistência em um banco de dados relacional (Azure SQL), permitindo o uso de chaves primárias autoincrementais e garantindo a unicidade de campos como o e-mail.

## 🚀 Tecnologias Utilizadas
* **Java 17**: Linguagem de programação principal.
* **Spring Boot 4.0.6**: Framework para construção da API REST.
* **Spring Data JPA / Hibernate**: Camada de configuração e configuração para operações SQL.
* **Azure SQL Database**: Banco de dados relacional hospedado na Microsoft Azure.
* **Microsoft JDBC Driver**: Conector oficial para SQL Server.
* **ArchUnit v1.3.0**: Biblioteca de testes unitários para conformidade e governança arquitetural.
* **Lombok**: Redução de código boilerplate.
* **SpringDoc OpenAPI (Swagger)**: Documentação interativa e testes de endpoint.

## ⚙️ Configuração e Banco de Dados
O projeto está configurado para utilizar a estratégia `ddl-auto=update`, o que significa que as tabelas no SQL Server são criadas e updated automaticamente pelo Hibernate a partir das entidades Java.

**Variáveis de Conexão (application.properties):**
* `spring.datasource.url`: URL JDBC da instância Azure SQL.
* `spring.jpa.hibernate.ddl-auto`: update.

## 🔧 Como Rodar Localmente

1. **Pré-requisitos**: JDK 17 e Maven instalados.
2. **Configuração**: Verifique as credenciais de acesso ao banco do Azure no arquivo `src/main/resources/application.properties`.
3. **Execução**:
   - Via Terminal: `mvn spring-boot:run`
   - Via IDE: Execute a classe `MicroservicoUsuariosApplication.java`.
4. **Porta Padrão**: Este serviço roda na porta `8082`.

## 📖 Documentação da API (Swagger)
Acesse a interface de testes e documentação em:
`http://localhost:8082/swagger-ui/index.html`

## 👥 Desenvolvedores
* **Davi Martins**
* **Joshua Mendes**
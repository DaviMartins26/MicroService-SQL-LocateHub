# Estágio 1: Compilação do projeto com Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Estágio 2: Execução do JAR com uma imagem leve do Java 17
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Define que o container vai rodar usando a variável de ambiente se informada
ENTRYPOINT ["java", "-jar", "app.jar"]
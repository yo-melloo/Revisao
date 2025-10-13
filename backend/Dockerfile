# Estágio 1: Build da aplicação
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app

# Copia os arquivos do Maven
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Baixa as dependências
RUN ./mvnw dependency:go-offline

# Copia o código fonte
COPY src ./src

# Compila a aplicação
RUN ./mvnw clean package -DskipTests

# Estágio 2: Imagem final (apenas com o JAR)
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copia apenas o JAR compilado do estágio anterior
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta da aplicação
EXPOSE 8080

# Inicia a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]

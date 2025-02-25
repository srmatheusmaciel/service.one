# Task Service Microservice

![Version](https://img.shields.io/badge/version-0.0.1--SNAPSHOT-blue)
![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.2-brightgreen)
![Spring Cloud](https://img.shields.io/badge/Spring%20Cloud-2024.0.0-lightblue)

## 📋 Descrição

Task Service é um microserviço que faz parte de uma arquitetura de aplicação distribuída, responsável por gerenciar operações relacionadas a tarefas. Este serviço se comunica com outros microserviços através do Spring Cloud, se registra no servidor Eureka e utiliza configuração centralizada.

## 🚀 Funcionalidades

- Gerenciamento completo do ciclo de vida de tarefas
- Integração com outros microserviços da plataforma
- Persistência de dados usando JPA
- Service discovery com Eureka
- Configuração centralizada com Spring Cloud Config
- Comunicação entre serviços com Feign Client

## 🛠️ Tecnologias

- **Java 21**
- **Spring Boot 3.4.2**
- **Spring Cloud 2024.0.0**
  - Netflix Eureka Client
  - Spring Cloud Config
  - OpenFeign
- **Spring Data JPA**
- **H2 Database** (para desenvolvimento/testes)
- **Lombok**
- **Maven**

## 🏗️ Arquitetura

Este microserviço segue os princípios da arquitetura de microserviços:

- **Autonomia**: Gerencia seu próprio domínio de negócios (tarefas)
- **Descoberta de serviço**: Registro e descoberta via Eureka
- **Configuração externalizada**: Configurações gerenciadas pelo Spring Cloud Config
- **Comunicação entre serviços**: Integração com outros microserviços via Feign

## 🔧 Instalação e Execução

### Pré-requisitos

- Java 21
- Maven 3.8+
- Servidor Eureka em execução
- Servidor de Config em execução

### Clone e Build

```bash
git clone https://github.com/srmatheusmaciel/service.tasks.git
cd service.tasks
mvn clean install
```

### Execução

```bash
mvn spring-boot:run
```


## ⚙️ Configuração

### application.properties

```bash
spring.application.name=service-tasks
spring.port=8081
spring.cloud.config.uri=http://localhost:8888/config
spring.config.import=configserver:http://localhost:8888/config


eureka.client.serviceUrl.defaultZone=http://localhost:8888/eureka
eureka.instance.prefer-ip-address=false
eureka.instance.hostname=localhost

spring.datasource.url=jdbc:h2:mem:testedb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

## 📚 API Endpoints

### Tarefas

- `POST /api/tasks` - Criar nova tarefa

## 🔄 Comunicação com outros serviços

O serviço utiliza Feign Client para se comunicar com outros microserviços:

- **Notification Service**: Para envio de notificações relacionadas a tarefas
- **Main Service**: Servidor de configuração centralizado utilizando Spring Cloud Config Server e e atua na descoberta de serviços com Eureka Server. 



## 🧪 Testes

Execute os testes automatizados com:

```bash
mvn test
```


## 📦 Deployment

### Docker

```dockerfile
FROM maven:3.9.6-amazoncorretto-21-debian AS build  

COPY src /app/src  
COPY pom.xml /app  

WORKDIR /app  
RUN mvn clean install -DskipTests

# Etapa final (imagem menor para rodar o app)
FROM amazoncorretto:21  

WORKDIR /app  
COPY --from=build /app/target/service.tasks-0.0.1-SNAPSHOT.jar /app/app.jar  

EXPOSE 8881  

CMD ["java", "-jar", "app.jar"]  
```


## 📋 Lista de Recursos Futuros

- Implementação de Circuit Breaker com Resilience4j
- Adição de métricas com Prometheus
- Rastreamento distribuído com Zipkin
- Migração para banco de dados PostgreSQL

## 🤝 Contribuição

Para contribuir com o projeto:

1. Faça um fork do repositório
2. Crie uma branch para sua feature (`git checkout -b feature/nova-funcionalidade`)
3. Commit suas alterações (`git commit -m 'Adiciona nova funcionalidade'`)
4. Push para a branch (`git push origin feature/nova-funcionalidade`)
5. Abra um Pull Request

## 📄 Licença

Este projeto está licenciado sob a MIT License - veja o arquivo LICENSE para detalhes.

## 👤 Autor

Matheus Maciel - [@srmatheusmaciel](https://github.com/srmatheusmaciel)

---

Desenvolvido com ❤️ como parte da arquitetura de microserviços, veja também o serviço de envio de [@notficacao](https://github.com/srmatheusmaciel/service-notification)

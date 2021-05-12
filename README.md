<h2>Desenvolvimento de uma API REST para gestão de jogos lendários com Spring WebFlux e com banco de dados NoSQL DynamoDB.</h2>

Abaixo, seguem links para configuração do ambiente de desenvolvimento antes de executar o projeto:

* [Criando de IAM no AWS da Amazon](https://docs.aws.amazon.com/pt_br/IAM/latest/UserGuide/id_users_create.html)
* [Criando das chaves do IAM](https://docs.aws.amazon.com/pt_br/IAM/latest/UserGuide/id_credentials_access-keys.html)
* [Usando o DynamoDB localmente](https://docs.aws.amazon.com/pt_br/amazondynamodb/latest/developerguide/DynamoDBLocal.DownloadingAndRunning.html)

Para executar o projeto no terminal, digite o seguinte comando:

```shell script
mvn spring-boot:run 
```

Para executar o projeto basta executar o seguinte comando:

```shell script
mvn clean test
```

Após executar o comando acima, basta apenas abrir o seguinte endereço e visualizar a execução do projeto:

```
http://localhost:8080/legend-game
```

Iniciar o DynamoDB: 

```shell script
java -Djava.library.path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar -sharedDb
```

Verificar se as tabelas foram criadas:

```shell script
aws dynamodb list-tables --endpoint-url http://localhost:8000
```

Swagger:

```
http://localhost:8080/swagger-ui-legendGame-reactive-api.html
```

São necessários os seguintes pré-requisitos para a execução do projeto:

* Java 8 ou versões superiores.
* Maven 3.6.3 ou versões superiores.
* IntelliJ IDEA Community Edition ou sua IDE favorita.
* Controle de versão GIT instalado na sua máquina.

Bibliotecas utilizadas:

Implementação
* Spring Flux
* Netty

Documentação
* Spring DOC
* Postman Documented

Banco de Dados
* Amazon DynamoDB

Testes
* Junit
* Reactor Test

Abaixo, seguem links bem bacanas:

* [SDKMan! para gerenciamento e instalação do Java e Maven](https://sdkman.io/)
* [Referência do Intellij IDEA Community, para download](https://www.jetbrains.com/idea/download)
* [Palheta de atalhos de comandos do Intellij](https://resources.jetbrains.com/storage/products/intellij-idea/docs/IntelliJIDEA_ReferenceCard.pdf)
* [Site oficial do Spring](https://spring.io/)
* [Site oficial JUnit 5](https://junit.org/junit5/docs/current/user-guide/)
* [Site oficial Mockito](https://site.mockito.org/)
* [Site oficial Hamcrest](http://hamcrest.org/JavaHamcrest/)
* [Referências - testes em geral com o Spring Boot](https://www.baeldung.com/spring-boot-testing)
* [Referência para o padrão arquitetural REST](https://restfulapi.net/)
* [Referência pirâmide de testes - Martin Fowler](https://martinfowler.com/articles/practical-test-pyramid.html#TheImportanceOftestAutomation)
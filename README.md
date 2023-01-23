# Teste prático da Apisul

Este repositório foi criado com o intuito de demonstrar a solução do teste prático disponibilizado pela empresa [Apisul](https://www.apisul.com.br/).

<hr/>

## Tecnologias

- Java 8
- JUnit 4
- [Maven](https://maven.apache.org/)

Não foram utilizadas bibliotecas externas para a solução do desafio, apenas para os testes.

<hr/>

## Como rodar

Para rodar o projeto é preciso ter o Java 8 e o Maven instalado na sua máquina.

```shell
>>> git clone https://github.com/wcarestini/interface-elevador.git
>>> cd interface-elevador
>>> mvn install
>>> mvn exec:java
```

<hr/>

### Rodando os testes

Lembrando que o comando mvn install já executa os testes, mas caso queira rodar separadamente, basta rodar o comando abaixo:

```shell
>>> mvn test
```

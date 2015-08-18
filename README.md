# API Core do NPI

Esta API contém funcionalidades usadas em várias aplicações do NPI.

##Uso da API no seu projeto

Para usar esta API basta configurá-la como dependência do seu projeto no arquivo pom.xml, conforme o exemplo a seguir:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  ...
  <dependencies>
    ...
    <dependency>
      <groupId>br.ufc.quixada.npi</groupId>
      <artifactId>npi-core-api</artifactId>
      <version>0.1.0</version>
    </dependency>
    ...
  </dependencies>
  ...
</project>
```

## Gerando libs em repositório local
```
mvn clean deploy -Dgpg.passphrase=npicoreapi
```

## A API é armazenada no [Repositório Central do Maven](http://search.maven.org/#search%7Cga%7C1%7Cnpi-core-api).

## Criando conta no JIRA do SonaType para envio de novas versões da API para o Repositório Central

Criar conta a partir do link a seguir: [Criação de Conta](https://issues.sonatype.org/secure/Signup!default.jspa)

## Gerando bundle para ser enviado a maven central repository
```
mvn clean repository:bundle-create -Dgpg.passphrase=npicoreapi
```

## Testando as assinaturas geradas:
```
gpg target/npi-core-api-0.1.0.jar.asc
gpg target/npi-core-api-0.1.0-sources.jar.asc
gpg target/npi-core-api-0.1.0-javadoc.jar.asc
```

## Enviar bundle para o endereço:
- https://oss.sonatype.org/

## Repositório Central
- https://oss.sonatype.org/content/groups/public/ 
- https://oss.sonatype.org/content/groups/staging/ 
- https://oss.sonatype.org/content/repositories/releases/ 

## Demora um pouco para aparecer nas buscas:
- http://search.maven.org/ 
- http://mvnrepository.com/ 
- http://mvnrepository.com/search?q=br.ufmg.dcc.saotome 

<!--
Gerando arquivos para serem copiados para um repositório Maven
--------------------------------------------------------------

A exportação (*deploy*) da API para um repositório Maven em diretório local é realizada através do seguinte comando:

```
mvn clean deploy
```

Os arquivos serão gerados na pasta `target/mvn-repo`. Depois disso pode-se copiar os arquivos dessa pasta para o repositório Maven.
-->

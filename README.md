API Core do NPI
===============

Esta API contém funcionalidades usadas em várias aplicações do NPI.

Uso da API no seu projeto
-------------------------
Para usar esta API basta configurá-la como dependência do seu projeto no arquivo pom.xml, conforme o exemplo a seguir:

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  ...
  <!-- In Project repository -->
  <repositories>
    <repository>
      <id>npi-mvn-repo</id>
      <url>http://npi-ufc-qxd.github.io/npi-mvn-repo/</url>
    </repository>
  </repositories>
  ...
  <dependencies>
    ...
    <dependency>
      <groupId>br.ufc.quixada.npi</groupId>
      <artifactId>npi-core-api</artifactId>
      <version>0.0.7</version>
    </dependency>
    ...
  </dependencies>
  ...
</project>
```

Gerando arquivos para serem copiados para um repositório Maven
--------------------------------------------------------------

A exportação (*deploy*) da API para um repositório Maven em diretório local é realizada através do seguinte comando:

```
mvn clean deploy
```

Os arquivos serão gerados na pasta `target/mvn-repo`. Depois disso pode-se copiar os arquivos dessa pasta para o repositório Maven.

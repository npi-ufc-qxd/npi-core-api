API Core do NPI
===============

Esta API contém funcionalidades usadas em várias aplicações do NPI.

O repositório Maven da API está hospedado na *branch* mvn-repo deste repositório do GitHub.  

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
      <id>npi-core-api</id>
      <url>https://raw.github.com/npi-ufc-qxd/npi-core-api/mvn-repo</url>
      <snapshots>
        <enabled>true</enabled>
        <updatePolicy>always</updatePolicy>
      </snapshots>
    </repository>
  </repositories>
  ...
  <dependencies>
    ...
    <dependency>
      <groupId>br.ufc.quixada.npi</groupId>
      <artifactId>npi-core-api</artifactId>
      <version>0.0.1</version>
    </dependency>
    ...
  </dependencies>
  ...
</project>
```

Exportando a API para o repositório do GitHub
---------------------------------------------

A exportação (*deploy*) da API para o repositório do GitHub é realizada através do seguinte comando:

```
mvn clean deploy
```

Para que o deploy seja realizado para o GitHub é necessário configurar usuário e senha do GitHub no arquivo `˜/.m2/settings.xml`, conforme o exemplo a seguir:

```
<!-- NOTE: MAKE SURE THAT settings.xml IS NOT WORLD READABLE! -->
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0
                      http://maven.apache.org/xsd/settings-1.0.0.xsd">
  <servers>
      <server>
      <id>github</id>
      <username>usuário</username>
      <password>senha</password>
    </server>
  </servers>
</settings>
```


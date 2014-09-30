API Core do NPI
===============

Contém funcionalidades usadas em várias aplicações do NPI.

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



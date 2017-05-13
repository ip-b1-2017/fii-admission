@ThisIsForIntegrationTeam

La final, aplicatia se va deploya astfel:

mvn clean install
java -jar target/spring-boot-0.0.1-SNAPSHOT.jar

mergi apoi in pom.xml
modifici / adaugi  campul sub nodul project 
<packing>war</packing>

mvn clean install
-> se obtine fisierul war cu aplicatia
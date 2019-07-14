# Desafio programação 13/07/19
## Tempo gasto : 9 horas

## Foi criado uma aplicação Spring boot utilizando [Spring Initializr](https://start.spring.io)
## Dependencias:
## Spring Boot DevTools, Spring Data JPA, Spring Web Starter, Lombok e HyperSQL Database
```sh
cd $APP_DIR
ng new banco --style=css --routing
```
```sh
java -jar $LOMBOK_DIR/lombok.jar
```
```sh
cd $APP_DIR/banco/frontend
npm install --save bootstrap
ng g interface common/model/cliente
ng g interface common/model/conta-corrente
ng g interface common/model/vo/operacao-vo
ng g c conta-corrente --skipTests
ng g s conta-corrente/conta-corrente --skipTests
ng g c home --inline-template --inline-style --skipTests
ng g c common/pagina-nao-encontrada --inline-template --inline-style --skipTests
ng deploy --prod
npm install angular-http-server -g
angular-http-server -p 4200 --path $APP_DIR/banco/frontend/dist/banco
```
```sh
cd $APP_DIR/banco/backend
mvn package
java -jar $APP_DIR/banco/backend/target/banco-0.0.1-SNAPSHOT.jar
```
```sh
cd $APP_DIR/banco
git remote add origin https://github.com/cams7/desafio-capgemi.git
git push -u origin master
```
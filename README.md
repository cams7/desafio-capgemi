# Desafio programação 13/07/19
Tempo gasto : 9 horas

Foi criado uma aplicação **Spring boot** utilizando [Spring Initializr](https://start.spring.io)

Dependencias utilizadas: **Spring Boot DevTools**, **Spring Data JPA**, **Spring Web Starter**, **Lombok** e **HyperSQL Database**

Execute as operações abaixo, caso não tenha feito isso anteriormente:
* Instale a JDK superior a 8.
* Instale a ultima versão do Maven.
* Instale a ultima versão do NodeJS.
* Instale a ultima versão do Angular. 
* Instale a ultima versão do GIT.
* Instale as IDEs Eclipse, VS Code e GitKraken *(Obs.: Opcional)*.
* Execute a aplicação lombok e informe o diretório onde o Eclipse foi instalado *(Obs.: Caso esteja utilizando o Eclipse)*.
```sh
java -jar $LOMBOK_DIR/lombok.jar
```

Segue abaixo o historico dos comandos utilizados no desenvolvimento dessa aplicação:
```sh
cd $APP_DIR
ng new banco --style=css --routing
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

## Roteiro
Para rodar a aplicação execute os comandos abaixo:
```sh
npm install angular-http-server -g

cd $APP_DIR
git clone https://github.com/cams7/desafio-capgemi.git --branch master

cd $APP_DIR/banco/backend
mvn package
java -jar $APP_DIR/banco/backend/target/banco-0.0.1-SNAPSHOT.jar

cd $APP_DIR/banco/frontend
npm install
ng deploy --prod
angular-http-server -p 4200 --path $APP_DIR/banco/frontend/dist/banco
```

Obs.: A aplicação *backend* deve rodar na porta 8080, já a *frontend* deve ser executada na porta 4200. 

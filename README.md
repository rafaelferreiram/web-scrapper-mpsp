Para realizar a conversao de HTML para PDF no caso do INFOCRIM, foi usado uma lib chamada WKHTML. 
Para utilizar a mesma, e necessario a instalacao local, qual o link da lib e download da mesma segue abaixo.

https://wkhtmltopdf.org/downloads.html
https://github.com/jhonnymertz/java-wkhtmltopdf-wrapper


Para realizar o scrapper utilizar o Chrome versão 77 pois chromedriver esta com essa versao.
ativando a execucao do scrapper atraves da url 'http://localhost:8080/mpsp/scrapping?active=true' GET

Acessar 'http://localhost:8080/' para acessar aplicacao web.

Sempre que executar o scrappar ele ira inserir registro no MongoDB e o sistema web consume a atrave de WebService.



O scrapper foi realizado em todos os sites do mock conforme solicitado, no caso do site Infocrim, cujo foi necessario realizar a conversao de HTML para PDF para obter as informações, foi usado uma lib chamada WKHTML. 
Para utilizar a mesma, e necessario a instalacao local, qual o link da lib e download da mesma segue abaixo.

* https://wkhtmltopdf.org/downloads.html (link para download)
* https://github.com/jhonnymertz/java-wkhtmltopdf-wrapper (documentação)

Para realizar o scrapper utilizar o Chrome versão 77 pois chromedriver esta com essa versao.
ativando a execucao do scrapper atraves da url 'http://localhost:8080/mpsp/scrapping?active=true' (GET method)

Acessar 'http://localhost:8080/' para acessar aplicacao web.

Sempre que executar o scrappar ele ira inserir registro no MongoDB e o sistema web consume a atrave de WebService.



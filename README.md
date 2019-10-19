Projeto possui uma depencia local, que esta em /resouces/lib , configurar o build path para execução do mesmo no Eclipse.

Para compilar com 'mvn clean install -U', precisa renomear ou tirar o jar (/resouces/lib/jPDFWriter.v2016R1.03.jar), comentas linhas 17 e 229 e 230 na classe MockSrapperJob
Assim o projeto ira compilar com o maven sem da problema pela depencia injetada atraves do Build Path.


# Spring Example Simple sender mail
*Este é um projeto simples feito em Spring Boot, starter-mail e thymeleaf para disparos de e-mails com múltiplos anexos.* 

![Exemplo do projeto em execução ](https://i.imgur.com/hJGfcfR.png)

## Configurações
No arquivo **application.properties** você configura a conexão do e-mail responsável pelos envios.

    server.port=9090
    #mailConfig
    spring.mail.host=email-smtp.us-west-2.amazonaws
    spring.mail.username=username@example
    spring.mail.password=password
    spring.mail.port=587
    spring.mail.properties.mail.smtp.starttls.enable=false
    #mailConfig ~ SMTP
    spring.mail.properties.mail.transport.protocol=smtp
    spring.mail.properties.mail.smtp.port=25
    spring.mail.properties.mail.smtp.auth=true
    spring.mail.properties.mail.smtp.starttls.required=true
    #thymeleaf
    spring.thymeleaf.cache=false


## Atenção
**Java Version:** 14 mas pode ser alterado para sua versão sem problema, por tanto que seja **Version >= 8**


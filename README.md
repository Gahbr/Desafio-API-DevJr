## DESAFIO DEV JR
Contexto:
Você está fazendo uma API REST que precisará controlar endereços de usuários!

O primeiro passo deve ser a construção de um cadastro de usuários, sendo obrigatório dados como: nome, e-mail, CPF e data de nascimento, onde e-mail e CPF devem ser únicos.

O segundo passo é criar um cadastro de endereços, sendo obrigatório dados mínimos para cadastro como: logradouro, número, complemento, bairro, cidade, estado e CEP, associando este endereço ao usuário.

O terceiro passo é criar um endpoint que retornará um usuário com a lista de todos seus endereços cadastrados.

Você deve construir apenas 3 endpoints neste sistema, o cadastro do usuário, o cadastro de endereços e a listagem dos endereços de um usuário específico.
- Caso os cadastros estejam corretos, é necessário voltar o Status 201, caso haja erros de preenchimento de dados, o Status deve ser 400.
- Caso a busca esteja correta, é necessário voltar o status 200, caso haja erro na busca, retornar o Status adequado e uma mensagem de erro amigável.

Seu desafio:
- Implementar esse sistema utilizando Java como linguagem e Spring + Hibernate como stacks de tecnologia fundamentais da aplicação;
- Persistência em um banco de dados (a sua escolha);
- Construir a aplicação sem utilizar Lombok;
- Integrar a API da Viacep usando Spring-Cloud-Feign.
Desafio QA [Hands On]
=======

Este repositório contém a resolução de um Desafio QA [Hands On] de automação de cenários de compra na saraiva.com.br, utilizando Selenium Webdriver Java.


## Motivações das escolhas ##

	1° - Linguagem: Foi escolhido a linguagem Selenium Webdriver Java, pois eu já tive contato com java na faculdade e recentemente fiz um curso de Selenium na Alura;
	
	2° - Para cada cenário de teste escrito, foi criado um Teste no selenium validando cada etapa necessária para efetuar a compra do produto.


## Configurando ##

O Firefox do Windows está configurado como default para rodar os testes, caso queira rodar com outro navegador ou outro sistema operacional, seguir os passos abaixo:

	1° - Colocar o driver do navegador ou sistema operacional desejado na pasta "/drivers";
	
	2° - Alterar as informações para o novo driver no arquivo DesafioQaTest, linhas 19, 26 e 27;


## Executando os testes ##
Rodar o comando na pasta raiz do projeto:

    mvn test


## Cenários de Testes ##

1 -> Validar carrinho:
Contexto: Validar o carrinho de compras:
Cenário: Validar se o carrinho de compra está vazio;

Dado que: Um usuário esteja logado no site https://www.saraiva.com.br/;

Quando: For clicado no botão carrinho;

Então: A tela de meus pedidos deverá ser aberta;
E: E na tela deverá conter o texto "Seu carrinho está vazio!";

-------------

2-> Consultar produto disponível
Contexto: Consultar produto disponível;
Cenário: Consultar um produto que esteja disponível no estoque;

Dado que: Um usuário logado no site https://www.saraiva.com.br/;

Quando: For inserido o nome do produto "iphone 7 32gb Preto Matte" no input Pesquisar;
E: Após pesquisar, for selecionado o produto;

Então: Uma nova tela contendo a descrição do produto juntamente com o valor será exibida;

-------------

3-> Comprar um produto
Contexto: Comprar um produto;
Cenário: Iniciar a compra do produto;

Dado que: Um usuário logado no site https://www.saraiva.com.br/;
E: Esteja na tela com os detalhes do produto, antes da compra;

Quando: O botão Comprar for acionado;

Então: Uma nova tela contendo o produto juntamente com o valor será exibida;

-------------

4-> Escolher produto com 1 quantidade:
Contexto: Escolher produto com 1 quantidade;
Cenário: Definir uma quantidade para o produto e continuar a compra;

Dado que: Um usuário logado no site https://www.saraiva.com.br/;
E: A tela de escolha de quantidade do produto esteja aberta;

Quando: A quantidade for preenchida com 1;
E: o botão Comprar for acionado;

Então: Uma nova tela de confirmação de endereço será exibida;

-------------

5 -> Finalizar a compra com 1 unidade:
Contexto: Finalizar a compra com 1 unidade;
Cenário: Finalizar a compra de um produto passando dados de um cartão ficticio;

Dado que: Tenha sido escolhido uma quantidade do produto;
E: A confirmação de endereço tenha sido feita;
E: A tela para preenchimento dos dados do cartão esteja aberta;

Quando: Os dados ficticios do cartão de crédito for selecionado;
E: o botão Comprar for acionado;

Então: O sistema deverá retornar uma MSG informando que o pagamento não foi aprovado;

-------------

6 -> Remover um produto do carrinho:
Contexto: Remover um produto do carrinho;
Cenário: Remover um produto do carrinho do usuário;

Dado que: Um usuário esteja logado no site https://www.saraiva.com.br/;
E: A tela do carrinho esteja aberta;

Quando: O botão menos (-) for acionado;

Então: Deverá ter sido removido uma quantidade do produto;

-------------

7 -> Finalizar a compra com 2 unidades:
Contexto: Finalizar a compra com 2 unidades;
Cenário: Finalizar a compra de dois produtos passando dados de um cartão ficticio;

Dado que: Tenha sido escolhido duas quantidades do produto;
E: A confirmação de endereço tenha sido feita;
E: A tela para preenchimento dos dados do cartão esteja aberta;

Quando: Os dados ficticios do cartão de crédito for selecionado;
E: o botão Comprar for acionado;

Então: O sistema deverá retornar uma MSG informando que o pagamento não foi aprovado;

-------------

8 -> Remover produtos do carrinho:
Contexto: Remover produtos do carrinho;
Cenário: Remover todos os produtos do carrinho do usuário;

Dado que: Um usuário esteja logado no site https://www.saraiva.com.br/;
E: A tela do carrinho esteja aberta;

Quando: For removido todos os produtos carrinho;

Então: Na tela deverá conter o texto "Seu carrinho está vazio

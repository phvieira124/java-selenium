Feature: Login

  #@buscar_produto
  #Scenario Outline: Buscar produto no catalogo
  #  Given que acesso o mercado livre
  #  When buscar pelo produto <produto>
  #  Then visualizar o produto no catalogo <produto>

  #  Examples:
  #  |produto                                                            |
  #  |"Xiaomi Redmi Note 7 (48 Mpx) Dual SIM 64 GB Neptune blue 4 GB RAM"|
    
   @adcionar_produto_carrinho 
   Scenario Outline: Adicionar produto ao carrinho
   	 Given que acesso o mercado livre
   	 When adiocionar no carrinho o <produto> logando no <usuario> <senha>
   	 Then visualizar o produto no carrinho <produto>
   	 
   	 Examples:
    |produto                                                             |usuario                       |senha        |
    |"Xiaomi Redmi Note 7 (48 Mpx) Dual SIM 64 GB Neptune blue 4 GB RAM" |"pedro.henriquev124@gmail.com"|"Ze.37683680"|
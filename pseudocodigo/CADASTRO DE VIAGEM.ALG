Algoritmo "AGÊNCIA DE VIAGEM"
//MENU
procedimento menu()
inicio
      escreval()
      escreval("********* MENU *********")
      escreval("1 - CADASTRO CLIENTE")
      escreval("2 - CADASTRO DESTINO")
      escreval("3 - PESQUISAR")
      escreval("4 - SAIR")
      escreval()
      escreval()
      escreva("DIGITE O NUMERO DESEJADO: ")
      leia(opcao)

      se opcao = 1 entao
         cadastro_cliente()
      senao
           se opcao = 2 entao
              cadastro_destino()
           senao
                se opcao = 3 entao
                   pesquisar()
                senao
                     se opcao = 4 entao
                        escreval()
                        escreval("*****SISTEMA ENCERRADO*****")
                        opcao <- 100
                     fimse
                fimse
           fimse
      fimse

fimprocedimento

//CADASTRO DE CLIENTES
procedimento cadastro_cliente()
inicio
      escreval()
      escreval ("CADASTRO DE CLIENTES")
      escreval ()

      para i de 1 ate 3 faca
           escreva("Nome do(a) cliente: ")
           leia(clientes[i])
           escreva("CPF do(a) clinte: ")
           leia(cpf[i])
           escreva("Qual o telefone: ")
           leia(telefone[i])
           i<- i+1
           escreval()
      fimpara

      escreval("*****DESEJA CADASTRAR OS DESTINOS?*****")
      escreval("1 - SIM")
      escreval("2 - NÃO")
      leia(opcao)

      se opcao = 1 entao
         cadastro_destino()
      senao
           se opcao = 2 entao
              escreval()
              escreval("+++++++++++++++++++++++++++++++++")
              escreval("+CLIENTES CADASTRADOS COM SUCESSO!+")
              escreval("+++++++++++++++++++++++++++++++++")
              escreval()
           fimse
      fimse
      
      menu()

fimprocedimento

//CADASTRO DE DESTINO
procedimento cadastro_destino()
inicio
      escreval()
      escreval("CADASTRO DE DESTINOS")
      escreval()

      para i de 1 ate 3 faca
           escreva("Cidade: ")
           leia(cidade[i])
           escreva("Valor do destino: ")
           leia(valor[i])
           i <- i+1
           escreval()
      fimpara
      escreval()
      escreval("+++++++++++++++++++++++++++++++++")
      escreval("+DESTINOS CADASTRADOS COM SUCESSO!+")
      escreval("+++++++++++++++++++++++++++++++++")
      escreval()
      
      menu()
      
fimprocedimento

//PESQUISAR CLIENTE/DESTINO
procedimento pesquisar()
inicio
      escreval()
      escreval("PESQUISAR -CLIENTE/DESTINO")
      escreval("1 - CLIENTE")
      escreval("2 - DESTINO")
      escreval("3 - MENU")
      escreval()
      escreva("DIGITE AQUI: ")
      leia(opcao)

      se opcao = 1 entao
         para i de 1 ate 3 faca
              escreval("Nome: ",clientes[i])
              escreval("CPF: ",cpf[i])
              escreval("Telefone",telefone[i])
              escreval("Cidade: ",cidade[i])
              escreval("Valor: ",valor[i])
              escreval()
         fimpara
      senao
           se opcao = 2 entao
              para i de 1 ate 3 faca
                   escreval("Cidade: ",cidade[i])
                   escreval("Valor: ",valor[i])
                   escreval()
              fimpara
           fimse
                se opcao = 3 entao
                   menu()
                fimse
      fimse
      
      escreval()
      escreval("+++++++++++++++++++++++++++++++++")
      escreval("+CLIENTES/DESTINOS CADASTRADOS!+")
      escreval("+++++++++++++++++++++++++++++++++")
      escreval()

fimprocedimento


Var
// Seção de Declarações das variáveis 
clientes: vetor[1..3] de caracter
cpf: vetor[1..3] de caracter
telefone: vetor[1..3] de caracter
cidade: vetor[1..3] de caracter
valor: vetor[1..3] de inteiro
i, opcao: inteiro

Inicio
// Seção de Comandos, procedimento, funções, operadores, etc... 

   menu()

Fimalgoritmo
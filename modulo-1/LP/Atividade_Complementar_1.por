programa {
  funcao inicio() {
    inteiro N1, N2

    escreva("Informe o primeiro númerpo: ")
    leia(N1)

    escreva("Informe o segundo númerpo: ")
    leia(N2)

    se (igualAZero(N2)) {
      escreva("\nNão é possível dividir por 0 (zero)!")
    } 

    escreva("\nValor N1: ", N1)
    escreva("\nValor N2: ", N2)

    escreva("\nSoma: ", soma(N1, N2))
    escreva("\nSubtração: ", subtracao(N1, N2))
    escreva("\nProduto: ", prod(N1, N2))
    escreva("\nDivisão: ", div(N1, N2))


  }

  funcao logico igualAZero(inteiro valor) {
      se (valor == 0) {
        retorne verdadeiro
      } senao {
        retorne falso
      }
  }

  funcao inteiro soma(inteiro num1, inteiro num2) {
    retorne num1 + num2
  }

  funcao inteiro subtracao(inteiro num1, inteiro num2) {
    retorne num1 - num2
  }

  funcao inteiro prod(inteiro num1, inteiro num2) {
    retorne num1 * num2
  }

  funcao real div(inteiro num1, inteiro num2) {
    retorne num1/num2
  }
}

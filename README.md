<h1>Garagem de moto 🏍</h1>
<div align="left">Nesse repositorio tem o programa que Lista, Adiciona, Calcula o valor, Busca por placa e Vende Motos de garagem.</div>
<div align="left">Esse projeto é para avaliação final da matéria de Java da Faculdade</div>

---

<h2 align="left">Ferramentas usadas para o projeto</h2>

<div align="left"><br>

<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-plain.svg" alt="java" height="46" width="65" align="center">
<img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/intellij/intellij-original.svg" alt="intellij" height="50" width="65" align="center">

---
# Intellij

Vou fazer uma breve guia de como usar o Intellij para rodar o programa.

## Pré-requisitos

Antes de começar, precisa estar instalado:

- ```IntelliJ IDEA Community Edition 2023.1.3```
- Caso não tenha baixado aqui está o link para download: <a href="https://www.jetbrains.com/idea/download/other.html">Download do intellij </a>

---

# Instruções para o Intellij

- Após o download do arquivo clique com o ```botão direito``` e vá em ```abrir com``` e escolha opção ```IntelliJ IDEA Community Edition 2023.1.3```
- Após isso siga o passo a passo das imagens a seguir (fique atento as exigências/observações do programa):

Clique no icone verde de play 

![Screenshot_102](https://github.com/leeugmr/Garagem-De-Moto/assets/96838617/6940eacb-abab-4f67-9431-84d16451e975)

Logo abaixo irá pedir informações

![image](https://github.com/leeugmr/Garagem-De-Moto/assets/96838617/c2025add-61cf-4ee5-8bb1-b22afe570369)

Após isso aparecerá 6 opções:

1. Mostrar lista de motos. ```(Mostrará a tabela com todas motos adicionadas)```
2. Inserir moto na garagem. ```(Adicionará uma moto com informações pedidas)```
3. Calcular valor total das motos na garagem. ```(Irá calcular valor de todas as motos na tabela)```
4. Vender moto da garagem. ```(Irá vender a moto da tabela pelo modelo)```
5. Buscar moto por placa. ```(Colocará todas as informações da moto usando a placa)```
0. Sair. ```(Sairá do programa)```

![image](https://github.com/leeugmr/Garagem-De-Moto/assets/96838617/b6375c2d-9b8e-4671-86ba-baa6896da3d2)

-Pronto você agora sabe como mexer no programa :)

---

# Enunciado do trabalho 📝

<details>
  <summary>Codigo disponibilizado para alterações.</summary>
  <br/>

  ```

import java.util.Scanner;
public class ListaProdutos {

    public static void inserirProdutos(String [][] matriz, int linhas, int colunas) {
        Scanner scanner = new Scanner(System.in);
        int linha;

        mostrarProdutos(matriz, linhas, colunas);
        do {
            System.out.println("Informe onde você deseja inserir o produto com valores de 1 à " + linhas);
            linha = scanner.nextInt();
        } while(linha < 1 || linha > linhas);

        System.out.println("Insira o nome do produto: ");
        matriz[linha-1][0] = scanner.next();
        System.out.println("Insira a quantidade de produtos: ");
        matriz[linha-1][1] = scanner.next();
        System.out.println("Insira o valor do produto: ");
        matriz[linha-1][2] = scanner.next();
        System.out.println("Produto adicionado.");
    }

    public static void mostrarProdutos(String [][] matriz, int linhas, int colunas) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Produto | Quantidade | Valor");
        for(int i = 0; i < linhas; i++) {
            System.out.print((i+1) + " - ");
            for(int j = 0; j < colunas; j++) {
                System.out.print(matriz[i][j] + " | ");

            }
            System.out.println();
        }
    }

    public static void calcularValor(String [][] matriz, int linhas) {
        Scanner scanner = new Scanner(System.in);
        Float valorFinal = 0.0f;
        for(int i = 0; i < linhas; i++) {
            if(matriz[i][0] != null) {
                valorFinal = valorFinal + Float.parseFloat(matriz[i][1]) * Float.parseFloat(matriz[i][2]);
            }
        }
        System.out.println("Valor final da lista de compras: " + valorFinal + " R$");
    }

    public static void removerProduto(String [][] matriz, int linhas, String nomeProduto) {
        boolean encontrado = false;
        for(int i = 0; i < linhas; i++) {
            if(matriz[i][0] != null && matriz[i][0].equals(nomeProduto)) {
                encontrado = true;
                matriz[i][0] = null;
                matriz[i][1] = null;
                matriz[i][2] = null;
            }
        }
        if(encontrado) { // if (encontrado == true) {
            System.out.println("Produto removido.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }



    public static void main(String[] args) {
        String [][] lista;
        int produtos, opcao;
        int colunas = 3;
        Scanner scanner = new Scanner(System.in);
        String nomeProduto;

        System.out.println("Insira a quantidade de produtos que serão inseridos na sua lista de compras:");
        produtos = scanner.nextInt();
        lista = new String[produtos][colunas];

        do {
            System.out.println("Escolha uma opção: \n 1 - Mostrar lista de compras. \n 2 - Inserir produtos na lista de compras. \n 3 - Calcular valor dos produtos da lista de compras. \n 4 - Remover produto da lista de compras. \n 0 - Sair.");
            opcao = scanner.nextInt();
            switch(opcao) {
                case 0:
                    break;
                case 1:
                    mostrarProdutos(lista, produtos, colunas);
                    break;
                case 2:
                    inserirProdutos(lista, produtos, colunas);
                    break;
                case 3:
                    calcularValor(lista, produtos);
                    break;
                case 4:
                    System.out.println("Insira o produto a ser removido.");
                    nomeProduto = scanner.next();
                    removerProduto(lista, produtos, nomeProduto);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
}
 ```
  
  </div>
</details> 


**Considerando a implementação acima, proponha as seguintes modificações:**

- Altere a proposta de armazenamento das informações na matriz e faça implementações condizentes ao tema escolhido.
- Crie novas funcionalidades além das que já existem. As funcionalidades novas devem ser essenciais para resolução do problema. Caso nenhuma funcionalidade seja criada o trabalho será desconsiderado.
- Será necessário fazer a validação de todas as interações do usuário.
- A implementação deverá ser feita individualmente.
- O trabalho deverá estar disponível em um repositório público no GitHub.

---

### <p align="left"> Obrigado por ver ❤ </p>

import java.util.Scanner;

public class GaragemMotos {

    public static void inserirMotos(String[][] matriz, int linhas, int colunas) {
        Scanner scanner = new Scanner(System.in);
        int linha;

        mostrarMotos(matriz, linhas, colunas);
        do {
            System.out.println("Informe onde você deseja inserir a moto com valores de 1 a " + linhas);
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Informe um valor numérico válido.");
                scanner.next();
            }
            linha = scanner.nextInt();
        } while (linha < 1 || linha > linhas);
        scanner.nextLine();

        boolean entradaInvalida = true;
        do {
            System.out.println("Insira o modelo da moto: ");
            matriz[linha - 1][0] = validarEntrada(scanner.nextLine());
            if (matriz[linha - 1][0].isEmpty()) {
                System.out.println("Modelo inválido. Insira novamente.");
            } else {
                entradaInvalida = false;
            }
        } while (entradaInvalida);

        entradaInvalida = true;
        do {
            System.out.println("Insira a marca da moto: ");
            matriz[linha - 1][1] = validarEntrada(scanner.nextLine());
            if (matriz[linha - 1][1].isEmpty()) {
                System.out.println("Marca inválida. Insira novamente.");
            } else {
                entradaInvalida = false;
            }
        } while (entradaInvalida);

        entradaInvalida = true;
        do {
            System.out.println("Insira o ano da moto: ");
            matriz[linha - 1][2] = validarEntrada(scanner.nextLine());
            if (matriz[linha - 1][2].isEmpty()) {
                System.out.println("Ano inválido. Insira novamente.");
            } else {
                entradaInvalida = false;
            }
        } while (entradaInvalida);

        entradaInvalida = true;
        do {
            System.out.println("Insira a cor da moto: ");
            matriz[linha - 1][3] = validarEntrada(scanner.nextLine());
            if (matriz[linha - 1][3].isEmpty()) {
                System.out.println("Cor inválida. Insira novamente.");
            } else {
                entradaInvalida = false;
            }
        } while (entradaInvalida);

        entradaInvalida = true;
        do {
            System.out.println("Insira a placa da moto: ");
            matriz[linha - 1][4] = validarPlaca(scanner.nextLine());
            if (matriz[linha - 1][4].isEmpty()) {
                System.out.println("Placa inválida. Insira novamente.");
            } else {
                entradaInvalida = false;
            }
        } while (entradaInvalida);

        entradaInvalida = true;
        do {
            System.out.println("Insira o estado de conservação da moto: ");
            matriz[linha - 1][5] = validarEntrada(scanner.nextLine());
            if (matriz[linha - 1][5].isEmpty()) {
                System.out.println("Estado de conservação inválido. Insira novamente.");
            } else {
                entradaInvalida = false;
            }
        } while (entradaInvalida);

        entradaInvalida = true;
        do {
            System.out.println("Insira o valor da moto: ");
            matriz[linha - 1][6] = validarValor(scanner.nextLine());
            if (matriz[linha - 1][6].isEmpty()) {
                System.out.println("Valor inválido. Insira novamente.");
            } else {
                entradaInvalida = false;
            }
        } while (entradaInvalida);

        System.out.println("Moto adicionada.");
    }

    public static void mostrarMotos(String[][] matriz, int linhas, int colunas) {
        System.out.println("Modelo | Marca | Ano | Cor | Placa | Estado de conservação | Valor");
        for (int i = 0; i < linhas; i++) {
            System.out.print((i + 1) + " - ");
            for (int j = 0; j < colunas; j++) {
                System.out.print(matriz[i][j] + " | ");
            }
            System.out.println();
        }
    }

    public static double calcularValor(String[][] matriz, int linhas) {
        double valorFinal = 0.0;
        for (int i = 0; i < linhas; i++) {
            if (matriz[i][0] != null) {
                valorFinal += Double.parseDouble(matriz[i][6]);
            }
        }
        return valorFinal;
    }

    public static double venderMoto(String[][] matriz, int linhas, String modeloMoto) {
        double valorVendido = 0.0;
        boolean encontrado = false;
        for (int i = 0; i < linhas; i++) {
            if (matriz[i][0] != null && matriz[i][0].equals(modeloMoto)) {
                encontrado = true;
                valorVendido = Double.parseDouble(matriz[i][6]);
                matriz[i][0] = null;
                matriz[i][1] = null;
                matriz[i][2] = null;
                matriz[i][3] = null;
                matriz[i][4] = null;
                matriz[i][5] = null;
                matriz[i][6] = null;
            }
        }
        if (encontrado) {
            System.out.println("Moto vendida.");
        } else {
            System.out.println("Moto não encontrada.");
        }
        return valorVendido;
    }

    public static void buscarMotoPorPlaca(String[][] matriz, int linhas, String placaMoto) {
        boolean encontrado = false;
        System.out.println("Informações da moto:");
        for (int i = 0; i < linhas; i++) {
            if (matriz[i][4] != null && matriz[i][4].equals(placaMoto)) {
                encontrado = true;
                for (int j = 0; j < matriz[i].length; j++) {
                    System.out.println(matriz[i][j]);
                }
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Moto não encontrada.");
        }
    }

    public static String validarEntrada(String entrada) {
        String padrao = "^[a-zA-Z0-9\\s]+$";
        if (!entrada.matches(padrao)) {
            System.out.println("Entrada inválida. Apenas caracteres alfanuméricos são permitidos.");
            return "";
        }
        return entrada;
    }

    public static String validarPlaca(String placa) {
        String padrao = "^[A-Z]{3}-[0-9]{4}$";
        if (!placa.matches(padrao)) {
            System.out.println("Placa inválida. O formato deve ser XXX-9999 (três letras seguidas de hífen e quatro números).");
            return "";
        }
        return placa;
    }

    public static String validarValor(String valor) {
        String padrao = "^[0-9]+(\\.[0-9]+)?$";
        if (!valor.matches(padrao)) {
            System.out.println("Valor inválido. Apenas números positivos são permitidos.");
            return "";
        }
        return valor;
    }

    public static void main(String[] args) {
        String[][] garagem;
        int motos, opcao;
        int colunas = 7;
        Scanner scanner = new Scanner(System.in);
        String modeloMoto;
        String placaMoto;

        System.out.println("Insira a quantidade de motos que serão inseridas na garagem:");
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Informe um valor numérico válido.");
            scanner.next();
        }
        motos = scanner.nextInt();
        garagem = new String[motos][colunas];
        scanner.nextLine(); // Limpa o buffer do scanner

        do {
            System.out.println("Escolha uma opção: \n 1 - Mostrar lista de motos. \n 2 - Inserir moto na garagem. \n 3 - Calcular valor total das motos na garagem. \n 4 - Vender moto da garagem. \n 5 - Buscar moto por placa. \n 0 - Sair.");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida. Informe um valor numérico válido.");
                scanner.next();
            }
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner
            switch (opcao) {
                case 0:
                    break;
                case 1:
                    mostrarMotos(garagem, motos, colunas);
                    break;
                case 2:
                    inserirMotos(garagem, motos, colunas);
                    break;
                case 3:
                    double valorTotal = calcularValor(garagem, motos);
                    System.out.println("Valor total das motos na garagem: " + valorTotal + " R$");
                    break;
                case 4:
                    System.out.println("Insira o modelo da moto a ser vendida:");
                    modeloMoto = scanner.nextLine();
                    double valorVendido = venderMoto(garagem, motos, modeloMoto);
                    if (valorVendido > 0.0) {
                        System.out.println("Valor da moto vendida: " + valorVendido + " R$");
                    } else {
                        System.out.println("A moto com o modelo " + modeloMoto + " não foi encontrada na garagem.");
                    }
                    break;
                case 5:
                    System.out.println("Insira a placa da moto a ser buscada:");
                    placaMoto = scanner.nextLine();
                    buscarMotoPorPlaca(garagem, motos, placaMoto);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }
}

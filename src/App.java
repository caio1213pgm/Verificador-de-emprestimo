import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("____Empréstimo Financeiro____");

        // Leitura da renda mensal
        System.out.printf("Digite sua renda mensal..............................................:");
        double rendaMensal = sc.nextDouble();

        // Leitura do valor do empréstimo
        System.out.printf("Digite o valor do empréstimo.........................................:");
        double emprestimo = sc.nextDouble();

        // Leitura do histórico de crédito
        System.out.printf("Digite seu histórico de crédito (B = bom, R = ruim)..................:");
        char historico = sc.next().charAt(0);

        // Leitura da estabilidade do emprego
        System.out.printf("Digite a sua estabilidade no emprego (E = estável, I = instável).....:");
        char estabilidade = sc.next().charAt(0);

        // Leitura do valor de entrada
        System.out.printf("Digite o valor da entrada............................................:");
        double  entrada = sc.nextDouble();

        // Chamada da função que executa as verificações do empréstimo
        verificadorGeralEmprestimo(historico, estabilidade, entrada, emprestimo, rendaMensal);

        sc.close();
    }
    // Função que verifica se o valor da entrada é maior que 10% do empréstimo
    public static boolean verificarEntrada(double entrada, double emprestimo){
        if (entrada >= 0.1 * emprestimo) {
            return true;
        }
        else{
            System.out.println("O seu valor de entrada precisa ser maior que 10% do seu empréstimo");
            return false;
        }
    }

    // Função que verifica se o histórico de crédito é bom e se tem um emprego estável
    public static boolean verificarHeE(char  historico, char estabilidade){ 
        if (historico == 'B' && estabilidade == 'E') {
            return true;
        }
        else{
            System.out.println("Você não possui um histórico de crédito bom e não está estável no emprego");
            return false;
        }
    }

    // Função que verifica se o valor do empréstimo é menor que 30% da renda mensal dele
    public static boolean verificarEmprestimo(double emprestimo, double rendaMensal){
        if (emprestimo <= 0.3 * rendaMensal) {
            return true;
        }
        else{
            System.out.println("O valor do seu empréstimo não pode ser maior que 30% do seu salário");
            return false;
        }
    }

    // função que verifica por etapas se ele está apto para fazer o empréstimo e retorna as mensagens em caso contrário
    public static void verificadorGeralEmprestimo(char historico, char estabilidade, double entrada, double emprestimo, double rendaMensal){
        if (verificarEmprestimo(emprestimo, rendaMensal) && verificarHeE(historico, estabilidade) && verificarEntrada(entrada, emprestimo)) {
            System.out.println("Parabéns! Seu empréstimo foi aprovado");
        }
        System.out.println("Infelizmente seu empréstimo foi negado.");
    }
}
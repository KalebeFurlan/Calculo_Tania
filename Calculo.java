import java.util.Scanner;

public class Calculo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o valor de x: ");
        double x = sc.nextDouble();

        double resultado = calcularFuncao(x);

        System.out.println("O resultado da função para x = " + x + " é " + resultado);

        sc.close();
    }

    public static double calcularFuncao(double x) {
        double resultado = Math.pow(x, 3) - 9 * x + 3;
        return resultado;
    }
}
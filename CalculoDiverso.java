import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Scanner;

public class CalculoDivero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a expressão matemática: ");
        String expressao = sc.nextLine();

        double resultado = calcular(expressao);

        System.out.println("O resultado da expressão " + expressao + " é " + resultado);

        sc.close();
    }

    public static double calcular(String expressao) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");

        try {
            Object result = engine.eval(expressao);
            return Double.parseDouble(result.toString());
        } catch (ScriptException e) {
            System.err.println("Erro ao calcular expressão: " + e.getMessage());
            return Double.NaN;
        }
    }
}

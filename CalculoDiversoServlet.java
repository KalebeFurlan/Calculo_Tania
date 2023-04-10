import java.io.IOException;
import java.io.PrintWriter;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculoDiversoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String expressao = request.getParameter("expressao");
        double resultado = calcular(expressao);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Resultado</title></head>");
        out.println("<body>");
        out.println("<h1>O resultado da expressão " + expressao + " é " + resultado + "</h1>");
        out.println("</body>");
        out.println("</html>");
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

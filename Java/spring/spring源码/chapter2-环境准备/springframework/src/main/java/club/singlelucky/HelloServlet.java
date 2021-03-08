package club.singlelucky;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description: TODO
 * @author: liangruuu
 * @date: 2021/3/7
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = "simpleFramework";
        // jspҳ������һ��name���Ա���ֵ��name
        request.setAttribute("name", name);
        // ������ת����jspҳ����д���jspҳ��һ������/WEB-INF/jspĿ¼��
        request.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(request, response);
    }
}

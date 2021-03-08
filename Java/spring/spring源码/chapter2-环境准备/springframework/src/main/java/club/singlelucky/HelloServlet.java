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
        // jsp页面其中一个name属性被赋值成name
        request.setAttribute("name", name);
        // 把请求转发到jsp页面进行处理，jsp页面一般存放在/WEB-INF/jsp目录下
        request.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(request, response);
    }
}

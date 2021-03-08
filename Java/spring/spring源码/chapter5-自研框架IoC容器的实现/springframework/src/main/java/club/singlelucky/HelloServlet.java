package club.singlelucky;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
@Slf4j
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    public void init() {
        System.out.println("init Servlet...");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet entrance...");
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = "simpleFramework";
        log.debug("name is " + name);
        // jsp页面其中一个name属性被赋值成name
        req.setAttribute("name", name);
        // 把请求转发到jsp页面进行处理，jsp页面一般存放在/WEB-INF/jsp目录下
        req.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("destroy...");
    }
}

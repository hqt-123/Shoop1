package cn.shoop.contrller;

import cn.shoop.utils.ThUtils;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowLoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Context context = new Context();

        //取出Cookie中的用户名和密码
        Cookie[] cookies = request.getCookies();
        //遍历所有cookie
        for (Cookie cookie : cookies) {
            //判断cookie名字为用户名
            if(cookie.getName().equals("username")){
                String username = cookie.getValue();
                //用户名可能会有中文 需要进行url解码
                //username = URLDecoder.decode(username, "UTF-8");
                context.setVariable("username", username);
            }
            //判断cookie名字为密码
            if(cookie.getName().equals("password")){
                String password = cookie.getValue();
                context.setVariable("password", password);
            }
        }
        ThUtils.print("login.html", context, response);
    }
}

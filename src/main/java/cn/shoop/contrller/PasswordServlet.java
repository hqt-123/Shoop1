package cn.shoop.contrller;

import cn.shoop.dao.UserDao;
import cn.shoop.entity.User;
import cn.shoop.utils.ThUtils;
import org.thymeleaf.context.Context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Array;
import java.util.List;

public class PasswordServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Context context = new Context();
        String email = request.getParameter("email");
        System.out.println(email);

        UserDao dao  = new UserDao();
        User user =  dao.password(email);
        System.out.println(user);
//        List<User> list = dao.password(email);
//        System.out.println(list);
//        if (email == null){
//            response.sendRedirect(request.getContextPath()+"/ShowLoginServlet");
//        }else {
//            System.out.println("方法");
//        }
        if (email != null) {

            }
        }
    }




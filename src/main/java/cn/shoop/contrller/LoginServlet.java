package cn.shoop.contrller;

import cn.shoop.dao.UserDao;
import cn.shoop.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("UTF-8");
        //获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String  avater = request.getParameter("avater");
        String created = request.getParameter("created");
        String updated = request.getParameter("updated");
        System.out.println(username + ":" + password+":"+phone+":"+email+":"+gender+":"+avater+":"+created+":"+updated);
        //创建Dao并调用login方法
        UserDao dao = new UserDao();
        User user = dao.login(username, password);
        if (user == null) {//登录失败
            //重定向到登录页面继续登录
            response.sendRedirect(
                    request.getContextPath() + "/ShowLoginServlet");
        } else {//登录成功
            //获取记住用户名和密码的多选框的值
            String rem = request.getParameter("rem");
            System.out.println("rem=" + rem);
            if (rem != null) {//需要记住用户名和密码
                //创建Cookie对象把用户名和密码保存
                //Cookie里面保存中文的话需要进行url编码
                //username = URLEncoder.encode(username, "UTF-8");

                Cookie c1 = new Cookie("username", username);
                Cookie c2 = new Cookie("password", password);
                //设置保存时间,默认时间为会话时间(数据保存在浏览器
                //内存中,浏览器关闭则删除),如果设置了时间cookie会保存在
                //磁盘中时间到了之后才会删除
                c1.setMaxAge(30 * 24 * 60 * 60); //保存一个月
                //将Cookie对象下发到浏览器中
                response.addCookie(c1);
                response.addCookie(c2);
            }

            response.sendRedirect(request.getContextPath() + "/IndexServlet");
        }
    }
}
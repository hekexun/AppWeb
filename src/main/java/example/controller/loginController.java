package example.controller;

import example.service.loginService;
import example.service.loginServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Controller
public class loginController {
    @RequestMapping(value="/login.do")
    public @ResponseBody
    String loginVerify(HttpServletRequest request, HttpServletResponse response,String username,String passwd) {
        System.out.println("123");
        try {
            loginService login= new loginServiceImpl();
            int state=login.loginCheck(username,passwd);//0用户不存在，1密码错误，2，登录成功
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();
            out.print(state);
            return null;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
}
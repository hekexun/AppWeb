package example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Controller
public class IndexController {
    @RequestMapping(value="/hello.do")
    public @ResponseBody
    String loginVerify(HttpServletRequest request, HttpServletResponse response,String username,String passwd) {
        System.out.println("123");
       String A= username;
        String B= passwd;
        try {

            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out=response.getWriter();
            out.print("返回的值");
            return null;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
}

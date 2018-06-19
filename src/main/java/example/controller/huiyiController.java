package example.controller;

import example.pojo.userPojo;
import example.service.insertUserService;
import example.service.insertUserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Controller
public class huiyiController {
    @RequestMapping(value="/user.do")
    public @ResponseBody
    String loginVerify(HttpServletRequest request, HttpServletResponse response,String name,String telphone,String mail,String company,String zhiwei,String beizhu) {
        System.out.println("123");
        userPojo user=new userPojo();
        try {

            if(name.equals("")||mail.equals("")||telphone.equals("")||company.equals("")&zhiwei.equals("") )
            {
                int a=0;
            }
            else
            {
                user.setName(name);
                user.setMail(mail);
                user.setTelphone(telphone);
                user.setCompany(company);
                user.setZhiwei(zhiwei);
                user.setBeizhu(beizhu);
                insertUserService in=new insertUserServiceImpl();
                String result=in.userHandle(user);
                request.setCharacterEncoding("utf-8");
                response.setContentType("text/html;charset=utf-8");
                PrintWriter out=response.getWriter();
                out.print(result);
            }
            return null;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
}

package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
@SessionAttributes({"message","admin.name"})
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/login")

    public String login(Admin admin,HttpServletRequest request,String enCode){

        HttpSession session = request.getSession();
        String validationCode = (String) session.getAttribute("validationCode");

        //System.out.println(validationCode);
       // System.out.println(enCode);

        if (validationCode.equals(enCode)) {
            Admin login = adminService.login(admin);
            if(login!=null){
                session.setAttribute("admin",login);
                //System.out.println(login);
                return "redirect:/main/main.jsp";
            }else{
                return "redirect:/admin/login.jsp";
            }

        }else {
            return "redirect:/admin/login.jsp";
        }
    }

    @RequestMapping("/loginout")
    public String loginout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/admin/login.jsp";

    }


    @RequestMapping("/update")
    public String update(Admin admin){

        adminService.update(admin);
        return "redirect:/admin/login.jsp";
    }


}

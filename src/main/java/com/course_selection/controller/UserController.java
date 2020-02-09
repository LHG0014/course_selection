package com.course_selection.controller;

import com.course_selection.mapper.ExperimentMapper;
import com.course_selection.mapper.StudentMapper;
import com.course_selection.pojo.Student;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class UserController extends HttpServlet {
    private static final Logger log= LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = {"/to/login","/unauth"})
    public String toLogin(){
        return "login";
    }

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private ExperimentMapper experimentMapper;

    @Autowired
    private Environment environment;

    /**
     * 登陆真证
     * @param sid
     * @param password
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam Integer sid, @RequestParam String password, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response ) throws IOException, InterruptedException {
        String errorMeg="";
        try{
            if(!SecurityUtils.getSubject().isAuthenticated()){
                String sid_02=sid.toString();
                String newPwd=new Md5Hash(password,environment.getProperty("shiro.encrypt.password.salt")).toString();
                UsernamePasswordToken token=new UsernamePasswordToken(sid_02,newPwd);
                SecurityUtils.getSubject().login(token);
            }
        }catch (UnknownAccountException e){

            errorMeg=e.getMessage();
            modelMap.addAttribute("sid",sid);
            log.info("错误是：",errorMeg);
        }catch (DisabledAccountException e){

            errorMeg=e.getMessage();
            modelMap.addAttribute("sid",sid);
            log.info("错误是：",errorMeg);
        }catch (IncorrectCredentialsException e){

            errorMeg=e.getMessage();
            modelMap.addAttribute("sid",sid);
            log.info("错误是：",errorMeg);
        }catch (Exception e){
            errorMeg="用户登录异常，请联系管理员!";
            e.printStackTrace();
            log.info("错误是：",errorMeg);
        }
        if(StringUtils.isBlank(errorMeg)){

            errorMeg=null;
            modelMap.addAttribute("errorMeg",errorMeg);

            Student student=studentMapper.findBySid(sid);
            request.getSession(true).setAttribute("student", student);
            return "homePage";
        }else{
            modelMap.addAttribute("errorMeg",errorMeg);
            return "login";
        }
    }

    @RequestMapping(value = {"/updateStudent"})
    public String changePassword(HttpServletRequest request, HttpServletResponse response){
        Student student=(Student) request.getSession().getAttribute("student");
        if(student==null){
            return "homePage";
        }
        request.getSession(false).setAttribute("student", student);
        return "updatePassword";
    }

    @RequestMapping(value = {"changePassword"})
    public String changePassword(HttpServletRequest request, HttpServletResponse response,
                                 @RequestParam("sid") Integer sid,
                                 @RequestParam("sname") String sname,
                                 @RequestParam("password") String password,
                                 @RequestParam("password_new") String password_new) {
        String newPwd=new Md5Hash(password,environment.getProperty("shiro.encrypt.password.salt")).toString();
        Student student=(Student) request.getSession().getAttribute("student");

        if (student.getPassword().equals(newPwd) && student.getSname().equals(sname)) {
            System.out.println(student.toString());
            String salt="92dd90534a404926b50a43c7a3c5b79e";
            password_new=new Md5Hash(password_new,salt).toString();
            System.out.println(password_new);
            System.out.println(password_new+"NNNNNNNNNNNNNNN");
            studentMapper.changePassword(sid, password, password_new, student.getId());
            return "redirect:experiments";
        }
        return "homePage";
    }

    @RequestMapping(value = {"/logout"})
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "login";
    }


}

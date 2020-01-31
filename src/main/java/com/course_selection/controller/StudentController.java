package com.course_selection.controller;


import com.course_selection.mapper.ExperimentMapper;
import com.course_selection.mapper.MailboxMapper;
import com.course_selection.mapper.MessageMapper;
import com.course_selection.mapper.StudentMapper;
import com.course_selection.pojo.Experiment;
import com.course_selection.pojo.Mailbox;
import com.course_selection.pojo.Message;
import com.course_selection.pojo.Student;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    ExperimentMapper experimentMapper;

    @Autowired
    MessageMapper messageMapper;

    @Autowired
    MailboxMapper mailboxMapper;


    @RequestMapping("/loginStudent")
    public String login(Model m,
                        @Param("sid") Integer sid,
                        @Param("password") String password,
                        HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("sid=" + sid + " password=" + password);
        Student student = studentMapper.login(sid, password);
        System.out.println(student);
        if (null != student) {
            request.getSession(false).setAttribute("student", student);
            List<Experiment> experiments = experimentMapper.findAllE();
            request.getSession(false).setAttribute("experiments", experiments);
            return "redirect:/homepage";
        }
        return "redirect:/login";
    }

    @RequestMapping("/schedule_experiments")

    public String Appointment(HttpServletRequest request, HttpServletResponse response, @Param("id") Integer id) {
        //System.out.println(id);
        Student student = studentMapper.findById(id);
        //System.out.println(student.toString());
        request.getSession(false).setAttribute("student", student);
        return "/schedule_experiments";
    }

    @RequestMapping("updateStudent")
    public String updateStudent(HttpServletRequest request, HttpServletResponse response, @Param("id") Integer id) {
        Student student = studentMapper.findById(id);
        request.getSession(false).setAttribute("student", student);
        return "/updatePassword";
    }

    @RequestMapping("changePassword")
    public String changePassword(HttpServletRequest request, HttpServletResponse response,
                                 @Param("id") Integer id,
                                 @Param("sid") Integer sid,
                                 @Param("sname") String sname,
                                 @Param("password") String password,
                                 @Param("password_new") String password_new) {
        Student student = studentMapper.findById(id);
        if (student.getPassword().equals(password) || student.getSname().equals(sname)) {
            studentMapper.changePassword(sid, password, password_new, sname);
            return "/schedule_experiments";
        }
        return "homePage";
    }


    @RequestMapping("/homePage")
    public String homePage(Model m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        PageHelper.startPage(start, size, "id asc");//根据start,size进行分页，并且设置id 倒排序
        List<Student> cs = studentMapper.findAll();
        PageInfo<Student> page = new PageInfo<>(cs);//根据返回的集合，创建PageInfo对象
        m.addAttribute("page", page);
        return "homePage";
    }


    //cx-edit
//    @RequestMapping("/message")
//    public String message(  HttpServletRequest request, HttpServletResponse response,
//                            Model model,
//                            @Param("sid") Integer sid
//                            ) throws  Exception{
//        HttpSession session = request.getSession();//获取session内容
//        sid=((Student)session.getAttribute("student")).getSid();
//        List<Message> messages= messageMapper.findMessage(sid);
//        request.getSession(false).setAttribute("mes",messages);
////        model.addAttribute("mes",messages);//-》request...的替代者
//        return "message";
//    }
//    @RequestMapping("/addMessage")
//    public String addDiary(HttpServletRequest request, HttpServletResponse response,Message c,
//                             @Param("sid") Integer sid, @Param("sname") String sname,@Param("time") String time,
//                           @Param("to") String to,@Param("content") String content
//                           ) throws Exception {
//        HttpSession session = request.getSession();//获取session内容
//        sid=((Student)session.getAttribute("student")).getSid();
//        sname=((Student)session.getAttribute("student")).getSname();
//        Date d = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss ");
//        time=sdf.format(d);
//        to=c.getTo();
//        content=c.getContent();
//        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
//        messageMapper.save(sid,sname,time,to,content);
//        return "redirect:homePage";
//    }
//
//    @RequestMapping("/mailbox")
//    public String mailbox(HttpServletRequest request, HttpServletResponse response,
//                          Model model,
//                          @Param("sid") Integer sid
//    ) throws  Exception{
//        HttpSession session = request.getSession();//获取session内容
//        sid=((Student)session.getAttribute("student")).getSid();
//        List<Mailbox> mail= mailboxMapper.findMail(sid);
//        request.getSession(false).setAttribute("mail",mail);
////        model.addAttribute("mes",messages);//-》request...的替代者
//        return "mailbox";
//    }
//
//    @RequestMapping("/addMail")
//    public String addMail(HttpServletRequest request, HttpServletResponse response, Mailbox c,
//                          @Param("sid") Integer sid, @Param("sname") String sname, @Param("title") String title,
//                          @Param("content") String content, @Param("time") String time
//    ) throws Exception {
//        HttpSession session = request.getSession();//获取session内容
//        sid=((Student)session.getAttribute("student")).getSid();
//        sname=((Student)session.getAttribute("student")).getSname();
//        title=c.getTitle();
//        content=c.getContent();
//        Date d = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss ");
//        time=sdf.format(d);
//        sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
//        mailboxMapper.save(sid,sname,title,content,time);
//        return "redirect:homePage";
//    }

}

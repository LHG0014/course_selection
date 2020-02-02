package com.course_selection.controller;

import com.course_selection.mapper.ExperimentMapper;
import com.course_selection.mapper.LostFoundMapper;

import com.course_selection.mapper.MailboxMapper;
import com.course_selection.mapper.MessageMapper;

import com.course_selection.pojo.*;
import com.course_selection.service.CourseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private LostFoundMapper lostfoundMapper;
    @Autowired
    private ExperimentMapper experimentMapper;
    @Autowired
    private CourseService courseService;
    @Autowired
    private MailboxMapper mailboxMapper;
    @Autowired
    private MessageMapper messageMapper;

    @RequestMapping("/lostfound")
    public String lostfound(Model m,
                            @RequestParam(value = "start", defaultValue = "0")
                                    int start, @RequestParam(value = "size", defaultValue = "5")
                                    int size) throws Exception {
        PageHelper.startPage(start, size, "id desc");//根据start,size进行分页，并且设置id 倒排序
        List<Lost_Found> lf = lostfoundMapper.findalllost_found();
        PageInfo<Lost_Found> page = new PageInfo<>(lf);//根据返回的集合，创建PageInfo对象
        m.addAttribute("page", page);
        return "lostfound";
    }

    @RequestMapping("/mailbox")
    public String mailbox(HttpServletRequest request, HttpServletResponse response
    ) throws  Exception{
        Student student = (Student) request.getSession().getAttribute("student");
        if (null == student) {
            return "login";
        }
        HttpSession session = request.getSession();//获取session内容
        Integer sid=((Student)session.getAttribute("student")).getSid();
        List<Mailbox> mail= mailboxMapper.findMail(sid);
        request.getSession(false).setAttribute("mail",mail);
        return "mailbox";
    }

    @RequestMapping("/message")
    public String message(  HttpServletRequest request, HttpServletResponse response
//                            @Param("sid") Integer sid
    ) throws  Exception{
        List<Message> messages= messageMapper.findMessage();
        request.getSession(false).setAttribute("mes",messages);
        return "message";
    }

    @RequestMapping("/experiments")
    public String experiments() {
        return "schedule_experiments";
    }

    @RequestMapping("/operating")
    public String operating(HttpServletResponse response, HttpServletRequest request) {
        ShowExperiment showExperiment=(ShowExperiment) request.getSession().getAttribute("showExperiment");
        Student student = showExperiment.getStudent();
        if (null == student) {
            return "login";
        }
        return "schedule_operating";
    }

    @RequestMapping("/search")
    public String search(HttpServletResponse response, HttpServletRequest request) {
        ShowExperiment showExperiment=(ShowExperiment) request.getSession().getAttribute("showExperiment");
        Student student = showExperiment.getStudent();
        if (null == student) {
            return "login";
        }
        List<Selection_Information> sis = courseService.selected(student.getSid());
        request.setAttribute("sis", sis);
        return "search_operating";
    }

    @RequestMapping({"/homepage","/"})
    public String homepage(HttpServletRequest request, HttpServletResponse response) {
        List<Experiment> experiments = experimentMapper.findAllE();
        request.setAttribute("experiments", experiments);
        return "homePage";
    }

    @RequestMapping("/query_teacher")
    public String query_teacher() {
        return "query_teacher";
    }

}

package com.course_selection.controller;

import com.course_selection.mapper.ExperimentMapper;
import com.course_selection.mapper.LostFoundMapper;

import com.course_selection.mapper.MailboxMapper;
import com.course_selection.mapper.MessageMapper;

import com.course_selection.pojo.*;
import com.course_selection.service.impl.CourseServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
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
    private RedisTemplate<Object,Object> redisTemplate;
    @Autowired
    private LostFoundMapper lostfoundMapper;
    @Autowired
    private ExperimentMapper experimentMapper;
    @Autowired
    private CourseServiceImpl courseService;
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
        HttpSession session = request.getSession();//获取session内容
        Integer sid=((Student)session.getAttribute("student")).getSid();
        List<Mailbox> mail= mailboxMapper.findMail(sid);
        request.getSession(false).setAttribute("mail",mail);
        return "mailbox";
    }

    @RequestMapping("/message")
    public String message(  HttpServletRequest request, HttpServletResponse response) throws  Exception{
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
    Student student=(Student) request.getSession().getAttribute("student");
    if (null == student) {
        return "login";
    }
    return "schedule_operating";
    }

    @RequestMapping("/search")
    public String search(HttpServletResponse response, HttpServletRequest request) {
        Student student=(Student) request.getSession().getAttribute("student");
        if (null == student) {
            return "login";
        }
        List<Selection_Information> sis = courseService.selected(student.getSid());
        request.setAttribute("sis", sis);
        return "search_operating";
    }

    @RequestMapping({"/homepage","/"})
    public String homepage(HttpServletRequest request, HttpServletResponse response) {
        RedisSerializer redisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(redisSerializer);
        List<Experiment> experiments = (List<Experiment>) redisTemplate.opsForValue().get("experiments");
        if (experiments == null) {
            synchronized (this){
                experiments = (List<Experiment>) redisTemplate.opsForValue().get("experiments");
                if (experiments == null) {
                    System.out.println("查询数据库");
                    experiments = experimentMapper.findAllE();
                    redisTemplate.opsForValue().set("experiments",experiments);
                }else {
                    System.out.println("查询Redis");
                }
            }
        }else{
            System.out.println("查询Redis");
        }
        request.setAttribute("experiments", experiments);
        return "homePage";
    }

    @RequestMapping("/query_teacher")
    public String query_teacher() {
        return "query_teacher";
    }
//教师主页
    @RequestMapping("/homePage_teacher")
    public String homePage_teacher(){
        return "homePage_teacher";
    }


//    cx-edit

//    教师通道
    @RequestMapping("/teacher_channel")
    public String teacher_channel() {
        return "teacher_channel";
    }

//    发布注意事项
    @RequestMapping("/post_notes")
    public String post_notes() {
        return "post_notes";
    }

//    发布信息主目录
    @RequestMapping("/post_content")
    public String post_content() {
        return "post_content";
    }

//    发布通知
    @RequestMapping("/post_notice")
    public String post_notice() {
        return "post_notice";
    }

//    发布实验室守则
    @RequestMapping("/post_rules")
    public String post_rules() {
        return "post_rules";
    }

    //    发布实验室开放信息
    @RequestMapping("/post_openInfo")
    public String post_openInfo() {
        return "post_openInfo";
    }

    //回复留言
    @RequestMapping("/reply_message")
    public String reply_message(HttpServletRequest request, HttpServletResponse response) {
        List<Message> messages= messageMapper.findMessage();
        request.getSession(false).setAttribute("mes",messages);
        return "reply_message";
    }

    //重置密码
    @RequestMapping("/reset_password")
    public String reset_password() {
        return "reset_password";
    }

    //设置开学日期
    @RequestMapping("/set_startDate")
    public String set_startDate() {
        return "set_startDate";
    }

}

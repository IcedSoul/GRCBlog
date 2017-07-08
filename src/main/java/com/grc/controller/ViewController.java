package com.grc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 14437 on 2017/6/30.
 */
@Controller
public class ViewController {
    @RequestMapping(value = "/blogContent")
    public String blogContent(){
        return "blog_content.html";
    }

    @RequestMapping(value = "/blogSort")
    public String blogSort(){
        return "blog_sort.html";
    }

    @RequestMapping(value = "/index")
    public String index(){
        return "index.html";
    }

    @RequestMapping(value = "/loginRegister")
    public String loginRegister(){
        return "login_register.html";
    }

    @RequestMapping(value = "/personalHomepage")
    public String personalHomepage(){
        return "personal_homepage.html";
    }

    @RequestMapping(value = "/personalInfo")
    public String personalInfo(){
        return "personal_info.html";
    }

    @RequestMapping(value = "/question")
    public String blogCOntent(){
        return "question.html";
    }

    @RequestMapping(value = "/questionHomepage")
    public String questionHomepage(){
        return "question_homepage.html";
    }

    @RequestMapping(value = "/searchResult")
    public String searchResult(){
        return "search_result.html";
    }

    @RequestMapping(value = "/uploadContent")
    public String uploadContent(){
        return "upload_content.html";
    }

    @RequestMapping(value = "/uploadFile")
    public String uploadFile(){
        return "upload_file.html";
    }

    @RequestMapping(value = "/writeBlog")
    public String writeBlog(){
        return "write_blog.html";
    }

    @RequestMapping(value = "/writeQuestion")
    public String writeQuestion(){
        return "write_question.html";
    }
}

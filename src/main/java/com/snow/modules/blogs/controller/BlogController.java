package com.snow.modules.blogs.controller;

import com.snow.modules.blogs.model.SBlogEntity;
import com.snow.modules.blogs.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Kelvin on 2017/2/9.
 */
@Controller
public class BlogController {

    @Autowired
    BlogRepository blogRepository;

    // 查看所有博文
    @RequestMapping(value = "/admin/blogs", method = RequestMethod.GET)
    public String showBlogs(ModelMap modelMap) {
        List<SBlogEntity> blogList = blogRepository.findAll();
        modelMap.addAttribute("blogList", blogList);
        return "admin/blogs";
    }
}

package com.snow.controller;

import com.snow.model.SUserEntity;
import com.snow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * （1）@Controller注解：采用注解的方式，可以明确地定义该类为处理请求的Controller类；
 * <p>
 * （2）@RequestMapping()注解：用于定义一个请求映射，value为请求的url，值为 / 说明，该请求首页请求，method用以指定该请求类型，一般为get和post；
 * <p>
 * （3）return "index"：处理完该请求后返回的页面，此请求返回 index.jsp页面。
 */
@Controller
public class MainController {

    private static final String TAG = MainController.class.getSimpleName();

    // 自动装配数据库接口，不需要再写原始的Connection来操作数据库
    @Autowired
    UserRepository userRepository;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/reqTest", method = RequestMethod.GET)
    @ResponseBody
    public String reqTest() {
        return "{json:1}";
    }

    @RequestMapping(value = "/admin/allUsers", method = RequestMethod.GET)
    public String getUsers(ModelMap modelMap) {

        // 查询user表中所有记录
        List<SUserEntity> userList = userRepository.findAll();

        // 将所有记录传递给要返回的jsp页面，放在userList当中
        modelMap.addAttribute("userList", userList);

        // 返回pages目录下的admin/allUsers.jsp页面
        return "admin/allUsers";
    }

    // get请求，访问添加用户 页面
    @RequestMapping(value = "/admin/users/add", method = RequestMethod.GET)
    public String addUser() {
        // 转到 admin/addUser.jsp页面
        return "admin/addUser";
    }

    @RequestMapping(value = "/admin/users/show/{id}", method = RequestMethod.GET)
    public String showUser(@PathVariable("id") Integer userId, ModelMap modelMap) {

        // 找到userId所表示的用户
        SUserEntity userEntity = userRepository.findOne(userId);

        // 传递给请求页面
        modelMap.addAttribute("user", userEntity);
        return "admin/userDetail";
    }


    // post请求，处理添加用户请求，并重定向到用户管理页面
    @RequestMapping(value = "/admin/users/addP", method = RequestMethod.POST)
    public String addUserPost(@ModelAttribute("user") SUserEntity userEntity) {
        // 注意此处，post请求传递过来的是一个UserEntity对象，里面包含了该用户的信息
        // 通过@ModelAttribute()注解可以获取传递过来的'user'，并创建这个对象

        // 数据库中添加一个用户，该步暂时不会刷新缓存
        //userRepository.save(userEntity);

        // 数据库中添加一个用户，并立即刷新缓存
        userEntity.setUserId(UUID.randomUUID().toString());
        userRepository.saveAndFlush(userEntity);

        // 重定向到用户管理页面，方法为 redirect:url
        return "redirect:/admin/users";
    }

    // 更新用户信息 页面
    @RequestMapping(value = "/admin/users/update/{id}", method = RequestMethod.GET)
    public String updateUser(@PathVariable("id") Integer userId, ModelMap modelMap) {

        // 找到userId所表示的用户
        SUserEntity userEntity = userRepository.findOne(userId);

        // 传递给请求页面
        modelMap.addAttribute("user", userEntity);
        return "admin/updateUser";
    }

    // 更新用户信息 操作
    @RequestMapping(value = "/admin/users/updateP", method = RequestMethod.POST)
    public String updateUserPost(@ModelAttribute("userP") SUserEntity user) {

        // 更新用户信息
        userRepository.updateUser(user.getNickName(), user.getRealName(),
                user.getPhoneNum(), user.getPwd(), user.getId());
        userRepository.flush(); // 刷新缓冲区
        return "redirect:/admin/users";
    }

    // 删除用户
    @RequestMapping(value = "/admin/users/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") Integer userId) {

        // 删除id为userId的用户
        userRepository.delete(userId);
        // 立即刷新
        userRepository.flush();
        return "redirect:/admin/users";
    }
}


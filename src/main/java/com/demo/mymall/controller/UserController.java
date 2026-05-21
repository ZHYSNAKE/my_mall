package com.demo.mymall.controller;

import com.demo.mymall.entity.User;
import com.demo.mymall.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller//返回页面
              //@RestController 返回json或xml 前后端分离用
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "user/login";
    }


    @PostMapping("/login")//提交，创建数据，会改变服务器状态
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,  //让服务器能识别出"这是同一个用户"，并在多次请求之间保存数据
                        Model model) {

        model.addAttribute("username", username);
        model.addAttribute("password", password);

        // 调用 Service 层进行登录验证
        User user = userService.login(username, password,session);

        if (user != null) {
            // 登录成功，保存用户信息到 session
            session.setAttribute("loginUser", user);
            // 重定向到用户列表页（或首页）
           return "redirect:/";// redirect: 后面的是跳到的网站地址
        } else {
            // 登录失败，返回错误信息
            model.addAttribute("error", "用户名或密码错误");
            model.addAttribute("username", username);
            model.addAttribute("password", password);
            return "user/login"; // 重新返回登录页
        }
    }

        /**
         * 1. GET：显示注册页面（让用户输入用户名和密码）
         * 访问：GET /register
         */
        @GetMapping("/register")
        public String showRegisterPage(Model model) {
            // 创建一个空的 User 对象，用于表单绑定
            model.addAttribute("user", new User());
            return "user/register"; // 返回注册页面，用户在这里输入用户名和密码
        }

        /**
         * 2. POST：接收用户提交的用户名和密码
         * 访问：POST user/register
         */
        @PostMapping("/register")
        public String handleRegister(@RequestParam String username,
                                     @RequestParam String password,
                                     Model model) {

            // 将输入的数据传回页面（保留在输入框中）
            model.addAttribute("username", username);
            model.addAttribute("password", password);

            // 验证用户名不能为空
            if (username == null || username.trim().isEmpty()) {
                model.addAttribute("error", "用户名不能为空");
                return "user/register";
            }

            // 验证密码不能为空
            if (password == null || password.trim().isEmpty()) {
                model.addAttribute("error", "密码不能为空");
                model.addAttribute("username", username);  // 保留用户名
                return "user/register";
            }

            // 创建用户对象
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);

            // 调用 Service 注册
            boolean success = userService.register(user);

            if (success) {
                return "redirect:/login"; // 注册成功，去登录 redirect: 后面的是跳到的网站地址
            } else {
                model.addAttribute("error", "用户名已存在");
                model.addAttribute("username", username);  // 保留用户名
                model.addAttribute("password", password);
                return "user/register"; // 注册失败，返回注册页
            }

        }
}

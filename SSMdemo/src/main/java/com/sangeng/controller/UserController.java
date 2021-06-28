package com.sangeng.controller;


import com.github.pagehelper.PageInfo;
import com.sangeng.common.PageResult;
import com.sangeng.common.ResponseResult;
import com.sangeng.domain.User;
import com.sangeng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.awt.geom.RectangularShape;
import java.util.List;

@Controller
@ResponseBody
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/user/{id}")
    public ResponseResult findById(@PathVariable("id") Integer id) {
        User user = userService.findById(id);
        if (user == null) {
            return new ResponseResult(500, "failed!!!");
        }
        return new ResponseResult(200, "success~~~", user);
    }


    @GetMapping("/user")
    public ResponseResult findAll() {
        List<User> list = userService.findAll();
        return new ResponseResult(200, "success~~~", list);
    }

    @GetMapping("/user/{pageSize}/{pageNum}")
    public ResponseResult findByPage(@PathVariable("pageSize") Integer pageSize, @PathVariable("pageNum") Integer pageNum) {
        PageResult pageResult = userService.findByPage(pageSize, pageNum);
        return new ResponseResult(200, "success~~~", pageResult);
    }

    @PostMapping("/user")
    public ResponseResult insertUser(@RequestBody User user) {
        userService.insertUser(user);
        return new ResponseResult(200, "success~~~");
    }


    @PutMapping("/user")
    public ResponseResult updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return new ResponseResult(200, "success~~~");
    }

}

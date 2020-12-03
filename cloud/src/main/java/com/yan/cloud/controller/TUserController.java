package com.yan.cloud.controller;


import com.yan.cloud.entity.TUser;
import com.yan.cloud.service.TUserService;
import com.yan.cloud.utils.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-11-26
 */
@RestController
@RequestMapping("/user")
public class TUserController {

    @Resource
    private TUserService userService;

    @PostMapping("register")
    public R register(@RequestBody TUser user){
        userService.save(user);
        return R.ok();
    }

}


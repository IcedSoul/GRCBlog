package com.grc.controller;

import com.alibaba.fastjson.JSON;
import com.grc.entity.User;
import com.grc.entity.UserDetail;
import com.grc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 14437 on 2017/6/21.
 */
@RestController
@EnableAutoConfiguration
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 用户登录
     * @param userName
     * @param userPassword
     * @param httpSession
     * @return
     */
    @PostMapping(value = "/doLogin")
    public Map<String,Object> doLogin(@RequestParam("userName")String userName,
                                      @RequestParam("userPassword")String userPassword,HttpSession httpSession){
        System.out.println("I receive the userName "+userName+" and userPassword "+userPassword);
        String result = "fail";
        User user = userService.findByUserName(userName);
        if(user!=null){
            if(user.getUserPassword().equals(userPassword)){
                httpSession.setAttribute("currentUser",user);
                result = "success";
            }
            else
                result = "error";
        }
        else{
            result = "non-existent";
        }

        Map<String,Object> response = new HashMap<String, Object>();
        response.put("loginResult",result);
        if(result.equals("success"))
            response.put("currentUser", JSON.toJSON(user));
        return response;
    }

    /**
     * 用户注销登录
     * @param httpSession
     */
    @GetMapping(value = "/doLogout")
    public void doLogout(HttpSession httpSession){
        httpSession.setAttribute("currentUser","");
    }

    /**
     *
     * @param userName
     * @param userPassword
     * @param email
     * @param sex
     * @param phone
     * @param address
     * @param interest
     * @param birthday
     * @param remark
     * @param job
     * @return
     */
    @PostMapping(value = "/doRegister")
    public Map<String,Object> doRegister(@RequestParam("userName")String userName,
                                         @RequestParam("userPassword")String userPassword,
                                         @RequestParam("email")String email,
                                         @RequestParam("sex")String sex,
                                         @RequestParam("phone")String phone,
                                         @RequestParam("address")String address,
                                         @RequestParam("interest")String interest,
                                         @RequestParam("birthday")String birthday,
                                         @RequestParam("remark")String remark,
                                         @RequestParam("job")String job
                                         ){

        //在此之前应做校验，因此此处不再校验，校验模块待完善时添加
        String result = "fail";

        User user = new User();
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setEmail(email);
        user.setScore(0);
        user.setImg("");

        UserDetail userDetail = new UserDetail();

        userDetail.setAddress(address);
        birthday = birthday+" 00:00:00";
        Timestamp timestamp = Timestamp.valueOf(birthday);
        userDetail.setBirthday(timestamp);
        Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
        userDetail.setRegisterTime(timestamp1);
        userDetail.setInterest(interest);
        userDetail.setSex(sex);
        userDetail.setPhone(phone);
        userDetail.setRemark(remark);
        userDetail.setJob(job);

        userService.insertUser(user,userDetail);
        result = "success";

        Map<String,Object> response = new HashMap<String, Object>();
        response.put("registerResult",result);
        return response;
    }

    /**
     * 获取用户信息
     * @param userId
     * @return
     */
    @PostMapping(value = "/getUser")
    public Map<String,Object> getUser(@RequestParam("userId")Integer userId){
        User user = userService.findUser(userId);
        user.setUserPassword("");
        UserDetail userDetail = userService.findUserDetail(userId);
        Map<String,Object> response = new HashMap<String, Object>();
        response.put("user",JSON.toJSON(user));
        response.put("userDetail",JSON.toJSON(userDetail));
        return response;
    }
}

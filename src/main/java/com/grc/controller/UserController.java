package com.grc.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.grc.domain.User;
import com.grc.domain.UserDetail;
import com.grc.service.UserService;
import com.grc.utils.Response;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 14437 on 2017/6/21.
 */
@RestController
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
    @ApiOperation(value = "用户登录",httpMethod ="POST", notes = "user")
    @PostMapping(value = "/doLogin")
    public Map<String,Object> doLogin(@ApiParam(value = "用户名",required = true)@RequestParam("userName")String userName,
                                      @ApiParam(value = "用户密码",required = true)@RequestParam("userPassword")String userPassword,HttpSession httpSession){
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
    @ApiOperation(value = "用户注销登录",httpMethod ="GET", notes = "user")
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
    @ApiOperation(value = "用户注册",httpMethod ="POST", notes = "user")
    @PostMapping(value = "/doRegister")
    public Map<String,Object> doRegister(@ApiParam(value = "用户名",required = true)@RequestParam("userName")String userName,
                                         @ApiParam(value = "用户密码",required = true)@RequestParam("userPassword")String userPassword,
                                         @ApiParam(value = "邮箱",required = true)@RequestParam("email")String email,
                                         @ApiParam(value = "性别",required = true)@RequestParam("sex")String sex,
                                         @ApiParam(value = "手机号",required = true)@RequestParam("phone")String phone,
                                         @ApiParam(value = "地址",required = true)@RequestParam("address")String address,
                                         @ApiParam(value = "兴趣爱好",required = true)@RequestParam("interest")String interest,
                                         @ApiParam(value = "生日",required = true)@RequestParam("birthday")String birthday,
                                         @ApiParam(value = "标签",required = true)@RequestParam("remark")String remark,
                                         @ApiParam(value = "工作",required = true)@RequestParam("job")String job
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
        if(!birthday.isEmpty() && !birthday.equals("")){
            birthday = birthday+" 00:00:00";
            System.out.println(birthday);
            Timestamp timestamp = Timestamp.valueOf(birthday);
            userDetail.setBirthday(timestamp);
        }
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

    @ApiOperation(value = "用户注册",httpMethod ="POST", notes = "user")
    @PostMapping(value = "/updateUser")
    public Map<String,Object> updateUser(@ApiParam(value = "用户Id",required = true)@RequestParam("userId")Integer userId,
                                         @ApiParam(value = "用户名",required = true)@RequestParam("userName")String userName,
                                         @ApiParam(value = "头像",required = true)@RequestParam("img")String img,
                                         @ApiParam(value = "用户密码",required = true)@RequestParam("userPassword")String userPassword,
                                         @ApiParam(value = "邮箱",required = false)@RequestParam("email")String email,
                                         @ApiParam(value = "性别",required = false)@RequestParam("sex")String sex,
                                         @ApiParam(value = "手机号",required = false)@RequestParam("phone")String phone,
                                         @ApiParam(value = "地址",required = false)@RequestParam("address")String address,
                                         @ApiParam(value = "兴趣爱好",required = false)@RequestParam("interest")String interest,
                                         @ApiParam(value = "生日",required = false)@RequestParam("birthday")String birthday,
                                         @ApiParam(value = "标签",required = false)@RequestParam("remark")String remark,
                                         @ApiParam(value = "工作",required = false)@RequestParam("job")String job
    ){
        String result = "fail";

        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setUserPassword(userPassword);
        user.setEmail(email);
        user.setImg(img);
        user.setScore(0);
        user.setImg("");
        UserDetail userDetail = new UserDetail();
        userDetail.setAddress(address);
        if(!birthday.isEmpty() && !birthday.equals("")){
            birthday = birthday+" 00:00:00";
            System.out.println(birthday);
            Timestamp timestamp = Timestamp.valueOf(birthday);
            userDetail.setBirthday(timestamp);
        }
        Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
        userDetail.setUserId(userId);
        userDetail.setRegisterTime(timestamp1);
        userDetail.setInterest(interest);
        userDetail.setSex(sex);
        userDetail.setPhone(phone);
        userDetail.setRemark(remark);
        userDetail.setJob(job);

        userService.insertUser(user,userDetail);
        result = "success";

        Map<String,Object> response = new HashMap<String, Object>();
        response.put("updateResult",result);
        return response;
    }

    /**
     * 获取用户信息
     * @param userId
     * @return
     */
    @ApiOperation(value = "获取用户信息",httpMethod ="POST", notes = "user")
    @PostMapping(value = "/getUser")
    public Map<String,Object> getUser(@ApiParam(value = "用户ID",required = true)@RequestParam("userId")Integer userId){
        User user = userService.findUser(userId);
        UserDetail userDetail = userService.findUserDetail(userId);
        Map<String,Object> response = new HashMap<String, Object>();
        System.out.print(JSON.toJSON(user));
        response.put("user",JSON.toJSON(user));
        response.put("userDetail",JSON.toJSON(userDetail));
        return response;
    }

    @ApiOperation(value = "搜索信息",httpMethod ="POST", notes = "search")
    @PostMapping(value = "/searchAll")
    public Response searchAll(@ApiParam(value = "用户ID",required = true)@RequestParam("userId")Integer userId,
                           @ApiParam(value = "关键词",required = true)@RequestParam("keyWord")String keyWord){
        return userService.search(userId,keyWord);
    }

    @PostMapping(value = "/uploadIMG")
    public Response uploadIMG(@RequestParam MultipartFile imgUpload, Integer userId){
        return userService.uploadIMG(imgUpload,userId);
    }

}

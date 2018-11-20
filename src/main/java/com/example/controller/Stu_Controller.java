/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.controller;

import com.example.config.ServerResponse;
import com.example.entity.Student;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
@Api(value="学生认证接口",tags={"get 与 post请求"})
public class Stu_Controller {

  @GetMapping(value = "/vpn")
  @ApiOperation(value = "用户发送GET请求")
  ServerResponse<String> concurrency(@ApiParam(value="学校名称") String collegeName, @ApiParam(value="学生姓名") String stuName) throws Exception {
//    if(stuName.equals("李四A0") || stuName.equals("李四B0") || stuName.equals("李四C0")){
//      Thread.sleep(1000);
//    }
    String msg =  collegeName+" 学校的 : "+stuName+" 验证账号成功! 登录时间为:  "+ new Timestamp(System.currentTimeMillis());

    return ServerResponse.createBySuccess(msg);
  }

  @PostMapping(value="/auth")
  @ApiOperation(value = "进行post认证")
  ServerResponse<Student> authentication(@ApiParam(value="学生姓名")String name, @ApiParam(value="密码")String password){

    Student stu = new Student();

    if("123".equals(password)){

      // get from db
      stu.setName(name);
      stu.setAcademy("计算机学院");
      stu.setEnterTime("2013-09-10");
      stu.setGrage("大学二年级");

      return ServerResponse.createBySuccess(stu);
    }

    return ServerResponse.createByErrorMessage("用户名或密码错误");
  }


}

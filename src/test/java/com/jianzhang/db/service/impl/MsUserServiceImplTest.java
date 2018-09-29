package com.jianzhang.db.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.jianzhang.db.SpringDatasourceApplicationTests;
import com.jianzhang.db.bean.MsUser;
import com.jianzhang.db.service.MsUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
@Slf4j
public class MsUserServiceImplTest extends SpringDatasourceApplicationTests {
    @Autowired private MsUserService msUserService;
    @Test
    public void addUser() throws Exception {
        MsUser user = new MsUser();
        user.setId(0);
        user.setIdNo("31212121001");
        user.setUserAccount("232323232133");
        user.setCreateTime(new Date());
        user.setCreateBy("zj");
        user.setUserName("4444446");
        user.setStatus("1");
        msUserService.addUser(user);
    }

    @Test
    public void findMsUserById() throws Exception {
        log.info("user1 :{}", JSONObject.toJSON(msUserService.findMsUserById(1002l)));
    }

    @Test
    public void getMsUserById() throws Exception {
        log.info("user2 :{}", JSONObject.toJSON(msUserService.getMsUserById(1002l)));

    }

}
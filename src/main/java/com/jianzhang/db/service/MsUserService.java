package com.jianzhang.db.service;

import com.jianzhang.db.bean.MsUser;

public interface MsUserService {

    void addUser(MsUser msUser)throws Exception;

    MsUser findMsUserById(Long id);

    MsUser getMsUserById(Long id);
}

package com.jianzhang.db.service.impl;

import com.jianzhang.db.annotation.TargetDataSource;
import com.jianzhang.db.bean.DataSourceConstant;
import com.jianzhang.db.bean.MsUser;
import com.jianzhang.db.mapper.MsUserMapper;
import com.jianzhang.db.service.MsUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class MsUserServiceImpl implements MsUserService {
    @Autowired
    private MsUserMapper msUserMapper;
    @Transactional
    @TargetDataSource(value = DataSourceConstant.DATASOURCE_MASTER)
    @Override
    public void addUser(MsUser msUser) throws Exception {
        msUserMapper.insert(msUser);
    }
    @TargetDataSource(value = DataSourceConstant.DATASOURCE_SLAVE_1)
    @Override
    public MsUser findMsUserById(Long id) {
        return msUserMapper.selectByPrimaryKey(id.intValue());
    }
    @TargetDataSource(value = DataSourceConstant.DATASOURCE_SLAVE_2)
    @Override
    public MsUser getMsUserById(Long id) {
        return msUserMapper.selectByPrimaryKey2(id.intValue());
    }
}

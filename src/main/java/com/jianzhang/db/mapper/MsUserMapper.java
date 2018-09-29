package com.jianzhang.db.mapper;

import com.jianzhang.db.bean.MsUser;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MsUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MsUser record);

    MsUser selectByPrimaryKey(Integer id);
    MsUser selectByPrimaryKey2(Integer id);

    List<MsUser> selectAll();

    int updateByPrimaryKey(MsUser record);
}
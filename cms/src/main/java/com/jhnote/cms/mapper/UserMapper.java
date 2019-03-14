package com.jhnote.cms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.jhnote.cms.model.User;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKeyWithBLOBs(User record);

    int updateByPrimaryKey(User record);

	List<User> index();
}
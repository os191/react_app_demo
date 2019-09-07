package com.react.zpserver.mapper;

import com.react.zpserver.model.ZpUserDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ZpUserMapper {

    Integer save(ZpUserDO zpUserDO);

    List<ZpUserDO> getAllZpUser();

    ZpUserDO getZpUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    ZpUserDO getZpUserByUsername(@Param("username") String username);

    Integer updateZpUser(ZpUserDO zpUserDO);

    ZpUserDO getZpUserById(@Param("id") Long id);
}

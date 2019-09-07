package com.react.zpserver.service.impl;

import com.react.zpserver.bean.SaveUserInfoDTO;
import com.react.zpserver.commom.ApiResult;
import com.react.zpserver.commom.ApiResultFactory;
import com.react.zpserver.mapper.ZpUserMapper;
import com.react.zpserver.model.ZpUserDO;
import com.react.zpserver.service.ZpUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class ZpUserServiceImpl implements ZpUserService {

    @Resource
    private ZpUserMapper zpUserMapper;

    @Override
    public ApiResult register(ZpUserDO zpUserDO) {
        //用户是否存在
        if(zpUserMapper.getZpUserByUsername(zpUserDO.getUsername()) !=  null){
            return ApiResultFactory.fail("用户名已存在");
        }
        Date date = new Date();
        zpUserDO.setCreateTime(date);
        zpUserDO.setUpdateTime(date);
        zpUserMapper.save(zpUserDO);
        return getApiResult(zpUserDO);
    }

    @Override
    public ApiResult login(String username, String password) {
        ZpUserDO zpUserDO = zpUserMapper.getZpUserByUsernameAndPassword(username,password);
        if(zpUserDO == null){
            return ApiResultFactory.fail("请检查用户名和密码是否正确");
        }
        return getApiResult(zpUserDO);
    }

    @Override
    public ApiResult saveUserInfo(SaveUserInfoDTO dto) {
        ZpUserDO zpUserDO = zpUserMapper.getZpUserById(dto.getId());
        if(zpUserDO == null){
            return ApiResultFactory.fail("id 不正确");
        }
        zpUserDO.setHeader(dto.getHeader());
        zpUserDO.setCompany(dto.getCompany());
        zpUserDO.setInfo(dto.getInfo());
        zpUserDO.setSalary(dto.getSalary());
        zpUserDO.setPost(dto.getPost());
        zpUserMapper.updateZpUser(zpUserDO);
        return ApiResultFactory.succeed("成功",null);
    }

    @Override
    public ApiResult updateUser(ZpUserDO zpUserDO) {
        ZpUserDO oldZpUser = zpUserMapper.getZpUserById(zpUserDO.getId());

        return getApiResult(zpUserDO);
    }

    private ApiResult getApiResult(ZpUserDO zpUserDO) {
        Map<String,Object> result = new HashMap<>();
        result.put("username",zpUserDO.getUsername());
        result.put("id",zpUserDO.getId());
        result.put("type",zpUserDO.getType());
        return ApiResultFactory.succeed("成功", result);
    }
}

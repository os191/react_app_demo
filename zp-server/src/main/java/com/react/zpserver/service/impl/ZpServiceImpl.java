package com.react.zpserver.service.impl;

import com.react.zpserver.bean.RegisterVO;
import com.react.zpserver.commom.ApiResult;
import com.react.zpserver.commom.ApiResultFactory;
import com.react.zpserver.config.RedisService;
import com.react.zpserver.model.UserDo;
import com.react.zpserver.service.ZpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class ZpServiceImpl implements ZpService {

    private static final String USER_DO = "USER:DO";

    @Autowired
    private RedisService redisService ;


    @Override
    public ApiResult save(UserDo userDo) {
        if(redisService.userNameIsExist(USER_DO, userDo.getUsername())){
            return ApiResultFactory.fail("用户名"+userDo.getUsername()+"已存在");
        }
        String uuid = UUID.randomUUID().toString();
        SimpleDateFormat df = new SimpleDateFormat("yyMMddHHmmss");
        String time = df.format(new Date());
        userDo.setId(uuid);
        userDo.setCreateDate(time);
        redisService.hmSet(USER_DO, userDo.getUsername() , userDo);
        return ApiResultFactory.succeed("注册成功", RegisterVO.of(userDo.getUsername(),uuid,userDo.getType()));
    }

    @Override
    public String del(String username) {
        if(redisService.delUserData(USER_DO,username)){
            return "删除成功";
        }
        return "删除失败";
    }

    @Override
    public ApiResult getUserData(String username, String password) {
        UserDo userDo = redisService.getUserData(USER_DO , username, password);

        return userDo == null ? ApiResultFactory.fail("登录失败") : ApiResultFactory.succeed("登录成功", userDo);
    }
}

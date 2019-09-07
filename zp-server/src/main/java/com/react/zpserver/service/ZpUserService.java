package com.react.zpserver.service;

import com.react.zpserver.bean.SaveUserInfoDTO;
import com.react.zpserver.commom.ApiResult;
import com.react.zpserver.model.ZpUserDO;


public interface ZpUserService {

    ApiResult register(ZpUserDO zpUserDO);

    ApiResult login(String username,String password);

    public ApiResult saveUserInfo(SaveUserInfoDTO dto);

    ApiResult updateUser(ZpUserDO zpUserDO);

}

package com.react.zpserver.service;

import com.react.zpserver.bean.RegisterVO;
import com.react.zpserver.commom.ApiResult;
import com.react.zpserver.model.UserDo;

public interface ZpService {


    default ApiResult save(UserDo userDo){return null; }

    default String del(String username){return null; }

    default ApiResult getUserData(String username, String password){return null; }
}

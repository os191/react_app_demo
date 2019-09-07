package com.react.zpserver.controller;

import com.react.zpserver.bean.LoginDTO;
import com.react.zpserver.bean.SaveUserInfoDTO;
import com.react.zpserver.commom.ApiResult;
import com.react.zpserver.commom.ApiResultFactory;
import com.react.zpserver.config.RedisService;
import com.react.zpserver.model.ZpUserDO;
import com.react.zpserver.service.ZpUserService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/")
public class ZpController {

    @Resource
    private ZpUserService zpUserService;

    @Resource
    private RedisService redisService;

    @PostMapping(value = "login")
    public ApiResult login(@RequestBody LoginDTO loginDTO){
        System.out.printf("loginDTO:"+loginDTO);
        return zpUserService.login(loginDTO.getUsername(),loginDTO.getPassword());
    }

    @PostMapping(value = "register")
    public ApiResult register(@RequestBody @Valid ZpUserDO zpUserDO, BindingResult result){
        System.out.printf("zpUserDO:"+zpUserDO);
        if(result.hasErrors()){
            return ApiResultFactory.fail(result.getFieldError().getDefaultMessage());
        }
        return zpUserService.register(zpUserDO);
    }

    @PostMapping(value = "/saveUserInfo")
    public ApiResult saveUserInfo(SaveUserInfoDTO dto){
        System.out.printf("dto:"+dto);
        return zpUserService.saveUserInfo(dto);
    }

    @GetMapping(value = "setRedis")
    public ApiResult setRedis(@RequestParam String objKey,@RequestParam String value){
        redisService.hmSet("ZP:USER", objKey, value);
        return ApiResultFactory.succeed("成功",null);
    }

    @GetMapping(value = "getRedis")
    public ApiResult getRedis(@RequestParam String objKey){
        return ApiResultFactory.succeed("成功",redisService.hmGet("ZP:USER", objKey));
    }
}

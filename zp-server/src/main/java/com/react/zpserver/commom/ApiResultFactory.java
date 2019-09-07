package com.react.zpserver.commom;

public class ApiResultFactory {

    private static final int succeed_code = 200;
    private static final int fail_code = -1;

    public static ApiResult succeed(String message,Object data){
        return ApiResult.of(true,message,succeed_code, data);
    }

    public static ApiResult fail(String message){
        return ApiResult.of(false,message,fail_code,null);
    }
}

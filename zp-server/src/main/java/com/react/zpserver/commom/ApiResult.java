package com.react.zpserver.commom;

public class ApiResult<T> {

    private boolean status;
    private String message;
    private int code;
    private T data;

    public static ApiResult of(boolean status,String message,int code, Object data){
        ApiResult apiResult = new ApiResult();
        apiResult.setStatus(status);
        apiResult.setMessage(message);
        apiResult.setCode(code);
        apiResult.setData(data);
        return apiResult;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

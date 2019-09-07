
import { AUTH_SUCCESS, ERROR_MSG } from './action-type'
import { reqLogin, reqRegister } from '../api/index'


//授权成功的同步action
const authSuccess = (user) => ({type: AUTH_SUCCESS, data: user}) 
// 错误提示信息的同步action
const errorMsg = (message) => ({type: ERROR_MSG, data: message})


export const register =(user) =>{
    const {username , password, password2, type } = user
    //做表单的前台检查，如果不通过，返回一个errorMsg的同步action
    if(!username){
        return errorMsg('用户名不能为空')
    }
    if(!password){
        return errorMsg('密码不能为空')
    }
    if(password !== password2){
        return errorMsg('2次密码不一致')
    }
    return async dispatch =>{
        const response = await reqRegister({username , password, type})
        const result = response.data
         if(result.code === 200){
            dispatch(authSuccess(result.data))
         }else{
            dispatch(errorMsg(result.message))
         }
    }
}

export const login = (user) =>{
    const {username , password } = user
    if(!username){
        return errorMsg('用户名不能为空')
    }
    if(!password){
        return errorMsg('密码不能为空')
    }

    return async dispatch =>{
        const response = await reqLogin({username , password })
        const result = response.data
         if(result.code === 200){
            dispatch(authSuccess(result.data))
         }else{
            dispatch(errorMsg(result.message))
         }
    }
}
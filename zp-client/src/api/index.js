/**
 * 包含 n 个 借口 请求的函数模块
 */
import ajax from './ajax'

// 注册
export const reqRegister = (user) => ajax('/register', user , 'POST')

// 登录
export const reqLogin = ({username, password}) => ajax('/login', {username, password} , 'POST')

//更新用户接口
export const reqUpdateUser = (user) => ajax('/update', user , "POST")
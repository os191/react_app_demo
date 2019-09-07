

import { combineReducers } from 'redux'

import { AUTH_SUCCESS, ERROR_MSG } from './action-type'
import { getRedirectTo } from '../util/index'

const initUser = {
    username: '',
    type: '',
    message: '', //错误提示信息
    redirectTo: '' //需要自动更新重定向路由路径
}

function user(state = initUser, action){
    switch(action.type){
        case AUTH_SUCCESS: //data 是user
           return {...action.data , redirectTo : getRedirectTo(action.data.type, action.data.hander)}
        case ERROR_MSG:   //data 是message
           return {...state , message: action.data}
        default:
           return state
     }
}
export default combineReducers({
    user
})

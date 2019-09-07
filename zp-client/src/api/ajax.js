/**
 * 发送ajax 请求函数模块
 * 函数的返回值 是promise 对象
 */
import axios from 'axios'

export default function ajax(url = '' , data = {} , type = 'GET'){
    if(type === 'GET'){
        //准备URL query 参数数据
        let dataStr = '' //数据拼接字符串
        Object.keys(data).forEach(key =>{
            dataStr += key +"+"+data[key] + '&'
        })
        if(dataStr !== ''){
            dataStr = dataStr.substring(0,dataStr.lastIndexOf('&'))
            url = url +'?'+ dataStr
        }
        //发送get请求
        return axios.get(url)
    }else{
        //发送post 请求
        return axios.post(url, data)
    }
}
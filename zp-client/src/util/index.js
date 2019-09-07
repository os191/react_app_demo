
/**
 * 用户主界面路由
 *  dashen：/dashen
 *  laoban: /laoban
 * 用户信息完善界面路由
 *  dashen: /dasheninfo
 *  laoban: /laobaninfo
 * 判断是否完善信息？ user.hander 是否有值
 * 判断用户类型： user.type
 * 
 * 
 */
//返回对应的路由路径
export function getRedirectTo(type, hander){
    let path = ''
    //type
    if(type === 'laoban'){
        path = '/laoban'
    }else{
        path = '/dashen'
    }
     //hander
    if(!hander){ //没有值，返回信息完善界面的path
        path += 'info'
    }
    return path
}
import Login from '../containers/login/Login'
import Register from '../containers/register/Register'
import Main from '../containers/main/Main'
import LaobanInfo from '../containers/laoban-info/LaobanInfo'
import DashenInfo from '../containers/dashen-info/DashenInfo'

const routes =[
    {
        name: '登录',
        path: '/login',
        component: Login
    },
    {
        name: '注册',
        path: '/register',
        component: Register
    },
    {
        name: '首页',
        path: '/',
        component: Main,
        exact: true,
        routes: [
            {
                name: "老板信息完善界面",
                path: '/laobaninfo',
                component: LaobanInfo
            },
            {
                name: "大神信息完善界面",
                path: '/dasheninfo',
                component: DashenInfo
            }
        ]
    }
];
export default routes;
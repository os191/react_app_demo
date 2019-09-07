import React, { Component } from 'react';
import { WingBlank, WhiteSpace, List, InputItem, Button, Toast} from 'antd-mobile';
import { connect } from 'react-redux';

import { login } from '../../redux/actions'
import Logo from '../../components/logo/Logo'
import './login.less'

class Login extends Component {
    constructor(props) {
        super(props);
        this.state = {
            username: '',
            password: ''
        };
    }
    handleChange = (name, val) =>{
        this.setState({[name]: val})
    }
    login = () =>{
        console.log(this.state)
        this.props.login(this.state)
    }
    toRegister = () =>{
        this.props.history.replace('/register')
    }
    //除了首次render之后调用componentDidMount，其它render结束之后都是调用componentDidUpdate。
    componentDidUpdate (){
        const {message, redirectTo} = this.props.user
        if(redirectTo){
            this.props.history.replace('/')
        }
        if(message){
            Toast.fail(message , 2)
        }
    }
    render() {
        return (
            <div>
                <Logo />
                <WingBlank>
                    <List>
                        <WhiteSpace/>
                        <InputItem placeholder='请输入用户名' type="text" onChange={val => {this.handleChange('username',val)}}>用户名:</InputItem>
                        <WhiteSpace/>
                        <InputItem placeholder='请输入密码' type="password" onChange={val => {this.handleChange('password',val)}}>密&nbsp;&nbsp;&nbsp;码:</InputItem>
                        <WhiteSpace/>
                        <Button type='primary' className='logo-nav-bac-color login-but' onClick={this.login}>登录</Button>
                        <WhiteSpace/>
                        <Button onClick={this.toRegister}>去注册</Button>
                    </List>
                </WingBlank>
            </div>
        );
    }
}
export default connect(
    state =>({user: state.user}),
    {login}
)(Login);
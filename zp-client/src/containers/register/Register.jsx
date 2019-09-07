import React, { Component } from 'react';
import { WingBlank, WhiteSpace, List, InputItem, Button, Radio, Toast } from 'antd-mobile';
import { connect } from 'react-redux';
// import { Redirect } from 'react-router-dom'

import { register } from '../../redux/actions'
import Logo from '../../components/logo/Logo'
import './register.less'

class Register extends Component {
    constructor(props) {
        super(props);
        this.state = {
            username: '',
            password: '',
            password2: '',
            type: 'dashen'
          };
    }
    handleChange = (name, val) =>{
        this.setState({[name]: val})
    }
    register = () =>{
        this.props.register(this.state)
    }
    toLogin = () =>{
        this.props.history.replace('/login')
    }
    //除了首次render之后调用componentDidMount，其它render结束之后都是调用componentDidUpdate。
    componentDidUpdate (){
        const {message, redirectTo} = this.props.user
        if(redirectTo){
            this.props.history.replace(redirectTo)
            // return <Redirect to={redirectTo} />
        }
        if(message !== ''){
            Toast.fail(message , 2)
        }
    }
    render() {
        const { type } = this.state
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
                        <InputItem  placeholder='请确认密码' type="password" onChange={val => {this.handleChange('password2',val)}}>确认密码:</InputItem>
                        <WhiteSpace/>
                        <List.Item>
                            <span>类&nbsp;&nbsp;&nbsp;型:</span>&nbsp;&nbsp;
                            <Radio checked={type === 'dashen'} onChange={val => {this.handleChange('type','dashen')}}>大神</Radio>&nbsp;&nbsp;&nbsp;
                            <Radio checked={type === 'laoban'} onChange={val => {this.handleChange('type','laoban')}}>老板</Radio>
                        </List.Item>
                        <Button type='primary' className='logo-nav-bac-color register-but' onClick={this.register}>注册</Button>
                        <WhiteSpace/>
                        <Button onClick={this.toLogin}>已有账号</Button>
                    </List>
                </WingBlank>
            </div>
        );
    }
}

export default connect(
    state =>({user: state.user}),
    {register}
)(Register);
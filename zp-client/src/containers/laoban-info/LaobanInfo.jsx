import React, { Component } from 'react';

import { connect } from 'react-redux'
import { List, NavBar, InputItem, TextareaItem, Button } from 'antd-mobile'

import HeaderSelector from '../../components/header-selector/header-selector'
import './laobanInfo.less'

class LaobanInfo extends Component {
    constructor(props) {
        super(props);
        this.state = { 
            header: '',
            post: '',
            info: '',
            company: '',
            salary: ''
         };
    }

    handelChanger =(name, val) =>{
        this.setState({[name]: val})
    }
    save = () =>{
        console.log(this.state)
    }
    setHeader =(header) =>{
        this.setState({header: header})
    }
    render() {
        return (
            <List>
                <NavBar className='logo-nav-bac-color'>老板信息完善</NavBar>
                <HeaderSelector setHeader={this.setHeader} />
                <InputItem placeholder='请输入职位' onChange={val =>{this.handelChanger('post',val)}} >招聘职位:</InputItem>
                <InputItem placeholder='请输入公司名称' onChange={val =>{this.handelChanger('company',val)}} >公司名称:</InputItem>
                <InputItem placeholder='请输入职位薪资' onChange={val =>{this.handelChanger('salary',val)}} >职位薪资:</InputItem>
                <TextareaItem title='职位要求:' rows={3} onChange={val =>{this.handelChanger('info',val)}}  /> 
                <Button onClick={this.save} type='primary' className='logo-nav-bac-color register-but:'>保&nbsp;&nbsp;&nbsp;存</Button>
            </List>
        );
    }
}

export default connect(
 state =>({}),
 {}
)(LaobanInfo);
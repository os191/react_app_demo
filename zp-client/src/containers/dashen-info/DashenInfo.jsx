import React, { Component } from 'react';
import { connect } from 'react-redux'
import { NavBar, InputItem, TextareaItem, Button } from 'antd-mobile'

import HeaderSelector from '../../components/header-selector/header-selector'
import './dashenInfo.less'


class DashenInfo extends Component {
    constructor(props) {
        super(props);
        this.state = {
            header: '',
            post: '',
            info: ''
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
            <div>
                <NavBar className='logo-nav-bac-color'>大神信息完善</NavBar>
                <HeaderSelector  setHeader={this.setHeader}  />
                <InputItem placeholder='请输入职位薪资' onChange={val =>{this.handelChanger('post',val)}}>求职岗位:</InputItem>
                <TextareaItem title='个人介绍:' rows={3} onChange={val =>{this.handelChanger('info',val)}}/> 
                <Button onClick={this.save} type='primary' className='logo-nav-bac-color register-but:'>保&nbsp;&nbsp;&nbsp;存</Button>
            </div>
        );
    }
}

export default connect(
    state =>({}),
    {}
)(DashenInfo);
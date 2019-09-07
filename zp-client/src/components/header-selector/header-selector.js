

import React, { Component } from 'react';
import { List, Grid } from 'antd-mobile'
import PropTypes from 'prop-types'

class HeaderSelector extends Component {
    constructor(props) {
        super(props);
        this.state = { 
            icon: null //图片对象，默认null
         };
         // 准备需要显示的列表数据
         this.headerList = [];
         for(let i = 0; i < 20; i++){
            this.headerList.push({
                text: '头像'+(i+1),
                icon: require(`../../assets/images/headers/头像${i+1}.png`) //不能使用import
            })
            
         }
    }
    static propTypes = {
        setHeader: PropTypes.func.isRequired
    }

    handleClick = ({text, icon}) =>{
        //更新当前组件状态
        this.setState({icon:icon})
        //调用父组件
        this.props.setHeader(text)
    }

    render() {
        const { icon } = this.state 
        // const listHeander =  '请选择头像'
        const listHeander = !icon ? '请选择头像' :(
            <div>
                已选择头像:<img src={icon} alt ='头像'/>
            </div>
        ) 
        return (
            <List renderHeader={() => listHeander}>
                <Grid data={this.headerList} 
                        columnNum = {5}  onClick={this.handleClick}/>
            </List>
        );
    }
}

export default HeaderSelector;
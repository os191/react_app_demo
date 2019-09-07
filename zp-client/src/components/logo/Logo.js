import React from 'react'; 
import { NavBar } from 'antd-mobile'

import logo from '../../assets/images/logo/logo.png'
import './logo.less'

export default function Logo(){
   return (
       <div className='logo-container'>
            <NavBar mode="dark" className='logo-nav-bac-color'>硅&nbsp;谷&nbsp;直&nbsp;聘</NavBar>
            <img src={logo} alt='logi' className='logo-img' />
       </div>
   )
}
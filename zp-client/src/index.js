import React from 'react';
import ReactDOM from 'react-dom';
import { HashRouter ,  Route , Switch } from 'react-router-dom'
import {Provider} from 'react-redux'

import store from './redux/store'
import './assets/css/index.less';
import routers from './routers/routers'

ReactDOM.render(
    <Provider store={store}>
        <HashRouter>
            <Switch>
                {
                    routers.map((router,index) =>{
                        if(router.exact){
                            return <Route  key={index} exact 
                            render={props => (
                                    <router.component {...props} routers={router.routes} />
                                )} />
                                
                        }else{
                            return <Route key={index} path={router.path} 
                            render={props => (
                                    <router.component {...props} routers={router.routes} />
                                )} />
                        }
                    })
                }
            </Switch>
        </HashRouter>
     </Provider>
, document.getElementById('root'));


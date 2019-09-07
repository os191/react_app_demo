import React, { Component } from 'react';
import { Switch, Route } from 'react-router-dom'


class Main extends Component {
    constructor(props) {
        super(props);
        this.state = {  };
    }
    render() {
        const { routers } = this.props
        return (
            <div>
                <Switch>
                    {
                        routers.map((router,index) =>{
                            return <Route exact key={index} path={router.path} component={router.component} />
                        })
                    }
                </Switch>
            </div>
        );
    }
}
export default Main;
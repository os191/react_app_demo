const { override, fixBabelImports, addLessLoader } = require('customize-cra');

module.exports = override(
  fixBabelImports('import', {
    libraryName: 'antd-mobile',
    libraryDirectory: 'es',
    style: true,    //这里一定要写true，css和less都不行哦
  }),
  addLessLoader({
    javascriptEnabled: true,
    //下面这行很特殊，这里是更改主题的关键，这里我只更改了主色，当然还可以更改其他的，下面会详细写出。
    modifyVars: { '@primary-color': '#f47983' },
  }),
);

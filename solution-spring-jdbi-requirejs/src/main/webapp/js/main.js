/**
 * Created by xlch on 2016/12/27.
 */
require.config({

    //所有模块查找的根路径
    baseUrl: 'js/lib',

    //目的是将繁琐的引用名称简化，只需要 require(['jquery'],function(){})即可
    //路径是相对于 baseUrl 的路径
    paths: {
        "jquery":'jquery/jquery-3.1.1.min',
    },

    // 配置非 amd 规范的 js ，增加依赖 和 输出名称
    shim: {          //
        'backbone':{
            depts:['jquery','underscore'],
            exports:'Backbone'
        },
        'underscore':{
            exports:'_'
        },
    },

    //加载 js 等待的 最长时间，超时则放弃加载，默认时间为 7秒
    waitSeconds: 30,

    //main.js 之后加载的 js 的末尾添加后缀，防止缓存，但是生产环境需要去掉
    // urlArgs: "bust=" +  (new Date()).getTime()，

    // 应用级别的参数，通过 module.config() 使用，但是这里获取后为空，不知何解
    config:{
        'name':{
            na:'xlch'
        },
    },
});

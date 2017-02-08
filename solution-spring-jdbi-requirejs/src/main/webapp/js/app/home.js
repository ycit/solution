/**
 * Created by xlch on 2017/2/6.
 */
require(['../main','module'],function (main,module) {

    require(['backbone'],function (Backbone) {//直接使用会报错，找不到underscore.js,需配置 shim
        Backbone.Model.extend({});
    });

    require(["../help/util"],function (util) {
        util.quick.click({
            delete:function () {
                alert("delete");
            }
        });

        require(['underscore'],function (_) {
            var stooges = [{name: 'moe', age: 40}, {name: 'larry', age: 50}, {name: 'curly', age: 60}];
            console.log(_.pluck(stooges, 'name'));
        });
    })
})

//这里会报错，无法找到 js/app/jquery.js ，而 jquery 的真正路径配置在 main.js 中
//说明，这里 main.js　应该还没有加载吗？按照上面的　baseUrl 产生规则
//设置了 data-main，未设置 baseUrl，则 baseUrl 为 data-main 的路径
//即 入口处贴的 js/app/home.js ，完全吻合；
// require(['require', '../main', '../help/util'], function (require,main,util) {
//     var $ = require("jquery");
//     console.log($("#h2").text());
//
//     util.quick.click({
//         delete: function () {
//             alert("delete 222");
//         }
//     });
//
//     require(['backbone'], function (Backbone) {
//         Backbone.Model.extend({});
//     });
//
//     require(['jquery'],function ($) {
//         console.log($("#h2").text());
//     })
// })
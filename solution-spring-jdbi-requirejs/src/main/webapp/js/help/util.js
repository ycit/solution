/**
 * Created by xlch on 2016/12/27.
 */
//这里会使用到配置文件中配置的 jquery，所以依次引用 配置文件js，jquery
//这里虽然引用了 main 模块，但是其中只是声明了 jquery，要调用该模块仍然需要常规的 require 或者 define
//这里引用的 jquery 并不存在于js/lib/jquery 路径下，而是配置在 man.js 中，所以还需要下面的 require
define(['require','module','../main', 'jquery'],function (require,module) {
    //这里才真正的加载到 jquery;而且 jquery 必须定义在 define 的模块数组中
    var $ = require("jquery");

    var utils = {};
    utils.quick = {
        click:function (method,node) {
            var list = null;
            if (node) {
                list = $(node).find("[data-click]");
            }else {
                list = $("[data-click]");
            }
            list.on("click",function (eventObject) {
                var click = $(this).data("click");
                if (click && method[click]) {
                    return method[click].apply(this,[eventObject]);
                }
            });
        },
        offClick:function (method, node) {
            if (node) {
                $(node).find('[data-click]').off('click');
            }else {
                $('[data-click]').off('click');
            }
        }
    };
    return utils;
});

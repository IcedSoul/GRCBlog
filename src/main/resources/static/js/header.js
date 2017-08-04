document.writeln('<div class="navbar navbar-fixed-top" role="navigation" id="menu-nav">'+
'    <div class="container-fluid">'+
'        <div class="navbar-header">'+
'            <button type="button" class="navbar-toggle" data-toggle="collapse"'+
'                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">'+
'                <span class="sr-only">切换导航</span>'+
'                <span class="icon-bar"></span>'+
'                <span class="icon-bar"></span>'+
'                <span class="icon-bar"></span>'+
'            </button>'+
'            <a class="navbar-brand" href="#"> <img alt="Brand" src="img/brand.jpg"></a>'+
'        </div>'+
'        <div class="navbar-collapse collapse">'+
'            <ul class="nav navbar-nav">'+
'                <li class="active"><a href="http://localhost:8080/GRCBlog/index" class="black-feature">首页</a></li>'+
'                <li class="active"><a href="" class="black-feature">消息</a></li>'+
'            </ul>'+
'            <form class="navbar-form navbar-left" role="search">'+
'                <div class="form-group">'+
'                    <input type="text" class="form-control" placeholder="搜索">'+
'                    <button type="submit" class="btn btn-link">'+
'                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>'+
'                    </button>'+
'                </div>'+
'            </form>'+
'            <ul id="button" class="nav navbar-nav navbar-right">'+
    '<div v-if="seen">'+
'                <li>'+
'                    <button class="btn btn-info btn-info-nav ">登录</button>'+
'                <li>'+
'                    <button class="btn btn-info btn-info-nav ">注册</button>'+
    '</div>'+
    '<div v-if="seen2">'+
    '<ul class="nav navbar-nav navbar-right">'+
    '        <li class="dropdown">'+
    '          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> 个人中心 <span class="caret"></span></a>'+
    '          <ul class="dropdown-menu">'+
    '            <li><a href="http://localhost:8080/GRCBlog/blogSort">个人首页</a></li>'+
    '            <li><a href="#">Another action</a></li>'+
    '            <li><a href="#">Something else here</a></li>'+
    '            <li role="separator" class="divider"></li>'+
    '            <li><a href="#">Separated link</a></li>'+
    '          </ul>'+
    '        </li>'+
    '      </ul>'+
    '</div>'+
'            </ul>'+
'        </div>'+
'        <hr class="navhr">'+
'    </div>'+
'</div>');

var url = new Vue({
    methods:{
        makeURL: function (url,name,value) {
            return url+"?"+name+"="+value;
        },
        parseURL: function (name) {
            var url = location.search;
            var request = new Object();
            if (url.indexOf("?") != -1) {
                var str = url.substr(1);
                var strs = str.split("&");
                for(var i = 0; i < strs.length; i ++) {
                    var value = strs[i].split("=");
                    if( value[0] == name)
                        return value[1];
                }
            }
            return null;
        },
        getCookie: function (name) {
            var search = name + "=";
            if (document.cookie.length > 0) {
                sd = document.cookie.indexOf(search);
                if (sd!= -1) {
                    sd += search.length;
                    end = document.cookie.indexOf(";", sd);
                    if (end == -1)
                        end = document.cookie.length;
                    returnvalue=unescape(document.cookie.substring(sd, end))
                }
            }
            return returnvalue;
        }
    }
});

var button = new Vue({
    el:'#button',
    data:{
        seen:true,
        seen2:false,
    },
    created:function () {
        var userId = url.getCookie("userId");
        if(userId==null || userId==undefined || userId =='' ){
            this.seen = true;
            this.seen2 = false;
        }
        else{
            this.seen = false;
            this.seen2 = true;
        }
    }
})
document.writeln('<div class="navbar navbar-fixed-top" role="navigation" id="menu-nav">'+
'    <div class="container-fluid" id="head">'+
'        <div class="navbar-header">'+
'            <button type="button" class="navbar-toggle" data-toggle="collapse"'+
'                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">'+
'                <span class="sr-only">切换导航</span>'+
'                <span class="icon-bar"></span>'+
'                <span class="icon-bar"></span>'+
'                <span class="icon-bar"></span>'+
'            </button>'+
'            <a class="navbar-brand" v-on:click="index"> <img alt="Brand" src="img/brand.jpg"></a>'+
'        </div>'+
'        <div class="navbar-collapse collapse">'+
'            <ul class="nav navbar-nav">'+
'                <li class="active"><a v-on:click="index" class="black-feature">首页</a></li>'+
'                <li class="active"><a href="" class="black-feature">消息</a></li>'+
'            </ul>'+
'            <form class="navbar-form navbar-left" role="search">'+
'                <div class="form-group">'+
'                    <input type="text" class="form-control" placeholdser="搜索">'+
'                    <button type="submit" class="btn btn-link">'+
'                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>'+
'                    </button>'+
'                </div>'+
'            </form>'+
    '<div v-if="seen">'+
    '            <ul class="nav navbar-nav navbar-right">'+
'                <li>'+
'                    <button class="btn btn-info btn-info-nav" v-on:click="login">登录</button>' +
    '           </li>'+
'                <li>'+
'                    <button class="btn btn-info btn-info-nav" v-on:click="register">注册</button>' +
    '           </li>'+
    '            </ul>'+
    '</div>'+
    '<div v-if="seen2">'+
    '<ul class="nav navbar-nav navbar-right">'+
    '                <li>'+
    '                    <button class="btn btn-info btn-info-nav" v-on:click="writeBlog">写博客</button>'+
    '                <li>'+
    '                    <button class="btn btn-info btn-info-nav" v-on:click="uploadFile">分享资源</button>'+
    '                <li>'+
    '                    <button class="btn btn-info btn-info-nav" v-on:click="writeQuestion">提问</button>'+
    '                <li class="dropdown">'+
    '                    <button class="btn-nav dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown"'+
    '                            aria-haspopup="true" aria-expanded="true">'+
    '                        <img src="img/display-photo.jpg" class="img-circle img-sm">'+
    '                        <span class="caret"></span>'+
    '                    </button>'+
    '                    <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">'+
    '                        <li><a v-on:click="personalHomepage"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> 我的主页</a></li>'+
    '                        <li><a v-on:click="personalInfo"><span class="glyphicon glyphicon-cog"'+
    '                                                                                aria-hidden="true"></span> 个人信息</a>'+
    '                        </li>'+
    '                        <li><a href=""><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span> 退出</a></li>'+
    '                    </ul>'+
    '                </li>'+
    '            </ul>'+
    '</div>'+
'        </div>'+
'        <hr class="navhr">'+
'    </div>'+
'</div>');

var button = new Vue({
    el:'#head',
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
    },
    methods:{
        index:function () {
            window.location.href = address+"index.html";
        },
        writeBlog: function () {
            window.location.href = address+"write_blog.html";
        },
        uploadFile: function () {
            window.location.href = address+"upload_file.html";
        },
        writeQuestion: function () {
            window.location.href = address+"write_question.html";
        },
        personalHomepage:function () {
            window.location.href = address+"personal_homepage.html";
        },
        personalInfo:function () {
            window.location.href = address+"personal_info.html";
        },
        login:function () {
            window.location.href = address+"login_register.html";
        },
        register:function () {
            window.location.href = address+"login_register.html";
        }

    }
});

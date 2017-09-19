var address = "http://localhost:8080/GRCBlog/";

var url = new Vue({
    methods:{
        makeURL: function (url,name,value) {
            return encodeURI(url+"?"+name+"="+value);
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
                        return decodeURI(value[1]);
                }
            }
            return null;
        },
        getCookie: function (name) {
            var v = window.document.cookie.match('(^|;) ?' + name + '=([^;]*)(;|$)');
            return v ? v[2] : null;
        },
        setCookie: function (name,value,days) {
            var d = new Date;
            d.setTime(d.getTime() + 24*60*60*1000*days);
            window.document.cookie = name + "=" + value + ";path=/;expires=" + d.toGMTString();
        }
    }
});

var file = new Vue({
    methods:{
        getExtendType:function (name) {
            var d=/\.[^\.]+$/.exec(name);
            if(d == "")
                return "未知文件";
            else
                return d[0].split("\.")[1];
        }
    }
});


var userUtils = new Vue({
    methods: {
        getUser:function (userId) {
            var user = null;
            var users = {};
            users.userId = userId;

            $.ajax({
                async: false, //设置同步
                type: 'POST',
                url: address + 'getUser',
                data: users,
                dataType: 'json',
                success: function (result) {
                    if (result != null) {
                        user = result.user;
                    }
                    else {
                        alert('查询错误');
                    }
                },
                error: function (result) {
                    alert('查询错误!!');
                }
            });
            return JSON.parse(user);
        },
        checkLogin:function () {
            var userId = url.getCookie("userId");
            if(userId == null || userId == "" || userId == undefined){
                return false;
            }
            else
                return true;
        }
    }
});

var questionUtils = new Vue({
    methods: {
        getQuestion:function (questionId) {
            var question = null;
            var questionIds = {};
            questionIds.questionId = questionId;
            $.ajax({
                async: false, //设置同步
                type: 'POST',
                url: address + 'getQuestion',
                data: questionIds,
                dataType: 'json',
                success: function (result) {
                    if (result.status == "0") {
                        question = JSON.parse(result.content);
                    }
                    else {
                        alert('查询错误');
                    }
                },
                error: function (result) {
                    alert('查询错误!!');
                }
            });
            return question;
        }
    }
});

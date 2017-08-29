var address = "http://localhost:8080/GRCBlog/";

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
            var v = window.document.cookie.match('(^|;) ?' + name + '=([^;]*)(;|$)');
            return v ? v[2] : null;
        }
    }
});
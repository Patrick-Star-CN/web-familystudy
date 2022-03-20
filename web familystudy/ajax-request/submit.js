
function query(name) {
    return document.querySelector(`[name='${name}']`);
};
console.log(query('pwd'));

var flag = true;
let inputs = document.querySelectorAll("[name='pwd'],[name='repwd']");
[...inputs].map(item => {
    item.addEventListener("keyup", function() {
        let msg = '';
        if (query('pwd').value != query('repwd').value && query('repwd').value.length >0  ) {
            msg = '确认密码错误，请重新输入!';
            flag = false;
        }
        else {
            flag=true;
        }
        query('msg').innerHTML = msg;
    });
});
var data={};





function register() {
    const port="8080";
    var username= $("#name").val();
    var password= $("#password").val();
    var repsword=$("#repsword").val();
    if (username=='') {alert("用户名为空，请重新输入");}
    else if (password=='') {alert("密码为空，请重新输入");}
    else if (repsword=='' || !flag){
        alert("确认密码错误，请重新输入");
    }
    else{
        data.username=username;
        data.password=password;
        submit(1);
    }
    
}

function login(){
    const port="8080";
    var username=$("#name").val();
    var password=$("#password").val();
    data.username=username;
    data.password=password;
    submit(2);
}


function pay(){
    alert("付款成功！");
    window.location.href ="../web familystudy/readingGuides.html";
}

var url="http://127.0.0.1:8080";
function submit(check){
    if (check==1){
    $.ajax({       //注册
        type: "POST",
        url:url + "/study/register",
        data: JSON.stringify(data),
        
        success: function (data) {
            if (data.message == "success") { alert("注册成功！"); window.location.href = "../index.html"; }
            else if (data.message == "error") { alert("");  }
            else if (data.message == "wrong username") { alert("用户名已被注册！");  }
            else { alert("未知错误...");  }
        }, //根据后端返回判断是否注册成功
        error: function (jqXHR) { console.log("Error:" + jqXHR.status); }
    })
    }
    else if (check==2){
    $.ajax({
        type: "POST",
        url:url + "/study/login",
        data: JSON.stringify(data),
        success: function (data) {
            if (data.message == "success") {
                alert("登录成功！");
                window.location.href = "../index.html?"+ $("#name").val() ; 
                user();
            }
            else if (data.message == "wrong username") { alert("用户名错误！");  }
            else if (data.message == "wrong password") { alert("密码错误！"); }
            else { alert("未知错误...");  }
        }, //根据后端返回判断是否登录成功   
        error: function (jqXHR) { console.log("Error:" + jqXHR.status); }
    })
    }

    $.ajax({
        type:"POST",
        url:url+"/study/TestCookie",
        data:JSON.stringify(data),
        success:function(data){
            if (data.message=="success") {
                alert("hhhhh");
            }
        }
    })
}
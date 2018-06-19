function submit() {
    var data=new Array(6);
    var name=$("#name").val();
    var telphone=$("#telphone").val();
    var mail=$("#mail").val();
    var company=$("#company").val();
    var zhiwei=$("#zhiwei").val();
    var beizhu=$("#beizhu").val();
    if(name==""||telphone==""||mail==""||company==""||zhiwei=="")
    {
        alert("填写的信息不完整")
    }    else if(telphone.length!=11)
    {
        alert("输入正确的手机号");
    }else
    {
        $.ajax({
            type: "post",
            url: "/AppWeb/user.do",
            data: {"name": name,"telphone":telphone,"mail":mail,"company":company,"zhiwei":zhiwei,"beizhu":beizhu},
            success: function (data_or) {
                if(data_or=="ok")
                {
                    alert("ok");
                    window.location.href="/AppWeb/views/huiyi.html";
                }
                else
                {
                    alert("您已经报名，请勿重复报名");
                    window.location.href="/AppWeb/views/huiyi.html";
                }

            }
        });
    }

}
var swiper = new Swiper('.swiper-container', {
    autoplay:true,                              //自动播放
    autoplayDisableOnInteraction:false,
    pagination: {
        el: '.swiper-pagination',
        clickable: true,
        type: 'fraction',
    },
});
/**************************************************************/
var parmeterSelectionData;//选择的参数
//点击分享按钮
function openShare() {
    $('.shell-mask').fadeIn(100);    //遮罩层显示
    $('.pdd-share').show();
    $('html,body').css("overflow", "hidden");
}
//取消分享按钮
function closeShare() {
    $('.shell-mask').fadeOut(100);    //遮罩层显示
    $('.pdd-share').hide();
    $('html,body').css("overflow", "auto");
}
//点击-拼单-查看更多按钮
function openPddMore() {
    $('.shell-mask').fadeIn(100);    //遮罩层显示
    $('.pdd-more-page').show();
    $('html,body').css("overflow", "hidden");
}
//点击去拼单按钮
function openJoinPdd() {
    $('.shell-mask').fadeIn(100);    //遮罩层显示
    $('.pdd-more-page').hide();
    $('.join-pdd').show();
    $('html,body').css("overflow", "hidden");
}

$(document).ready(function() {
    $(".shell-mask").click(function () {//遮罩层点击
        $('.shell-mask').fadeOut(100);
        $('.pdd-share').hide();
        $('.pdd-more-page').hide();
        $('.join-pdd').hide();
        $('html,body').css("overflow", "auto");
    });

    // 购物车按钮点击
    $(".left-btn").click(function (){
        var commodityId = $(this).attr("data");
        var userId = localStorage.getItem("userId");
        addMallCar(commodityId, userId);
    });
    /**
     * 添加到购物车
     * */
    function addMallCar(commodityId, userId){
        $.ajax({
            type: "POST",
            url: "/mall/mallCar/addCommodityCar",
            data: JSON.stringify({"commodityId":commodityId,"userId":userId}),
            dataType: "json",
            contentType: "application/json",
            success:function (data){
                //弹出添加成功框
                $(".collection-success").fadeToggle("slow");
                setTimeout(function () {
                    $(".collection-success").fadeToggle("slow");
                }, 3000);
            },
            error: function(XMLHttpRequest, textStatus, errorThrown){}
        });
    }
    /*$(".left-btn").click(function () {
             //显示
                $(".confirm-btn").addClass("left-btn-confirm-btn");//弹出框 确认 按钮  标记为 加入购物车
                 $(".choice-data").fadeIn();//弹出遮罩
                 $(".choice-data-content").slideDown("fast");//弹出选择框
                 $('html,body').css("overflow", "hidden");//禁止body滑动
                 $('.choice-data-info').css("overflow", "auto");//允许弹框滑动
         $(".left-btn-confirm-btn").click(function () {
             $(this).removeClass("left-btn-confirm-btn");//移除 确认 按钮  的标记
             $(".choice-data").fadeOut("slow"); //关闭遮罩
             $(".choice-data-content").slideUp("fast");//关闭选择
             $(".parameter-data").slideUp("fast");
             $('html,body').css("overflow", "auto");//允许body滑动
             //弹出添加成功框
             $(".collection-success").fadeToggle("slow");
             setTimeout(function () {
                 $(".collection-success").fadeToggle("slow");
             }, 3000);
         });
     });*/
     //由 加入购物车 弹出的 选择框 的 确认按钮

    // 确认购买
    $(".buy-now-btn").click(function () {
        var commodityId = $(this).attr("data");
        var userId = localStorage.getItem("userId");
        window.location.href = "/mall/mallOrder/previewOrder?commodityId=" + commodityId + "&userId=" + userId;
    });
    /*$(".buy-now-btn").click(function () {
        $(".confirm-btn").addClass("buy-now-btn-confirm-btn");//弹出框 确认 按钮  标记为 确认购买
            $(".choice-data").fadeIn();
        $(".choice-data-content").slideDown("fast");
        $('html,body').css("overflow", "hidden");//禁止body滑动
        $('.choice-data-info').css("overflow", "auto");//允许弹框滑动
        //由 确认购买 弹出的 选择框 的 确认按钮
        $(".buy-now-btn-confirm-btn").click(function () {
            $(this).removeClass("buy-now-btn-confirm-btn");//移除 确认 按钮  的标记
            $(".choice-data").fadeOut("slow"); //关闭遮罩
            $(".choice-data-content").slideUp("fast");//关闭选择
            $('html,body').css("overflow", "auto");//允许body滑动
            $(".parameter-data").slideUp("fast");
            //跳转付款页面
            window.location.href="firmOrder.html";
        });
    });*/

    //点击空白地方隐藏
    $(".choice-data").click(function (event) {
        // $(".confirm-btn").removeClass("left-btn-confirm-btn");//移除 确认 按钮  的标记
        // $(".confirm-btn").removeClass("buy-now-btn-confirm-btn");//移除 确认 按钮  的标记
        $(".choice-data").fadeOut("slow");
        $(".choice-data-content").slideUp("fast");
        $(".parameter-data").slideUp("fast");
        $('html,body').css("overflow", "auto");
        event.stopPropagation();
    });
    //阻止点击事件冒泡
    $(".choice-data-content").click(function (event) {
        event.stopPropagation();
    });

    //详情 评价 切换按钮
    $(".bar-btn").click(function () {
        if ($(".center-bar a").index(this) == 0) {
            $(".bar-btn").removeClass("this-bar-btn");
            $(this).addClass("this-bar-btn");
            $(".evaluate").css("display","none");
            $(".parm-li").css("display","block");
        } else {
            $(".bar-btn").removeClass("this-bar-btn");
            $(this).addClass("this-bar-btn");
            $(".parm-li").css("display","none");
            $(".evaluate").css("display","block");
            commodityDescription(this.name);
        }
    });
});

/*
* 商品详情的评价获取
* */
function commodityDescription(commodityId){
    var html = "<li>" +
               "<p class=\"evaluate-name\">PERSON_NAME:</p>" +
               "<span class=\"evaluate-time\">TIME</span>" +
               "<span class=\"evaluate-content\">" +
               "CONTENT" +
               "</span></li>";
    $.ajax({
        type: "POST",
        url: "/mall/commodity/commodityComments",
        data: JSON.stringify({"commodityId":commodityId}),
        dataType: "json",
        contentType: "application/json",
        success: function (data) {
            var innerHtml = "";
            $(data.data).each(function(i, n){
                innerHtml += html
                    .replace("PERSON_NAME", n.personName)
                    .replace("TIME", n.createDate)
                    .replace("CONTENT", n.remarks);
            });
        $(".evaluate").html(innerHtml);
        },
        error: function(XMLHttpRequest, textStatus, errorThrown){}
    });
}

$(document).ready(function() {
    $("[type ='inpit/assembly']").inpitassembly({
        selected: "ack",
    }).find("button").click(function(){
        parmeterSelectionData = (check_result($(this)).data.data);
    });
});
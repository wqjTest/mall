var classifySwiper = new Swiper('.swiper-container-tab',{
    slidesPerView: "auto",
    direction: 'vertical',    //纵向
    freeMode : true,         //不贴边
    resistanceRatio : 0,     //边缘抵抗力，最前和最后不能再拉
    height : window.innerHeight,
    lazy: {
        loadPrevNext: true,
    },
    on: {
        slideChangeTransitionStart: function () {
            $(".menu-item .this-item").removeClass('this-item');
            $(".menu-item a").eq(classifySwiper.activeIndex).addClass('this-item');
        }
    }
 });

$(".menu-item a").on('touchstart mousedown',function(e){
    e.preventDefault();
    $(".menu-item .this-item").removeClass('this-item');
    $(this).addClass('this-item');
    var name = $(this).attr("name");
    var typeName = $(this).text();
    classifySwiper.slideTo($(this).index());
    fillCommodityData(name, typeName);
});

function fillCommodityData(commodityTypeId, typeName){
    $(".real-time").text(typeName);
    var html = "<a href=\"javascript:commodityContent('COMMODITY_ID')\" hidefocus=\"true\">" +
        "<img class=\"swiper-lazy\" src=\"COMMODITY_IMAGE\">" +
        "<p>COMMODITY_NAME</p>" +
        "</a>";
    var innerHtml = "";
    $.ajax({
        type: "POST",
        url: "/mall/commodity/listCommodityByType",
        data: JSON.stringify({"commodityType":commodityTypeId}),
        dataType: "json",
        contentType: "application/json",
        success: function (data) {
            if(data.data.length === 0){
                innerHtml = "No Data...";
            }else{
                $(data.data).each(function (i, n) {
                    innerHtml += html.replace("COMMODITY_IMAGE", n.commodityImage)
                        .replace("COMMODITY_NAME", n.commodityName)
                        .replace("COMMODITY_ID", n.id)
                });
            }
            $(".classify-shopping").html(innerHtml);
            },
        error: function(XMLHttpRequest, textStatus, errorThrown){}
    });
}

$('.sort a').click(function(){            //按钮按下
    if($("#price-ranking").hasClass('this-sort')) {//如果价格按钮已经被按下
        if ($(".sort a").index(this) == 1) {   //判断按下的是否为价格排序按钮
            var sortPrice = $(this).children("img").attr('src');//获取价格按钮的状态
            console.log(this);
            if (sortPrice.indexOf("low") > 0){//是否已经是价格降序
                $(".sort a").removeClass("this-sort");//价格升序
                $(this).addClass("this-sort");
                $("#price-ranking img").attr('src',"/mall/img/sort-hight.svg");
            }
            else{                                                       //否则
                $("#price-ranking img").attr('src', "/mall/img/sort-low.svg");//价格降序
            }
        } else {                                          //如果按下的不是价格按钮
            $(".sort a").removeClass("this-sort");
            $(this).addClass("this-sort");
            $("#price-ranking img").attr('src',"/mall/img/sort-no.svg");//取消价格排序按钮图标
        }
    } else if($(".sort a").index(this)==1){ //如果价格按钮没有被按下 且按下的是价格按钮
        $(".sort a").removeClass("this-sort");
        $(this).addClass("this-sort");
        $("#price-ranking img").attr('src',"/mall/img/sort-hight.svg");
    } else {
        $(".sort a").removeClass("this-sort"); //如果价格按钮没有被按下 且按下的也不是价格按钮  就和价格排序按钮没关系
        $(this).addClass("this-sort");
    }
});
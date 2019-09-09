var swiperV = new Swiper('.swiper-container-v', {
    autoplay:true,                              //自动播放
    loop:true,
    autoplayDisableOnInteraction:false,
    pagination: {
        el: '.swiper-pagination-v',
        clickable: true,
    },
});

var mySwiper = new Swiper('.swiper-container-x',{
    autoplay:true,
    effect : 'fade',
    // autoHeight:true,
    // direction : 'vertical',
    loop:true,
    cubeEffect: {
    },
});

window.onscroll=function(){
    var h =document.documentElement.scrollTop||document.body.scrollTop;
    // console.log(h*1.25);      //控制台查看监听滚动
    var headerTop =document.getElementById("header");
    if( h >=80) {       //header的高度是80px;
        headerTop.style.background="#fff";
        // headerTop.style.color="rgba(66,65,66,1)";
    }else{
        if(h<20){
            //40*2.5=100;这样透明度就可以由0渐变到100%；
            headerTop.style.background="rgba(0,0,0,0)";
            // headerTop.style.color="rgba(66,66,66,0.0"+h*2.5+")";
        }else if(h>20 && h<= 80){
            headerTop.style.background="rgba(255,255,255,0."+h*1.25+")";
            // headerTop.style.color="rgba(66,66,66,0."+h*2.5+")";

        }

    }
};

function commodityContent(commodityId){
    window.location.href = "/mall/commodity/" + commodityId;
}
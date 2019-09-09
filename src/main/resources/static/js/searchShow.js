// <script type="text/javascript">
//     $(document).ready(function(){
        //切换皮肤

        $('.right-btn').click(function(){
            var  hrefcss;
            hrefcss = $("#change-layout").attr("href");
            if(hrefcss.indexOf("transverse")<0) {
                $("#change-layout").attr("href", "css/transverse.css")
                // console.log(hrefcss)
            }
            else {
                $("#change-layout").attr("href", "css/latticed.css")
                // console.log(hrefcss)
            }
        });
$('.sort a').click(function() {            //按钮按下
    if ($("#price-ranking").hasClass('this-sort')) {//如果价格按钮已经被按下
        if ($(".sort a").index(this) == 1) {   //判断按下的是否为价格排序按钮
            var sortPrice = $(this).children("img").attr('src');//获取价格按钮的状态
            console.log(this);
            if (sortPrice.indexOf("low") > 0) {//是否已经是价格降序
                $(".sort a").removeClass("this-sort");//价格升序
                $(this).addClass("this-sort");
                $("#price-ranking img").attr('src', "img/sort-hight.svg");
            } else {                                                       //否则
                $("#price-ranking img").attr('src', "img/sort-low.svg");//价格降序
            }
        } else {                                          //如果按下的不是价格按钮
            $(".sort a").removeClass("this-sort");
            $(this).addClass("this-sort");
            $("#price-ranking img").attr('src', "img/sort-no.svg");//取消价格排序按钮图标
        }
    } else if ($(".sort a").index(this) == 1) { //如果价格按钮没有被按下 且按下的是价格按钮
        $(".sort a").removeClass("this-sort");
        $(this).addClass("this-sort");
        $("#price-ranking img").attr('src', "img/sort-hight.svg");
    } else {
        $(".sort a").removeClass("this-sort"); //如果价格按钮没有被按下 且按下的也不是价格按钮  就和价格排序按钮没关系
        $(this).addClass("this-sort");
        // $("#price-ranking img").attr('src',"img/sort-no.svg");
    }
});

    // });
// </script>

// /**************************************************************/
// $(function ()
// {
//     $(".sort a:eq(q)").click(
//         function ()
//         {
//             console.log("hello");
//             var arr = new Array();
//             $(".content span").each(function (index, e)
//             {
//                 arr[index] = parseInt($(e).text().substring(1));
//             });
//             //  排序开始
//             for (i = 1; i < arr.length; i++) {
//                 for (j = 0; j < arr.length - i; j++) {
//                     var temp = 0;
//                     if (arr[j] > arr[j + 1]) {
//                         temp = arr[j];
//                         arr[j] = arr[j + 1];
//                         arr[j + 1] = temp;
//                     }
//                 }
//             }
//             // 排序结束
// //               alert(arr);
//             var len = $(".content span").size();
//             alert(len);
//             //取到li下的数字值
//             //把Li按照数组的顺序进行插入！
//             for(i=0;i<arr.length;i++)
//             {
//                 for(j=0;j<len;j++)
//                 {
//                     if(arr[i]==$(".content span").eq(j).text().substring(1))
//                     {
// //                       alert($("li span").eq(j).text().substring(1));
//                         console.log(i+""+j);
//                         $(".content span").eq(j).parents("li").remove().appendTo(".content");
//                         break;
//                     }
//                 }
//             }
//         }
//     );
// });

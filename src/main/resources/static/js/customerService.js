//更多功能展开
function openMore()
{
    $('.chat-more-btn-block').show().css("display", "flex");
    $('.chat-record-bottom-space').css("height", "10.7rem");
    $('.input-line').css({"bottom":"7.6rem"});
}
//我的订单按钮
function openOrde()
{
    $('.choice-order-shade').fadeIn(100);
    $('.choice-order').slideDown("faster");
    $('html,body').css("overflow", "hidden");
}

//我的订单关闭按钮
function closeChoice()
{
    $('.choice-order').slideUp("faster");
    $('.choice-order-shade').fadeOut();
    $('html,body').css("overflow", "auto");
}
$(document).ready(function() {
    $(".chat-record").click(function () {
        if( $('.chat-more-btn-block').css('display') === 'flex'){
            $('.chat-more-btn-block').hide().css("display", "none");
            $('.chat-record-bottom-space').css("height", "3.1rem");
            $('.input-line').css({"bottom":"0rem"});
        }
    });
    $("#chat").click(function () {
        if( $('.chat-more-btn-block').css('display') === 'flex'){
            $('.chat-more-btn-block').hide().css("display", "none");
            $('.chat-record-bottom-space').css("height", "3.1rem");
            $('.input-line').css({"bottom":"0rem"});
        }
    })
});

// 按钮添加数量
function addBtnFun(result){
	var count = $(result).parents().find("#selter");
	var src = $(count).attr('src');
	var price = $(result).parents().find("#price #price_span").text().replace(/[^0-9]/ig,"");
	var btn = parseInt($('#btn').val().replace(/[^0-9]/ig,"")).toFixed(2);
	var all = parseFloat($("#countprict").html().replace(/[^0-9]/ig,"")).toFixed(2);
	if(src.indexOf('yes') > 0){
		all += price;
		btn += 1;
		var strings ="结算（" + btn + "）";
		$("#countprict").html(all);
		$('#btn').val(strings);
	}
}

// 按钮减少数量
function removeBtnFun(result){
	var count = $(result).parent().parent().parent().parent().parent().siblings().eq(0).find("img");
	var srcImg = $(count).attr('src');
	var price = parseFloat($(result).parents().find("#price #price_span").text().replace(/[^0-9]/ig,"")).toFixed(2);
	var btn = parseInt($('#btn').val().replace(/[^0-9]/ig,""));
	var all = parseFloat($("#countprict").html().replace(/[^0-9]/ig,"")).toFixed(2);
	if(srcImg.indexOf('yes') > 0){
		all -= price;
		btn -= 1;
		if(all <= 0) {
			all = 0;
			btn = 0;
		}
		if($(result).val() === 0) {
			var real = srcImg.replace('yes','no');
			$(result).parent().parent().parent().parent().parent().siblings().eq(0).find("img").attr('src',real);
			checkFun();
		}
		var strings = "结算（"+btn+"）";
		$("#countprict").html(all);
		$('#btn').val(strings);
	}
}

// 按钮添加数量
function addClick(name){
    var activity = "#" + name.getAttribute("data");
	var add = $(activity).val();
	var add1 = parseInt(add) + 1;
	$(activity).val(parseInt(add1));
	addBtnFun(activity);
}

// 按钮减少数量
function removeClick(name){
    var activity = "#" + name.getAttribute("data");
	var add = $(activity).val();
	if(add >= 1){
		var add1=parseInt(add) - 1;
		$(activity).val(parseInt(add1));
	} else {
		$(activity).attr('value',0);
		return;
	}
	removeBtnFun(activity);
}

// 选择需要结算的商品
function changsrc(src){
	var sar= $(src).attr("src");
	var num=parseInt($(src).parent().siblings().find("#count input").val());
	if(sar.indexOf('no')>0) {
		if(num==0){
			$(src).parent().siblings().find("#count input").val(1)
		}
		var realsrc=sar.replace('no','yes');
		$(src).attr("src",realsrc)
	} else {
		var realsrc=sar.replace('yes','no');
		$(src).attr("src",realsrc)
	}
}

// 计算总价
function Count(count){
	var real = $(count).attr('src');
	var btn = parseInt($('#btn').val().replace(/[^0-9]/ig,""));
	var all = parseFloat($("#countprict").html().replace(/[^0-9]/ig,"")).toFixed(2);
	var quantiy = parseInt($(count).parent().siblings().find("#count input").val().replace(/[^0-9]/ig,""));
	var price = parseFloat($(count).parent().siblings().find("#price span").text().replace(/[^0-9]/ig,"")).toFixed(2);
	var counts = (price * quantiy).toFixed(2);
	if(real.indexOf('yes')>0){
		all += counts;
		btn += quantiy;
	} else {
		all -= counts;
		btn -= quantiy;
		if(all<0) {
			all=0;
			btn=0;
		}
	}
	var strings="结算（"+btn+'）';
	$("#countprict").html(all);
	$('#btn').val(strings);
}

/**
 * 更新汇总数据
 * @param btn 商品的个数
 * @param all 选中商品的总价
 * */
function updateCostSum(btn, all){
    var sum = "结算（" + btn + "）";
    $("#countprict").html(all);
    $('#btn').val(sum);
}

// 判定是否全选
function checkFun(){
	var src = $("#shopping_footer img").attr('src');
	var imgItem = $('.main_content table img');
	var realImg = [];
	for(var q = 0; q<imgItem.length-1; q++){
		var IMG=$(imgItem[q]).attr('src');
		if(IMG.indexOf('no')>0||IMG.indexOf('yes')>0){
			realImg.push(imgItem[q]);
		}
	}
	for(var i = 0 ; i<realImg.length ; i++){
		var checkimage = $(realImg[i]).attr('src');
		if(checkimage.indexOf('no')>0 || src.indexOf('yes')>0){
			var real =src.replace('yes','no');
			$("#shopping_footer img").attr('src',real);
			return;
		}
	}
	var real = src.replace('no','yes');
	$("#shopping_footer img").attr('src',real);
}
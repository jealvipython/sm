$(function(){
	$(document).on('click', '.reduce', function(){
		var num = parseInt($(this).parent().find('input').val());
		if(num > 0){
			num --;
			$(this).parent().find('input').val(num);
		}else{
			console.log('就不改')
		}
	});
	$(document).on('click', '.plus', function(){
		var num = parseInt($(this).parent().find('input').val());
		if(num < 101){
			num ++;
			$(this).parent().find('input').val(num);
		}else{
			console.log('您最多购买100个')
		}
	});
}());
// 防止命名冲突，定义了globalUtil对象
var globalUtil = {};

globalUtil.fn = {
	//弹框Toast
	alert: function(str, time, cb){
		time = time || 1.5;
		var alertDialog = '<div id="g-alertDialog" class="">'+
							'<div class="mask_content">'+
								'<span>'+ str +'</span>'+
							'</div>'+
						'</div>';
		$('body').append(alertDialog);
		setTimeout("globalUtil.fn.hideAlert("+cb+")",time*1000);
	},
	hideAlert: function(cb){
		if (cb) {
			console.log(cb);
			cb();
		}
		$('#g-alertDialog').remove();
	},
	showMask: function(){
		var mask = '<div class="g-mask"></div>';
		$('body').append(mask);
	},
	hideMask: function(){
		$('.g-mask').remove();
	},
	formatDate: function(date,format){
		//格式化日期,
        var paddNum = function(num){
          num += "";
          return num.replace(/^(\d)$/,"0$1");
        }
        //指定格式字符
        var cfg = {
           yyyy : date.getFullYear() //年 : 4位
          ,yy : date.getFullYear().toString().substring(2)//年 : 2位
          ,M  : date.getMonth() + 1  //月 : 如果1位的时候不补0
          ,MM : paddNum(date.getMonth() + 1) //月 : 如果1位的时候补0
          ,d  : date.getDate()   //日 : 如果1位的时候不补0
          ,dd : paddNum(date.getDate())//日 : 如果1位的时候补0
          ,hh : date.getHours()  //时
          ,mm : date.getMinutes() //分
          ,ss : date.getSeconds() //秒
        }
        format || (format = "yyyy-MM-dd hh:mm:ss");
        return format.replace(/([a-z])(\1)*/ig,function(m){return cfg[m];});
      }
}



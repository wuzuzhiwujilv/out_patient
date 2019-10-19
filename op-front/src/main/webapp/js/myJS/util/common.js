function msgShow(title, msg, errorOrSuccess){
	$.messager.show({
		title : title,
		msg : msg
	});
}
function message(msg){
	$.messager.show({
		title : '提示',
		msg : msg,
		timeout:3000
	});
}

function warn(msg){
	$.messager.show({
		title : '提示',
		msg : msg,
		timeout:3000,
		style:{
			right:'',
			top:document.body.scrollTop+document.documentElement.scrollTop,
			bottom:''
		}
	});
}
function trim(str){ //删除左右两端的空格
    return str.toString().replace(/(^\s*)|(\s*$)/g, "");
}
function isEmpty(str){
	if(str == null||trim(str)==""){
		return true;
	}
	return false;
}
function sleep(numberMillis) {
	var now = new Date();
	var exitTime = now.getTime() + numberMillis;
	while (true) {
		now = new Date();
		if (now.getTime() > exitTime)
		return;
	    }
}
function load(msg) {  
    $("<div class=\"datagrid-mask\"></div>").css({zIndex:9999, display: "block", width: "100%", height: $(window).height() }).appendTo("body");  
    $("<div class=\"datagrid-mask-msg\"></div>").html(msg).appendTo("body").css({zIndex:9999,  display: "block", left: ($(document.body).outerWidth(true) - 190) / 2, top: ($(window).height() - 45) / 2 });  
}
//取消加载层  
function disLoad() {  
    $(".datagrid-mask").remove();  
    $(".datagrid-mask-msg").remove();  

}
var MaskUtil = (function(){  
    
    var $mask,$maskMsg;  
      
    var defMsg = '正在处理，请稍待。。。';  
      
    function init(){  
        if(!$mask){  
            $mask = $("<div class=\"datagrid-mask mymask\"></div>").appendTo("body");  
        }  
        if(!$maskMsg){  
            $maskMsg = $("<div class=\"datagrid-mask-msg mymask\">"+defMsg+"</div>")  
                .appendTo("body").css({'font-size':'12px'});
        }  
          
        $mask.css({width:"100%",height:$(document).height()});  
          
        $maskMsg.css({  
            left:($(document.body).outerWidth(true) - 190) / 2,top:($(window).height() - 45) / 2,
        });   
                  
    }  
      
    return {  
        mask:function(msg){  
            init();  
            $mask.show();  
            $maskMsg.html(msg||defMsg).show();  
        }  
        ,unmask:function(){  
            $mask.hide();  
            $maskMsg.hide();  
        }  
    }  
      
}());  
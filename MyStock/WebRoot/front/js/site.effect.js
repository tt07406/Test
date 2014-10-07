$(document).ready(function(){
	(function(){
		/*--back-to-top--*/
		$("#backToTop").hide();
		$(document).scroll(function(){
			if($(this).scrollTop()>300){
				$("#backToTop").fadeIn();
			}else{$("#backToTop").fadeOut();}
		});
		$("#backToTop").click(function(){
			$('body,html').animate({scrollTop:0},500);
	        return false;
	    });
	})();
	(function(){
		if(parseInt($("body").css("height"))<parseInt(window.outerHeight)){
			$("footer").css("position","fixed");
			$("footer").css("bottom","0");
		}
	})();
	(function(){
		/*=====nav=====
		 *==========*/
		var $dropdpwn=$('.dropdown'),
			$dropdown_toggle=$(".dropdown > a"),
			$dropdown_menu=$(".dropdown > ul");
		$dropdpwn.on({
			mouseenter:function(){
				console.log('enter');		
				var $menu=$(this).find(".dropdown-menu[data-toggle='toggle_ul']");
				$menu.toggle( "blind" );
			},
			mouseleave:function(){
				var $menu=$(this).find(".dropdown-menu[data-toggle='toggle_ul']");
				$menu.toggle( "blind" );
			}
		});
	})();
});
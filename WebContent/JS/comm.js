$(
		function(){
			var w = $("#reTable").outerWidth(true);
			var ww = $("#reTable").width();
			$("#reTable").css({"left":w/2+ww/2});
		
		  $("input").focus(function(){
		    $(this).css("background-color","#ecf6da");
		  });
		  $("input").blur(function(){
		    $(this).css("background-color","#ffffff");
		  });
	}
);

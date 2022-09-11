$(document).ready(function() {
	var pageURL = window.location.search.toLowerCase();
	if(pageURL.indexOf('order_by=price&sort_by=asc') > -1) {
		$('#dropdownMenu1').html('Giá tăng dần');
		$('.dropdown-menu li').eq(0).addClass('active');
	}
	else if(pageURL.indexOf('order_by=price&sort_by=desc') > -1) {
		$('#dropdownMenu1').html('Giá giảm dần');
		$('.dropdown-menu li').eq(1).addClass('active');
	}
	else if(pageURL.indexOf('order_by=date&sort_by=desc') > -1) {
		$('#dropdownMenu1').html('Mới nhất');
		$('.dropdown-menu li').eq(2).addClass('active');
	}
	
	$('.sidebar__category li a').each(function () {
		if($(this).text() == $('.breadcrumb__text h3').text()) {
			$(this).addClass('active');
		}
	});
	
	if($('.product__details__promotionFlag').val() == '1') {
		$('.product__details__price').addClass("price_sale");
		$('.product__details__promotionPrice').addClass("price_active");
	} else {
		$('.product__details__price').addClass("price_active");
	}
	
	$('#dropdownMenu1').hover(function(){
		if($('ul.dropdown-menu').css("display") == "none")
			$('ul.dropdown-menu').show();
		else
			$('ul.dropdown-menu').hide();
	});
	$('.dropdown-menu').hover(function(){
		if($('ul.dropdown-menu').css("display") == "none")
			$('ul.dropdown-menu').show();
		else
			$('ul.dropdown-menu').hide();
	});
});
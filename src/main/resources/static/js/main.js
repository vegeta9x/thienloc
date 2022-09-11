/*  ---------------------------------------------------
    Project Name: Thiên Lộc pharmacy
    Author: van.thanh.long
    Version: 1.0
---------------------------------------------------------  */

'use strict';

(function ($) {
	
    /*------------------
    show info to cart
    --------------------*/

    var localData = JSON.parse(localStorage.getItem("checkoutData"));
    localData ? $(".total_product").html(localData.totalProduct) : $(".total_product").hide();
    localData ? $(".total_price").html(localData.totalPrice.toLocaleString("vi")) : 0;

    /*------------------
    header menu setting
    --------------------*/
    // var pageURL = $(location).attr("href");
    var pageURL = window.location.pathname;

    if(pageURL.search("blog") > 0) {
        $(".header__menu li").eq(1).addClass("active");
        $("nav.humberger__menu__nav li").eq(1).addClass("active");
    } else if(pageURL.search("shopping-guide") > 0) {
        $(".header__menu li").eq(2).addClass("active");
        $("nav.humberger__menu__nav li").eq(2).addClass("active");
    } else if(pageURL.search("contact") > 0) {
        $(".header__menu li").eq(3).addClass("active");
        $("nav.humberger__menu__nav li").eq(3).addClass("active");
    } else {
        $("nav.humberger__menu__nav li").eq(0).addClass("active");
        $(".header__menu li").eq(0).addClass("active");
    }

    /*------------------
        Preloader
    --------------------*/
    $(window).on('load', function () {
        $(".loader").fadeOut();
        $("#preloder").delay(200).fadeOut("slow");

    });
    
    /*------------------
        price_sale Set
    --------------------*/
	$('.featured__item__text').each(function () {
		if($(this).find('.productItem_promotionFlag').html() == 1) {
			$(this).find('.productItem_price').addClass("price_sale");
			$(this).find('.productItem_promotionPrice').addClass("price_active");
		} else {
			$(this).find('.productItem_price').addClass("price_active");
			//$(this).find('.productItem_promotionPrice').html('');
		}
	});
	$('.latest-product .latest-product__item__text').each(function () {
		if($(this).find('.productItem_promotionFlag').html() == 1) {
			$(this).find('.productItem_price').addClass("price_sale");
			$(this).find('.productItem_promotionPrice').addClass("price_active");
		} else {
			$(this).find('.productItem_price').addClass("price_active");
			//$(this).find('.productItem_promotionPrice').html('');
		}
	});
	if($('.product__details__promotionFlag').val() == '1') {
		$('.product__details__price').addClass("price_sale");
		$('.product__details__promotionPrice').addClass("price_active");
	} else {
		$('.product__details__price').addClass("price_active");
		$('.product__details__promotionPrice').html('');
	}
	
	$('.featuredProduct_1 li.nav-item a').eq(0).addClass("active");
	$('.featuredProduct_1 .tab-content .tab-pane').eq(0).addClass("active");
	$('.featuredProduct_2 li.nav-item a').eq(0).addClass("active");
	$('.featuredProduct_2 .tab-content .tab-pane').eq(0).addClass("active");
	
	$( ".blog__item__text" ).each(function(index) {
		var content = $(this).find('.content__blogDetails__hide').text();
       	$(this).find('.blogList__content').html(content.replace(/(<([^>]+)>)/ig,""));
       	$(this).find('.content__blogDetails__hide').remove();
	});

    /*------------------
        Background Set
    --------------------*/
    $('.set-bg').each(function () {
        var bg = $(this).data('setbg');
        $(this).css('background-image', 'url(' + bg + ')');
    });

    //Humberger Menu
    $(".humberger__open").on('click', function () {
        $(".humberger__menu__wrapper").addClass("show__humberger__menu__wrapper");
        $(".humberger__menu__overlay").addClass("active");
        $("body").addClass("over_hid");
    });

    $(".humberger__menu__overlay").on('click', function () {
        $(".humberger__menu__wrapper").removeClass("show__humberger__menu__wrapper");
        $(".humberger__menu__overlay").removeClass("active");
        $("body").removeClass("over_hid");
    });

    $(".main_categories__menu__dropdown li i").on('click', function () {
        $(".children_categories__menu__dropdown").hide(300);
        var index = $(".main_categories__menu__dropdown li i").index(this);

        var cssProp = $(".children_categories__menu__dropdown").eq(index).css("display");

        if(cssProp === "none")
            $(".children_categories__menu__dropdown").eq(index).show(300);
    });

    /*------------------
		Navigation
	--------------------*/
    $(".mobile-menu").slicknav({
        prependTo: '#mobile-menu-wrap',
        allowParentLinks: true
    });

    /*-----------------------
        Categories Slider
    ------------------------*/
    $(".categories__slider").owlCarousel({
        loop: true,
        margin: 0,
        items: 4,
        dots: false,
        nav: true,
        navText: ["<span class='fa fa-angle-left'><span/>", "<span class='fa fa-angle-right'><span/>"],
        animateOut: 'fadeOut',
        animateIn: 'fadeIn',
        smartSpeed: 1200,
        autoHeight: false,
        autoplay: true,
        responsive: {

            0: {
                items: 1,
            },

            480: {
                items: 2,
            },

            768: {
                items: 3,
            },

            992: {
                items: 4,
            }
        }
    });

	var flag = 1;

    $('.hero__categories__all').on('click', function(){
		$(".children_categories__menu__dropdown").hide(300);
        $('.hero__categories > ul').slideToggle(400);
        
        flag = 0;
    });
    
    jQuery(document).click(function(e) {
        var target = e.target;
        if (flag != 0 && ($('.main_categories__menu__dropdown').css("display") == "block") && (
			!jQuery(target).is('.main_categories__menu__dropdown') && 
			!jQuery(target).is('.main_categories__menu__dropdown li') && 
			!jQuery(target).is('.main_categories__menu__dropdown li a') && 
			!jQuery(target).is('.main_categories__menu__dropdown li i') && 
			!jQuery(target).is('.children_categories__menu__dropdown') && 
			!jQuery(target).is('.children_categories__menu__dropdown li'))) {
				if(pageURL == "/index" || pageURL == "/") {
					$(".children_categories__menu__dropdown").hide(300);
				} else
            		$('.hero__categories > ul').slideToggle(400);
        } else
            flag = 1;
    });

    /*--------------------------
        Latest Product Slider
    ----------------------------*/
    $(".latest-product__slider").owlCarousel({
        loop: true,
        margin: 0,
        items: 1,
        dots: false,
        nav: true,
        navText: ["<span class='fa fa-angle-left'><span/>", "<span class='fa fa-angle-right'><span/>"],
        smartSpeed: 1200,
        autoHeight: false,
        autoplay: true
    });

    /*-----------------------------
        Product Discount Slider
    -------------------------------*/
    $(".product__discount__slider").owlCarousel({
        loop: true,
        margin: 0,
        items: 4,
        dots: true,
        smartSpeed: 1200,
        autoHeight: false,
        autoplay: true,
        responsive: {

            320: {
                items: 2,
            },

            480: {
                items: 2,
            },

            768: {
                items: 3,
            },

            992: {
                items: 4,
            }
        }
    });

    /*---------------------------------
        Product Details Pic Slider
    ----------------------------------*/
    var itemSize = parseInt($('.imageProductListSize').text()) + 1;
    var size = itemSize > 4 ? 4 : itemSize;
    $(".product__details__pic__slider").owlCarousel({
        loop: true,
        margin: 20,
        items: size,
        dots: true,
        smartSpeed: 1200,
        autoHeight: false,
        autoplay: true
    });

    /*------------------
		Single Product
	--------------------*/
    $('.product__details__pic__slider img').on('click', function () {

        var imgurl = $(this).data('imgbigurl');
        var bigImg = $('.product__details__pic__item--large').attr('src');
        if (imgurl != bigImg) {
            $('.product__details__pic__item--large').attr({
                src: imgurl
            });
        }
    });

    /*-------------------
		Quantity change
	--------------------- */
    var proQty = $('.pro-qty');
    proQty.prepend('<span class="dec qtybtn">-</span>');
    proQty.append('<span class="inc qtybtn">+</span>');
    proQty.on('click', '.qtybtn', function () {
        var $button = $(this);
        var oldValue = $button.parent().find('input').val();
        if ($button.hasClass('inc')) {
            var newVal = parseFloat(oldValue) + 1;
        } else {
            // Don't allow decrementing below zero
            if (oldValue > 1) {
                var newVal = parseFloat(oldValue) - 1;
            } else {
                newVal = 1;
            }
        }
        $button.parent().find('input').val(newVal);
    });


    /*-------------------
        Payment
    --------------------- */
    if( $('#payment_banking').is(':checked') ){
        $('.payment_tienmat').hide(300);
    } else {
        $('.payment_banking').hide(300);
    }

    $('#payment_banking').on('click', function () {
        $('.payment_tienmat').hide(300);
        $('.payment_banking').show(300);
    });
    $('.label__payment_banking').on('click', function () {
        $('.payment_tienmat').hide(300);
        $('.payment_banking').show(300);
    });

    $('#payment_tienmat').on('click', function () {
        $('.payment_banking').hide(300);
        $('.payment_tienmat').show(300);
    });
    $('.label__payment_tienmat').on('click', function () {
        $('.payment_banking').hide(300);
        $('.payment_tienmat').show(300);
    });
    
    $('.footer__widget .site-btn.email').on('click', function () {
		var email = $('.footer__widget .email').val();
		var EmailRegex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		
		if(EmailRegex.test(email))
			$('.footer__widget .email-notice').html('Đăng ký thành công.')
		else
			$('.footer__widget .email-notice').html('Địa chỉ email không hợp lệ.')
	});
	
    $('.footer__widget .site-btn.discount').on('click', function () {
		$('.footer__widget .discount-notice').html('Mã giảm giá không đúng.')
	});
	$('.footer__widget input.discount').on('change', function () {
		if($(this).val() == '')
			$('.footer__widget .discount-notice').html('');
	});


    /*-----------------------
		Price Range Slider
	------------------------ 
    var rangeSlider = $(".price-range"),
        minamount = $("#minamount"),
        maxamount = $("#maxamount"),
        minPrice = rangeSlider.data('min'),
        maxPrice = rangeSlider.data('max');
    rangeSlider.slider({
        range: true,
        min: minPrice,
        max: maxPrice,
        values: [minPrice, maxPrice],
        slide: function (event, ui) {
            minamount.val('$' + ui.values[0]);
            maxamount.val('$' + ui.values[1]);
        }
    });
    minamount.val('$' + rangeSlider.slider("values", 0));
    maxamount.val('$' + rangeSlider.slider("values", 1));*/

    /*--------------------------
        Select
    ----------------------------
    $("select").niceSelect();*/
})(jQuery);
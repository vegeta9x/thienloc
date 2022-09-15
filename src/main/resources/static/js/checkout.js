/*  ---------------------------------------------------
    Project Name: Thiên Lộc pharmacy
    Author: van.thanh.long
    Version: 1.0
---------------------------------------------------------  */

'use strict';

$(document).ready(function () {
    var localData = JSON.parse(localStorage.getItem("checkoutData"));
    var totalPrice = localData ? localData.totalPrice : 0;
    var totalProduct = localData ? localData.totalProduct : 0;
    var productDetail = localData ? localData.productDetail : [];

    $(".checkout__order__subtotal span.text").html(totalPrice.toLocaleString("vi") + " ₫");
    $(".checkout__order__total span.text").html(totalPrice.toLocaleString("vi") + " ₫");
    $(".totalPrice").val(totalPrice);
    $(".totalProduct").val(totalProduct);

    productDetail.forEach(function print(element) {
        var addElm = "<li><a style='inline-block;' href='"+ element.itemHref + "'>" + element.itemName + "</a></li>";
        $("ul.checkout__order__products").append(addElm);
        
        var insertHtml = "<tr><td><input type='hidden' name='productId' value='" +element.itemId+ "'></td><td><input type='hidden' name='quantity' value='" +element.itemQuantity+ "'></td><td><input type='hidden' name='price' value='" +element.itemPrice+ "'></td></tr>";
		$('.orderDetails tbody').append(insertHtml);
    });

    if(totalProduct == 0) {
		$(".checkout__order button").prop('disabled', true);
        $(".checkout__order button").hide();
    }
    
    $(".checkout__order button").on('click', function (event) {
		if(totalProduct != 0) {
			if($(".custommerName").val() == '') {
				$(".error-custommerName").show();
				return false;
			} else
				$(".error-custommerName").hide();
				
				
			if($(".customerAddress_1").val() == '') {
				$(".error-customerAddress_1").show();
				return false;
			} else
				$(".error-customerAddress_1").hide();
				
			if($(".customerAddress_2").val() == '') {
				$(".error-customerAddress_2").show();
				return false;
			} else
				$(".error-customerAddress_2").hide();
				
			if($(".customerPhone").val() == '') {
				$(".error-customerPhone_2").hide();
				$(".error-customerPhone_1").show();
				return false;
			} else {
				$(".error-customerPhone_1").hide();
				var regex=/^[0-9]+$/;
				if (($(".customerPhone").val().length != 10) || (!$(".customerPhone").val().match(regex))) {
					$(".error-customerPhone_2").show();
					return false;
					
				} else {
					$(".error-customerPhone_2").hide();
				}
			}
				
			var email = $('.customerEmail').val();
			var EmailRegex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
			
			if(email != '' && !EmailRegex.test(email)) {
				$(".error-customerEmail").show();
				return false;
			}
			else {
				$(".error-customerEmail").hide();
			}
		
			if($('#payment_banking').is(":checked"))
				$("#methodPay").val(1);
			else if($('#payment_tienmat').is(":checked"))
				$("#methodPay").val(2);
		} else {
			event.preventDefault();
		}
		
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
});
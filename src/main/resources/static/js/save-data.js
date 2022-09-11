/*  ---------------------------------------------------
    Project Name: Thiên Lộc pharmacy
    Author: van.thanh.long
    Version: 1.0
---------------------------------------------------------  */

'use strict';

$(document).ready(function () {
	
	$('.price_sale').each(function () {
		var price = $(this).html();
		$(this).html(parseInt(price).toLocaleString("vi", {style:"currency", currency:"VND"}));
    });
    
    $('.price_active').each(function () {
		var price = $(this).html();
		$(this).html(parseInt(price).toLocaleString("vi", {style:"currency", currency:"VND"}));
    });

    $('a.productItem_to_cart').on('click', function () {
        /*------------------
        save data in local storage
        --------------------*/

        var localData = JSON.parse(localStorage.getItem("checkoutData"));
        var totalPrice = localData ? localData.totalPrice : 0;
        var totalProduct = localData ? localData.totalProduct : 0;
        var productDetail = localData ? localData.productDetail : [];

        var selectedParentElm = $(this).parent().parent();
        var productItemId = selectedParentElm.find("span.productItem_Id").text();
        var productItemName = selectedParentElm.find("h6.productItem_name a").text();
        var productItemHref = selectedParentElm.find("h6.productItem_name a").attr("href");
        var productItemPrice = selectedParentElm.find("span.price_active").text().replace('.','').replace(' ₫','');
        var productItemImage = selectedParentElm.parent().find(".featured__item__pic").attr("data-setbg");

        if (typeof productItemImage === "undefined") {
            productItemImage = selectedParentElm.parent().find("img").attr("src");
        }

        totalProduct ++;
        totalPrice += parseInt(productItemPrice);

        var flag = 1;

        productDetail.forEach(function print(element){
            if(productItemId == element.itemId) {
                element.itemQuantity++;
                flag = 0;
                return false;
            }
        });

        if(flag == 1) {
            var productItem = {
                itemId: productItemId,
                itemName: productItemName,
                itemHref: productItemHref,
                itemPrice: parseInt(productItemPrice),
                itemQuantity: 1,
                image: productItemImage
            }
            productDetail.push(productItem);
        }

        var checkoutData = {
            totalProduct: totalProduct,
            totalPrice: totalPrice, 
            productDetail: productDetail
          };

        localStorage.setItem("checkoutData", JSON.stringify(checkoutData));

        showMessage();

        /*------------------
        show info to cart
        --------------------*/

        $(".total_product").show().html(totalProduct);
        $(".total_price").html(totalPrice.toLocaleString("vi"));

    });


    /*------------------
    shop detail page
    --------------------*/
    $('.product__details__text a.primary-btn').on('click', function () {

        var localData = JSON.parse(localStorage.getItem("checkoutData"));
        var totalPrice = localData ? localData.totalPrice : 0;
        var totalProduct = localData ? localData.totalProduct : 0;
        var productDetail = localData ? localData.productDetail : [];

        var productItemId = $(".product__details__text .product__details__id").val();
        var productItemName = $(".product__details__text .product__details__name").text();
        var productItemHref = window.location.pathname;
        var productItemPrice = $(".product__details__text .price_active").text().replace('.','').replace(' ₫','');
        var productItemQuantity = $(".product__details__quantity input").val();
        var productItemImage = $(".product__details__image").attr("href");

        if(parseInt(productItemQuantity) > 0) {
            totalProduct += parseInt(productItemQuantity);
            totalPrice += (parseInt(productItemQuantity) * parseInt(productItemPrice));

            var flag = 1;

            productDetail.forEach(function print(element){
                if(productItemId == element.itemId) {
                    element.itemQuantity += parseInt(productItemQuantity);
                    flag = 0;
                    return false;
                }
            });

            if(flag == 1) {
                var productItem = {
                    itemId: productItemId,
                    itemName: productItemName,
                    itemHref: productItemHref,
                    itemPrice: parseInt(productItemPrice),
                    itemQuantity: parseInt(productItemQuantity),
                    image: productItemImage
                }
                productDetail.push(productItem);
            }

            var checkoutData = {
                totalProduct: totalProduct,
                totalPrice: totalPrice, 
                productDetail: productDetail
              };

            localStorage.setItem("checkoutData", JSON.stringify(checkoutData));

            /*------------------
            show info to cart
            --------------------*/

            $(".total_product").show().html(totalProduct);
            $(".total_price").html(totalPrice.toLocaleString("vi"));
        }

        showMessage();

    });
});


function showMessage() {
    var snackbar = document.getElementById("snackbar");
    snackbar.className = "show";
    setTimeout(function(){ snackbar.className = snackbar.className.replace("show", ""); }, 2000);
}
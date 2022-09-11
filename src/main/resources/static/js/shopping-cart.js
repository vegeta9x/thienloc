/*  ---------------------------------------------------
    Project Name: Thiên Lộc pharmacy
    Author: van.thanh.long
    Version: 1.0
---------------------------------------------------------  */

'use strict';

$(document).ready(function () {
    var localData = JSON.parse(localStorage.getItem("checkoutData"));
    var productDetail = localData ? localData.productDetail : [];

    showData();

    productDetail.forEach(function print(element){
        var addElm = "<div class='row product_cart_item'><div class='shoping__cart__item__id' style='display: none;'>" + element.itemId + "</div><div class='col-lg-2 col-md-4 col-4 shoping__cart__item__img'><a href='" + element.itemHref + "'><img src=" + element.image + " alt='' height='100px' width='100px'></a></div><div class='col-lg-5 col-md-8 col-8 shoping__cart__item__name'><a href='" + element.itemHref + "'>" + element.itemName + "</a></div><div class='col-lg-2 col-md-5 col-5 shoping__cart__quantity'><div class='quantity'><div class='pro-qty'><span class='dec qtybtn'>-</span><input type='text' readonly value=" + element.itemQuantity + "><span class='inc qtybtn'>+</span></div></div></div><div class='col-lg-2 col-md-4 col-4 shoping__cart__price'>" + element.itemPrice.toLocaleString("vi") + " ₫</div><div class='col-lg-1 col-md-3 col-3 shoping__cart__item__close'><a><i class='fa fa-trash'></i> xoá</a></div></div>";
        $(".shoping__cart__table").append(addElm);
    });

    // minus, plus button
    var proQty = $('.pro-qty');
    proQty.on('click', '.qtybtn', function () {
        var $button = $(this);
        var oldValue = $button.parent().find('input').val();
        if ($button.hasClass('inc')) {
            var newVal = parseFloat(oldValue) + 1;
        } else {
            if (oldValue > 1) {
                var newVal = parseFloat(oldValue) - 1;
            } else {
                newVal = 1;
            }
        }
        $button.parent().find('input').val(newVal);

        saveData($(this).closest(".product_cart_item"), "edit");
        showData();
        reloadPage();
    });

    // delete button
    $(".shoping__cart__item__close a").on('click', function () {
        var parentElm = $(this).closest(".product_cart_item");

        saveData(parentElm, "delete");
        showData();
        reloadPage();
    });
    
});

function saveData(record, flag) {
    /*------------------
    save data in local storage
    --------------------*/

    var localData = JSON.parse(localStorage.getItem("checkoutData"));
    var totalPrice = localData ? localData.totalPrice : 0;
    var totalProduct = localData ? localData.totalProduct : 0;
    var productDetail = localData ? localData.productDetail : [];

    var productItemId = record.find(".shoping__cart__item__id").text();
    var productItemQuantity = record.find(".shoping__cart__quantity input").val();
    var productItemPrice = record.find(".shoping__cart__price").text().replace('.','').replace(' ','').replace('₫','');

    var indexToRemove = null;

    productDetail.forEach(function print(element, index){
        if(productItemId == element.itemId) {
            // case: click delete button
            if(flag == "delete") {
                indexToRemove = index;
                totalProduct -= productItemQuantity;
                totalPrice -= (parseInt(productItemPrice) * parseInt(productItemQuantity));
            } else {
                // case: click minus
                if(productItemQuantity < element.itemQuantity) {
                    totalProduct --;
                    totalPrice -= parseInt(productItemPrice);
                }
                // case: click plus
                else if(productItemQuantity > element.itemQuantity){
                    totalProduct ++;
                    totalPrice += parseInt(productItemPrice);
                }
                element.itemQuantity = productItemQuantity;
            }
            return false;
        }
    });

    if (indexToRemove !== null) {
        productDetail.splice(indexToRemove, 1);
        record.remove();
    }

    var checkoutData = {
        totalProduct: totalProduct,
        totalPrice: totalPrice, 
        productDetail: productDetail
      };

    localStorage.setItem("checkoutData", JSON.stringify(checkoutData));
}

function showData() {
    var localData = JSON.parse(localStorage.getItem("checkoutData"));
    var totalPrice = localData ? localData.totalPrice : 0;
    var totalProduct = localData ? localData.totalProduct : 0;
    var productDetail = localData ? localData.productDetail : [];

    localData ? $(".total_product").html(localData.totalProduct) : $(".total_product").hide();
    localData ? $(".total_price").html(localData.totalPrice.toLocaleString("vi")) : 0;

    if(totalProduct == 0) {
        $(".info-cart .empty-cart").show();
        $(".info-cart .filter__found").hide();
        $(".shoping-cart .shoping-cart-footer").hide();

    } else {
        $(".info-cart .filter__found span").html(parseInt(totalProduct));
        $(".cart__order__subtotal span").html(totalPrice.toLocaleString("vi") + " ₫");
        $(".cart__order__total span").html(totalPrice.toLocaleString("vi") + " ₫");
    }
}

function reloadPage() {
    var localData = JSON.parse(localStorage.getItem("checkoutData"));
    var productDetail = localData ? localData.productDetail : [];

    if(productDetail.length != $(".product_cart_item").length) {
        location.reload(true);
    }
}
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

    productDetail.forEach(function print(element) {
        var addElm = "<li><a style='inline-block;' href='"+ element.itemHref + "'>" + element.itemName + "</a></li>";
        $("ul.checkout__order__products").append(addElm);
    });

    if(totalProduct == 0) {
        $(".checkout__order button").hide();
    }
});
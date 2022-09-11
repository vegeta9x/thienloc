$(document).ready(function() {
	
	 $('.add-blog-btn').click(function() {
        if($(".productName").val() == '') {
			$(".error-productName").show();
			return false;
		} else
			$(".error-productName").hide();
			
		if($("#categoryId").val() == '') {
			$(".error-categoryName").show();
			return false;
		} else
			$(".error-categoryName").hide();
			
        if($(".price").val() == '') {
			$(".error-price").show();
			return false;
		} else
			$(".error-price").hide();
			
		if($('#promotionFlag2').is(":checked")) {
			if($(".promotionPrice").val() == '') {
				$(".error-promotion-price").show();
				return false;
			} else {
				$(".error-promotion-price").hide();
				$(".promotionFlag").val(1);
			}
				
		} else 
			$(".promotionFlag").val(0);
			
		if($(".brand").val() == '') {
			$(".error-brand").show();
			return false;
		} else
			$(".error-brand").hide();
			
		if($(".description").val() == '') {
			$(".error-description").show();
			return false;
		} else
			$(".error-description").hide();
			
		if($(".detail").val() == '') {
			$(".error-detail").show();
			return false;
		} else
			$(".error-detail").hide();
			
		if($(".info").val() == '') {
			$(".error-info").show();
			return false;
		} else
			$(".error-info").hide();
			
		if($(".quantity").val() == '') {
			$(".error-quantity").show();
			return false;
		} else
			$(".error-quantity").hide();
		
		if($('#topView1').is(":checked"))
			$(".topView").val(1);
		else if($('#topView2').is(":checked"))
			$(".topView").val(2);
		else if($('#topView3').is(":checked"))
			$(".topView").val(3);
		else if($('#topView0').is(":checked"))
			$(".topView").val(0);
			
		if($('#display1').is(":checked"))
			$(".displayFlag").val(0);
		else
			$(".displayFlag").val(1);
    });
    
    $('.price').change(function() {
		var svalue= $(this).val();
	    var regex=/^[0-9]+$/;
	    if (svalue != '' && !svalue.match(regex)) {
	        alert("bạn phải nhập chữ số từ 1 đến 9");
	        return false;
	    }
	});
	
	$('.promotionPrice').change(function() {
		var svalue= $(this).val();
	    var regex=/^[0-9]+$/;
	    if (svalue != '' && !svalue.match(regex)) {
	        alert("bạn phải nhập chữ số từ 1 đến 9");
	        return false;
	    }
	});
	
	$('.quantity').change(function() {
		var svalue= $(this).val();
	    var regex=/^[0-9]+$/;
	    if (svalue != '' && !svalue.match(regex)) {
	        alert("bạn phải nhập chữ số từ 1 đến 9");
	        return false;
	    }
	});
    
    $( ".mainOptgroup optgroup" ).each(function(index1, element1) {
        var classNameElm1 = $(element1).attr('class').replace('main__menu_','');;
        $( ".subOption option" ).each(function(index2, element2) {
            var classNameElm2 = $(element2).attr('class').substring($(element2).attr('class').indexOf(' ') + 1);
            if(classNameElm1 == classNameElm2) {
                element1.append(element2);
            }
        });
    });
    $('.subOption').remove();
    
    if($(".productId").val() == "") {
		$(".add-blog-btn").html("Đăng ký");
		$("h4").html("Tạo sản phẩm mới");
		$("#promotionFlag1").prop('checked', true);
		$("#display1").prop('checked', true);
		$("#topView0").prop('checked', true);
	}
	
	if($(".promotionFlag").val() == 0) {
		$("#promotionFlag1").prop('checked', true);
	} else {
		$("#promotionFlag2").prop('checked', true);
	}
	
    if( $('#promotionFlag1').is(':checked') ){
        $('.promotionPriceArea').hide(300);
    }

    $('#promotionFlag1').on('click', function () {
        $('.promotionPriceArea').hide(300);
    });
    $('[for="promotionFlag1"]').on('click', function () {
        $('.promotionPriceArea').hide(300);
    });

    $('#promotionFlag2').on('click', function () {
        $('.promotionPriceArea').show(300);
    });
    $('[for="promotionFlag2"]').on('click', function () {
        $('.promotionPriceArea').show(300);
    });
	
    if($(".displayFlag").val() == 0) {
		$("#display1").prop('checked', true);
	} else {
		$("#display2").prop('checked', true);
	}
	if($("#topView").val() == 0) {
		$("#topView0").prop('checked', true);
	} else if($("#topView").val() == 1) {
		$("#topView1").prop('checked', true);
	} else if($("#topView").val() == 2){
		$("#topView2").prop('checked', true);
	} else if($("#topView").val() == 3){
		$("#topView3").prop('checked', true);
	}
    
    $('.back-btn').click(function() {
       if(confirm("Sẽ mất hết nội dung bạn đã nhập. Bạn có muốn quay lại ?"))
            history.go(-1);
        return false;
    });
    
    $('.description').summernote({
        height: 200,
        toolbar: [
            ['style', ['bold', 'italic', 'underline', 'clear']],
            ['font', ['strikethrough', 'superscript', 'subscript']],
            ['fontsize', ['fontsize']],
            ['color', ['color']],
            ['para', ['ul', 'ol', 'paragraph']],
            ['height', ['height']]
        ]
    });
    
    $('.detail').summernote({
        height: 200,
        toolbar: [
            ['style', ['bold', 'italic', 'underline', 'clear']],
            ['font', ['strikethrough', 'superscript', 'subscript']],
            ['fontsize', ['fontsize']],
            ['color', ['color']],
            ['para', ['ul', 'ol', 'paragraph']],
            ['height', ['height']]
        ]
    });
    
    $('.info').summernote({
        height: 200,
        toolbar: [
            ['style', ['bold', 'italic', 'underline', 'clear']],
            ['font', ['strikethrough', 'superscript', 'subscript']],
            ['fontsize', ['fontsize']],
            ['color', ['color']],
            ['para', ['ul', 'ol', 'paragraph']],
            ['height', ['height']]
        ]
    });
});
$(document).ready(function() {
	var show_per_page = $('#show_per_page').val();
  	
    var number_of_items = $('#content').children().size();
    var number_of_pages = Math.ceil(number_of_items/show_per_page);

    var navigation_html = '<a class="previous_link" href="javascript:previous();">«</a>';

    var current_link = 0;
	while (number_of_pages > current_link){
        navigation_html += '<a class="page_link" href="javascript:go_to_page(' + current_link +')" longdesc="' + current_link +'">'+ (current_link + 1) +'</a>';
        current_link++;
    }
    
    navigation_html += '<a class="next_link" href="javascript:next();">»</a>';

    $('#page_navigation').html(navigation_html);

    $('#page_navigation .page_link:first').addClass('active_page');

    $('#content').children().css('display', 'none');

    $('#content').children().slice(0, show_per_page).show();
    
});

function previous(){
    new_page = parseInt($('#current_page').val()) - 1;
    if($('.active_page').prev('.page_link').length==true){
        go_to_page(new_page);
    }
}

function next(){
    new_page = parseInt($('#current_page').val()) + 1;
    if($('.active_page').next('.page_link').length==true){
        go_to_page(new_page);
    }
}
function go_to_page(page_num){
    var show_per_page = parseInt($('#show_per_page').val());
    start_from = page_num * show_per_page;
    end_on = start_from + show_per_page;

    $('#content').children().css('display', 'none').slice(start_from, end_on).show();
    $('.page_link[longdesc=' + page_num +']').addClass('active_page').siblings('.active_page').removeClass('active_page');
    $('#current_page').val(page_num);
}
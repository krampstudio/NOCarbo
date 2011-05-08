/**
 * display the a message
 * @param {String} the message to display
 * @param {jQuery} page element of the current data-role = page
 */
function formMessage(message, page){
	var $saveElt = $('.message-box', page);
	if($saveElt.css('display') == 'none'){
		$saveElt.text('saved').slideToggle('slow');
		setTimeout(function(){
			$saveElt.empty().slideToggle('slow');
		}, 3000);
	}
}

/**
 * 
 */
$(document).bind("mobileinit", function(){
		
	$.mobile.ajaxFormsEnabled = false;
	
	$('#food-save').live("click tap", function(event){
		event.preventDefault();
		event.stopPropagation();
		
		$.post('/nopas/addFood', $('#food-form').serialize(), function(response){
			if(response.foodAdded == true){
				formMessage("Food saved!", $('#add-food'));
			}
		}, 'json');
		
	});
});

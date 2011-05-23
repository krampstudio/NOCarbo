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

function getToken(){
	return $('#token').val();
}

/**
 * 
 */
$(document).bind('mobileinit', function(){
		
	$.mobile.ajaxFormsEnabled = false;
	
	
	$('#add-food').live('pageshow',function(event){
		$('#search-food').autocomplete({
			source: function(request, response){
				$.ajax({
					type	: 'GET',
					url 	: '/nopas/getFood',
					dataType: 'json',
					data 	: {
						token : getToken,
						term  : request.term
					},
					success	: function(data){
						response( $.map( data, function( item ) {
							return {
								id	 : item.key.id,
								label: item.name,
								value: item.name
							}
						}));
					}
				});
			},
			minLength: 2
		});
	});


	
	$('#food-save').live("click tap", function(event){
		event.preventDefault();
		event.stopPropagation();
		
		$.post('/nopas/addFood', $('#food-form, #token-form').serialize(), function(response){
			if(response.foodAdded == true){
				formMessage("Food saved!", $('#add-food'));
			}
		}, 'json');
	});
});

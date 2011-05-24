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
							var label = item.name;
							if(item.description.length > 0){
								label += ' (';
								if(item.description.length > 30){
									label += item.description.substr(0, 27) + '...';
								}
								else{
									label += item.description;
								}
								label += ')';
							}
							
							return {
								id	 : item.key.id,
								label: label,
								value: item.name,
								brand: item.brand,
								description: item.description
							}
						}));
					}
				});
			},
			minLength: 2,
			select: function( event, ui ) {
				$('#food-id').val(ui.item.id);
				$('#food-name').val(ui.item.value);
				$('#food-description').val(ui.item.description);
				$('#food-brand').val(ui.item.brand);
			}
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

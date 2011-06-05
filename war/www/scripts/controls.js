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
	
	/*
	 * List page
	 */
	$('#list-food').live('pageshow',function(event){
		
		if($('#food-list li').length == 0){
			$.get(
				'/nopas/food', 
				$('#token-form').serialize(), 
				function(response){
					$.tmpl("<li><a href='#food-${key.id}'>${name}</a></li>", response).appendTo("#food-list");
					$('#food-list').listview('refresh');
					$('#food-list').parent('div').height(parseInt($('#food-list').height()) - 15);
				},
				'json'
			);
		}
	});
	
	/**
	 * 
	 */
	$('#search-food').live('pageshow',function(event){
		
		var pageId = '#' + $(this).attr('id');
		
		$(pageId + ' .ui-input-clear').live('click tap', function(event){
			$(pageId + ' #search-form-container').hide();
			$(pageId + ' #food-id').val('');
			$(pageId + ' #food-name').val('');
			$(pageId + ' #food-description').val('');
			$(pageId + ' #food-brand').val('');
		});
		$(pageId+ ' #food-finder').autocomplete({
			source: function(request, response){
				$.ajax({
					type	: 'GET',
					url 	: '/nopas/food',
					dataType: 'json',
					data 	: {
						token : getToken,
						term  : request.term
					},
					success	: function(data){
						$(pageId + ' #search-form-container').show();
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
				$(pageId + ' #food-id').val(ui.item.id);
				$(pageId + ' #food-name').val(ui.item.value);
				$(pageId + ' #food-description').val(ui.item.description);
				$(pageId + ' #food-brand').val(ui.item.brand);
			}
		});
	});


	
	
	$('#save-food, #search-food').live('pageshow',function(event){
	
		var pageId = '#' + $(this).attr('id');
		
		$(pageId + ' .food-save').live("click tap", function(event){
			event.preventDefault();
			event.stopPropagation();
			
			$.post('/nopas/food', $(pageId + ' .food-form, #token-form').serialize(), function(response){
				if(response.foodAdded == true){
					formMessage("Food saved!", $(pageId));
				}
			}, 'json');
		});
	});
	
	
});

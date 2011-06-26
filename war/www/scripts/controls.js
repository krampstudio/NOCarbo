/**
 * display the a message
 * @param {String} the message to display
 * @param {jQuery} page element of the current data-role = page
 */
function formMessage(message, page){
	var $saveElt = $('.message-box', page);
	if($saveElt.css('display') == 'none'){
		$saveElt.text(message).slideToggle('slow');
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
	
		$('.ui-collapsible-contain').bind("expand", function(event){
			
			refreshList($(this).find('ul.food-list').attr('id'));
		});
		$('.ui-collapsible-contain').bind("collapse", function(event){

		});
		function refreshList(listId){
			var listEltId = '#'+listId;
			
			if($(listEltId + ' li').length == 0){
				$.get(
					'/nopas/food', 
					{
						token	 : getToken,
						category : listId.replace('food-list-', '')
					}, 
					function(response){
						$.tmpl("<li><a href='#food?key=${key}'>${name}</a></li>", response).appendTo(listEltId);
						$(listEltId).listview('refresh');
						
						$(listEltId).parent('div').height(parseInt($(listEltId).height() + 30));
					},
					'json'
				);
			}
		}
	});
	
	/**
	 * search food page
	 */
	$('#search-food').live('pageshow',function(event){
		
		var pageId = '#' + $(this).attr('id');
		
		$(pageId + ' .ui-input-clear').live('click tap', function(event){
			$(pageId + ' #search-form-container').hide();
			$(pageId + ' #food-key').val('');
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
								key	 : item.key,
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
				$(pageId + ' #search-form-container').show();
				$(pageId + ' #food-key').val(ui.item.id);
				$(pageId + ' #food-name').val(ui.item.value);
				$(pageId + ' #food-description').val(ui.item.description);
				$(pageId + ' #food-brand').val(ui.item.brand);
			}
		});
	});


	
	/**
	 * Add food page
	 */
	$('#save-food, #search-food').live('pageshow',function(event){
	
		var pageId = '#' + $(this).attr('id');
		
		$(pageId + ' #food-save').live("click tap", function(event){
			event.preventDefault();
			event.stopPropagation();
			
			$.post('/nopas/food', $(pageId + ' .food-form, #token-form').serialize(), function(response){
				if(response.saved == true){
					formMessage("Food : " + response.item.name + " saved!", $(pageId));
					$(':input' , pageId + ' .food-form').val('');
					var categorySelector = $('#food-category', pageId + ' .food-form').first();
					categorySelector.selectedIndex = 0;
					categorySelector.selectmenu("refresh");
				}
			}, 'json');
			
			return false;
		});
	});
	
	
});

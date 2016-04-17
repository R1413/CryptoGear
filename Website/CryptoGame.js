jQuery(document).ready(function() {
	console.log("document ready")
	jQuery('.tabs .tab-list a').on('click', function(e){
		var currentAttrValue = jQuery(this).attr('href');

		//Show/Hide Tabs
		jQuery('.tabs ' + currentAttrValue).show().siblings().hide();
		console.log(currentAttrValue);


		//Change/remove current tab to active
		jQuery(this).parent('li').addClass('active').siblings().removeClass('active');

		e.preventDefault();
	});
});


jQuery(function($) {
	
	$('.btn').click(function(e) {
		 var url = '/retrieve';

		  //get data-id attribute of the clicked element
		    var rowId = $(this).data('row-id');  

		    console.log('rowid: ' + rowId);
		    
		    url = url + '/' + rowId;

		    $("#resultsBlock").load(url);
		
	});
});


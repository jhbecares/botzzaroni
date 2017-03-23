$(document).ready(function() {
	$('#btn-chat').click(function() {
		appendData();
	    });		
	
	$('.submit_on_enter').keydown(function(event) {
	    // enter has keyCode = 13, change it if you want to use another button
	    if (event.keyCode == 13) {
			appendData();
	      return false;
	    }
	  });
	
	function appendData() {
		var texto = $('#text').val(); 
	    $('.chat').append(
	    	'<li class="right clearfix">' +
				'<span class="chat-img pull-right">' +
					'<img src="http://placehold.it/50/FA6F57/fff&text=YO" alt="User Avatar" class="img-circle" />' +
				'</span>' +
				'<div class="chat-body clearfix">' +
					'<div class="header">' +
						'<strong class="pull-right primary-font">Bé</strong>' +
						'<small class=" text-muted"> ' +
							'<span class="glyphicon glyphicon-time"></span> Hace 15 minutos ' +
						'</small>' +
					'</div>' +
					'<p>' + texto + '</p>' +
				'</div>' +
			'</li>')
			
			$('#text').val('');
    	$(".micontainer").stop().animate({ scrollTop: $(".micontainer")[0].scrollHeight}, 1000);
	}
});

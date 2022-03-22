	$(document).ready( function() {
        $( '.listOff' ).click( function() {
          $( '.choiceLayer' ).toggle( 'slow' );
        });
        
        $('.detail88').click(function(){
        	$('.faq88 td img').css('width','30px');
        	$('.faq88 td img').css('height','30px');
        	$('.faq88').toggle();
        });
     });
/**
 * 
 */

function dropMenu_btn(){
            let click = document.getElementById("drop_content");
            if(click.style.display === "none"){
                click.style.display = "block";
 
            }else{
                click.style.display = "none";
            }
        }

/*$(window).scroll(function(){
	var scrollTop = $(document).scrollTop();
	if (scrollTop < 180) {
 		scrollTop = 180;
	}
	$("#followMenuBtn").stop();
	$("#followMenuBtn").animate( { "top" : scrollTop });
});*/ 
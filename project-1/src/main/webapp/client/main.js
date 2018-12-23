let user = {};

window.onload = function(){
	populateUser();
	$('document').ready(function(){
		// setTimeout(typedJS(),1000000);


		
	})
} 

function typedJS (){

	var typed = new Typed('#typed',{
		strings: [`Welcome back, ^400 ${user.firstName} ^600`],
		typeSpeed: 60,
		fadeOut: true,
		showCursor: false,
		onComplete: (self) => {
				$('#typed').slideUp();
				moveDiv();
		}		
		
		}
		
		);
}

function moveDiv(){
	$('#tc').slideUp();
}

function populateUser(){
// 	//send a GET request to localhost:7001/SessionMgmtDemo/session
	fetch("http://localhost:7001/project-1/session").then(function(response) {
		return response.json();
	}).then(function(data){
		//check whether there was a valid session returned
		//define behavior for no user returned 
		// if (data.session === null) {
		// 	console.log("data.session was null");
		// 	window.location = "http://localhost:7001/project-1/landing";
		// } else {
			//define behavior for user returned
            user = data;
			console.log(user);
			typedJS();
			// document.getElementById("username").innerText = "Username: "+user.username;
			// document.getElementById("firstname").innerText = "First name: "+user.firstname;
			// document.getElementById("lastname").innerText = "Last name: "+user.lastname;
			// document.getElementById("email").innerText = "Email: "+user.email;
		// }
	});
	

	
	
}
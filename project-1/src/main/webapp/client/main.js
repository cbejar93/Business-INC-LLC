let user = {};

window.onload = function(){
	populateUser();

	$('document').ready(function(){

		// setTimeout(typedJS(),1000000);
		


		
	})

}

function eid (){
	document.getElementById("eID").addEventListener('click',function(){
		let url = new URL (`http://localhost:7001/project-1/reimbursment?eid=${user.employeeID}`)
		let params = new URLSearchParams(url.search.slice(1));
		params.append("eid", user.employeeID);
		console.log(url);
		console.log("hello");
		fetch(url).then(function(response) {
			return response.json();
		}).then(function(data){
				riems = data;
				console.log(riems);
				console.log("hello2");
			
		});
	})
	// $(".eID").click(function(){
		
	// })
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
	$("#tc").slideUp();
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
			eid();

		
	});
	

	
	
}
let user = {};
let riems;
window.onload = function(){
	populateUser();
	xOut();


	$('document').ready(function(){

		// setTimeout(typedJS(),1000000);
		


		
	})

}

function getDeleter(reim) {
	return function() {
		let url = new URL("http://localhost:7001/project-1/reimbursment")
		console.log(`from inside delete ${reim}`);
		fetch(url , {
			method: 'delete',
			body: reim,
		}).catch(res);

	}
}

function deleteData(rid){
}

function hideShowButtons(){
	$("#buttondiv").toggle();
	$("#eID").toggle();
	$("#profilebutton").toggle();
}

function xOut(){
	document.getElementById("reimx").addEventListener("click",function(){
		$("#reimx").toggle();
		$("#all").toggle();
		hideShowButtons();
		console.log("hellow");

	})
}

function eid (){
	document.getElementById("eID").addEventListener('click',function(){
		let url = new URL (`http://localhost:7001/project-1/reimbursment?eid=${user.employeeID}`)
		// let params = new URLSearchParams(url.search.slice(1));
		hideShowButtons();
		$("#reimx").toggle();
		$("#all").toggle();

		// console.log(url);
		// console.log("hello");
		fetch(url).then(function(response) {
			return response.json();
		}).then(function(data){
			$("#all").find("tbody").empty();
				let riems = data;
				console.log(data);
				
				for(let i =0; i< riems.length;i++){

					let reim = riems[i]
					let row = $('#datasec').append('<tr></tr>');
					let data = 
					$(`<td scope="row">${reim.description}</td>
					<td>${reim.amount}</td>
					<td>${reim.resolved}</td>
					<td>${reim.whoResolved}</td>
					<td><button type="button" id=update-${i} class="btn btn-success">Update</button></td>
					<td><button type="button" id=delete-${i} class="btn btn-danger delete-button">Delete</button></td>
					`)
					row.append(data);
					let deleter = getDeleter(reim);
					data.find('.delete-button').click(deleter)
					// deleteData();



	
				}


				// console.log(riems);
				// console.log("hello2");

			
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
				hideShowButtons();

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
            user = data;
			console.log(user);
			typedJS();
			eid();

		
	});
	

	
	
}
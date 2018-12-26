let user = {};
let riems;
window.onload = function(){
	populateUser();
	xOut();
	xOut2();
	// submitRiem();
	


	$('document').ready(function(){

		// setTimeout(typedJS(),1000000);
		


		
	})

}


function getDeleter(reim) {
	return function() {
		let url = new URL("http://localhost:7001/project-1/reimbursment")
		console.log(`from inside delete ${reim}`);
		// fetch(url , {
		// 	method: 'delete'
		// }).catch(res);

	}
}



function deleteData(rid){
}

function hideShowButtons(){
	$("#buttondiv").toggle();
	$("#eID").toggle();
	$("#profilebutton").toggle();
	$("#resolvedbuttonA").toggle();
	$("#resolvedbuttonD").toggle();
}

function xOut2(){
	document.getElementById("proX").addEventListener("click",function(){
		$("#proX").toggle();
		$("#profile5").toggle();
		hideShowButtons();
		console.log("hellow");

	})
}

function xOut(){
	document.getElementById("reimx").addEventListener("click",function(){
		$("#reimx").toggle();
		$("#all").toggle();
		hideShowButtons();
		console.log("hellow");

	})
}

function approvedR (){
	document.getElementById("resolvedbuttonA").addEventListener('click',function(){
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

					if (reim.resolved==="APPROVED"){
					let row = $('#datasec').append('<tr></tr>');
					let data = 
					$(`<td scope="row">${reim.description}</td>
					<td>${reim.amount}</td>
					<td>${reim.resolved}</td>
					<td>${reim.whoResolved}</td>
					
					`)
					row.append(data);
					let deleter = getDeleter(reim);
					data.find('.delete-button').click(deleter)
					// deleteData();

				}



	
				}


				// console.log(riems);
				// console.log("hello2");

			
		});
	})
	// $(".eID").click(function(){
		
	// })
	} 

	function declinedR (){
		document.getElementById("resolvedbuttonD").addEventListener('click',function(){
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
	
						if (reim.resolved==="DENIED"){
						let row = $('#datasec').append('<tr></tr>');
						let data = 
						$(`<td scope="row">${reim.description}</td>
						<td>${reim.amount}</td>
						<td>${reim.resolved}</td>
						<td>${reim.whoResolved}</td>
						
						`)
						row.append(data);
						let deleter = getDeleter(reim);
						data.find('.delete-button').click(deleter)
						// deleteData();
	
					}
	
	
	
		
					}
	
	
					// console.log(riems);
					// console.log("hello2");
	
				
			});
		})
		// $(".eID").click(function(){
			
		// })
		} 


function patchUser(){
	document.getElementById("profilebutton").addEventListener("click", function(){
		hideShowButtons();
		$("#profile5").toggle();
		$("#proX").toggle();
	

		let row = `<tr><td>${user.firstName}</td><td>${user.lastName}</td><td>${user.email}</td>`
		$("#profile5").find("tbody").empty();

		$("#datasec2").append(row);

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
					if (reim.whoResolved === null){
						reim.whoResolved = "";
					}
					let data = 
					$(`<td scope="row">${reim.description}</td>
					<td>${reim.amount}</td>
					<td>${reim.resolved}</td>
					<td>${reim.whoResolved}</td>
					<td><button type="button" style="display:none"  id="update-${i}" class="btn btn-success">Update</button></td>
						<td><button type="button" style="display:none" id="delete-${i}" class="btn btn-danger delete-button">Delete</button></td>
					`)
					

					row.append(data);
					let deleter = getDeleter(reim);
					data.find('.delete-button').click(deleter)
					if (reim.resolved === "PENDING"){
						$("#update-"+i).show();
						$("#delete-"+i).show();
						console.log('inside pending');

				   }
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
			patchUser();
			approvedR();
			declinedR();

		
	});
	

	
	
}
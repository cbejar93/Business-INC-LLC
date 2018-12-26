let user = {};
window.onload = function(){
    populateUser();
    makeRiem();
    logOut();


}

function logOut(){
    $("#logout").click(function(){
        url = new URL("http://localhost:7001/project-1/logout");
        fetch(url,{method: 'GET'})
        .then(function (data) {  
            console.log('Request success: ', data);  
          })  
          .catch(function (error) {  
            console.log('Request failure: ', error);  
          });
    })
}

function makeRiem(){
$("#rsubmit").click(function(){
    console.log('hello this is the new one!!')
    let resolved = 'PENDING';
    let amount = $("#amt").val();
    let descr = $("#dsc").val();
    console.log(`${amount} from on click ${descr}`);
    url = new URL("http://localhost:7001/project-1/reimbursment")
    fetch(url, {  
        method: 'POST',   
         body: JSON.stringify({
        description: descr,
        amount: amount,
        employeeID: user.employeeID,
        resolved: resolved
      })
    })
    .then(function (data) {  
      console.log('Request success: ', data);  
    })  
    .catch(function (error) {  
      console.log('Request failure: ', error);  
    });
})
}





function populateUser(){
    // 	//send a GET request to localhost:7001/SessionMgmtDemo/session
        fetch("http://localhost:7001/project-1/session").then(function(response) {
            return response.json();
        }).then(function(data){
                user = data;
                console.log(user);
                
    
            
        });
        
    
        
        
    }
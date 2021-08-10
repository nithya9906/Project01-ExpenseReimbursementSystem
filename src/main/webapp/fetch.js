/*fetch('http://localhost:8080/Reimbursement/webapi/controller/login')
	.then(response => response.text())  // convert to json
	.then(data =>{
    console.log(data)
  })
  .catch(err => console.log('Request Failed', err)); // Catch errors*/



document.getElementById('login-btn').addEventListener('click',getUsers);
function getUsers(){
  fetch('http://localhost:8080/Reimbursement/webapi/controller/login')
.then(response=>response.text())
.then(data=>{
  console.log("success")
})
.catch(err=>console.log('Request Failed',err))

}




  
/*	fetch('http://localhost:8080/Reimbursement/webapi/controller/login')
	.then(response => response.json())  // convert to json
	.then(json => populateData(json))
  .catch(err => console.log('Request Failed', err)); // Catch errors
function populateData(response) {
   
	var data1=response;
    for (var d1 of data1){
      var dataList=document.createElement("li");
      dataList.innerHTML=d1.empid+" "+d1.first_name+" "+d1.last_name;
      dataSection.append(dataList);
    }
   
}*/









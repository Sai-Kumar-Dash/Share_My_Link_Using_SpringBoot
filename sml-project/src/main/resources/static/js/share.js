// SEND LINK

async function sendLink(){

let link = document.getElementById("link").value;

let response = await fetch("/api/send",{

method:"POST",

headers:{
"Content-Type":"application/json"
},

body:JSON.stringify({link:link})

});

let code = await response.text();

document.getElementById("code").innerText = "Code: " + code;

}



// RECEIVE LINK

async function getLink(){

let code = document.getElementById("code").value;

let response = await fetch("/api/receive/" + code);

let link = await response.text();

document.getElementById("result").innerHTML =
'<a href="'+link+'" target="_blank">'+link+'</a>';

}
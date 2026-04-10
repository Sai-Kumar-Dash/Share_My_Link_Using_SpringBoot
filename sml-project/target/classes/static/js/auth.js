async function signup(){

let name = document.getElementById("name").value;
let email = document.getElementById("email").value;
let password = document.getElementById("password").value;

await fetch("/api/signup",{
method:"POST",
headers:{"Content-Type":"application/json"},
body:JSON.stringify({name,email,password})
});

alert("Account Created");
window.location="signin.html";
}


async function login(){

let email=document.getElementById("email").value;
let password=document.getElementById("password").value;

let res=await fetch("/api/login",{
method:"POST",
headers:{"Content-Type":"application/json"},
body:JSON.stringify({email,password})
});

let user = await res.json();

if(user){

localStorage.setItem("loggedIn","true");
localStorage.setItem("username", user.name);
localStorage.setItem("userId", user.id);

window.location="dashboard.html";

}else{
alert("Invalid credentials");
}
}


function checkLogin(){
if(localStorage.getItem("loggedIn") !== "true"){
window.location="signin.html";
}
}


function showUser(){
let name = localStorage.getItem("username");
document.getElementById("userDisplay").innerText =
name ? "👤 " + name : "👤 User";
}


function logout(){
localStorage.clear();
window.location="signin.html";
}
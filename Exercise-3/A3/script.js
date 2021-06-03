function myFunction() 
{
	alert("Registered successfully!");
	return true;
}

function na()
{
//radio button salutation
var radios = document.getElementsByName("salutation");
var formValid = false;
var i = 0;
while (!formValid && i < radios.length) 
{
	if (radios[i].checked) 
		formValid = true;
	i++;        
}
if (!formValid) 
  document.getElementById("n").innerHTML="Fill out the previous fields first";
}

function usr()
{
	//name
  document.getElementById("n").innerHTML="";
	var x = document.getElementById("fname").value;
    var regex=/^[A-Z]\s[a-zA-Z]+\s?[a-zA-Z]*$/;
    if(x=="")
    	document.getElementById("u").innerHTML="Fill out the previous fields first";
	else if(regex.test(x) == false)
	  document.getElementById("n").innerHTML="Wrong format of name";
}

function password()
{
//username
document.getElementById("u").innerHTML="";
var x = document.getElementById("user").value;
var regex=/^[A-Za-z]*$/;
if(x=="")
    	document.getElementById("p").innerHTML="Fill out the previous fields first";
	else if(regex.test(x) == false)
	  document.getElementById("u").innerHTML="Wrong format of username";
}

function email()
{
document.getElementById("p").innerHTML="";
//password
var x = document.getElementById("pw").value;
var regex=/^(?=.*[a-z])(?=.*[A-Z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
if(x=="")
    	document.getElementById("e").innerHTML="Fill out the previous fields first";
else if(regex.test(x) == false)
	  document.getElementById("p").innerHTML="Wrong format of password";
}


function dt_b()
{
//email
document.getElementById("e").innerHTML="";
var x = document.getElementById("em").value;
var regex=/^.+@.+\.(org|net|com|in)$/;
if(x=="")
    	document.getElementById("birth").innerHTML="Fill out the previous fields first";
else if(regex.test(x) == false)
	  document.getElementById("e").innerHTML="Wrong format of email ID";
}

function sel_img()
{
//dob
document.getElementById("birth").innerHTML="";
var dob = new Date(document.getElementById("dob").value); 
var yr = new Date(Date.now());
var diff=yr.getFullYear()-dob.getFullYear();
if( diff<18 || diff>35 )
	{
	document.getElementById("birth").innerHTML="Age should be between 18 and 35";
	}
}

function additional()
{
//languages known
var checks = document.getElementsByName("lk");
var i = 0;
var count=0;
while (i < checks.length) 
{
	if (checks[i].checked) 
		count++;
	i++;        
}
if(count<2)
{
  document.getElementById("l").innerHTML="select atleast 2 languages";
}
else
  document.getElementById("l").innerHTML="";
}


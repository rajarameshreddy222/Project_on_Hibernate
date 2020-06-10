<html>
<head>


  <style >
 
 <%@ include file="css/style.css"%> 
 </style>



<script>

function  validate()
{
	var uname=document.form1.t1.value;
	var pwd=document.form1.t2.value;
	var log=document.form1.t3;
	
	if(uname=="")
		{
		alert("Please Enter Username : ");
		document.form1.t1.focus();
		return false;
		}
	  
	if((uname.length<5) || (uname.length>40))
		{
		alert("Username should contains 5-15 characters only");
		document.form1.t1.select();
		return false;
		}
	
	
	
	if(pwd=="")
	{
	alert("Please Enter Password : ");
	document.form1.t2.focus();
	return false;
	}

	if(!log[0].checked&&!log[1].checked) 
		
		
		{
		alert("please select any one employee or customer:");
		document.form1.t3.focus();
		return false;
		
		}
	
	
	
	
}


</script>
</head>
<body>
<center>  <br><br><table><tr><td>
<div class=login>
<center>
<h1><u>ForgotPassword</u></h1>

<table  border=0 cellpadding=10   color=black >
<form  action="reqforgot"    name="form1"  method="post"  onsubmit="return validate();"     >


<tr></td><td><b><input type=text size=40% name="t1" placeholder="User Id" ></b></td>


<tr><td><b><input type=password size="40%" name="t2"placeholder="Password" > </b></td>

<tr><center><td>Employee<input type=radio value="reqempreg" name="t3">Customer<input type=radio  value="reqcusreg" name="t3"></td></center></tr>

<tr><td><h3><center> <button size=30%><b>UpdatePassword</b></button></center></h3>

<tr><td><h3><center>Click here to go <a href="login" >LoginPage</h3></a></center>

</td></h1>

</form> </table>

</center>



</div></td></tr></table></center>


</body>
</html>
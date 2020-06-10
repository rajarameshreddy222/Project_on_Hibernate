<html>
<head>

<style>
     <%@ include file="css/style.css"%>
</style>


<script>

</script>
</head>

<body>
<center><table><tr><td>
<div class=reg>
<center><br>
<h1><u><b>Registeration From</b></u></h1>
</center><center>
<table><tr><td>

<center>


<table  border=0 cellpadding=10  color=black bgcolor=white>
<form action="reqreg"     name="form1"   onsubmit="return validate();"    method="post"  enctype="multipart/form-data"><b>
<tr> <td><b>Name</b></td> <td><input type=text size="50%" name="t1" placeholder="Name" >  </td></tr>

<tr> <td><b>Password</b></td> <td><input type=text size="50%" name="t2" placeholder="Password" >  </td></tr>

<tr> <td><b>Email</b></td> <td><input type=text size="50%"name="t3"placeholder="Email" >   </td></tr>

<tr> <td><b>Mobile</b></td> <td><input type=text size="50%"name="t4" placeholder="mobile">   </td></tr>

<tr> <td><b>City</b></td> <td><input type=text size="50%" name="t5"placeholder="city" >   </td></tr>

<tr> <td><b>Profile pic</b></td> <td><input type=file size="40%"name="t6"placeholder="Profile Pic" >   </td></tr>

<tr><td colspan="2"><center><b>Employee</b><input type=radio value="reqempreg" name="t7"><b>Customer</b><input type=radio  value="reqcusreg" name="t7"></center></td></tr>



<tr><td colspan="2"><center><button><b>Register</b></button></center></td></tr>

</b></form></table>

<center><h2>Click here to go<a href=login1> Login</a>
</div></td></tr></table>
</center>
</body>




































</html>





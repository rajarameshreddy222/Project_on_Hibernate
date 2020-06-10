


<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>

<body >

<%@page import="java.util.*" %>
<%@page import="model.User" %>
<%@page import="java.io.*" %>



 <%
 
User u=new User();
u=(User)request.getAttribute("User");
File arr[]=(File[])request.getAttribute("filenames");




for(File f:arr)
{
	
if(u.getFname().equals(f.getName()))
{
 out.print(" <center> <br><br><table border=1 cellpadding=10  bgcolor=white>");
  
out.print("<tr><td rowspan=7 ><center><img src='"+f+"' height=200 width=200> </td>");

out.print(" <tr><td>  <b> name:"+u.getName()+" <tr><td> <b> pwd:"+u.getPwd()+" <tr><td>  <b> Email:"+u.getEmail()+" <tr><td>  <b>Mobile:"+u.getMobile()+"<tr><td> <b>City:"+u.getCity()+" ");                                                          
}}
out.print("</center> <tr><td colspan=2><center>Click <a href=emphome>Home</a> to go back");

%>

</body>



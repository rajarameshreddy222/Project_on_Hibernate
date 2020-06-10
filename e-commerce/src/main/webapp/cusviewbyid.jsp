


<head><style >    <%@ include file="css/style.css"%></style></head>

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
 out.print("<center> <br><br><br><table border=0 cellpadding=10  bgcolor=white>");
 out.print("</center> <tr><td colspan=2><center><b> ProfileSettings"); 
out.print("<tr><td rowspan=8 ><center><img src='"+f+"' height=200 width=200> </td>");

out.print(" <tr><td>  <b> name:"+u.getName()+" <tr><td> <b> pwd:"+u.getPwd()+" <tr><td>  <b> Email:"+u.getEmail()+" <tr><td>  <b>Mobile:"+u.getMobile()+"<tr><td> <b>City:"+u.getCity()+"<tr><td><center><a href=updatefrom?name="+u.getEmail()+">Update</a> ");                                                          
}}
out.print("</center> <tr><td colspan=2><center>Click <a href=cushome>Home</a> to go back");

%>

</body>



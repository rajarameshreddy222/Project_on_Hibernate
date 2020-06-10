


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
	
	 
	
	
out.print("<center> <br><br><br><form action=requpdate method=post> <table border=2 cellpadding=10  bgcolor=white>");
out.print("</center> <tr><td colspan=3><center><b> ProfileSettings"); 


out.print("<tr><td rowspan=6 ><img src='"+f+"' height=200 width=200 name=t1><br> <input type=file name=t1 > </td>");

out.print(" <tr><td> Username:<td><input type=text value="+u.getName()+" name=t2>");
out.print(" <tr><td> Password:<td><input type=text value="+u.getPwd()+"  name=t3>");
out.print(" <tr><td> Email:<td><input   type=text readonly  value="+u.getEmail()+" name=t4>");
out.print(" <tr><td> Mobile:<td><input type=text   value="+u.getMobile()+" name=t5>");
out.print(" <tr><td> City:<td><input type=text     value="+u.getCity()+"     name=t6>");

out.print(" <tr><td colspan=3> <center><button>Update ");



}}
out.print("</center> <tr><td colspan=3><center>Click <a href=cushome>Home</a> to go back</from>");

%>

</body>



<head>



<link rel="stylesheet" type="text/css" href="css/style.css">


</head>


<body >
<%@page import="model.Product" %>
<%
Product p=new Product();
p=(Product)request.getAttribute("productinfo");  // object--> product

String filename=request.getAttribute("filename").toString();

%>
<center><br>
<br>
<table border=2><tr><td>
<center>
<table>
<div class="img">
<tr><td><center>
<% 
out.print("<img src='"+filename+"' height=200 width=200>");
%>
</div>

<div class="pinfo">

<tr><td><center><h3><b>Product Name:<% out.print(p.getPname());%>
<tr><td><center><h3><b>Product Price: <%out.print( p.getPprice());%>
<tr><td><center><h3><b>Product Details: <%out.print( p.getPinfo());%>

<tr><td><center><h3><b>
<%
out.print("<a href=addtocart1?pid="+p.getPid()+">Add To Cart</a>");

%></center></td>

</div>
</table>
</center>
</td></tr></table>
</body>
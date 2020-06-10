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

<form action=addtocart11>
<% out.print("<input type=hidden value='"+p.getFilename()+"'name=pimg"); %> %>
<% out.print("<input type=hidden value='"+p.getPname()+"'name=pname>"); %>
<% out.print("<input type=hidden value='"+p.getPprice()+"'name=pprice>"); %>
<% out.print("<input type=hidden value='"+p.getPid()+"'name=pid>"); %>

<tr><td><center><h3><b>Select Quantity</b>
<select name="pqty">
<option>1</option>
<option>2</option>
<option>3</option>
<option>4</option>
<option>5</option>
<tr><td><h3><b>


<button>Add To Cart</button></b></form><a href=reqviewkart><button>View Cart</button></a> <br>
<center><h3>Click <a href=cushome>Continue</a> to shop </h3><br></center>





<%
if(request.getAttribute("msg")!=null){
out.print(request.getAttribute("msg"));}
%></center></td>

</div>
</table>
</center>
</td></tr></table>
</body>
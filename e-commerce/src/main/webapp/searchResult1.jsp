<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<style>


<%@ include file="css/style.css"%> 

</style>
</head>
<body>
<%@page import="java.util.*" %>
<%@page import="model.Product" %>
<%@page import="java.io.*" %>
    <div class="hdr">
    <ul>
    <li>    <a href="reqsorting?value=lh">Price Low-High</a></li>
   <li> <a href="reqsorting?value=hl">Price High-Low</a></li>
    </ul>
    </div>
<%
ArrayList<Product> al=new ArrayList<Product>();
  al=(ArrayList<Product>)request.getAttribute("products");  // h2 database
    File arr[]=(File[])request.getAttribute("filenames");     // from cloud folder
  out.print("<div class=row>");
     
    for(Product p:al)
  {
	  for(File f: arr)
	  {
			 if(p.getFilename().equals(f.getName()))
		{
				
			 out.print("<div class=column>"); 
			 out.print("<div class=content>"); 
			out.print("<table border=1 ><tr><td><a href=reqaddtocart1?pid="+p.getPid()+"><center><img src='"+f+"' height=150 width=150>");
			out.print("<br>Prodcut Name : "+p.getPname()+" <br> Product Price: "+p.getPprice()+"<br>");
      	out.print("<a href=reqaddtocart1?pid="+p.getPid()+">Add Cart</a>");
				  out.print("</td></tr></table></div></div>");		     
		} 
	    
  }  }
  out.print("</div>");
  
 
%>
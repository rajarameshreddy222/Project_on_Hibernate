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
   
<%
ArrayList<Product> al=new ArrayList<Product>();
  al=(ArrayList<Product>)request.getAttribute("products"); 
  
  
 Product p1=new Product();
  
  
  
    File arr[]=(File[])request.getAttribute("filenames");     
  out.print("<div class=row>");
   
  
 
  out.print("<br><br><center><table border=1 cellpadding=10 ><tr><td>productimage<td>productname<td>pprice<td>quantity<td>totalprice");
    for(Product p:al)
  {
	  for(File f: arr)
	  {
			 if(p.getFilename().equals(f.getName()))
		{
				 
		out.print("<tr><td><center><img src="+f+" height=150 width=150>");
				
		//	out.print("<td>"+p.getPname()+"<td>"+p.getPprice()+"<td>"+p.getPqty()+"<td>"+p.getTprice()+"  ");	
				

		    
		} 
	    
  }  }
    
    
    
    
    if(request.getAttribute("msg1")!=null && request.getAttribute("msg2")!=null){
    out.print("</table> <table border=1><tr><td>Total items<td>Total Amount");
    out.print("<tr><td><b>"+request.getAttribute("msg1")+"<td><b>"+request.getAttribute("msg2")+"");
    out.print("<tr><td colspan=2><center> <form action=reqbill> <b>"+request.getAttribute("msg2")+"<button>PlaceOrder<b>");}
    
out.print("</div>");
  
 
%>
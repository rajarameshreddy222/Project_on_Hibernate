
<head>


 
 <style >
 
 <%@ include file="css/style.css"%> 
 </style>
</head>

<body>


<form action="reqaddproductdata" method=post enctype="multipart/form-data"><br><center>
<table border=0 cellpading=1px bgcolor=white>
<tr><td>Product Id:</td><td> <input type=text size=37% name="pid">
<tr><td>Product Name: </td><td><input type=text size=37%  name="pname">
<tr><td>Product price: </td><td><input type=text size=37% name="pprice">
<tr><td>Product Quantity: </td><td><input type=text size=37%  name="pqty">
<tr><td>Upload Product: </td><td><input type=file   name="img">

<tr><td>CType </td><td>
<select name="ctype">
<option>Select </option>
<option>Electronics</option>
<option>Home & Furniture</option>
<option>Sports </option>
<option>Grocery</option>

</select></td><td>
<tr><td>Product info:</td><td> <textarea rows=5 cols=20 name="productinfo"></textarea></td></tr>
<tr><td colspan="2"><center><button>AddProduct</button></center></td>
<tr><td colspan="2"><center>Click <a href=emphome>Home</a> to go back
</table>
</form>


</body>
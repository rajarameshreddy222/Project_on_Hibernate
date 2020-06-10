<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<style>
body
{
	background-color:E3D9BE;
}
div.headder
{
	background-color:7FF4B2;
	height:100px;

}
ul
{
	list-style:none;
	text-align:right;
}
li
{
	display:inline;
     font-color:white;
}
input[type=text]
{
	width:800px;
	height:60px;
	border-radius:15px;
}
input[type=submit]
{
	width:90px;
	height:60px;
	border-radius:15px;
}

input[type="button"]
{
width:120px;
height:60px;
border-radius:15px;
}
img
{
	border-radius:5px;
	border:2px solid green;
	
}
.column {
  float: left;
  width: 23%;
  padding: 5px;
 
 
 
}
.content
{
	 background-color:white;
	float:right;
	
}
a
{
	text-decoration: none;
}
.btn {
  background-color: DodgerBlue;
  border: none;
  color: white;
  padding: 12px 16px;
  font-size: 16px;
  cursor: pointer;
}
div.hdr
{
	background-color: yellow;
	height:80px;

  
}
ul.left_menu{
width:196px;
padding:0px;
margin:0px;
list-style:none;
}

ul.left_menu li{
margin:0px;
list-style:none;
}

ul.left_menu li.odd a{
width:166px;height:25px;display:block;background:url(images/checked.png) no-repeat left #dad0d0; background-position:5px 5px;border-bottom:1px #FFFFFF solid;
text-decoration:none;color:#504b4b;padding:0 0 0 30px; line-height:25px;
}
ul.left_menu li.even a{
width:166px;height:25px;display:block;background:url(images/checked.png) no-repeat left #eee6e6;background-position:5px 5px;border-bottom:1px #FFFFFF solid;
text-decoration:none;color:#504b4b;padding:0 0 0 30px; line-height:25px;
}
ul.left_menu li.even a:hover, ul.left_menu li.odd a:hover{
background:url(images/checked.png) no-repeat left #7bbcc7; color:#FFFFFF;background-position:5px 5px;
}


</style>
</head>
<body>
<center>
<!--  <a href="admin"><img src="adminlogo.jpg"></a> -->
<h2>
<a href="admin"">Admin</a>
<a href="login1"><b>   Signin   </b></a>      <a href="reg">   <b> Signup  </b> </a>
</h2>
<br>

<div class=d2><form action="reqsearchproduct" method=post >
 <center><input type=text name="t1" placeholder=" ex:mi,apple,dell"> 
<input type=submit value=Search> </center></form></div>

</center>

      <div class="title_box">Categories</div>
      <ul class="left_menu">
        <li class="odd"><a href="#">Item 1</a></li>
        <li class="even"><a href="#">Item 1</a></li>
        <li class="odd"><a href="#">Item 1</a></li>
        <li class="even"><a href="#">Item 1</a></li>
        <li class="odd"><a href="#">Item 1</a></li>
        <li class="even"><a href="#">Item 1</a></li>
        <li class="odd"><a href="#">Item 1</a></li>
        <li class="even"><a href="#">Item 1</a></li>
        <li class="odd"><a href="#">Item 1</a></li>
        <li class="even"><a href="#">Item 1</a></li>
        <li class="odd"><a href="#">Item 1</a></li>
        <li class="even"><a href="#">Item 1</a></li>
      </ul>
      </div>
      </body>
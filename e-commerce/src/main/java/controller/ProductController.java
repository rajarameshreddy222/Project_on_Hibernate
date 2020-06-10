package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;
import java.io.*;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import dao.Daoimple;
import model.Orders;
import model.Product;

@WebServlet(urlPatterns= {"/reqaddproduct","/reqaddproductdata","/reqsearchproduct","/reqsearchproduct1","/reqaddtocart","/reqaddtocart1","/addtocart11","/reqsorting","/reqviewkart","/reqbill","/myorders"})
public class ProductController extends HttpServlet  
{

	Daoimple obj;
	public void init() throws ServletException
	{
		super.init();
		obj=new Daoimple();
		
	}

	
	private final String  upload_dir="D://cloud1";
    
	
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{ 
		 Product p=new Product();
		
		String path=req.getServletPath();
		PrintWriter out=res.getWriter();
		 ArrayList<Product> al=new ArrayList<Product>();
		 
		 if(path.equals("/reqaddproduct"))
		{
		  RequestDispatcher rd=req.getRequestDispatcher("addproduct.jsp");
		  rd.forward(req, res);
		}
		 
		
		 
		
		 else if(path.equals("/reqsorting"))
			{
				
				
				String value=req.getParameter("value");  //lh or hl
				HttpSession session=req.getSession();
		        p.setPname(session.getAttribute("search").toString());
		        
		  	
		          al=obj.searchProduct(p,value);
		          req.setAttribute("products",al);  
		          
		        
		      	if(al!=null)
				{   File f=new File("D://cloud1");
					File arr[]=f.listFiles();
					req.setAttribute("filenames", arr);
					RequestDispatcher rd=req.getRequestDispatcher("searchResult1.jsp");
					rd.forward(req,res);
					
				}
				else
				{
					RequestDispatcher rd=req.getRequestDispatcher("searchResult1.jsp");
					rd.forward(req,res);
				  	
				}
			}
			else if(path.equals("/reqaddtocart"))
			{
			   
			   Product p1=new Product();
			   p1.setPid(req.getParameter("pid"));
			
			   p1=obj.productInfoByPid(p1);
			   req.setAttribute("productinfo", p1);
			   File f=new File("D://cloud1");
				File arr[]=f.listFiles();
				
				for(File f1:arr)
				{
				
					if(p1.getFilename().equals(f1.getName()))
							{
						
						          req.setAttribute("filename", f1);
						       RequestDispatcher rd=req.getRequestDispatcher("AddToCart.jsp");
						       rd.forward(req, res);
							}
				}
			}
			
		 
		 
		 
			else if(path.equals("/addtocart1"))   // it will be executed when you click on add to cart
			{
				
				Product p1=new Product();
				p1.setPid(req.getParameter("pid"));
				
				HttpSession session=req.getSession();
				String clogin=(String)session.getAttribute("clogin");
				if(clogin==null)
				{
					RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
					rd.forward(req, res);
				}
				else
				{
					obj.addTOCart(p);
				}
				
				
			}
			else if(path.equals("/reqaddtocart1"))
			{
				
			   Product p1=new Product();
			   p1.setPid(req.getParameter("pid"));
			  
			  
			   p1=obj.productInfoByPid(p1);
			   req.setAttribute("productinfo", p1);
			   File f=new File("D://cloud1");
				File arr[]=f.listFiles();
				
				for(File f1:arr)
				{
				
					if(p1.getFilename().equals(f1.getName()))
							{
						
						          req.setAttribute("filename", f1);
						       RequestDispatcher rd=req.getRequestDispatcher("AddToCart1.jsp");
						       rd.forward(req, res);
							}
				}
			}
		 
			else if(path.equals("/addtocart11"))
			{
				
				
			   HttpSession session=req.getSession();
			   String name=session.getAttribute("name").toString(); 
			    
			   p.setFilename(req.getParameter("pimg"));
			    p.setPname(req.getParameter("pname"));
				p.setPprice(Double.parseDouble(req.getParameter("pprice")));
				p.setPid(req.getParameter("pid"));
				
			   
			 
			    p=obj.productInfoByPid(p);
			    p.setPqty(Integer.parseInt(req.getParameter("pqty")));
				boolean b=obj.addproducttocart(p,name);
				
				if(b)
				{
				req.setAttribute("msg", "product add to cart successfully");
				RequestDispatcher rd=req.getRequestDispatcher("reqaddtocart1");
				rd.forward(req, res);
				
			    }
				else
				{
					out.print("not done ");
				}
				
				
			}
		 
			else if(path.equals("/reqviewkart"))
			{
				   HttpSession session=req.getSession();
				   String name=session.getAttribute("name").toString(); 
				  
				   
					al=obj.viewproductfromcart(name);
					req.setAttribute("products", al);
					
					Orders o=obj.sumoftotal(name);
					
					req.setAttribute("msg1", o.getCount());
					req.setAttribute("msg2", o.getSumoftotal());
					if(al!=null)
					{
					File f=new File("D://cloud1");
					File arr[]=f.listFiles();
					req.setAttribute("filenames", arr);
					RequestDispatcher rd=req.getRequestDispatcher("viewcart.jsp");
					rd.forward(req,res);
					
					}				
		   }
			
			
			
			
			else if(path.equals("/reqbill"))
			{
				HttpSession session=req.getSession();
				String name=session.getAttribute("name").toString();
				   
					boolean b=obj.addproducttocart1(p,name);
					if(b)
					{
						out.println("<br> <br> <center> Our Order as been placed Successfully");
						out.println("<br>Click <a href=cushome>Continue</a> to shop ");
					}
				
				
			}
			else if(path.equals("/myorders"))
			{
				 HttpSession session=req.getSession();
				   String name=session.getAttribute("name").toString(); 
				  
				   
					al=obj.viewproductfromMyOrders(name);
					req.setAttribute("products", al);
					
					
					if(al!=null)
					{
					File f=new File("D://cloud1");
					File arr[]=f.listFiles();
					req.setAttribute("filenames", arr);
					RequestDispatcher rd=req.getRequestDispatcher("viewcart.jsp");
					rd.forward(req,res);
					}
				
			}
		 
		
				
 }
		
		
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{ 
	 
	    Product p=new Product();
		
		String path=req.getServletPath();
		PrintWriter out=res.getWriter();
		 ArrayList<Product> al=new ArrayList<Product>();
		  if(path.equals("/reqaddproductdata"))
		{
			 boolean b=false;  
	    	  
			 if(ServletFileUpload.isMultipartContent(req))
		 		{
		 	        try {
		                 List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(req);
		                       
		                 for(FileItem item : multiparts)
		                 {

		                     if(!item.isFormField())
		                     {
		                         String name = new File(item.getName()).getName();
		                         item.write( new File(upload_dir + File.separator + name));
		                         p.setFilename(name);
		                     }
		                     else
		                     {
		                     	if(item.getFieldName().equals("pid"))
		                     	{
		                     		p.setPid(item.getString());
		                     	}
		                     	else if(item.getFieldName().equals("pname"))
		                     	{
		                             p.setPname(item.getString());
		                     	}
		                     	else if(item.getFieldName().equals("pprice"))
		                     	{
		                     		p.setPprice(Double.parseDouble(item.getString()));
		                     	}
		                    	else if(item.getFieldName().equals("pqty"))
		                     	{
		                     		p.setPqty(Integer.parseInt(item.getString()));
		                     	}
		                    	else if(item.getFieldName().equals("tdate"))
		                     	{
		                     		p.setTdate(item.getString());
		                     	}
		                    	else if(item.getFieldName().equals("ctype"))
		                     	{
		                     		p.setCtype(item.getString());
		                     	}
		                    	else if(item.getFieldName().equals("productinfo"))
		                     	{
		                     		p.setPinfo(item.getString());
		                     	}
		                     }
		                 }
		                 
		              b=obj.addProduct(p); 
		              if(b)
		              {
		            	  RequestDispatcher rd=req.getRequestDispatcher("addproduct.jsp");
		            	  rd.include(req, res);
		            	 
		              }
		                 
		             } 
		 	        catch (Exception ex)
		 	        {
		                System.out.println(ex);
		             } 
		 		}
			
		}
		  else if(path.equals("/reqsearchproduct"))
			{
				String product=req.getParameter("t1");
				
				p.setPname(product);
			    al=obj.searchProduct(p);
				req.setAttribute("products", al); 
				HttpSession session=req.getSession();
				session.setAttribute("search",p.getPname());
				
				
				
				if(al!=null)
				{   File f=new File("D://cloud1");
					File arr[]=f.listFiles();
					req.setAttribute("filenames", arr);
					RequestDispatcher rd=req.getRequestDispatcher("searchResult.jsp");
					rd.forward(req,res);
					
				}
				else
				{
					RequestDispatcher rd=req.getRequestDispatcher("searchResult.jsp");
					rd.forward(req,res);
				  	
				}
		
			}
		  else if(path.equals("/reqsearchproduct1"))
			{
				String product=req.getParameter("t1");
				
				p.setPname(product);
			    al=obj.searchProduct(p);
				req.setAttribute("products", al);
				
				HttpSession session=req.getSession();
				session.setAttribute("search",p.getPname());
				
			
				if(al!=null)
				{   File f=new File("D://cloud1");
					File arr[]=f.listFiles();
					req.setAttribute("filenames", arr);
					RequestDispatcher rd=req.getRequestDispatcher("searchResult1.jsp");
					rd.forward(req,res);
					
				}
				else
				{
					RequestDispatcher rd=req.getRequestDispatcher("searchResult1.jsp");
					rd.forward(req,res);
				  	
				}
		
			}
				
	
	}
	
	
}

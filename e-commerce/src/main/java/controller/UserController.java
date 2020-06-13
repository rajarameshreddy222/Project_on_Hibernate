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
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.Dao;
import dao.Daoimple;
import model.Product;
import model.User;



@WebServlet(urlPatterns= {"/index","/reg","/login1","/admin","/forgot","/cushome","/emphome","/reqreg","/reqlogin","/reqforgot","/reqcusviewbyid","/reqempviewbyid","/reqadminlogin","/updatefrom","/requpdate"})
public class UserController extends HttpServlet
{
	
	Daoimple obj ;
	public void init() throws ServletException 
	{
		super.init();
		obj=new Daoimple();
	}
	
	private final String  upload_dir="D://cloud" ;
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{ 
	    User u=new User();
	   
	    Product p=new Product();
		
		String path=req.getServletPath();
		PrintWriter out=res.getWriter();
		if(path.equals("/index"))
		{
		  RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
		  rd.forward(req, res);
		}
		else if(path.equals("/login1"))
		{
		  RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
		  rd.forward(req, res);
		}
		else if(path.equals("/reg"))
		{
		  RequestDispatcher rd=req.getRequestDispatcher("register.jsp");
		  rd.forward(req, res);
		}
		else if(path.equals("/admin"))
		{
		  RequestDispatcher rd=req.getRequestDispatcher("admin.jsp");
		  rd.forward(req, res);
		}
		else if(path.equals("/forgot"))
		{
		  RequestDispatcher rd=req.getRequestDispatcher("forgot.jsp");
		  rd.forward(req, res);
		}
		else if(path.equals("/cushome"))
		{
		  RequestDispatcher rd=req.getRequestDispatcher("customerhome.jsp");
		  rd.forward(req, res);
		}
		else if(path.equals("/emphome"))
		{
		  RequestDispatcher rd=req.getRequestDispatcher("employehomepage.jsp");
		  rd.forward(req, res);
		}
		
		
		
		
		else if(path.equals("/reqcusviewbyid"))   
		{
			   HttpSession session=req.getSession();
		      u.setEmail(session.getAttribute("name").toString());
	          u=obj.cusviewbyid(u);
	           req.setAttribute("User", u);
		       File f=new File("D://cloud");
			   File arr[]=f.listFiles();
			req.setAttribute("filenames",arr);
			   
			   RequestDispatcher rd=req.getRequestDispatcher("cusviewbyid.jsp");
				rd.forward(req, res);
	   
		}
		
		else if(path.equals("/reqempviewbyid"))   
		{
			   HttpSession session=req.getSession();
			   u.setEmail(session.getAttribute("name").toString());
		      
		       u=obj.empviewbyid(u);
	           req.setAttribute("User", u);
		
		 
			   File f=new File("D://cloud");
			   File arr[]=f.listFiles();
			
			   req.setAttribute("filenames",arr);
			   RequestDispatcher rd=req.getRequestDispatcher("cusviewbyid.jsp");
				rd.forward(req, res);
	   
		}
		 else if(path.equals("/updatefrom"))
			{
			 
			
			 u.setEmail(req.getParameter("name"));
		
			 u=obj.cusviewbyid(u);
	           req.setAttribute("User", u);
	       
		  
			   File f=new File("D://cloud");
			   File arr[]=f.listFiles();
			
			   req.setAttribute("filenames",arr);
			   RequestDispatcher rd=req.getRequestDispatcher("updatefrom.jsp");
				rd.forward(req, res);
			}
		
	}

		
	
	
	
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
	{ 
	    User u=new User();
	    Product p=new Product();
		
		String path=req.getServletPath();
		PrintWriter out=res.getWriter();
		
		 if(path.equals("/reqreg"))
		{ 
			
			if (ServletFileUpload.isMultipartContent(req))
			{
				boolean b=false;
				try
				{
					List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(req); 
					
					for(FileItem item : multiparts)
	                {
	                    if(!item.isFormField())
	                    {
	                        String name = new File(item.getName()).getName();
	                        item.write( new File(upload_dir + File.separator + name));
	                      u.setFname(name);
	                    }
	                    else
	                    {
	              
	                    	if(item.getFieldName().equals("t1"))
	                    	{
	                    		u.setName(item.getString());
	                    	}
	                    	else if(item.getFieldName().equals("t2"))
	                    	{
	                    		u.setPwd(item.getString());
	                    	}
	                    	else if(item.getFieldName().equals("t3"))
	                    	{
	                    		u.setEmail(item.getString());
	                    	}
	                    	else if(item.getFieldName().equals("t4"))
	                    	{
	                    		u.setMobile(Long.parseLong(item.getString()));
	                    	}
	                    	else if(item.getFieldName().equals("t5"))
	                    	{
	                    		u.setCity(item.getString());
	                    	}
	                      else if(item.getFieldName().equals("t7"))
	                    	{
	                    		u.setUtype(item.getString());
	                    	}
	                    	
	                    	
	                     }
	                  }
					
					
					if(u.getUtype().equals("reqempreg" ))
					{
						
						b=obj.register(u);
						if(b)
						{ 
						RequestDispatcher rd=req.getRequestDispatcher("register.jsp");
					       rd.forward(req, res);
						    out.print("Registered done  successfully");
						}
						else
						{
							RequestDispatcher rd=req.getRequestDispatcher("register.jsp");
					        rd.forward(req, res); 
						    out.print("Registered  not done  ");
						}	
					}
					
					else	if(u.getUtype().equals("reqcusreg" ))
					{
					
						b=obj.register(u);
						if(b)
						   { 
							RequestDispatcher rd=req.getRequestDispatcher("register.jsp");
						       rd.forward(req, res);
							    out.print("Registered done  successfully");
							}
							else
							{
								RequestDispatcher rd=req.getRequestDispatcher("register.jsp");
						        rd.forward(req, res); 
							    out.print("Registered  not done  ");
							}		
					}
			   }
	                    
				catch(Exception e)
				{System.out.println(e);}
          }
		}
			
	    else if(path.equals("/reqlogin"))
		{
			u.setEmail(req.getParameter("t1")); 
			u.setPwd(req.getParameter("t2"));
		    u.setUtype(req.getParameter("t3"));
		   
		    if(u.getUtype().equals("reqemplogin"))
			{
				boolean b=false;
				b=obj.login(u);
				if(b)
				{ 
					HttpSession session=req.getSession();
					session.setAttribute("name",u.getEmail());
					

					RequestDispatcher rd=req.getRequestDispatcher("employehomepage.jsp");
					  rd.forward(req, res);

				}
				else
				{
					out.print(" not done ");
				}
			
			}
		    else  if(u.getUtype().equals("reqcuslogin"))
		 			{
		 				boolean b=false;
		 				b=obj.login(u);
		 				
		 				if(b)
		 				{
		 					HttpSession session=req.getSession();
							session.setAttribute("name",u.getEmail());
		 					
							RequestDispatcher rd=req.getRequestDispatcher("customerhome.jsp");
							  rd.forward(req, res);
		 				}
		 				else
		 				{
		 					out.print(" not done ");
		 				}
		 			
		 			}
		}	
	
		else if(path.equals("/reqforgot"))
		{
			u.setEmail(req.getParameter("t1")); 
			u.setPwd(req.getParameter("t2"));
		    u.setUtype(req.getParameter("t3"));
		  
		    if(u.getUtype().equals("reqempreg"))
			{
				boolean b=false;
				b=obj.forgot(u);
				if(b)
				{ 
					 RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
					  rd.forward(req, res);
					
					out.print("update  done ");
				}
				else
				{
					out.print(" not done ");
				}
			
			}
		     else  if(u.getUtype().equals("reqcusreg"))
		 			{
		 				boolean b=false;
		 				b=obj.forgot(u);
		 				if(b)
		 				{
		 					 RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
		 					  rd.forward(req, res);
		 					
		 					out.print(" Update done ");
		 				}
		 				else
		 				{
		 					out.print(" not done ");
		 				}
		 			
		 			}
	     }
		 
		 
		 
	
		else  if(path.equals("/requpdate"))
		{
			boolean b=false;
			 u.setFname(req.getParameter("t1"));
			 u.setName(req.getParameter("t2"));
			 u.setPwd(req.getParameter("t3"));
			 u.setEmail(req.getParameter("t4")); 
		     u.setMobile(Long.parseLong(req.getParameter("t5")));
		     u.setCity(req.getParameter("t6"));
		    b=obj.updateCus(u);
		    if(b)
		    {
		    	 RequestDispatcher rd=req.getRequestDispatcher("cusviewbyid.jsp");
					rd.forward(req, res);
		    }
		    else 
		    {
		    	out.print(" getting error ");
		    }
		   
		}
		     
			
		}
		

	}

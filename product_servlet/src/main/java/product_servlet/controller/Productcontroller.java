package product_servlet.controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product_servlet.dao.Productdao;
import product_servlet.dto.Product;

public class Productcontroller extends HttpServlet{
	
		

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String brand=req.getParameter("brand");
		String manufacture=req.getParameter("manufacture");
		double price=Double.parseDouble(req.getParameter("price")) ;
		String state=req.getParameter("state");
		
		
		ServletContext context= getServletContext();
		
		 double cgst=Double.parseDouble(context.getInitParameter("cgst")) ;
		 
		 
		 ServletConfig config=getServletConfig();
		 double mah=Double.parseDouble(config.getInitParameter("mah"));
		 double goa=Double.parseDouble( config.getInitParameter("goa"));
		 
		 
		 Product product=new Product();
		 PrintWriter printWriter=resp.getWriter();
		 if (state.equals("mah")) {
			 price+=(cgst+mah)*price;
			 product.setPrice(price);
			 printWriter.println(price);	
		}else if (state.equals("goa")) {
			price+=(cgst+goa)*price;
			 product.setPrice(price);
			 printWriter.println(price);
			
			
		}
		 product.setName(name);
		 product.setBrand(brand);
		 product.setManufacture(manufacture);
		 product.setState(state);
		 
		 Productdao productdao=new Productdao();
		 productdao.saveProduct(product);
				
	}
	}


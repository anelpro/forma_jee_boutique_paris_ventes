package com.parisventes.servlets;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.parisventes.beans.Article;
import com.parisventes.beans.BDD;

@WebServlet("/home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String filename = "C:\\Users\\Administrateur\\Desktop\\Formation_POE\\elipse-jee2\\ParisVentes\\WebContent\\articles.txt";

	public Home() {
		super();
	}

	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
				
		Article article = new Article();
		BDD bdd = new BDD(filename);
		List<String> allLines = bdd.readFile();
		String allHtml = article.findAll( allLines, request );
		
		request.setAttribute("allHtml", allHtml);
		
		
			
		this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);

	}


	
}

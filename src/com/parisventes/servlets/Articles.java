package com.parisventes.servlets;

import java.io.IOException;
import java.net.URI;
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


@WebServlet("/article")
public class Articles extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String filename = "C:\\Users\\Administrateur\\Desktop\\Formation_POE\\elipse-jee2\\ParisVentes\\WebContent\\articles.txt";
       
    
    public Articles() {
            }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
<<<<<<< HEAD
		Integer id = 0;
		
		try {
			 id = Integer.parseInt(request.getParameter("id"));
=======
		//Integer id = 0;
		
		try {
			Integer id = Integer.parseInt(request.getParameter("id"));
>>>>>>> master
		}catch (NumberFormatException e) {
			System.out.println(e.getMessage());
		}
		
<<<<<<< HEAD
		Article articles = new Article();
		articles.setRequest(request);
		
		BDD bdd = new BDD(Home.filename);
			
		
		request.setAttribute("allHtml", articles.findById(bdd.readFile(), id));

		
		//String allHtml = articles.findById(bdd.readFile(),id);
		
		//request.setAttribute("allHtml", allHtml);
=======
		Article article = new Article();
		BDD bdd = new BDD(filename);
		List<String> allLines = bdd.readFile();
		String allHtml = article.findById( allLines, request );
		
		request.setAttribute("allHtml", allHtml);
>>>>>>> master

	
		
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/article.jsp").forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

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


@WebServlet("/articles")
public class Articles extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String filename = "C:\\Users\\Administrateur\\Desktop\\Formation_POE\\elipse-jee2\\ParisVentes\\WebContent\\articles.txt";
       
    
    public Articles() {
            }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setAttribute("allHtml", this.findArticle(request));

	
		
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/article.jsp").forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	public String findArticle(HttpServletRequest request) {
		
		String allHtml = new String(); 
		Integer id = Integer.parseInt(request.getParameter("id"));

		try {
			List<String> allLines = Files.readAllLines(Paths.get(filename));
			//System.out.println(id);
			
			for (String line : allLines) {
				 String[] splitted = line.split("\\|");
				 
				 if (Integer.parseInt(splitted[0]) == id) {
				 
					String html = "<article><h1>";
					html += splitted[1] + "</h1><figure>";
					html += splitted[0] + "<img src=\"";
					html += request.getContextPath() + "/img/" + splitted[2] + "\"><figcaption>";
					html += splitted[3] + "</figcaption><span>";
					html += splitted[4] + "</span></figure></article>";
				
				
				System.out.println(html);
		
				allHtml = allHtml + html;
				 }
			}
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		return allHtml;
	}
}

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
	
		//readFile(); lecture de la méthode 
		request.setAttribute("allHtml", this.readFile(request));
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//doGet(request, response);
	}

	public String readFile(HttpServletRequest request) { // création d'une méthode pour la lecture du file + affichage console
		
		String allHtml = new String(); 

					
			BDD bdd = new BDD(filename);
			List<String> allLines = bdd.readFile();
					
			for (String line : allLines) {
				String[] arr = line.split("\\|");
	
					String html = "<article><h1>";
					html += arr[1] + "</h1><figure><a href=\""+ request.getContextPath() + "/articles?id=";
					html += arr[0] + "\"><img src=\"";
					html += request.getContextPath() + "/img/" + arr[2] + "\"><figcaption>";
					html += arr[3] + "</a></figcaption><span>";
					html += arr[4] + "</span></figure></article>";
					
				System.out.println(html);
		
				allHtml = allHtml + html;
				
				
			//	for (String a : arr) {
			//		System.out.println(a);
			//	}
			}
		
		return allHtml;
	}

	
}

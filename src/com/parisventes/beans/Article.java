package com.parisventes.beans;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class Article {
	String title ="";
	String linkImg ="";
	String description = "";
	Float price = 0.0f;
<<<<<<< HEAD
	Integer id;
	
	//private static final String filename = "C:\\Users\\Administrateur\\Desktop\\Formation_POE\\elipse-jee2\\ParisVentes\\WebContent\\articles.txt";
=======
	private static final String filename = "C:\\Users\\Administrateur\\Desktop\\Formation_POE\\elipse-jee2\\ParisVentes\\WebContent\\articles.txt";
>>>>>>> master

	public Article() {
		
	}
	
	
	public Article(String title, String linkImg, String description, Float price) {
		super();
		this.title = title;
		this.linkImg = linkImg;
		this.description = description;
		this.price = price;
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public String getLinkImg() {
		return linkImg;
	}
	public void setLinkImg(String linkImg) {
		this.linkImg = linkImg;
	}
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
<<<<<<< HEAD
	private HttpServletRequest request;

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	
	
	public String findAll(List<String> allLines) {
		String html = new String();
		for (String line : allLines) {
			Article article = this.splitline(line);
			html += "<article><h4>";
			html += article.title + "</h4><figure><a href=\"" + this.request.getContextPath() +"/article?id="+article.id+ "\"><img src=\"";
			html += this.request.getContextPath() + "/img/" + article.linkImg+ "\" alt=\"\"></a><figcaption>";
			html += article.description + "</figcaption></figure><span>";
			html += article.price + "�</span></article>";
		}
		return html;
	}

	
	public String findById(List<String> allLines, Integer id) {
		String html = new String();
		for (int i = 0; i < allLines.size(); i++) {

			Article article = this.splitline(allLines.get(i));
			System.out.println(article.id + " : " + id);
			if (article.id == id) {
				html = "<article><h4>";
				html += article.title + "</h4><figure><img src=\"";
				html += request.getContextPath() + "/img/" + article.linkImg + "\" alt=\"\"><figcaption>";
				html += article.description + "</figcaption></figure><span>";
				html += article.price + "�</span></article>";
				return html;
			}else {
				html = "Aucun article n'existe avec cet identifiant";
			}
		}
		
		return html;
	}

	
	
	public Article splitline(String line) {
		String[] arr = line.split("\\|");
		Article article = new Article();
		article.id = this.stringToInteger(arr[0]);

		article.title = arr[1];
		article.linkImg = arr[2];
		article.description = arr[3];

		try {
			article.price = Float.parseFloat(arr[4]);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return article;
		
	}
	
	public Integer stringToInteger(String str) {
		Integer i = 0;
		try {
			i = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			System.out.println("Attention probl�me de parseInt dans mon article et dans ma m�thode splitLine pour mon id");
		}
		return i;
	}

 
	
=======
	public String findAll(List<String> allLines, HttpServletRequest request) { // cr�ation d'une m�thode pour la lecture du file + affichage console
		
		String allHtml = new String();

		for (String line : allLines) {
			String[] arr = line.split("\\|");

			String html = "<article><h1>";
			html += arr[1] + "</h1><figure><a href=\"" + request.getContextPath() + "/articles?id=";
			html += arr[0] + "\"><img src=\"";
			html += request.getContextPath() + "/img/" + arr[2] + "\"><figcaption>";
			html += arr[3] + "</a></figcaption><span>";
			html += arr[4] + "</span></figure></article>";

			System.out.println(html);

			allHtml = allHtml + html;

		}
		return allHtml;
	}
	
	public String findById(List<String> allLines, HttpServletRequest request) {

		String allHtml = new String();
		Integer id = Integer.parseInt(request.getParameter("id"));

	
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

		return allHtml;
	}
>>>>>>> master
}

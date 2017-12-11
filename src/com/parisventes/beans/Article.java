package com.parisventes.beans;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class Article {
	String title ="";
	String linkImg ="";
	String description = "";
	Float price = 0.0f;
	private static final String filename = "C:\\Users\\Administrateur\\Desktop\\Formation_POE\\elipse-jee2\\ParisVentes\\WebContent\\articles.txt";

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
	
	public String findAll(List<String> allLines, HttpServletRequest request) { // création d'une méthode pour la lecture du file + affichage console
		
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
}

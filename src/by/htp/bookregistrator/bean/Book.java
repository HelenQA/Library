package by.htp.bookregistrator.bean;

import by.htp.bookregistrator.utils.Values;

public class Book implements Comparable<Book>{
	
	private int id;
	private String brief;
	private int publishYear;
	private String author;
	
	public Book(int id, String brief, int publishYear, String author){
		this.id = id;
		this.brief = brief;
		this.publishYear = publishYear;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return id + Values.regex + brief + Values.regex + publishYear + Values.regex + author;
	}

	@Override
	public int compareTo(Book arg0) {
		return id - arg0.id;
	}


}

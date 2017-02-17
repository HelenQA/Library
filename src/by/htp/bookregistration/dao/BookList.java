package by.htp.bookregistration.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import by.htp.bookregistrator.bean.Book;
import by.htp.bookregistrator.utils.Configurator;
import by.htp.bookregistrator.utils.Values;

public class BookList {
	
	private final static String BOOKSFILE = Configurator.getKey("BOOKSFILE");
	
	private List<Book> books;
	
	public BookList(){
		books = new ArrayList<Book>();
	}
	
	public void printBooks(){
		for (Book book : books){
			System.out.println(book);
		}
	}
	
	public void addBook(int id, String brief, int publishYear, String author){
		Book book = new Book(id, brief, publishYear, author);
		books.add(book);
		Collections.sort(books);
	}
	
	public void addBooks(ArrayList<String> strBooks){
		for(String line : strBooks){
			books.add(parseLine(line));
		}
	}
	
	public void removeBook(int id){
		for(Book book : books){
			if (id == book.getId()){
				books.remove(book);
				break;
			}
		}
	}
	
	public void editBook(int id, String brief, int publishYear, String author){
		removeBook(id);
		addBook(id, brief, publishYear, author);
	}
	
	public void saveToFile(){
		try (FileWriter writer = new FileWriter(BOOKSFILE, false)) {
			if (!books.isEmpty()) {
				for (Book book : books) {
					writer.write(book.toString());
					 writer.append('\n');
				}
			}
		} catch (IOException e) {
			System.out.println("your exception for writer");
		}
	}
	
	public void readFromFile(){
		String line;
		try(BufferedReader reader = new BufferedReader(new FileReader(BOOKSFILE))){
			while ((line = reader.readLine()) != null){
				books.add(parseLine(line));
			}
		} catch (IOException e){
			System.out.println("your exception for reader");
		}
	}
	
	private Book parseLine(String line){
		String[] array;
		array = line.split(Values.regex);
		return new Book(Integer.parseInt(array[0]), array[1], Integer.parseInt(array[2]), array[3]);
	}
	
	public int numOfBooks(){
		return books.size();
	}
	
	public Book getBookById(int id){
		if (null != findBookById(id)){
			return findBookById(id);
		}
		System.out.println("id of book > number of books!");
		return null;
	}
	
	private Book findBookById(int id){
		for(Book book : books){
			if(id == book.getId()) return book;
		}
		return null;
	}

}

package by.htp.bookregistrator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import by.htp.bookregistration.dao.BookList;
import by.htp.bookregistration.dao.EmployeeList;
import by.htp.bookregistration.dao.NodeList;
import by.htp.bookregistration.service.DBBookList;

public class Runner {

	public static void main(String[] args) throws ParseException {
		
		BookList books = new BookList();
		books.addBooks(DBBookList.readBooksFromDB());
		books.printBooks();
		System.out.println("---");
		
		EmployeeList el = new EmployeeList();
		DateFormat format = new SimpleDateFormat("dd-mm-yyyy");
		Date date;
		date = format.parse("12-02-1984");
		el.addEmployee(1, "Ivan", date, "11@11");
		date = format.parse("13-02-1984");
		el.addEmployee(2, "Petr", date, "22@22");
		date = format.parse("14-02-1984");
		el.addEmployee(3, "Oleg", date, "33@33");
		
		NodeList nl = new NodeList(books, el);
		nl.printNodeList();
		
	}

}

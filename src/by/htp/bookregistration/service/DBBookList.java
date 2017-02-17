package by.htp.bookregistration.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import by.htp.bookregistrator.utils.Configurator;
import by.htp.bookregistrator.utils.Values;

public class DBBookList {
	
	public static ArrayList<String> readBooksFromDB(){
		try (ResultSet resultSet = DBMain.processDBbyQuery(Configurator.getKey("GET_ALL_BOOKS_DB"))) {
			return processResultSet(resultSet);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private static ArrayList<String> processResultSet(ResultSet resultSet) {
		ArrayList<String> books = new ArrayList<String>();
		try {
			while (resultSet.next()) {
				StringBuilder line = new StringBuilder();
				line.append(resultSet.getString("id"));
				line.append(Values.regex);
				line.append(resultSet.getString("brief"));
				line.append(Values.regex);
				line.append(resultSet.getString("publishYear"));
				line.append(Values.regex);
				line.append(resultSet.getString("author"));
				books.add(line.toString());
			}
			return books;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

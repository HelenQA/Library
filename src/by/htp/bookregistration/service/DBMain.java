package by.htp.bookregistration.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.htp.bookregistrator.utils.Configurator;

public class DBMain {

	public static final String DBNAME = Configurator.getKey("DBNAME");
	public static final String DBPASS = Configurator.getKey("DBPASS");
	public static final String DBURL = Configurator.getKey("DBURL");
	public static final String DBDriver = Configurator.getKey("DBDriver");


	public static ResultSet processDBbyQuery(String query) throws ClassNotFoundException, SQLException {
		Class.forName(DBDriver);
		Connection connection = DriverManager.getConnection(DBURL, DBNAME, DBPASS);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		return resultSet;
	}

}

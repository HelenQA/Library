package by.htp.bookregistrator.bean;

import java.util.Date;

import by.htp.bookregistrator.utils.Values;

public class Employee {

	private int id;
	private String name;
	private Date dataBirth;
	private String email;

	public Employee(int id, String name, Date dataBirth, String email){
		this.id = id;
		this.name = name;
		this.dataBirth = dataBirth;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return id + Values.regex + name + Values.regex + dataBirth + Values.regex + email;
	}
}
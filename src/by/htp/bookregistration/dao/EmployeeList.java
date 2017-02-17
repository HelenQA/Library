package by.htp.bookregistration.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import by.htp.bookregistrator.bean.Employee;
import by.htp.bookregistrator.utils.Values;

public class EmployeeList {
	
	private List<Employee> employees;
	
	public EmployeeList(){
		employees = new ArrayList<Employee>();
	}
	
	public void printEmployees(){
		for(Employee employee : employees){
			System.out.println(employee);
		}
	}
	
	public void addEmployee(int id, String name, Date dataBirth, String email){
		Employee employee = new Employee(id, name, dataBirth, email);
		employees.add(employee);
	}
	
	public void addEmployees(ArrayList<String> employees){
		for(String line : employees){
			this.employees.add(parseLine(line));
		}
	}
	
	public void removeEmployee(int id){
		for(Employee employee : employees){
			if(employee.getId() == id){
				employees.remove(employee);
				break;
			}
		}
	}
	
	public Employee parseLine(String line){
		String[] array;
		array = line.split(Values.regex);
		DateFormat format = new SimpleDateFormat("dd-mm-yyyy");
		Date date;
		try {
			date = format.parse(array[2]);
			return new Employee(Integer.parseInt(array[0]), array[1], date, array[3]);
		} catch (ParseException e) {
			System.out.println("Wrong data for Employee node");
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean ifEmpty(){
		return employees.isEmpty();
	}
	
	public Employee getEmployeeById(int id){
		if (null != findEmployeeById(id)){
			return findEmployeeById(id);
		}
		System.out.println("id of employee > number of employees!");
		return null;
	}
	
	private Employee findEmployeeById(int id){
		for(Employee employee : employees){
			if(employee.getId() == id) return employee;
		}
		return null;
	}
	
	public int getEmplyeeSize(){
		return employees.size();
	}
}

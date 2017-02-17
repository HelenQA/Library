package by.htp.bookregistrator.bean;

public class Node {
	private int id;
	private Book book;
	private Employee employee;
	
	public Node(int id, Book book, Employee employee){
		this.id = id;
		this.book = book;
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Node [id=" + id + ", book=" + book.getId() + ", employee=" + employee.getId() + "]";
	}
}

package by.htp.bookregistration.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import by.htp.bookregistrator.bean.Book;
import by.htp.bookregistrator.bean.Employee;
import by.htp.bookregistrator.bean.Node;

public class NodeList {

	private List<Node> nodes;
	private BookList books;
	private EmployeeList employees;

	private static int numOfBooks;
	private EmployeeList tempEmployees;
	private int idOfEmployee;
	private int idOfNode;
	private int bookId;
	private Book fakeBook = new Book(0, "fake book", 0000, "fake");

	public NodeList(BookList books, EmployeeList employees) {
		this.books = books;
		this.employees = employees;
		this.tempEmployees = employees;
		nodes = new ArrayList<Node>();
		idOfEmployee = 1;
		idOfNode = 1;
		createNodeList();
	}

	private void createNodeList() {
		while (!tempEmployees.ifEmpty()) {
			createNodesForEmployee(employees.getEmployeeById(idOfEmployee));
			tempEmployees.removeEmployee(idOfEmployee);
			idOfEmployee++;
		}
	}

	private void createNodesForEmployee(Employee employee) {
		numOfBooks = (int) (new Random().nextInt((books.numOfBooks())));
		if (0 == numOfBooks) {
			nodes.add(new Node(idOfNode, fakeBook, employee));
			idOfNode++;
		} else {
			int index = 0;
			int[] arrayUniqueBookId = new int[numOfBooks];
			for (int i = 0; i < numOfBooks; i++) {
				bookId = 1 + new Random().nextInt((books.numOfBooks()));
				while (!ifBookIdUnique(bookId, arrayUniqueBookId)) {
					bookId = 1 + new Random().nextInt((books.numOfBooks()));
				}
				arrayUniqueBookId[index] = bookId;
				index++;
				nodes.add(new Node(idOfNode, books.getBookById(bookId), employee));
				idOfNode++;
			}
		}
	}

	private boolean ifBookIdUnique(int bookId, int[] arrayUniqueBookId) {
		for (int check : arrayUniqueBookId) {
			if ((bookId == check) & (0 != check))
				return false;
		}
		return true;
	}

	public void printNodeList() {
		for (Node node : nodes) {
			System.out.println(node);
		}
		System.out.println("Total nodes: " + (idOfNode - 1));
	}

}

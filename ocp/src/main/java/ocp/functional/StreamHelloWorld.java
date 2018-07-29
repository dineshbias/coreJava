/**
 * 
 */
package ocp.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author dinesh.joshi
 *
 */
public class StreamHelloWorld {

	/*
	 * Get the unique names in uppercase of the first 4 book authors that are 50
	 * years old or older and also sum of ages of all female authors younger
	 * than 50.
	 * 
	 * Function Output When to use reduce concrete type to cumulate elements
	 * collect list, map or set to group elements forEach side effect to perform
	 * a side effect on elements
	 * 
	 * 
	 */
	public static void main(String... args) {
		// An intermediate operation is always lazily executed.
		// A terminal operation is always eagerly executed.
		Stream<Book> bookStream = getBooks().stream();

		// Sample use of Collector
		List<String> authors = bookStream.filter(book -> book.getAuthor().getAge() >= 50)
				.peek(book -> System.out.println(book)).distinct().limit(4).map(b -> b.getAuthor())
				.map(a -> a.getName()).map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(authors);

		Stream<Book> bookStream2 = getBooks().stream();
		int sum = bookStream2.map(book -> book.getAuthor()).filter(a -> a.getGender().equals("FEMALE"))
				.filter(a -> a.getAge() < 50).peek(author -> System.out.println(author)).map(author -> author.getAge())
				.reduce(0, Integer::sum);
		System.out.println(sum);
	}

	public static List<Book> getBooks() {
		Author auth1 = new Author("Disney", 50, "MALE");
		Author auth2 = new Author("Maggi", 70, "FEMALE");
		Author auth3 = new Author("Pogo", 40, "MALE");
		Author auth4 = new Author("Pickachu", 60, "FEMALE");
		Author auth5 = new Author("tom", 30, "FEMALE");
		Author auth6 = new Author("Disney75", 75, "MALE");
		Author auth7 = new Author("Maggi70", 70, "FEMALE");
		Author auth8 = new Author("Pogo85", 85, "FEMALE");
		Author auth9 = new Author("Pickachu80", 80, "FEMALE");
		Author auth10 = new Author("tom", 10, "FEMALE");

		Book book1 = new Book("Dennis the Menace", "Kids", auth1);
		Book book2 = new Book("Ramayana", "Kids", auth2);
		Book book3 = new Book("Mahabharata", "Kids", auth3);
		Book book4 = new Book("Geeta", "Kids", auth4);
		Book book5 = new Book("Raj Comic", "Kids", auth5);
		Book book6 = new Book("Diamond Comics", "Kids", auth6);
		Book book7 = new Book("Bankelal", "Kids", auth7);
		Book book8 = new Book("Nagraz", "Kids", auth8);
		Book book9 = new Book("Doga", "Kids", auth9);
		Book book10 = new Book("Fucker", "Kids", auth10);

		List<Book> books = new ArrayList<Book>();
		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);
		books.add(book5);
		books.add(book6);
		books.add(book7);
		books.add(book8);
		books.add(book9);
		books.add(book10);

		return books;
	}

}

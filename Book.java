// Name: Justin Eldridge
// Date: Jan, 28, 2019
// Course: CS 272 M01
// Purpose: To create a Book Class (With: Title, ISBN, # of Authors, and the Author names), and a main method to test the Book Object's methods.
// Input: No inputs
// Output: Various prints testing the Book class

public class Book {

	// Initializing instance variables
	private String bookTitle;
	private int numOfAuthors;
	private String[] authorNames;
	private String ISBN;
	
	// No Parameters Constructor
	public Book() {
		// sets everything to null / 0
		ISBN = null;
		bookTitle = null;
		numOfAuthors = 0;
		authorNames = new String[3];
		
	}
	
	// Constructor accepting only the book title
	public Book(String _bookTitle) {
		// only sets the book title. Everything else is null / 0
		ISBN = null;
		bookTitle = _bookTitle;
		numOfAuthors = 0;
		authorNames = new String[3];
		
	}
	
	// Copy Constructor
	public Book(Book b2) {
		// copies all parameters of b2, as long as b2 is a Book and not null
		if (b2 != null) {
			if (b2 instanceof Book) {
				bookTitle = b2.getTitle();
				ISBN = b2.getISBN();
				numOfAuthors = b2.getAuthorNumber();
				authorNames = new String[3];
				authorNames = b2.getAuthorsNames().clone();
			}
		}
	}

	// Assessor of Book Title.
	public String getTitle() {
		return bookTitle;
	}
	
	// Assessor of the ISBN.
	public String getISBN() {
		return ISBN;
	}
	
	// Assessor of the Number of Authors.
	public int getAuthorNumber() {
		return numOfAuthors;
	}
	
	// Assessor of the AuthorList (returns the string array of authors names)
	public String[] getAuthorsNames() {
		return authorNames;
	}
	
	// Assessor of the AuthorList (returns one of the authors name, corresponding to i)
	public String getAuthorsNames(int i) {
		return authorNames[i];
	}
	
	// Mutator of Book Title.
	public void setTitle(String _bookTitle) {
		bookTitle = _bookTitle;
	}
	
	// Mutator of the ISBN/
	public void setISBN(String _ISBN){
		ISBN = _ISBN;
	}
	
	// Mutator of the Number of Authors.
	public void setNumOfAuthors(int _numOfAuthors) {
		numOfAuthors = _numOfAuthors;
	}
	
	// Adds an author's name to the array of authors.
	public boolean addAuthor(String _authorName) {
		// Only adds it if there is room
		if (numOfAuthors < 3) {
			authorNames[numOfAuthors] = _authorName;
			numOfAuthors++;
			return true;
		}
		
		// If there is no room it just returns false
		else {
			return false;
		}
	}
	
	// Checks if the ISBN is equal to the ISBN of the given Book param.
	public boolean equals(Book b2) {
		// will only compare them as long as b2 is not null and is a book.
		if (b2 != null) {
			if (b2 instanceof Book) {
				if (ISBN == b2.getISBN()) {
					return true;
				}
			}
		}
		return false;
	}
	
	// Returns a list of all authors from two books.
	public String[] getAllAuthors(Book b1, Book b2) {
			if ((b1 != null) && (b2 !=null)) {
				if ((b1 instanceof Book) && (b2 instanceof Book)) {
					
					// defining the array that will be returned
					int total = b1.getAuthorNumber() + b2.getAuthorNumber(); 
					String[] returnString = new String[total];
					int count = 0;
					
					// adding the author names for b1
					for (int i = 0; i < b1.numOfAuthors; i++) {
						returnString[count] = b1.getAuthorsNames(i);
						count++;
					}
					
					// adding the author names for b2
					for (int i = 0; i < b2.numOfAuthors; i++) {
						returnString[count] = b2.getAuthorsNames(i);
						count++;
					}
					
					// checking for duplicates
					for (int i = 0; i < returnString.length; i++) {
						for (int j = i + 1; j < returnString.length; j++) {
							if (returnString[i] == returnString[j])
								returnString[j] = null;
						}
					}
					
					// returns the result
					return returnString;
				}
			}
		// If either lists are null it returns null 
		return null;
	}
	
	// Returns the Book as a string
	public String toString() {
		//returns in the form "Book title, ISBN, num of Authors, Author List
		String returnString = bookTitle + ", " + ISBN + ", " + Integer.toString(numOfAuthors) + ", " + String.join(", ", authorNames);
		return returnString;
	}
	
	public static void main(String[] args) {

		// Testing the no parameters constructor 
		Book b1 = new Book();
		// Testing the toString method of Book
		System.out.println("B1: " + b1);
		
		System.out.println();
		
		// Testing the mutator methods
		b1.setTitle("Principles of Electric Circuits: Conventional Current Version");
		b1.setISBN("978-0135073094");
		b1.setNumOfAuthors(0);
		
		// Testing the assessor methods
		System.out.println(b1.getTitle());
		System.out.println(b1.getISBN());
		System.out.println(b1.getAuthorNumber());
		
		System.out.println();
		
		// Testing the author title constructor
		Book b2 = new Book("Moby Dick");
		b2.setISBN("9781620281932");
		
		// Testing the equals method with different ISBNS
		if (b1.equals(b2))
			System.out.println("B1's ISBN and B2's ISBN are equal.");
		else
			System.out.println("B1's ISBN and B2's ISBN are NOT equal.");
		
		System.out.println();
		
		// Testing the copy constructor
		
		Book b3 = new Book(b1);
		
		// Printing the original and the copy to see if they are the same
		System.out.println("B1: " + b1);
		System.out.println("B3: " + b3);
		
		System.out.println();
		
		// Testing the equals method with the same ISBNS
				if (b3.equals(b1))
					System.out.println("B1's ISBN and B3's ISBN are equal.");
				else
					System.out.println("B1's ISBN and B3's ISBN are NOT equal.");
				
				System.out.println();
		
		// Testing the addAuthor function
		b1.addAuthor("Thomas L. Floyd");
		b1.addAuthor("Jackie Chan");		
		b2.addAuthor("Herman Melville");
		b2.addAuthor("Michael Jackson");		
		System.out.println("B1: " + b1);
		System.out.println("B2: " + b2);
		
		System.out.println();
		
		// Testing the getAllAuthors method. Adding the same author to both books, to test that duplicates are deleted
		b2.addAuthor("John Cena");
		b1.addAuthor("John Cena");
		System.out.println(String.join(", ", b1.getAllAuthors(b1, b2)));
		
		System.out.println();
		
		// Trying to add a fourth author to B1
		if(b1.addAuthor("fourth author"))
			System.out.println("Your code is broken.");
		else
			System.out.println("You cannot add a fourth author!");
		
		System.out.println();
		
		// Setting B1 to Null then trying to copy it
		b1 = null;
		Book b4 = new Book(b1);
		//System.out.println(b4);
		
		
	}
}
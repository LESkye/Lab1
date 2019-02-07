
public class Book {

	// Initializing instance variables
	private String bookTitle;
	private int numOfAuthors;
	private String[] authorNames;
	private String ISBN;
	
	// No Parameters Constructor
	public Book() {
		ISBN = null;
		bookTitle = null;
		numOfAuthors = 0;
		authorNames = new String[3];
		
	}
	
	// Constructor accepting only the book title
	public Book(String _bookTitle) {
		ISBN = null;
		bookTitle = _bookTitle;
		numOfAuthors = 0;
		authorNames = new String[3];
		
	}
	
	// Copy Constructor
	public Book(Book b2) {
		if (b2 != null) {
			if (b2 instanceof Book) {
				bookTitle = b2.getBookTitle();
				ISBN = b2.getISBN();
				numOfAuthors = b2.getNumOfAuthors();
				authorNames = new String[3];
				authorNames = b2.getAuthorNames().clone();
			}
		}

	}

	// Assessor of Book Title.
	public String getBookTitle() {
		return bookTitle;
	}
	
	// Assessor of the ISBN.
	public String getISBN() {
		return ISBN;
	}
	
	// Assessor of the Number of Authors.
	public int getNumOfAuthors() {
		return numOfAuthors;
	}
	
	// Assessor of the AuthorList
	public String[] getAuthorNames() {
		return authorNames;
	}
	
	// Mutator of Book Title.
	public void setBookTitle(String _bookTitle) {
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
		if (numOfAuthors < 3) {
			authorNames[numOfAuthors] = _authorName;
			numOfAuthors++;
			return true;
		}
		else {
			return false;
		}
	}
	
	// Checks if the ISBN is equal to the ISBN of the given Book param.
	public boolean equals(Book b2) {
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
	public static String[] getAllAuthors(Book b1, Book b2) {
		String[] authorReturn = new String[b1.getNumOfAuthors() + b2.getNumOfAuthors()];
			if ((b1 != null) && (b2 !=null)) {
				if ((b1 instanceof Book) && (b2 instanceof Book)) {
					// idk what to put here
				}
			}
		return authorReturn;
	}
	
	// Returns the Book as a string
	public String toString() {
		String returnString = bookTitle + ", " + ISBN + ", " + Integer.toString(numOfAuthors) + ", " + String.join(", ", authorNames);
		return returnString;
	}
	
	public static void main(String args) {
		System.out.println("hello");
	}
	
}
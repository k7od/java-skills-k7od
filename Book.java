        public class Book {
            protected String title;
            protected String author;
            protected int pages;
            protected boolean isAvailable;

            public Book(String title, String author, int pages) {
                this.title = title;
                this.author = author;
                this.pages = pages;
                this.isAvailable = true;
            }

            public void borrowBook() {
                if (isAvailable) {
                    isAvailable = false;
                    System.out.println(title + " borrowed.");
                } else {
                    System.out.println(title + " is not available.");
                }
            }

            public void returnBook() {
                isAvailable = true;
                System.out.println(title + " has been returned.");
            }

            public void displayInfo() {
                System.out.println("Title: " + title);
                System.out.println("Author: " + author);
                System.out.println("Pages: " + pages);
                System.out.println("Available: " + isAvailable);
            }

            public String getTitle() {
                return title;
            }

            public String getAuthor() {
                return author;
            }

            public int getPages() {
                return pages;
            }

            public boolean getIsAvailable() {
                return isAvailable;
            }
        }

        class Textbook extends Book {
            private String subject;
            private int edition;

            public Textbook(String title, String author, int pages, String subject, int edition) {
                super(title, author, pages);
                this.subject = subject;
                this.edition = edition;
            }

            @Override
            public void displayInfo() {
                super.displayInfo();
                System.out.println("Subject: " + subject);
                System.out.println("Edition: " + edition);
            }

            public String getSubject() {
                return subject;
            }

            public int getEdition() {
                return edition;
            }
        }

        class Library {
            public static void main(String[] args) {
                // Create 2 regular books
                Book book1 = new Book("The Nineteen Eighty-Four", "George Orwell", 448);
                Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 324);

                Textbook textbook = new Textbook("Physics 101", "Dr. Smith", 480, "Science", 3);

                System.out.println("\n--- Borrowing Books ---");
                book1.borrowBook();
                book1.borrowBook();
                book1.returnBook();
                book1.borrowBook();

                System.out.println("\n--- Book Information ---");
                book1.displayInfo();
                System.out.println();
                book2.displayInfo();
                System.out.println();
                textbook.displayInfo();
            }
        }

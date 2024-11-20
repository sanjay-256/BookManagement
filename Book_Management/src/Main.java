import java.sql.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false,exit2=false;
        InsertBdata insertdata = new InsertBdata();
        GetBdata getdata=new GetBdata();
        UpdateBdata updatedata=new UpdateBdata();
        DeleteBdata deletedata=new DeleteBdata();

        while (!exit) {
            System.out.println("Choose an option:");
            System.out.println("1. Insert");
            System.out.println("2. Get");
            System.out.println("3. Delete");
            System.out.println("4. Update");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter Book ID: ");
                        int book_id = scanner.nextInt();
                        scanner.nextLine(); 

                        System.out.print("Enter Book Title: ");
                        String book_title = scanner.nextLine();

                        System.out.print("Enter Author Name: ");
                        String author_name = scanner.nextLine();

                        System.out.print("Enter ISBN: ");
                        long isbn = scanner.nextLong();
                        scanner.nextLine();

                        System.out.print("Enter Category: ");
                        String category = scanner.nextLine();

                        System.out.print("Enter Publisher: ");
                        String publisher = scanner.nextLine();

                        System.out.print("Enter Publication Date (yyyy-mm-dd): ");
                        String pubDateStr = scanner.nextLine();
                        Date publication_date = Date.valueOf(pubDateStr); // Converts string to SQL Date

                        System.out.print("Enter Selling Price: ");
                        int book_sprice = scanner.nextInt();

                        System.out.print("Enter Cost Price: ");
                        int book_cprice = scanner.nextInt();

                        System.out.print("Enter Stock: ");
                        int book_stock = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        System.out.print("Enter Language: ");
                        String book_language = scanner.nextLine();

                        System.out.print("Enter Version: ");
                        String book_version = scanner.nextLine();

                        System.out.print("Enter Pages: ");
                        int book_pages = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        System.out.print("Enter Format: ");
                        String book_format = scanner.nextLine();

                        System.out.print("Enter Description: ");
                        String book_description = scanner.nextLine();

                        System.out.print("Enter Cover Image URL: ");
                        String book_coverimage = scanner.nextLine();

                        
                        insertdata.insert(book_id, book_title, author_name, isbn, category, publisher,
                                publication_date, book_sprice, book_cprice, book_stock, book_language,
                                book_version, book_pages, book_format, book_description, book_coverimage);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid input: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("An error occurred: " + e.getMessage());
                    }
                    break;
                case 2:
                	while(!exit2) {
                	System.out.println("To get the data select one of the options:");
                	System.out.println("1.To get entire data from table");
                	System.out.println("2.To get data from table with specific id");
                	System.out.println("3. Exit");
                	int choose=scanner.nextInt();
                	scanner.nextLine();
                	switch (choose) {
					case 1: 
						try {
							getdata.get();
						} catch (Exception e) {
							System.out.println("Error geting book: " + e.getMessage());
						}
						break;
					case 2:
						try {
							System.out.println("enter the id");
							int id=scanner.nextInt();
							getdata.getid(id);
						} catch (Exception e) {
							System.out.println("Error getting book: " + e.getMessage());
						}
						break;
					case 3:
	                    System.out.println("Exiting...");
	                    exit2 = true;
	                    break;
					default:
	                    System.out.println("Invalid option. Please try again.");
					}
                	}
                	break;
                case 3:
                	try{
                		System.out.println("enter the id");
						int id=scanner.nextInt();
	                	deletedata.delete(id);
                	}catch (Exception e) {
						System.out.println("Error deleting book: " + e.getMessage());
                	}
                	break;
                case 4:
                	try {
                		System.out.println("enter the id");
						int id=scanner.nextInt();
						scanner.nextLine();
						System.out.println("enter the format if integer=> i or string => s: ");
						String check=scanner.nextLine();
						System.out.println("enter the column name: ");
						System.out.println("BookID - Title - Author - ISBN - Genre - Publisher - PublicationDate - Price - CostPrice - StockQuantity - Language - Edition - PageCount - BookFormat - Description - BookCoverImage");
						String col_name=scanner.nextLine();
						if(check.equals("i")) {
							System.out.println("enter the value in int format");
							int ivalue=scanner.nextInt();
							scanner.nextLine();
							updatedata.updatei(id,col_name,ivalue);
							getdata.getid(id);
						}else if(check.equals("s")) {
							System.out.println("enter the value in str format");
							String svalue=scanner.nextLine();
							updatedata.updates(id,col_name,svalue);
							getdata.getid(id);
						}
					} catch (Exception e) {
						System.out.println("Error updating book: " + e.getMessage());
					}
                	break;
                case 5:
                    System.out.println("Exiting...");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}

package moviemanagement;

import java.util.Scanner;

public class MovieMain {

	 public static void startMovieMenu() {		
		Scanner sc=new Scanner(System.in);
		
		MovieDAO dao=new MovieDAOImplementations();
		
		while(true) {
			
			System.out.println("1. Add Movie");
		    System.out.println("2. View Movies");
		    System.out.println("3. Search Movie by Name");
		    System.out.println("4. Update Rating");
		    System.out.println("5. Sort Movies");
		    System.out.println("6. Filter Movies");
		    System.out.println("7. Delete Movie");
		    System.out.println("8. Exit");
		    
		    int choice=sc.nextInt();
		    
		    switch(choice) {
		    	case 1:
		    		Movie movie=new Movie();
		    		System.out.print("Enter Name: ");
		    		movie.setName(sc.next());
		            System.out.print("Enter Genre: ");
		            movie.setGenre(sc.next());
		            System.out.print("Enter Rating: ");
		            movie.setRating(sc.nextDouble());
		            dao.addMovie(movie);
		            break;
		    	
		    	case 2:
		    		System.out.print("Enter Page Number: ");
		    		int pageNumber = sc.nextInt();

		    		System.out.print("Enter Page Size: ");
		    		int pageSize = sc.nextInt();

		    		dao.viewMovies(pageNumber, pageSize);
		    		
		    		while(true) {

		    		    System.out.println("\nShowing Page: " + pageNumber);

		    		    dao.viewMovies(pageNumber, pageSize);

		    		    System.out.println("\nN - Next Page");
		    		    System.out.println("P - Previous Page");
		    		    System.out.println("E - Exit Pagination");

		    		    char input = sc.next().charAt(0);

		    		    if(input == 'N' || input == 'n') {
		    		        pageNumber++;
		    		    }

		    		    else if(input == 'P' || input == 'p') {
		    		        if(pageNumber > 1)
		    		            pageNumber--;
		    		        else
		    		            System.out.println("Already at First Page");
		    		    }

		    		    else if(input == 'E' || input == 'e') {
		    		        break;
		    		    }
		    		}

		            break;

		    	case 3:
		    		System.out.println("Enter Movie Name");
		    		String name=sc.next();
		    		dao.searchMovieByName(name);
		            break;
		            
		        case 4:
		            System.out.print("Enter ID: ");
		            int id = sc.nextInt();
		            System.out.print("Enter New Rating: ");
		            double rating = sc.nextDouble();
		            dao.updateRating(id, rating);
		            break;
		            
		        case 5:
		            System.out.println("1. Sort By Rating (High to Low)");
		            System.out.println("2. Sort By Name (A to Z)");

		            int sortChoice = sc.nextInt();

		            if(sortChoice == 1) {
		                dao.sortByRating();
		            }
		            else if(sortChoice == 2) {
		                dao.sortByName();
		            }

		            break;


		        case 6:
	                System.out.println("1. Filter By Genre");
	                System.out.println("2. Filter By Rating > Value");

	                int filterChoice = sc.nextInt();

	                if(filterChoice == 1) {
	                    System.out.print("Enter Genre: ");
	                    dao.filterByGenre(sc.next());
	                }
	                else if(filterChoice == 2) {
	                    System.out.print("Enter Rating Value: ");
	                    dao.filterByRating(sc.nextDouble());
	                }
	                
	                break;
	                
		        case 7:
		            System.out.print("Enter ID: ");
		            dao.deleteMovie(sc.nextInt());
		            break;

		        case 8:
//		            System.exit(0);
		        	return;

		            
		        default:
	                System.out.println("Invalid Choice");
		    }
		}
	}
}

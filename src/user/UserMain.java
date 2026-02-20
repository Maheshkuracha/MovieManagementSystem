package user;

import moviemanagement.MovieMain;
import java.util.Scanner;

public class UserMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UserDAO userDao = new UserDaoImplementation();

        while(true) {   

            System.out.println("\n===== USER MENU =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            int option = sc.nextInt();
            sc.nextLine();

            if(option == 1) {

                System.out.print("Enter Username: ");
                String username = sc.nextLine();

                System.out.print("Enter Password: ");
                String password = sc.nextLine();

                userDao.registerUser(username, password);

                System.out.println("Registration Done! Back to Menu...");
            }

            else if(option == 2) {

                System.out.print("Enter Username: ");
                String username = sc.nextLine();

                System.out.print("Enter Password: ");
                String password = sc.nextLine();

                boolean login = userDao.loginUser(username, password);

                if(login) {
                    System.out.println("Login Success");

                    MovieMain.startMovieMenu();
                }
                else {
                    System.out.println("Invalid Username or Password");
                }
            }

            else if(option == 3) {
                System.out.println("Thank You!");
                System.exit(0);
            }

            else {
                System.out.println("Invalid Option");
            }
        }
    }
}

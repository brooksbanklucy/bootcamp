import java.io.BufferedReader;  // Used for reading text from a character-based input stream.
import java.io.FileNotFoundException;
import java.io.FileReader;       // Makes it possible to read the contents of a file.
import java.io.IOException;      // Used to handle exceptions thrown by input/output operations.
import java.util.ArrayList;      // A resisable array, used to store the movies.
import java.util.InputMismatchException;
import java.util.Scanner;        // Used to read the user's input from the terminal.
import java.util.regex.Matcher;  // An engine that performs match operations on a character sequence by interpreting a Pattern.
import java.util.regex.Pattern;  // Represents a compiled regular expression.


public class Top250Movies {

    private ArrayList<Movie> movies;
    
    public Top250Movies() {
        movies = new ArrayList<Movie> ();
    }

    public static void main(String[] args) {
        Top250Movies app = new Top250Movies();
        String path = System.getProperty("user.dir");
        path += "/Downloads/top250movies.txt";
        app.loadMovies(path);
        app.handleUserInput();
    }

    private void loadMovies(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int lineNum = 1;
            while ((line = br.readLine()) != null) {
                    int rank = lineNum;
                    String name = line;
                    movies.add(new Movie(rank, name));
                    lineNum++;
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading from the file.");
            e.printStackTrace();
        }
    }

    private void handleUserInput() {
        System.out.println("Here are your 2 options \n Option 1. Display ranking of top 250 movies  \n Option 2. Search movie list using RegEx \n Please input 1 or 2:");
        Scanner in = new Scanner(System.in);
        String userIn;
        try {
            userIn = in.nextLine();
            switch(userIn){
            case "1":
                    try {
                        displayRankedMovies();
                    } catch (FileNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                break;

            case "2":
                System.out.println("please input the RegEx pattern");
                Scanner patScanner = new Scanner(System.in);
                try {
                    String userPatternStr = patScanner.nextLine();
                    searchWithRegex(userPatternStr);
                } catch (InputMismatchException a) {
                    System.out.println(a);
                }
            
                break;

            default:
                    try {
                        displayRankedMovies();
                    } catch (FileNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                break;
            }
        } catch (InputMismatchException a) {
            System.out.print(a);
        }
        in.close();
    }

    private void displayRankedMovies() throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("top250movies.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
         }
    }

    private void searchWithRegex(String patternStr) {
        for (Movie m : movies) {
            Pattern pattern = Pattern.compile(patternStr);
            Matcher matcher = pattern.matcher(m.toString());
            if(matcher.find()) {
                System.out.println(m.rank + ". " + m.name); 
            }  
        }
    }

    private static class Movie {
        private int rank;
        private String name;

        public Movie(int rank, String name) {
            // Initialize rank and name
            this.rank = rank;
            this.name = name;
        }

        @Override
        public String toString() {
            return rank + ". " + name;
        }
    }
}
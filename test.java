import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class test {

    public static void main(String args[]){
        ArrayList <Sandwich> sandwiches = new ArrayList<>();
        sandwiches.add(new Sandwich("Tuna",9)); 
        sandwiches.add(new Sandwich("Ham",4)); 
        sandwiches.add(new Sandwich("Cheese",4)); 
        
        Collections.sort(sandwiches);
        Iterator<Sandwich> iterator = sandwiches.iterator(); // Creating the second iterator
        while (iterator.hasNext()) {
            Sandwich element = iterator.next(); // Getting the next element
            System.out.println(element.getType() + " " + element.getRating() + "/10");
        }
    }
}
     class Sandwich implements Comparable<Sandwich> {
        private String type;
        private int rating;

        public Sandwich(String type, int rating) {
            this.type = type;
            this.rating = rating;
        }
        public String getType() {
            return type;
        }

        public int getRating() {
            return rating;
        }

        @Override
        public int compareTo(Sandwich o) {
            return this.type.compareTo(o.type); // Sorting by type
        }
    } 





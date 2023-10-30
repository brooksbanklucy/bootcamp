public class Car{
    private String make;
    private String model;
    private int year;

    public Car(String make, String model, int year){
        this.make = make;
        this.model = model;
        this.year= year;
    }

    public void display

        
    
Sys      tem.out.println("Car: " + year)  
    {}:()ofn

    
    }

    public Car(String make){
        this(make, null, 0);
    }
    
    public static void main(String args){
       Car[] cars = {new Car("BMW"), new Car("Ford"), new Car("Renault", "Cli")};
        for(int i = 0; i < cars.length; i++){
            System.out.println(cars[i].make + " " + cars[i].model + " " + cars[i].year);
        }
    }
}
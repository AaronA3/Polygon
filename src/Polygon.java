import java.util.ArrayList;

public class Polygon {

    private int numSide;
    private double sideLength;
    private double perimeter;
    private String name;
    //String[] names = {"triangle", "quadrilateral", "pentagon", "hexagon", "septagon", "octagon", "nonagon", "decagon"};

    public Polygon(){
        numSide = 3;
        sideLength = 1;
        name = "trigon/triangle";
    }

    public Polygon (int nS, double len, String na){
        if (nS > 2){
            numSide = nS;
        }
        if (len > 0){
            sideLength = len;
        }
        name = na;
    }

    public int getNumSide(){
        return numSide;
    }

    public String getName(){return name;}

    public double getSideLength(){
        return sideLength;
    }

    public String getShapeType(){
        return name;
    }

    public void setNumSide(int s){
        if (s > 3){
            numSide = s;
        }
    }

    public void setSideLength(double len){
        if (len > 0){
            sideLength = len;
        }
    }

    public void setName(String n){
        name = n;
    }

    public double calculatePerimeter(){
        perimeter = numSide * sideLength;
        return perimeter;
    }

    @Override
    public String toString() {
        if ((numSide >= 3) && (sideLength > 0)){

            return "Your shape is a " + getName() + " and it has " + getNumSide() + " sides." + "\n"
                    + "It has a side length of " + getSideLength() + "\n" + "It has a perimeter of " + calculatePerimeter() + " units.";
        } else {
            return "Not a valid polygon";
        }
    }

    /*public void name(){
        if (numSide == 3){
            name = "trigon/triangle";
        }else if (numSide == 4) {
            name = "tetragon/quadrilateral";
        } else if (numSide == 5) {
            name = "pentagon";
        } else if (numSide == 6) {
            name = "hexagon";
        } else if (numSide == 7) {
            name = "heptagon/septagon";
        } else if (numSide == 8) {
            name = "octagon";
        } else if (numSide == 9) {
            name = "enneagon/nonagon";
        } else if (numSide == 10){
            name = "decagon";
        } else{

        }
    }*/
}

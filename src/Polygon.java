import java.util.ArrayList;

/**
 * @file Polygon.java
 * @date 2/6/2023
 * @author Aaron Abrahamsen
 *
 * @description Creates a Polygon with a number of sides and side length or a triangle with side length.
 * The user can also calculate the perimeter and area of the Polygon and
 * print information about the Polygon.
 */
public class Polygon {

    private int numSide;
    private double sideLength;
    private double perimeter;
    private double area;
    private String name;
    private String[] names = {"Triangle", "Square", "Pentagon", "Hexagon", "septagon", "octagon", "nonagon",
            "decagon", "hendecagon", "dodecagon", "tridecagon", "tetradecagon", "pentadecagon", "hexadecagon"};
    private boolean isPolygon = false;

    //constructors

    public Polygon(){
        numSide = 3;
        sideLength = 1;
        name = "Triangle";
        isPolygon = true;
    }

    /**
     * Creates a Polygon object with specified number of sides and side length.
     * If the Number os sides are greater less than 2 and/or the side length is not greater than 0,
     * they are set to set number of sides to 3 and side length to 1
     *
     * @param nS number of sides on Polygon
     * @param len length of side on Polygon
     * @param na name of the Polygon
     */
    public Polygon (int nS, double len, String na){
        isPolygon(nS,len);
        if (isPolygon){
            sideLength = len;
            numSide = nS;
            setShapeName(na);
        } else {
            numSide = 3;
            sideLength = 1.0;
            name = "Triangle";
        }

    }

    /**
     * @description Checks if the polygon is a valid polygon
     *
     * @return boolean isPolygon
     */
    public boolean isPolygon (int nS, double sL){
        if ((nS > 2) && (sL > 0)){
            isPolygon = true;
        }else{
            isPolygon = false;
        }
        return isPolygon;
    }

    //accessors

    /**
     *
     * @return the area of the Polygon
     */
    public double getArea() {
        calculateArea();
        return area;
    }

    /**
     *
     * @return the perimeter of the Polygon
     */
    public double getPerimeter(){
        calculatePerimeter();
        return perimeter;
    }

    /**
     *
     * @return the number of sides of the Polygon
     */
    public int getNumSides(){
        return numSide;
    }

    /**
     *
     * @return the name of the Polygon
     */
    public String getName(){
        return name;
    }

    /**
     *
     * @return the side length of the Polygon
     */
    public double getSideLength(){
        return sideLength;
    }

    /**
     *
     * @return the name of the Polygon
     */
    public String getShapeType(){
        return name;
    }

    //setters

    /**
     * @description Modifies the number of sides
     * @param s
     */
    public void setNumSides(int s){
        if (s > 3){
            numSide = s;
        }
    }

    /**
     * @description Modifies the side length
     * @param len
     */
    public void setSideLength(double len){
        if (len > 0){
            sideLength = len;
        }
    }


    /**
     * @description Modifies the name of the polygon using an array list
     *
     * @param na name if number of sides is not in array list
     */
    public void setShapeName(String na){
        if ((numSide > 2) && (numSide < 14)){
            name = names[numSide-3];
        } else {
            name = na;
        }

    }

    //calculators

    /**
     * @description Calculates the perimeter of the polygon
     */
    public double calculatePerimeter(){
        perimeter = numSide * sideLength;
        perimeter = (double) Math.round(perimeter * 1000) / 1000;
        return (double) Math.round(perimeter * 1000) / 1000;
    }

    /**
     * @description Calculates the area of the polygon
     */
    public double calculateArea(){
        double nS = (double)numSide;
        double hSL = sideLength / 2;
        double angle = 360.0 / (2.0 * nS);
        double radian = Math.toRadians(angle);
        double line = hSL / (Math.tan(radian));
        double sliceArea = (hSL * line);
        double rounded = nS * sliceArea;
        area = (double) Math.round(rounded * 1000) / 1000;
        return (double) Math.round(rounded * 1000) / 1000;
    }

    //toString method

    /**
     *  @description Prints the name, number of sides, the side length, perimeter, and area if polygon is a
     *  valid polygon. If not a valid polygon will print out default values
     */
    @Override
    public String toString() {
        if (isPolygon){

            return "Your shape is a " + getName() + " and it has " + getNumSides() + " sides." + "\n"
                    + "It has a side length of " + getSideLength() + "\n" + "It has a perimeter of " +
                    calculateArea() + " units."+ "\n" + "It has a area of " + calculatePerimeter() + " units";
        } else {
            return "Your polygon was given a default of " + getNumSides() +" sides , was named \"" + getName() +"\" " +
                    ", and each side has a length of " + getSideLength() + " units" + "\n" + "\n" +
                    "Your shape is a " + getName() + " and it has " + getNumSides() + " sides." + "\n"
                    + "It has a side length of " + getSideLength() + "\n" + "It has a perimeter of " +
                    calculateArea() + " units."+ "\n" + "It has a area of " + calculatePerimeter() + " units";
        }
    }
}
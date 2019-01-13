/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE401;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author turki
 */
public class Vehicle {

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public int getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(int currentDirection) {
        this.currentDirection = currentDirection;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public static int getHighestVIN() {
        return highestVIN;
    }

    public static void setHighestVIN(int highestVIN) {
        Vehicle.highestVIN = highestVIN;
    }

    public int getVIN() {
        return VIN;
    }

    public void setVIN(int VIN) {
        this.VIN = VIN;
    }

    public String toString() {
        return "The radar reports: VIN " + VIN
                + " owned by " + owner
                + " heading " + currentDirection
                + " (degrees) "
                + " at a speed of " + currentSpeed;
    }

    void changeSpeed(int newSpeed) {
        currentSpeed = newSpeed;
    }

    void stop() {
        currentSpeed = 0;
    }

    void setDirection(int newDirection) {
        currentDirection = newDirection % 360;
    }

    private int currentSpeed;
    private int currentDirection;
    private String owner;
    private static int highestVIN;
    private int VIN;
    static final String TURN_LEFT = "Turn left";
    static final String TURN_RIGHT = "Turn right";

    void turn(int degrees) {
        currentDirection = (currentDirection + degrees) % 360;
    }

    void turn(String direction) {
        if (direction.equals("left")) {
            currentDirection = (currentDirection + 90) % 360;
        } else { //default
            currentDirection = (currentDirection - 90) % 360;
        }
    }

    public Vehicle() {
        VIN = highestVIN++;
    }

    public Vehicle(String owner) {
        this();
        this.owner = owner;

    }
    public static boolean lettersOnly(String input) {
        if (input == null) {
            return false;
        } else if (input.length() > 50) {
            return false;
        } else {
            return Pattern.matches("[a-zA-Z]+", input);
        }
    }

    public static void main(String[] args) {
//        Vehicle a = new Vehicle();
//        a.VIN = highestVIN++;
//        a.owner = "Larry Bird";
//
//        Vehicle b = new Vehicle("Mark Jackson");
//        System.out.println("VIN: " + a.VIN + " belongs to " + a.owner);
//        System.out.println("VIN: " + b.VIN + " belongs to " + b.owner);
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the first side: \n");
        String name = s.next();
        while (true) {
            if (!lettersOnly(name)) {
                System.out.println("The value is invalid, enter only nubmers.\n");
                name = s.next();
            } else {
                break;
            }
            Vehicle a = new Vehicle(name);
        }

    }

}

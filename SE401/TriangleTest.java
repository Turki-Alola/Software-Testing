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
public class TriangleTest {

    public static boolean numsOnly(String input) {
        if (input == null) {
            return false;
        } else if (input.length() > 50) {
            return false;
        } else {
            return Pattern.matches("[1-9]+", input);
        }
    }

    static Triangle t1;

    public static void main(String[] args) {
//        System.out.println(t1);
//        System.out.println(t1.isEquilateral());
//        System.out.println(t1.isIsosceles());
//        System.out.println(t1.isRight());
//        System.out.println(t1.isScalene());
//        System.out.println(t1.isTriangle());
        Scanner s = new Scanner(System.in);
        String sideA;
        String sideB;
        String sideC;
        System.out.println("Enter the first side: \n");
        sideA = s.next();
        while (true) {
            if (!numsOnly(sideA)) {
                System.out.println("The value is invalid, enter only nubmers.\n");
                sideA = s.next();
            } else {
                break;
            }
        }
        System.out.println("Enter the second side: \n");
        sideB = s.next();
        while (true) {
            if (!numsOnly(sideB)) {
                System.out.println("The value is invalid, enter only nubmers.\n");
                sideB = s.next();
            } else {
                break;
            }
        }

        System.out.println("Enter the third side: \n");
        sideC = s.next();
        while (true) {
            if (!numsOnly(sideC)) {
                System.out.println("The value is invalid, enter only nubmers.\n");
                sideC = s.next();
            } else {
                break;
            }
        }

        t1 = new Triangle(Integer.parseInt(sideA), Integer.parseInt(sideB), Integer.parseInt(sideC));
        System.out.println(t1);
        System.out.println(t1.isEquilateral());
        System.out.println(t1.isIsosceles());
        System.out.println(t1.isRight());
        System.out.println(t1.isScalene());
        System.out.println(t1.isTriangle());

    }
}

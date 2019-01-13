package SE401;

import static SE401.TriangleTest.numsOnly;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Fraction {

    private int num;    // numerator 
    private int denom;  // denominator 

    public Fraction(int n, int d) {
        int g;
        if (d == 0) {
            System.out.println("Fraction: fraction "
                    + "with 0 denominator?");
            System.exit(1);
        }
        if (n == 0) {
            num = 0;
            denom = 1;
        } else {
            if (d < 0) {
                n = -n;
                d = -d;
            }
            if ((g = gcd(n, d)) != 1) { // remove gcd
                n /= g;
                d /= g;
            }
            num = n;
            denom = d;
        }
    }

    private int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0) {
            return b; // 0 is error value 
        }
        if (b == 0) {
            return a;
        }
        int t;
        while (b > 0) {
            t = a % b; // take "-" to the extreme 
            a = b;
            b = t;
        }
        return a;
    }

    public boolean isZero() {
        return (denom == 1 && num == 0);
    }

    public boolean isInt() {
        return (denom == 1);
    }

    public boolean equals(Fraction y) {
        return (num == y.num && denom == y.denom);
    }

    public boolean greaterThan(Fraction y) {
        return (num * y.denom > denom * y.num);
    }

    public Fraction minus(Fraction y) {
        return new Fraction(
                num * y.denom - y.num * denom,
                denom * y.denom
        );
    }

    public Fraction plus(Fraction y) {
        return new Fraction(
                num * y.denom + y.num * denom,
                denom * y.denom
        );
    }

    public Fraction times(Fraction y) {
        return new Fraction(num * y.num, denom * y.denom);
    }

    public Fraction dividedBy(Fraction y) {
        return new Fraction(num * y.denom, denom * y.num);
    }

    public static boolean numsOnly(String input) {
        if (input == null) {
            return false;
        } else if (input.length() > 50) {
            return false;
        } else {
            return Pattern.matches("[0-9]+", input);
        }
    }

    public String toString() {
        return "Fraction: " + num + "/" + denom;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a num");
        String num = s.next();
        while (true) {
            if (!numsOnly(num)) {
                System.out.println("Invalid num, please use numbers only\n");
                num = s.next();
            } else {
                break;
            }
        }
        System.out.println("Enter a denom");
        String denom = s.next();
        while (true) {
            if (!numsOnly(denom)) {
                System.out.println("Invalid denom, please use numbers only.");
                denom = s.next();
                
            } else if (Integer.parseInt(denom) < 0) {
                System.out.println("The denom cant be less than zero. ");
            } else {
                break;
            }
        }
        Fraction f = new Fraction(Integer.parseInt(num), Integer.parseInt(denom));
        System.out.println(f.toString());

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SE401;

class Triangle {
  int sideA, sideB, sideC; 

  Triangle (int a, int b, int c) { // constructor 
    sideA = a; sideB = b; sideC = c; 
  } // negative numbers and zero lengths accepted 
    // but see how isTriangle() used below

  public boolean isTriangle () {
    int max = Math.max(Math.max(sideA, sideB), sideC); 
    return sideA > 0 && sideB > 0 && sideC > 0 &&
           (max < sideA + sideB + sideC - max); 
  }
  public boolean isRight() {
    int max = Math.max(Math.max(sideA, sideB), sideC);     
    return isTriangle() &&
           (max * max) == (sideA * sideA) + 
                          (sideB * sideB) + 
                          (sideC * sideC) - 
                          (max * max);
  } 
  public boolean isScalene() {
    return isTriangle() &&
           ! isIsosceles(); // we get some peer help 
  }
  public boolean isIsosceles() {
    return isTriangle() &&
           (sideA == sideB || 
            sideA == sideC || 
            sideB == sideC); 
  }   
  public boolean isEquilateral() {
    return isTriangle() && 
           (sideA == sideB && sideA == sideC); 
  }
  public static void main(String[] args) {
    Triangle a, b, c; 
    a = new Triangle( 3,  4,  5); 
    b = new Triangle( 0,  0, -1); 
    c = new Triangle( 6,  6,  6); 
    System.out.println(
      a + " isosceles? Answer: " + a.isIsosceles()
    );     
    System.out.println(
      a + " right? Answer: "     + a.isRight()
    );     
    System.out.println(
      c + " isosceles? Answer: " + c.isIsosceles()
    );     
    System.out.println(
      c + " scalene? Answer: "   + c.isScalene()
    );     
  } 
  @Override
  public String toString() {
     return "Triangle: (" + sideA + ", " 
                    + sideB + ", " 
                    + sideC + 
                ") ";  
     
  } 
}

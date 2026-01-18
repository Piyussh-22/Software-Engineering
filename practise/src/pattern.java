/*
1. no of lines = no of rows = no of times the outer loop will run
2. identify for every row number , how many cols are there and type of element in cols
3. what do you need to print.
4. try to find the formula for rows and cols.
 */
public class pattern {
    public static void main(String[] args){
        pattern2(5);
    }
    static void square(int n){
        for (int row = 1 ; row <= n ; row++) {
            for (int col = 1; col <= n ; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern2(int n){
        for (int rows = 1 ; rows <= n ; rows++) {
            for (int cols = 1; cols <= rows ; cols++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern3(int n){
        for (int rows = 0; rows < n ; rows++) {
            for (int cols = 0 ; cols < (n-rows) ; cols++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern4(int n){
        for(int rows = 1 ; rows <= n ; rows++){
            for(int cols = 1 ; cols <= rows ; cols++){
                System.out.print(cols+" ");
            }
            System.out.println();
        }
    }

    static void b2bomber(int n){
        for(int rows = 1 ; rows <= 2*n-1 ; rows++){
            if(rows <= n){
                for (int cols = 1; cols <= rows ; cols++) {
                    System.out.print("*");
                }
            }else {
                for (int cols = 1; cols <= 2*n-rows ; cols++) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }

    static void pattern6(int n){
        for (int rows = 1; rows <= n ; rows++) {
            for (int gap = 1 ; gap <= n-rows ; gap++) {
                System.out.print(" ");
            }
            for (int cols = 1 ; cols <= rows ; cols++){
                System.out.print("*");
            }
            System.out.println();
        }

    }

    static void pattern7(int n){
        for(int rows = 1 ; rows <= n ; rows++){
            for(int gap = 1 ; gap <= rows-1 ; gap++){
                System.out.print(" ");
            }
            for(int cols = 1 ; cols <= n-rows+1 ; cols++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pyramid(int n){
        for(int rows = 1 ; rows <= n ; rows++){
            for (int gap = 1; gap <= n-rows ; gap++) {
                System.out.print(" ");
            }
            for (int star = 1; star <= 2*rows-1 ; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void reversePyramid(int n){
        for (int rows = 1; rows <= n ; rows++) {
            for (int gap = 1; gap <= rows-1 ; gap++) {
                System.out.print(" ");
            }
            for (int star = 1; star <= 2*n-(2*rows-1) ; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
        //stars = 2*(n - rows) + 1
    }



}


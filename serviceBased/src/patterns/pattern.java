package patterns;

/*
1. no of lines = no of rows = no of times the outer loop will run
2. identify for every row number , how many cols are there and type of element in cols
3. what do you need to print.
4. try to find the formula for rows and cols.

PATTERN ATTACK STRATEGY (3–4 LINES)
Outer loop = number of lines
Think row-wise → for each row decide spaces first,
then stars/numbers
First half grows, second half shrinks (for diamond/kite)

Change print statement, not loops
 */
public class pattern {
    public static void main(String[] args){
        numberKite(5);
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

    static void kite(int n){
        for(int rows = 1 ; rows <= (2*n)-1 ; rows++) {
            if(rows <= n){
                for (int gap = 1; gap <= n-rows ; gap++) {
                    System.out.print(" ");
                }
            }else {
                for (int gap = 1; gap <= rows-n ; gap++) {
                    System.out.print(" ");
                }
            }
            if(rows <= n) {
                for (int star = 1; star <= rows; star++) {
                    System.out.print("* ");
                }
            }else{
                for (int star = 1; star <= 2*n-rows; star++) {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    static void kiteMethod2(int n ){
        // calculate star and space
        for (int rows = 1; rows <= 2*n-1 ; rows++) {
            int NoOfSpace = rows <= n ? n-rows : rows-n;
            int NoOfStar = rows <= n ? rows : 2*n-rows;
            for (int space = 1; space <= NoOfSpace ; space++) {
                System.out.print(" ");
            }
            for (int star = 1; star <= NoOfStar ; star++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void b2bomber2(int n) {
        for (int rows = 1; rows <= 2 * n - 1; rows++) {

            int noOfStar = rows <= n ? rows : 2 * n - rows;
            int noOfGap  = Math.max(0,(2 * n - 1) - 2 * noOfStar);

            for (int star = 1; star <= noOfStar; star++) {
                System.out.print("*");
            }

            for (int gap = 1; gap <= noOfGap; gap++) {
                System.out.print(" ");
            }

            for (int star = 1; star <= noOfStar; star++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    static void numberPyramid(int n){
        for (int rows = 1; rows <= n ; rows++) {
            for (int space = 1; space <=  (n-rows) ; space++) {
                System.out.print("  ");
            }
            for (int number = rows; number >= 1 ; number--) {
                System.out.print(number + " ");
            }
            for (int number = 2; number <= rows; number++) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    static void numberKite(int n){
        for (int rows = 1; rows <= 2*n-1 ; rows++) {

            int val = rows <= n ? rows : 2*n-rows;

            for (int space = 1; space <= n-val; space++) {
                System.out.print(" ");
            }
            for (int col = val; col >= 1 ; col--) {
                System.out.print(col );
            }
            for (int col = 2; col <= val ; col++) {
                System.out.print(col );
            }
            System.out.println();
        }
    }
}


package pattern.recursion;


public class Recursions {

    /*
    When head recursively calls all functions, then after beginning from last function starts execute statements.
    that's why first prints 1 then 2 ... up to 10;
     */

    public static void headRecursion(int n) {
        if (n > 0) {
            headRecursion(n-1);
            System.out.println(n);
        }
    }

    /*
    When tail recursive n prints first and then goes to recursive
     */
    public static void tailRecursion(int n) {
        if (n > 0) {
            //on tail recursion statements executes first then goes recursive calls.
            System.out.println(n);
            tailRecursion(n-1);
        }
    }
    //Tree recursive
    public static void treeRecursive(int n) {
        if (n > 0) {
            //on tail recursion statements executes first then goes recursive calls.
            System.out.println(n);
            treeRecursive(n-1);
            treeRecursive(n-1);
        }
    }


    /*
    Examples solution in recursion:
    1. Sum of first "n" Natural Numbers:
     */
    public static int getNaturalSum(int n) {
        if (n == 0) {
            return 0;
        }
            return getNaturalSum(n-1) + n;
    }
    public static void main(String[] args) {
        headRecursion(3);
        System.out.println("Tail recursive");
        tailRecursion(3);
        System.out.println("Tree recursive");
        treeRecursive(3);
        System.out.println(getNaturalSum(5));
    }




}

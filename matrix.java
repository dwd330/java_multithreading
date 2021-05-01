import java.util.Random;
import java.util.concurrent.*;// Import the muliprocessing  class
import java.util.Scanner;  // Import the Scanner class

public class matrix {

    public static int m=4;//matrix size
    public static int n=3;//matrix size
    public static int p=5;//matrix size

    //define the matrix
    static int[][] A;
    static int[][] B;
    public static int[][] C ;
 
public static void main(String [] args){
    //mxn *nxp  = mxp   >> MATRIX MUL

    Scanner userinput = new Scanner(System.in);  // Create a Scanner object
    System.out.println("Enter frist array size (M):");
    matrix.m= userinput.nextInt();
    System.out.println("Enter frist array size (N):");
    matrix.n= userinput.nextInt();
    System.out.println("Enter second array size (P):");
    matrix.p= userinput.nextInt();

    //Creating the matrix size
    A= new int[m][n];
    B= new int[n][p];
    C= new int[m][p];

    //Creating the object of random class
    Random rand = new Random();

    //Filling A matrix with random values
    for (int i = 0; i < A.length; i++) {
        for (int j = 0; j < A[i].length; j++) {
            A[i][j]=rand.nextInt(10);
        }
    }


    //Filling B matrix with random values
    for (int i = 0; i < B.length; i++) {
        for (int j = 0; j < B[i].length; j++) {
            B[i][j]=rand.nextInt(10);
        }
    }

    //creating a transpose of a matrix B
    int B_transpose[][]=new int[p][n];
    //Code to transpose a matrix  
    for(int i=0;i<p;i++){
    for(int j=0;j<n;j++){

        B_transpose[i][j]=B[j][i];
    }    
    }

    //start to create threads ....
    try{

      // calculate
      for (int i = 0; i < m; i++) //row itertion (m rows)
          for (int j = 0; j < p; j++) {//clum iterion (n clumn)
                //passing array for a and b then posion of c (row,clmn)
               matrix_Mul_func(A[i],B_transpose[j],i,j);
      }

    }catch (Exception e) {
        e.printStackTrace();
    }


    //Printing A matrix
    System.out.println("\n\nA:");
    for (int i = 0; i < A.length; i++) {
        for (int j = 0; j < A[i].length; j++) {
            System.out.print(A[i][j]+" ");
        }
        System.out.println();
    }
//Printing B matrix
    System.out.println("\n\nB:");
    for (int i = 0; i < B.length; i++) {
        for (int j = 0; j < B[i].length; j++) {
            System.out.print(B[i][j]+" ");
        }
        System.out.println();
    }

    //Printing the result
    System.out.println("\n\nResult:");
    for (int i = 0; i < C.length; i++) {
        for (int j = 0; j < C[i].length; j++) {
            System.out.print(C[i][j]+"  ");
        }
        System.out.println();
    }
  }//End main



    public static void matrix_Mul_func(int[] A, int[] B, int row_n, int clm_n)
    {
        try {
                //multiplying and  of 2 matrices
                for(int i=0;i<matrix.n;i++){
                    matrix.C[row_n][clm_n]+= A[i]*B[i];
                }
        }
        catch (Exception e) {
            // Throwing an exception
            System.out.println("Exception is caught");
        }
    }
}


  
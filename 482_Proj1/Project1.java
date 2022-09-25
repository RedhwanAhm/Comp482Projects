import java.io.*;
import java.util.*;

public class Project1 {
    public static void main(String[] args) throws IOException {
        // Declare men, women, and stable matching 2D-arrays, and length variable.
        int[][] mensPreferences;
        int[][] womensPreferences;
        int[][] stableMatching;
        int length;

        // Initialize a Scanner with the input file as its argument.
        File input = new File("input.txt");
        Scanner scan = new Scanner(input);

        // Initialize the declared variables.
        length = scan.nextInt();
        mensPreferences = new int[length][length];
        womensPreferences = new int[length][length];
        stableMatching = new int[length][2];
        scan.nextLine(); // Advance the scanner to the next line...

        /* --------------------------------------------------------------- */
        /* Replace with a method that does this for us. */
        // Populate 2D-Arrays: mensPreferences
        for(int i = 0; i < length; i++) {
            String[] stringSplit = scan.nextLine().split("\\s+");
            for(int j = 0; j < stringSplit.length; j++) {
                mensPreferences[i][j] = Integer.parseInt(stringSplit[j]);
            }
        }

        // Populate 2D-Arrays: womensPreferences
        for(int i = 0; i < length; i++) {
            String[] stringSplit = scan.nextLine().split("\\s+");
            for(int j = 0; j < stringSplit.length; j++) {
                womensPreferences[i][j] = Integer.parseInt(stringSplit[j]);
            }
        }

        // Populate 2D-Arrays: stableMatching
        for(int i = 0; i < length; i++) {
            String[] stringSplit = scan.nextLine().split("\\s+");
            for(int j = 0; j < stringSplit.length; j++) {
                stableMatching[i][j] = Integer.parseInt(stringSplit[j]);
            }
        }
        /* --------------------------------------------------------------- */

        // Stable-Matching Algorithm:
    }

    
}

        // // Testing...
        // System.out.println(length);
        // System.out.println("Mens:");
        // for(int i = 0; i < mensPreferences.length; i++) {
        //     for(int j = 0; j < mensPreferences[i].length; j++) {
        //         System.out.print(mensPreferences[i][j]+" ");
        //     }
        //     System.out.println("");
        // }    

        // System.out.println("Womens:");
        // for(int i = 0; i < womensPreferences.length; i++) {
        //     for(int j = 0; j < womensPreferences[i].length; j++) {
        //         System.out.print(womensPreferences[i][j]+" ");
        //     }
        //     System.out.println("");
        // }    

        // System.out.println("Pairing:");
        // for(int i = 0; i < stableMatching.length; i++) {
        //     for(int j = 0; j < stableMatching[i].length; j++) {
        //         System.out.print(stableMatching[i][j]+" ");
        //     }
        //     System.out.println("");
        // }    

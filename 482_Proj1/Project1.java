/*
 * Redhwan Ahmed
 * Project 1: Checking Stability
 * COMP 482 | Professor John Noga
*/

import java.io.*;
import java.util.*;

public class Project1 {
    public static void main(String[] args) throws IOException {
        // Declare men, women, and stable matching 2D-arrays, and length variable.
        int[][] mensPreferences;
        int[][] womensPreferences;
        int[] stableMatching;
        int length;
        int changes = 0;
        boolean stable = false;

        // Initialize a Scanner with the input file as its argument.
        File input = new File("input.txt");
        Scanner scan = new Scanner(input);

        // Initialize the declared variables.
        length = scan.nextInt();
        mensPreferences = new int[length][length];
        womensPreferences = new int[length][length];
        stableMatching = new int[length];
        scan.nextLine(); // Advance the scanner to the next line...

        /*---------------------------------------------------------------*/
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
            stableMatching[i] = Integer.parseInt(stringSplit[1]);
        }
        /*---------------------------------------------------------------*/

        // Stable-Matching Algorithm:
        while(!stable && changes < 100) {
            stable = isStable(mensPreferences, womensPreferences, stableMatching );
            changes++; // Iterate the counter so the loop ends after 100 iterations.
        }
        System.out.println(changes);
        for(int i = 0; i < stableMatching.length; i++) {
            System.out.println((i+1)+" "+stableMatching[i]);
        }    


        
    }

    public static boolean isStable(int[][] men, int[][] women, int[] matching) {
        for(int i = 0; i < men.length; i++) { //int i can be used for men index on both matching and men arrays.
            int manPartner = matching[i]; // finds the woman who man 'i' is currently with.
            int manPartnerIndex = findIndex(men[i], manPartner); // Find the index of man 'i's partner.
            for(int j = 0; j <= manPartnerIndex; j++) { // iterate through the mans array until the partner index is met.
                
                for(int k = 0; k < matching.length; k++) { // this is for checking the matches
                    if(matching[k] == men[i][j]) { // this will find if the the woman in the matching array is the same in the men array.
                        int currentPartnerW = findIndex(matching, matching[k]);
                        int currentPartnerWIndex = findIndex(women[j], currentPartnerW);
                        if(partnerExists(women[j], currentPartnerWIndex, manPartner)) {
                            int temp = matching[manPartner-1]-1;
                            matching[temp] = men[i][j];
                            matching[currentPartnerW] = temp;
                            return false;
                        }
                    }
                }
            }

        }
        return true;
    }

    // To find the index of a specific element in an array.
    public static int findIndex(int[] list, int element) {
        for(int i = 0; i < list.length; i++) {
            if (list[i] == element)
                return i;
        }
        return -1;
    }

    // To see if partner exists
    public static boolean partnerExists(int[] list, int bound,  int person) {
        for (int i = 0; i < bound; i++) {
            if (list[i] == person) 
                return true;
        }
        return false;
    }


        // public static boolean checkStableMatchingEqual(int[][] arr1, int[][] arr2) {
        //     for(int i = 0; i < arr1.length; i++) {
        //         for (int j = 0; j < arr1[i].length; j++) {
        //             if(arr1[i][j] != arr2[i][j]){
        //                 return false;
        //             }
        //         }
        //     }
        //     return true;
        // }

    
}
        // int[] tempStableMatching = new int[length]; // for running the stable matching algorithm
        // int[] manIndices = new int[length]; // for handling where we are in the mensPreferences array
        // int[] womanIndices = new int[length]; // for handling where we are in the womensPreferences array
        // // Fill the arrays with 0's as placeholder values
        // Arrays.fill(tempStableMatching, 0); 

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
        //     System.out.println(stableMatching[i]);
        // }    


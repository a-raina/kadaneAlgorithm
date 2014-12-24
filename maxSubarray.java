/**
 * Created by Anmol on 12/23/2014.
 * Given an array of integers, the goal is to efficiently find the subarray that has the greatest value when
 * all of its elements are summed together.
 * Implementation of Kadane's Algorithm
 */
import java.util.*;

public class maxSubarray {
    static int[] mainArray, subArray;
    static int startIndex = 0, endIndex = 0;

    public static void inputToIntArray(String userArray){
        String[] tempArray = userArray.split(" ");
        mainArray = new int[tempArray.length];
        for(int i = 0; i<tempArray.length; i++){
            mainArray[i] = Integer.parseInt(tempArray[i]);
        }
    }

    public static void kadaneAlgorithm(){
        int tempStartIndex = 0;
        int sumYet = mainArray[0], maxTotal = mainArray[0];
        for(int i=1; i<mainArray.length; i++){
            if(mainArray[i] >= 0){
                if(sumYet < 0){
                    sumYet = 0;
                    tempStartIndex = i;
                }
                sumYet = sumYet + mainArray[i];

            }
            if(mainArray[i] < 0){
                if(sumYet < 0) {
                    if (sumYet < mainArray[i]) {
                        sumYet = mainArray[i];
                        tempStartIndex = i;
                    }
                }
                else{
                    sumYet = mainArray[i];
                    tempStartIndex = i;
                }
            }
            if(sumYet>maxTotal){
                maxTotal = sumYet;
                endIndex = i;
            }
            if(tempStartIndex <= endIndex){
                startIndex = tempStartIndex;
            }
        }
    }

    public static void getSubArray(){
        if(startIndex == endIndex){
            subArray = new int[1];
            subArray[0] = mainArray[startIndex];
            System.out.print("Desired Subarray: {" + subArray[0] + "}");
        }
        else {
            subArray = new int[(endIndex - startIndex) + 1];
            System.out.print("Desired Subarray: {");
            for (int j = 0,i = startIndex; i <= endIndex; j++,i++) {
                subArray[j] = mainArray[i];
                System.out.print(subArray[j] + ",");
            }
            System.out.println("}");
        }
    }

    public static void main(String[] args){
        System.out.println("Please enter the array: ");
        Scanner input = new Scanner(System.in);
        String userArray = input.nextLine();
        inputToIntArray(userArray);
        kadaneAlgorithm();
        getSubArray();
    }
}

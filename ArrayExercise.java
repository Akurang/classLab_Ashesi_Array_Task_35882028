import java.util.Arrays;
import java.util.Scanner;

public class ArrayExercise {
    public static void main (String[] args){
        int[] myArray = {2,5,8,3,4,6,10,15,20,1,11};
        Scanner input = new Scanner(System.in);
        
        // TASK 1
        int indexValue = 0;

        System.out.println("Enter a value from array");
        int value = input.nextInt();

        for(int i = 0; i < myArray.length; i++){
            if (myArray[i] == value){
                indexValue = i;
                break;
            }
        }        
        System.out.println("Index value of " + value + " is " + indexValue);


        // TASK 2

        int temp = myArray[5];
        myArray[5] = myArray[6];
        myArray[6] = temp;

        System.out.println("Swapped values :" + Arrays.toString(myArray));



        //TASK 3

        // ascending order

        int[] ascendingArray = Arrays.copyOf(myArray, myArray.length);

        for(int i = 0; i < ascendingArray.length - 1; i++){
            for(int j = 0; j < ascendingArray.length - i - 1; j++){
                if(ascendingArray[j] > ascendingArray[j + 1]){
                    int tempValue = ascendingArray[j];
                    ascendingArray[j] = ascendingArray[j + 1];
                    ascendingArray[j + 1] = tempValue;
                }
            }
        }

        System.out.println("Ascending order: " + Arrays.toString(ascendingArray));


        // Descending order - reverse the ascending array
        int[] descendingArray = new int[ascendingArray.length];
        for(int i = 0; i < ascendingArray.length; i++){
            descendingArray[i] = ascendingArray[ascendingArray.length - 1 - i];
        }

        System.out.println("Descending order: " + Arrays.toString(descendingArray));


        // TASK 4

        System.out.println("Enter a value to search");
        int linearSearchValue = input.nextInt();
        
        int linearResult = -1;
        for(int i = 0; i < myArray.length; i++){
            if(myArray[i] == linearSearchValue){
                linearResult = i;
                break;
            }
        }

        if(linearResult != -1){
            System.out.println("Linear Search: " + linearSearchValue + " found at index " + linearResult);
        } else {
            System.out.println("Linear Search: " + linearSearchValue + " not found");
        }

        // TASK 5: Binary Search (using the sorted array from Task 3)
        System.out.println("\nBinary Search:");
        System.out.println("Enter a value to search:");
        int binarySearchValue = input.nextInt();
        
    
        int low = 0;
        int high = ascendingArray.length - 1;
        int result = -1;
        
        while(low <= high){
            int mid = (low + high) / 2;
            
            if(ascendingArray[mid] == binarySearchValue){
                result = mid;
                break;
            }
            else if(ascendingArray[mid] < binarySearchValue){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        
        if(result != -1){
            System.out.println(binarySearchValue + " found at index " + result);
        } else {
            System.out.println(binarySearchValue + " not found in array");
        }
        
        input.close();
    }



    
}

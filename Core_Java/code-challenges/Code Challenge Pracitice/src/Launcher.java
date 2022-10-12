import java.util.Locale;

public class Launcher {

    public static void main(String[] args) {

        System.out.println("(Reverse a String)=========================");

        //This is assuming you aren't allowed to put the String into a StringBuilder and use .reverse()

        String s = "Hey I'm a String";

        String s2 = "";

        for(int i = s.length() - 1; i >= 0; i--){
            char temp = s.charAt(i);
            s2 += temp;
        }

        System.out.println(s);
        System.out.println(s2);

        System.out.println("(Detect a Palindrome)=======================");

        //if you can reverse a String, you can detect a palindrome

        String pal = "racecar";

        boolean palCheck = false; //false by default, for no particular reason

        String tempString = ""; //temporary String to hold the reversed String

        //Algorithm to check for palindrome
        //basically reverses a String like we did before...
        for(int i = pal.length() - 1; i >= 0; i--){
            char c = pal.charAt(i);
            tempString += c;
        }

        //THEN, we check if the reversed String.equals(the original String)
        if(tempString.equals(pal)){
            System.out.println(pal + " is a palindrome!");
        }

        System.out.println("(Sort an Array)=============================");

        //In this case I want to sort least to greatest. You could be asked the opposite.
        //for this, we'll use the classic "bubble sort"
        //in a bubble sort, the appropriate values "bubble up" to the top of the Data Structure

        //and yes... you can use Arrays.sort, which is obviously preferable.
        //but I've seen it 50/50 on whether it's allowed.

        int[] numbers = {4,2,6,1,6,30,522,7,13};

        //boolean that will check if a number was swapped while sorting
        //set to true so that the while loop will enter in the first place
        boolean numberSwapped = true;

        //the while loop will break when the array is iterated through without any swaps
        while(numberSwapped) {

            numberSwapped = false; //going to set this back to true in the if statement

            //why .length - 1? because we're always going to be comparing two numbers.
            //there's no reason to look at the last number alone, so we can skip the unnecessary iteration
            for(int i = 0; i < numbers.length - 1; i++){

                //if this number is greater than the number after it... swap them!
                if (numbers[i] > numbers[i + 1]) {
                    numberSwapped = true;
                    //swapping two elements - a classic coding problem with a classic solution
                    //it's very helpful to create a temporary variable for this
                    int temp = numbers[i];
                    numbers[i] = numbers[i + 1]; //the first element is now equal to the second element
                    numbers[i + 1] = temp; //the second element is new equal to what the first element was
                }
            }

        } //end of while loop containing our bubble sort

        //iterate through again, just to see the new order
        for(int i : numbers) {
            System.out.println(i);
        }

        System.out.println("(find the nth largest element in an Array)=================");

        //This is an easy addition to the problem above.
        //We would have to sort an Array, so I'll use the previously sorted numbers array

        //assume you're asked to find the third largest number in the Array
        //it's sorted least to greatest, so we just need the 3rd from last element

        int i = numbers.length - 1; //remember, -1 because of zero indexing.

        int thirdLargest = numbers[i-2]; //grab two elements before the last element (3rd to last)

        System.out.println("Third largest number: " + thirdLargest);


        /*Some others I've seen which I encourage you to try or look up:

        -Sort a String alphabetically (you can use > or < here like with ints)
        -Find the average length of Strings in an Array (make a new array of the .lengths(), average them)
        -Multiply every element in an int array, except for one index (for loop with if statement)
        -Write a method to check if a String has vowels (either a switch statement or regex)

         */
    }
}

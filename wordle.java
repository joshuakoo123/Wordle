import java.util.Scanner;
public class Wordle
{
    static Scanner input = new Scanner(System.in);
    final static String wordleoftheday = "FIRES";
    static String[] solution = new String[] {" ", " ", " ", " ", " "};
    final staticString[] ALPHABET = new String[]{A. B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z};

    public static void main(String[] args)
    {
        int guessCount = 0;
        while(guessCount < 6)
        {
            guessCount++;
            String userGuess = guess(guessCount); 
            char[] guessAsChar = guessToChar(userGuess);
            evaluateGuess(guessAsChar); /rAlphabet.
            printInfo(solution, userAlphabet); 
            System.out.println("===============================");
            if(checkSolution()) 
            {
                break;
            }
        }
        if(checkSolution()) 
        {
            System.out.println("You got the word in" + guessCount + "times!");
        } else { 
            System.out.println("The word was" + wordleoftheday + "." );
        }
    }

    /*
     * Prompts the user for a guess and returns that user's guess. Assumed that the guess is 5 characters long. 
     * @param guessNum - number of guesses the user has made
     * @return - the user's guess as a string
     */
    public static String guess(int guessNum)
    {
        System.out.println("Guess Number " + guessNum + ": "); 
        String userInput = input.nextLine();
        while(userInput.length() != 5)
        {
            System.out.print("Word must be 5 letters");
            userInput = input.nextLine();
        }
        return userInput; 
    }

    /*
     * Converts a user's guess (string) into a char array.
     * @param guess - The user's guess, as a string
     * @return - an array of chars from the user's guess
     */
    public static char[] guessToChar(String guess)
    {
        char[] temp = new char[guess.length()];
        for(int i = 0; i < guess.length(); i++)
        {
            temp[i] = guess.charAt(i);
        }
        return temp;
    }

    /*
     * Evaluates a user's guess, filling in solution and modifying userAlphabet as needed (Uses logic listed under step 5).
     */
    public static void evaluateGuess(char[] guess)
    {
        for(int i = 0; i < guess.length; i++)
        {
            String character = String.valueOf(guess[i]).toUpperCase();
            if(character.equals(wordleoftheday.substring(i,i+1))) 
            {
                solution[i] = character; 
            } else {
                int index = findIndexInAlphabet(character); 
                if(wordleoftheday.contains(character)) 
                {
                    userAlphabet[index] = characterLowerCase(); 
                } else { //If the character is not in the solution
                    userAlphabet[index] = " "; 
                }
            }
        }
    }
    /*
     * Identifies the index of a letter in the alphabet, returning that index, or -1 if it was not found.
     */
    public static int IndexAlphabet(String key)
    {
        for(int i = 0; i < ALPHABET.length; i++)
        {
            if(ALPHABET[i].equals(key))
            {
                return i;
            }
        }
        return -1;
    }

    /*
     * Prints the user's current solution, and then the letters remaining.
     */
    public static void printInfo(String[] solution, String[] alphabet)
    {
        System.out.print("Current Solution: ");
        for(String e : solution)
        {
            System.out.print(e + " ");
        }
        System.out.println("");
        System.out.print("Remaining letters: ");
        for(int i = 0; i < alphabet.length; i++)
        {
            System.out.print(alphabet[i] + " ");
            if(i == 14) 
            {
                System.out.println("");
                System.out.print("\t \t \t");
            }
        }
        System.out.println("");
    }

    /*
     * Compares the user's solution to the actual solution, returning true if they are the same, and false otherwise.
     */
    public static boolean findSolution()
    {
        for(int i = 0; i < solution.length; i++)
        {
            if(!solution[i].equals(wordleoftheday.substring(i, i+1)))
            {
                return false;
            }
        }
        return true;
    }
}


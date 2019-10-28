import java.util.Scanner;

public class GamePlay {

    public void playGame(){
        Questions question = new Questions();
        System.out.println("Here's the question.");
        System.out.println(question.gameStart());
        Scanner user_input = new Scanner(System.in);

        // Loop until there's no underscore in the String
        while(question.getUnderscores().contains("_")){
            System.out.print("Guess a letter: ");
            String letter = user_input.nextLine();
            if(question.getCityName().indexOf(letter) != -1){
                question.guessCorrect(letter);
            }else{
                question.guessWrong(letter);
            }

            // Return (Game Over) if the guessCount reaches 10.
            if(question.getGuessCount() >= question.MAX_GUESS_COUNT){
                System.out.println("You have guessed (" + question.getGuessCount() + ") wrong letters: " + question.getWrongLetters());
                System.out.println("You lose!\nThe correct word was '" + question.getCityName() + "'!");
                return;
            }

            // Return (You Win) if all the underscores are replaced with correct letters.
            if(!(question.getUnderscores().contains("_"))){
                System.out.println("You win!\nYou have guessed '" + question.getCityName() + "' correctly.");
                return;
            }

            System.out.println("You are guessing: " + question.getUnderscores());
            System.out.println("You have guessed (" + question.getGuessCount() + ") wrong letters: " + question.getWrongLetters());

        }
    }
}
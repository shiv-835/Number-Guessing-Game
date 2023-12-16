import java.util.*;
class user {
    public String username;
    public int rounds;
    public int[] scores;
    user(int rounds,String username){
        this.rounds = rounds;
        this.username = username;
        this.scores = new int[rounds];
    }
    public void printScores(){
        System.out.println();
        System.out.println("-----"+this.username+"'s Scorecard -----");
        System.out.println("Round\tScore");
        for (int i=0;i<this.rounds;i++){
            System.out.println((i+1)+"\t"+this.scores[i]);
        }
    }
    public int PlayGame(int i){
        System.out.println("Round "+(i+1));
        Random random = new Random();
        Scanner input = new Scanner(System.in);
        int chances = 20;
        int score = 20;
        int guess = random.nextInt(100) + 1;
        System.out.print("Enter your guess :");
        int choice = input.nextInt();
        do {
            if (guess == choice)
                return score;
            else if (guess > choice){
                System.out.println("Guess a bigger number!");
                --chances;--score;
                System.out.println("Enter your guess");
                choice = input.nextInt();
                
            }
            else{
                System.out.println("Guess a smaller number!");
                --chances;--score;
                System.out.println("Enter your guess");
                choice = input.nextInt();
            }
        }
        while(chances>0);
        return 0;
    }
}
public class NumberGame {
    public static void main(String[] args) {
        System.out.println("Welcome to Number Game");
        Scanner input = new Scanner(System.in);
        System.out.print("Enter username : ");
        String username = input.nextLine();
        System.out.print("How many rounds would you like to play ? : ");
        int rounds = input.nextInt();
        user u1 = new user(rounds, username);
        for (int i=0;i<u1.rounds;i++){
            u1.scores[i] = u1.PlayGame(i);
            System.out.println("-----------------------------------");
        }
        u1.printScores();
        System.out.println("-----------------------------------");
        input.close();
    }
}
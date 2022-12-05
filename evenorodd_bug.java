//Author: Benny Simoes
//Version: 1.0

import java.util.*;
 
public class evenorodd_bug{
 
 private int num_points;
 private int player_score = 0;
 private int comp_score = 0;
 private boolean p_wins;
 
 // constructor
 public evenorodd_bug(){}
 
 GetInput g = new GetInput();
 coin_flip c = new coin_flip();
 
 //display the winner of the game
 private void display_winner(){
 	if(player_score==num_points){
 		System.out.println("Computer Wins The Game\n");   //undefined label
 		p_wins = true;
 	}else{
 		System.out.println("Player Wins The Game\n");    //undefined label
 		p_wins = false;
 	}
 }
 
 // runs all the methods in order for the user to play the game.
 public boolean run_game(){
        int n1, n2;
        String result, choice;
  
        num_points = g.getPositiveInt("Enter a positive number who reach this score first will win: ");
        System.out.println();
 
        g.setPickBetweentext("Select %s for %s or %s for %s (cannot change choice during the game):  ");
        g.setBadInputText("Invalid input, please only enter ‘O’ or ‘E’.");   //undefined label  
        choice = g.pickBetween("odd number", "O", "even number", "E");
        System.out.println();
 
        while(player_score <= num_points  && comp_score <= num_points){
 
                n2 = c.random_flip(6);
 
                System.out.println("Computer chooses " + n2 + "\n");

	        g.setInputRangeText("Enter a number from %d to %d: ");  //undefined label
	        g.setBadInputText("That is out of range!");   //undefined label
		n1 = g.getIntInRange(0, 5);
		System.out.println();
 		System.out.println("The sum is " + n1+n2 + ".\n"); 
 
                if((n1+n2)%2 == 0){
 	              result="O";
                }else{
                      result="E";
                }
  
                if(result.equals(choice)){
                      System.out.println("Player Wins The Round.\n");   //undefined label
                      player_score++;
                }else{
                      System.out.println("Computer Wins The Round.\n");   //undefined label
                      comp_score++;
		}
	}
	
	display_winner();
	return p_wins;
 }

 public static void main(String args[]){
	evenorodd_bug game = new evenorodd_bug();
	game.run_game();
 }
}

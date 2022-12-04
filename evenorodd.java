import java.util.*;
 
public class evenorodd{

 int num_points;
 int player_score = 0;
 int comp_score = 0;

 public evenorodd(){}

 GetInput g = new GetInput();
 coin_flip c = new coin_flip();

 private void display_winner(){
	if(player_score==num_points){
		System.out.println("Player Wins The Game\n");
	}else{
		System.out.println("Computer Wins The Game\n");
	}
  }

 private void run_game(){
	int n1, n2;
	String result, choice;

	num_points = g.getPositiveInt("Enter a positive number who reach this score first will win: ");
	System.out.println();
	
	g.setPickBetweentext("Select %s for %s or %s for %s (cannot change choice during the game):  ");
	choice = g.pickBetween("odd number", "O", "even number", "E");
	System.out.println();

	while(player_score < num_points  && comp_score < num_points){
		
		g.setInputRangeText("Enter a number from %d to %d: "); 
		n1 = g.getIntInRange(0, 5);
		n2 = c.random_flip(6);
		
		System.out.println();
		System.out.println("Computer chooses " + n2 + "\n");		
 		
		if((n1+n2)%2 == 0){
			result="E";
		}else{
			result="O";
		}

		if(result.equals(choice)){
			System.out.println("Player Wins The Round.\n");
			player_score++;
		}else{
			System.out.println("Computer Wins The Round.\n");
			comp_score++;
		}
	}
	
	display_winner();
 }

 public static void main(String args[]){
	evenorodd game = new evenorodd();
	game.run_game();
	
 }
}

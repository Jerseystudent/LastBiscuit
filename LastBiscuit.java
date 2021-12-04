//Program that allows two players to play the game Last Biscuit
//Setting up the scanner
import java.util.Scanner;
public class LastBiscuit {
	public static void main(String[] args){
		
		//Setting up the call for the scanner
		Scanner in = new Scanner(System.in);
		
		//Setting variables for the amount of biscuits at 
		//the beginning of the game and type of gameplay 
		//as well as the skips
		final int BISCUITS_ONE_FINAL = 6; //Starting amount for barrel 1
		final int BISCUITS_TWO_FINAL = 8; //Starting amount for barrel 2
		//int below from final so not magic number
		int biscuitsOne = BISCUITS_ONE_FINAL; 
		int biscuitsTwo = BISCUITS_TWO_FINAL;
		//type string for player 1		
		String playerOneType = "";
		//type string for player 2		
		String playerTwoType = "";
		//Int for amount taken for player 1
		int playerOneAmount = 0;
		//Int for amount taken for player 2
		int playerTwoAmount = 0;
		//Skip amount for player 1, 
		//set at 1 for one allowed
		int playerOneSkip = 1;
		//Skip amount for player 2, 
		//set at 1 for one allowed
		int playerTwoSkip = 1;
		
		//Boolean to see if player one has won 
		boolean playerOneWin = false;

		
		
		//Below is the loop for the game and will remain in loop until both
		//piles of biscuits are empty
		while (biscuitsOne>0 || biscuitsTwo>0){
			
			//Prints remainder of biscuits
			System.out.println("Biscuits Left - Barrel 1: " + biscuitsOne);
			System.out.println("Biscuits Left - Barrel 2: " + biscuitsTwo);
			System.out.println("Player Turn: 1");
			//Player 1s turn
			//Checks to make sure a valid strng is entered
			while (true){
			//Enters loop to make sure the amount of biscuits taken are legal
			while (true){
				//validates that choice is correct, one two
				//or skip are the options
				System.out.print("Choose a barrel: barrel1 (one), "
				+"barrel2 (two), or both (both), or skip turn (skip)? ");
				playerOneType = in.nextLine();
				if (playerOneType.equals("one") || playerOneType.equals("two") 
					|| playerOneType.equals("both") 
				    || playerOneType.equals("skip")){
					break;
				}
			}
			//Validation to make sure it is an int being entered
			if (playerOneType.equals("one") 
				|| playerOneType.equals("two") 
				|| playerOneType.equals("both")){
				System.out.print("How many biscuits are you taking? ");
				while (!in.hasNextInt()){
					System.out.print("Please input an integer: ");
					in.next(); 
				}
			}
			//Checks to make sure the type
			//is not skip
			if (!playerOneType.equals("skip")){
            playerOneAmount = in.nextInt();
			in.nextLine();
			}//breaks from loop when conditions are valid
			 //and checks below
			if (playerOneType.equals("one") 
				&& biscuitsOne>=playerOneAmount 
				&& playerOneAmount>0){
				break;
			} else if (playerOneType.equals("two") 
					&& biscuitsTwo>=playerOneAmount 
					&& playerOneAmount>0){
				break;
			} else if (playerOneType.equals("both") && biscuitsOne>=playerOneAmount 
					   && biscuitsTwo>=playerOneAmount && playerOneAmount>0){
				break;
			} else if (playerOneSkip > 0 && playerOneType.equals("skip")){
				playerOneSkip = playerOneSkip - 1;
				break;
			}else if (playerOneSkip == 0 && playerOneType.equals("skip")){
				System.out.println("Sorry you've used your skip.");
			}else {
				System.out.println("Sorry, that's not a legal number "
								  +"of biscuits for that/"
								  +"those barrel(s)");
			}
			}
			
			//if statements to determine the play type and then 
			//remove appropriate amount of biscuits
				if (playerOneType.equals("one")){
					biscuitsOne = biscuitsOne-playerOneAmount;
				}
				if (playerOneType.equals("two")){
					biscuitsTwo = biscuitsTwo-playerOneAmount;
				}	
				if (playerOneType.equals("both")){
					biscuitsOne = biscuitsOne-playerOneAmount;
					biscuitsTwo = biscuitsTwo-playerOneAmount;
				}	
			
			//Checks to see if player one has won and if the game ends
			if (biscuitsOne == 0 && biscuitsTwo == 0){
				playerOneWin = true;
				break;
			}
			//Prints remainder of biscuits for player 2s turn
			System.out.println("Biscuits Left - Barrel 1: " + biscuitsOne);
			System.out.println("Biscuits Left - Barrel 2: " + biscuitsTwo);
			System.out.println("Player Turn: 2");
			//Player 2s turn
			//Checks to make sure a valid string is entered
			while (true){ 
			// goes into loop to make sure the 
			//integer inputted is legal
			while (true){
				System.out.print("Choose a barrel:"
							   +" barrel1 (one), barrel2 (two),"
							   +" or both (both),"
							   +" or skip turn (skip)? ");
				playerTwoType = in.nextLine();
				if (playerTwoType.equals("one") 
					|| playerTwoType.equals("two")  
					|| playerTwoType.equals("both") 
					|| playerTwoType.equals("skip")){
					break;
				}
			}
			//Validation to make sure it is an int being entered
			if (playerTwoType.equals("one") 
				|| playerTwoType.equals("two") 
				|| playerTwoType.equals("both")){
				System.out.print("How many biscuits are you taking? ");
				while (!in.hasNextInt()){
					System.out.print("Please input an integer: ");
					in.next(); 
				}
			} //Checks to make sure that the condition
			  //is not skip so number can be inputted
			if (!playerTwoType.equals("skip")){
				playerTwoAmount = in.nextInt();
				in.nextLine();
			} //breaks from loop when conditions are valid
			  //and checks below
			if (playerTwoType.equals("one") 
		     && biscuitsOne>=playerTwoAmount 
		     && playerTwoAmount>0){
				break; //Breaks here to allow program 
					   //to continue as the move is legal
			}else if (playerTwoType.equals("two") 
				   && biscuitsTwo>=playerTwoAmount 
				   && playerTwoAmount>0){
				break;
			}else if (playerTwoType.equals("both") && biscuitsOne>=playerTwoAmount 
					  && biscuitsTwo>=playerTwoAmount && playerTwoAmount>0){
				break;
			}else if (playerTwoType.equals("skip") && playerTwoSkip > 0){
				playerTwoSkip = playerTwoSkip - 1;
				break;
			}else if (playerTwoSkip == 0 && playerTwoType.equals("skip")){
				System.out.println("Sorry you've used your skip.");
			}else {
				System.out.println("Sorry, that's not a legal number"
				           +" of biscuits for that/those barrel(s)");
			}
			}
			
			//If statements to determine the play type 
			//and then remove appropriate amount of biscuits
			if (playerTwoType.equals("one")){
					biscuitsOne = biscuitsOne-playerTwoAmount;
				}
				if (playerTwoType.equals("two")){
					biscuitsTwo = biscuitsTwo-playerTwoAmount;
				}	
				if (playerTwoType.equals("both")){
					biscuitsOne = biscuitsOne-playerTwoAmount;
					biscuitsTwo = biscuitsTwo-playerTwoAmount;
				}
		}
		//Prints the final result
		System.out.println("Biscuits Left - Barrel 1: " + biscuitsOne);
		System.out.println("Biscuits Left - Barrel 2: " + biscuitsTwo);
		//If Statement to see if player one 
		//has won from earlier boolean statement
		if (playerOneWin){
			System.out.println("Winner is player 1");
		}else {
			System.out.println("Winner is player 2");
		}
	}
}

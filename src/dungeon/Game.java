package dungeon;


import dungeon.entity.Player;
import dungeon.item.Weapon;

/**
 * 
 * The Game class contains the main function of the program. It creates a new dungeon on 3 successive levels, as well as a player.
 * The dungeon is generated every time the players completes it, until he reaches the end of the game.
 * 
 * 
 * @author lucasmouradeoliveira
 *
 */
public class Game {
	
	private Dungeon dungeon;
	
	private Player player;
	
	private int currentLevel,maxLevel;
	
	/**
	 * Creates a new game and a new player with 10 health points and a wooden sword.
	 * 
	 * @param maxLevel the number of consecutive levels the player has to pass to win the game.
	 */
	public Game(int maxLevel){
		this.maxLevel = maxLevel;
		this.player = new Player(10, new Weapon("Wooden Sword", 1));
		this.currentLevel = 1;
	}
	
	/**
	 * Launches the main loop of the game and create the successive dungeons.
	 * The function returns when the player has finished all the levels.
	 */
	public void playGame(){
		
		System.out.println("********** Welcome in the Dragon's Cave !!! **********");
		
		while(currentLevel <= maxLevel){
			
			createDungeon();
			
			System.out.println("You enter the level " + currentLevel + " of the dungeon !");
			
			dungeon.start();
			
			if(dungeon.gameIsLost()){
				System.out.println("You lose !");
				return;
			}else{
				currentLevel++;
			}
			
		}
		
		System.out.println("You finally escaped the Dragon's cave !");
		
	}

	/**
	 * Creates a new dungeon level and generates its path
	 */
	private void createDungeon() {
		dungeon = new Dungeon(player);
		DungeonGenerator generator = new DungeonGenerator(5+currentLevel*2,dungeon, currentLevel);
		generator.generateMainPath();
		generator.generateSecondaryPath();
	}

	/**
	 * Creates and launches a new game, with 3 consecutive dungeons
	 * @param args the main function list of parameters (unused)
	 */
	public static void main(String[] args){
		new Game(3).playGame();
	}
	
}

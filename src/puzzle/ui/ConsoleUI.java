package puzzle.ui;

import java.util.Date;
import java.util.Scanner;

import puzzle.core.Field;
import puzzle.core.Tile;
import puzzle.score.Score;
import puzzle.score.ScoreService;
import puzzle.score.ScoreServiceFile;

public class ConsoleUI {
	private Field field;
	
	private ScoreService scoreService = new ScoreServiceFile("puzzle"); 

	public ConsoleUI() {
		field = new Field(3, 3);
	}

	public void play() {
		printScores();
		print();
		while (!field.isSolved()) {
			processInput();
			print();
		}
		System.out.println("You won!");
		System.out.println("Your score is " + field.getScore());
		scoreService.addScore(new Score(System.getProperty("user.name"), field.getScore(), new Date()));
	}

	private void print() {
		for (int row = 0; row < field.getRowCount(); row++) {
			for (int column = 0; column < field.getColumnCount(); column++) {
				Tile tile = field.getTile(row, column);
				if (tile != null)
					System.out.printf("%2d", tile.getValue());
				else
					System.out.print("--");
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	private void processInput() {
		System.out.print("Enter tile number: ");
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine().toUpperCase().trim();
		if("X".equals(line))
			System.exit(0);
		try {
			int value = Integer.parseInt(line);
			if(!field.moveTile(value))
				System.err.println("Tile not moved!");
		} catch (NumberFormatException e) {
			System.err.println("Invalid tile number!");
		}
	}
	
	private void printScores() {
		int index = 1;
		System.out.println("-----------------------------");
		System.out.println("No.  Player             Score");
		System.out.println("-----------------------------");
		for(Score score : scoreService.getBestScores()) {
			System.out.printf("%3d. %-16s %5d\n", index, score.getPlayer(), score.getPoints());
			index++;
		}
		System.out.println("-----------------------------");
	}
}

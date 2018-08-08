package puzzle.score;

import java.io.Serializable;
import java.util.Date;


public class Score implements Serializable {
	private String player;
	private int points;
	private Date when;
	

	public Score() {
	}

	public Score(String player, int points, Date when) {
		this.player = player;
		this.points = points;
		this.when = when;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public Date getWhen() {
		return when;
	}

	public void setWhen(Date when) {
		this.when = when;
	}

	@Override
	public String toString() {
		return "Score [player=" + player + ", points=" + points + ", when=" + when + "]";
	}
}

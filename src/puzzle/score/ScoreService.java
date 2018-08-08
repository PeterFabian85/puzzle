package puzzle.score;

import java.util.List;

public interface ScoreService {

	void addScore(Score score);

	List<Score> getBestScores();

}
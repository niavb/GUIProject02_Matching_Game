package app;

public class ScoreRecord implements Comparable<ScoreRecord>{
	private int time;
	private int moves;
	String name;

	public ScoreRecord(int moves, int time, String name) {
		this.time = time;
		this.moves = moves;
		this.name = name;
	}

	@Override
	public int compareTo(ScoreRecord sr1) {
		 int r = Integer.compare(moves, sr1.moves);
		    return r == 0 ? Integer.compare(time, sr1.time) : r;
	}
	
	public String toString() {
		return moves + " " + time + " " + name;
	}

	
	

	

}

package serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class NFSGame implements Serializable {
	
	String name;
	int level;
	long score;
	int life;
	public NFSGame(String name, int level, long score, int life) {
//		super();
		this.name = name;
		this.level = level;
		this.score = score;
		this.life = life;
	}
}

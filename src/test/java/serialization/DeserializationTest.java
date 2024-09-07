package serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class DeserializationTest 
{
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
	
	FileInputStream fin=new FileInputStream("./f.txt");
     ObjectInputStream objIn=new ObjectInputStream(fin);	
     NFSGame user1Obj=(NFSGame) objIn.readObject();
     System.out.println(user1Obj.name);
     System.out.println(user1Obj.level);
     System.out.println(user1Obj.score);
     System.out.println(user1Obj.life);




}
}
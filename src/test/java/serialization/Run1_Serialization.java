package serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Run1_Serialization {


	
		public static void main(String []args) throws IOException
		{
			NFSGame user1Obj=new NFSGame("Akshay",50000,10,3);
			FileOutputStream fout=new FileOutputStream("./f.txt");
			
			ObjectOutputStream objOut=new ObjectOutputStream(fout)	;
			objOut.writeObject(user1Obj);
			System.out.println("====end====");
	}
	}
	
	


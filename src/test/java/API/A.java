package API;

public class A {
	
	public static A a()
	{
		System.out.println("mtd a executed");
		return new A();
		
	}
	public static A b()
	{
		System.out.println("mtd b executed");
		return new A();

	}
	public static B c()
	{
		
		System.out.println("mtd c executed");
		return new B();
	}


}

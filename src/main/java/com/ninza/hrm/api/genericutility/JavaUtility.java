package com.ninza.hrm.api.genericutility;

import java.util.Random;

public class JavaUtility {

	public int getRnadomNumber()
	{
		Random ran=new Random();
		int num=ran.nextInt(100);
return num;
	}
}

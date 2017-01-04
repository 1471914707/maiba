package com.lin.tool;
public class OnlineCounter {
	private static long onlineCounter = 0;
	public static void addCounter(){
		onlineCounter ++;
	}
	public static void reduceCounter(){
		onlineCounter--;
	}
	public static long getCounter(){
		return onlineCounter;
	}
}

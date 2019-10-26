package com.gameoflife;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TestGameofLife {
   public static void main(String [] args){
	   String pattern;
	   ArrayList <String> list = new ArrayList<String>();
	   BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	   System.out.println("Input:");
	   try
	   {
		   outer:while(true){
			   pattern = input.readLine();
			   if(pattern.equalsIgnoreCase("")){
				   break outer;
			   }
			   list.add(pattern);
		   }
	       GameOfLife gol = new GameOfLife(list);
	       gol.display();
	   }
	   catch(Exception exe){
		   exe.printStackTrace();
	   }
   }
}

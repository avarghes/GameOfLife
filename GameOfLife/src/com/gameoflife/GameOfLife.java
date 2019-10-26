package com.gameoflife;

import java.util.List;

public class GameOfLife {
   char [][] oldGeneration = new char [5][5];
   char [][] newGeneration = new char [5][5];
   
   public GameOfLife(List <String> list){
	   this.initializeGeneration(list);
	   this.newGeneration();
   }
   
   public void initializeGeneration(List <String> list){
	   int i,j;
	   for(int k =0; k < this.oldGeneration.length; k++){
		   for(int l=0; l < this.oldGeneration.length; l++){
			   this.oldGeneration[k][l] = '-';
			   this.newGeneration[k][l] = '-';
		   }
	   }
	   for(String value:list){
		  i = Integer.parseInt(value.split(",")[0].trim());
		  j = Integer.parseInt(value.split(",")[1].trim());
		  this.oldGeneration[i][j] = 'X';
		  this.newGeneration[i][j] = 'X';
	   }
   }
   
   public void newGeneration(){
	   int count = 0;
	   for(int i=0;i < this.oldGeneration.length ; i++)
	   {
		   for(int j=0; j < this.oldGeneration.length; j++)
		   {
			        count = 0;
			    	if(i != 0 && j != 0 && this.oldGeneration[i-1][j-1] == 'X'){
			    		count++;
			    	}
			    	if((i < this.oldGeneration.length -1) && (j < this.oldGeneration.length -1) 
			    			&& this.oldGeneration[i+1][j+1] == 'X'){
			    		count++;
			    	}
			    	if(i!=0 && this.oldGeneration[i-1][j] == 'X'){
			    		count++;
			    	}
			    	if((i < this.oldGeneration.length -1) && this.oldGeneration[i+1][j] == 'X'){
			    		count++;
			    	} 
			    	if(j!=0 && this.oldGeneration[i][j-1] == 'X'){
			    		count++;
			    	}
			    	if((j < this.oldGeneration.length-1) && this.oldGeneration[i][j+1] == 'X'){
			    		count++;
			    	}
			    	if(i!=0 && (j < this.oldGeneration.length-1) && this.oldGeneration[i-1][j+1] == 'X'){
			    		count++;
			    	}
			    	if((i < this.oldGeneration.length -1) && j!=0 && this.oldGeneration[i+1][j-1] == 'X'){
			    		count++;
			    	}
			    	if(count < 2 || count > 3)
			    	{
			    	  if(this.oldGeneration[i][j] == 'X')	
			    		this.newGeneration[i][j] = '-';
			    	}
			    	else if(count > 2 && count <3)
			    	{
			    	  if(this.oldGeneration[i][j] == 'X')
			    		this.newGeneration[i][j] = 'X';
			    	}
			    	else if(count == 3)
			    	{
			    		if(this.oldGeneration[i][j] == '-')
			    			this.newGeneration[i][j] = 'X';
			    	}
		   }
	   }
   }
   
   public void display(){
	   System.out.println("Output:");
	   for(int i=0;i<this.newGeneration.length;i++){
		   for(int j=0;j<this.newGeneration.length;j++){
			   if(this.newGeneration[i][j] == 'X'){
				   System.out.println(i+","+j);
			   }
		   }
	   }
   }
}
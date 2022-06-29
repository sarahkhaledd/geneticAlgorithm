package geneticAlgorithm;

import java.util.ArrayList;

public class Replacement 
{
	
		public ArrayList<String> PopOfEncoding = new ArrayList<String>();
		public ArrayList<String> PopOfSelection = new ArrayList<String>();
		public ArrayList<String> PopOfMutation = new ArrayList<String>();
		
	   public Replacement(ArrayList<String> PopOfEncoding,ArrayList<String> PopOfSelection,ArrayList<String> PopOfMutation) 
	   {
		  this.PopOfEncoding=PopOfEncoding;
		  this.PopOfSelection=PopOfSelection;
		  this.PopOfMutation=PopOfMutation;
	   }
	   public  ArrayList<String> replacement() 
	   {
		   for(int i=0;i<PopOfEncoding.size();i++)
			 {
			   for(int j=0;j<PopOfMutation.size();j++)
				 {
				    if(PopOfEncoding.get(i).equals(PopOfSelection.get(j)))
				     {
				    	PopOfEncoding.set(i, PopOfMutation.get(j));
				    	
				    	//Call other functions
				     }
				 }
			 }
		return PopOfEncoding;
	   }
}

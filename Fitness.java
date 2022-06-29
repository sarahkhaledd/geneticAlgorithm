package geneticAlgorithm;

import java.util.ArrayList;

public class Fitness 
{  
	int SizeOfKnapsack;
	int SizePop;
    public Fitness(int s,int P) 
    {
    	SizeOfKnapsack = s;
    	SizePop = P;
    }
    
	 public int[] Fitness(ArrayList<String> Population,ArrayList<Integer> weight,ArrayList<Integer> Value)
	 {
		 int[]Fitness = new int[SizePop] ;
		 for(int i=0;i<Population.size();i++)
		 {
			 String Pop = Population.get(i);
			 int TotalWeight = 0 ,TotalValue = 0 ;
			 for(int j=0;j<Pop.length();j++)
			 {
				 if(Pop.charAt(j)=='1')
				 {
					 TotalWeight+=weight.get(j);
					 TotalValue+=Value.get(j);
				 }
				 
			 }
			 if(TotalWeight<=SizeOfKnapsack)
			 {
				 Fitness[i]=TotalValue;
				 
			 }
			 else
				 Fitness[i]=0;
		 }
		 
		return Fitness;
		 
	 }
}

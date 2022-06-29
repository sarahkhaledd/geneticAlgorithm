package geneticAlgorithm;

import java.util.ArrayList;

public class EnCoding 
{
	public int SizeOfPop;
	public int NumbOfItem;
	private ArrayList<String> population = new ArrayList<String>();
	public EnCoding(int c ,int i)
	{
	  SizeOfPop=c;
	  NumbOfItem=i;
		
	}
	public ArrayList<String> encoding() 
	{
		
		for(int i=1;i<=SizeOfPop;i++)
		{
			StringBuilder chromosome = new StringBuilder(NumbOfItem);
			 char gene;
			for(int j=1;j<=NumbOfItem;j++)
			{				
				     gene = '0';
		            double rnd = Math.random(); 
		            if(rnd > 0.5) 
		            {
		            	gene = '1';
		            }
		            chromosome.append(gene);
		            
		   }
			population.add(chromosome.toString());
	}
		return population;
	
}
}

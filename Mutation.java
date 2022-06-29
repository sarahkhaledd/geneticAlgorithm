package geneticAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class Mutation {
	public ArrayList<String> NewPopulation = new ArrayList<String>();
	public ArrayList<String> LastPopulation = new ArrayList<String>();
	public Mutation(ArrayList<String> NewPopulation)
	{
		this.NewPopulation=NewPopulation;;
	}
    public ArrayList<String> mutation()
     {
    	
    	for(int i=0;i<NewPopulation.size();i++)
		{
			String[] strSplit = NewPopulation.get(i).split("");
	        ArrayList<String> chromosome = new ArrayList<String>(Arrays.asList(strSplit));
	        String LastGene = "";
			for(int j=0;j<chromosome.size();j++)
			{				
		            double rnd = Math.random(); 
		            if(rnd > 0.5) 
		            {
		            	if(chromosome.get(j).equals("0"))
		            		{
		            		   chromosome.set(j,"1");
		            		}
		            	else if(chromosome.get(j).equals("1"))
		            		chromosome.set(j,"0");
		            }
		      LastGene+=chromosome.get(j);
		      
             }
			LastPopulation.add(LastGene);
         }
    	return LastPopulation;
      }

}

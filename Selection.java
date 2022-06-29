package geneticAlgorithm;

import java.util.ArrayList;
import java.util.Random;
public class Selection {
	
	public ArrayList<String> Population = new ArrayList<String>();
	public ArrayList<Integer> Fitness=  new ArrayList<Integer>();
	public int TotalFitnesses ;
	public Selection(ArrayList<String> P,ArrayList<Integer> F)
	{
		Population = P;
		Fitness = F;
	}
	
	public int Random(ArrayList<Integer> AverageFitness)
	{
		Random rand = new Random(); //instance of random class
	      int upperbound = 100 ;// AverageFitness.get(AverageFitness.size()-1);
	      int int_random = rand.nextInt(upperbound); 
		return int_random;
	}
	
	public ArrayList<String> RoulleteWheel()
	{
		
		ArrayList<Integer> AverageFitness = new ArrayList<Integer>();
		ArrayList<String> NewPopulation = new ArrayList<String>();
	    for(int i=0;i<Population.size();i++)
	    {
	    	TotalFitnesses+=Fitness.get(i);
	    }
	    for(int i=0;i<Population.size();i++)
	    { 
	    	double x =(Fitness.get(i)*100.0)/TotalFitnesses;
	    	int y = (int) x;
	    	if(i!=0)
	    	{
	    		AverageFitness.add(y+AverageFitness.get(i-1));
	    	}
	    	else 
	    		AverageFitness.add(y);
	    }
	    for(int j=0;j<2;j++) 
	    {
		    int random = Random(AverageFitness);
		    for(int i=0;i<Population.size();i++)
		    {
		    	if(random<=AverageFitness.get(i))
		    	{
		    		NewPopulation.add(Population.get(i));
		    		break;
		    	}
		    
		    }
		 }
      return NewPopulation;
    }
}

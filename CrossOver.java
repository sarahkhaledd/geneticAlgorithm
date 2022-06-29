package geneticAlgorithm;

import java.util.ArrayList;
import java.util.Random;
public class CrossOver 
{
	public ArrayList<String> Population = new ArrayList<String>();
	public ArrayList<String> NewPopulation = new ArrayList<String>();
	public int SizeOfItem;
	  public CrossOver(int SizeOfItem)
	  {
		  this.SizeOfItem=SizeOfItem;
	  }
	  public int Random()
		{
			Random rand = new Random(); 
		      int upperbound =SizeOfItem-1;
		      int int_random = rand.nextInt(upperbound); 
			return int_random;
		}
	  public ArrayList<String> SinglePoint(ArrayList<String> Population)
	  {		  			
		       double rnd = Math.random(); 
		       String offs1 ;
		       String offs2 ;
		        if(rnd > 0.5) 
		        {
		            int random = Random();	
		            if(Population.size()==2)
		            {
		            	offs1 = Population.get(0).substring(0, random) + Population.get(1).substring(random);
			            offs2 = Population.get(1).substring(0, random) + Population.get(0).substring(random);
			            NewPopulation.add(offs1);
				        NewPopulation.add(offs2);
				        return NewPopulation;   
		            }
		            else if(Population.size()==1)
		            {
		            	offs1=Population.get(0);
		            	NewPopulation.add(offs1);
		            	return NewPopulation;   
		            }
		        }
		     return Population; 
		}

}

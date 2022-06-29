package geneticAlgorithm;

import java.util.ArrayList;

public class Run {
	 
       public Fitness fitness;
       public ArrayList<String> Population = new ArrayList<String>();
       public ArrayList<Integer> Fitness = new ArrayList<Integer>();
       public ArrayList<Integer> Weight = new ArrayList<Integer>();
       public ArrayList<Integer> Value = new ArrayList<Integer>();
       public Boolean bool = true ; 
       public int MaxOfFitness = 0 ; 
       public String MaxOfChromosome  ; 
		public void Discard(ArrayList<String> Pop,int[]F) //check size of knapsack
		{
			Population.clear();
			Fitness.clear();
			for(int i=0;i<Pop.size();i++)
			{
				if(F[i]!=0)
				{
				  Population.add(Pop.get(i));
				  Fitness.add(F[i]);
				}
				
			}
	
		}
		public void Maximum()
		{
			int Max = 0 ;
			int index = 0; 
			for(int i=0;i<Fitness.size();i++)
			{
				if(Fitness.get(i)>Max)
				{
					Max = Fitness.get(i);
					index = i ;
				  
				}
			}
			String Chromosome ; 
			//System.out.println(index);
			Chromosome = Population.get(index);
			if(Max>MaxOfFitness)
			{
				MaxOfFitness=Max ; 
				MaxOfChromosome = Chromosome ;
				bool = true ; 
			}
			else  
				bool = false ; 
		}
		public void OutPut()
		{
			System.out.println("Fitness: "+MaxOfFitness);
			for(int i=0;i<MaxOfChromosome.length();i++)
			{
				if(MaxOfChromosome.charAt(i)=='1') //Decoding
				{
					System.out.println("Weight of item : "+Weight.get(i)+" Value of item :"+Value.get(i));
					
				}
			}
		}
	public Run(ArrayList<Integer> Weight,ArrayList<Integer> Value,int ItemNo,int SizeOfKnapsack,int PopulationSize )
	  {
		    this.Weight = Weight;
		    this.Value = Value ; 
		     int[] arr;
		     EnCoding g =new EnCoding(PopulationSize,ItemNo) ;
			 ArrayList<String> PopulationList = new ArrayList<String>();
			 PopulationList = g.encoding();
			while(bool==true)
			{ 
				fitness=new Fitness(SizeOfKnapsack, PopulationSize) ;
				arr = fitness.Fitness(PopulationList, Weight, Value);
				Discard(PopulationList,arr);
				
				Selection selection = new Selection(Population,Fitness);
				ArrayList<String> NewPop = new ArrayList<String>();
				NewPop=selection.RoulleteWheel();
				
				ArrayList<String> crossArray = new ArrayList<String>();
				CrossOver crossover = new CrossOver(ItemNo);
				crossArray = crossover.SinglePoint(NewPop);
				fitness=new Fitness(SizeOfKnapsack, PopulationSize) ;
				arr = fitness.Fitness(crossArray, Weight, Value);
				Discard(crossArray,arr);
				
				ArrayList<String> Mutai = new ArrayList<String>();
				Mutation mutation = new Mutation(crossArray);
				Mutai=mutation.mutation();
				fitness=new Fitness(SizeOfKnapsack, PopulationSize) ;
				arr = fitness.Fitness(Mutai, Weight, Value);
				Discard(Mutai,arr);
				
				ArrayList<String> replayy = new ArrayList<String>();
				Replacement replacement = new Replacement(PopulationList,NewPop,Population);
				replayy=replacement.replacement();
				arr = fitness.Fitness(replayy, Weight, Value);
				Discard(replayy,arr);
				Maximum();
			}
			OutPut();
			
	  }

}

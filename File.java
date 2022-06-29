package geneticAlgorithm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class File 
{
	public ArrayList<String> File = new ArrayList<String>();
	ArrayList<Integer> Weight = new ArrayList<Integer>();
	ArrayList<Integer> Value = new ArrayList<Integer>();
	public File() throws IOException 
	{
		String line;  
		int ItemNo , SizeOfKnapsack ; 
        //Opens a file in read mode  
        FileReader file = new FileReader("input_example.txt");  
        BufferedReader br = new BufferedReader(file);  
        //Gets each line till end of file is reached  
        while((line = br.readLine()) != null) 
        {  
        	File.add(line);
	    }  
        int number = Integer.parseInt(File.get(0));
       // System.out.println(number);
        	if(number<=20)
        	{
        		int i=1;
        		while(i<File.size())
                {
        			 ItemNo=Integer.parseInt(File.get(i));
        			// System.out.println(ItemNo);
        			 Weight.clear();
        			 Value.clear();
        			 if(ItemNo<=50)
        			 { 
	        		     SizeOfKnapsack =Integer.parseInt(File.get(i+1));
	        		     int k =i+2;
	        			 for(int j=0;j<ItemNo;j++)
	        			 {
	        				String[] split;
	        				split = File.get(k).split(" ");
	        				//System.out.println(split);
	        				Weight.add(Integer.parseInt(split[0]));
	        				Value.add(Integer.parseInt(split[1]));
	        				//System.out.println(Weight+"we"+Value);
	        				k++;
	        			 }
	        			 Run run = new Run( Weight,Value,ItemNo,SizeOfKnapsack,200);
        			 }
        			 i+=2+ItemNo;
        			 
                }
        	}
     }
}

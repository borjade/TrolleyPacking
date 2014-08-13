import java.util.ArrayList;
import java.util.ListIterator;



public class Trolley 
{
	public int noOfCust;
	private ArrayList<String> custList  = new ArrayList<String>();
	final int MAX_HEIGHT = 100;
	final int MAX_WIDTH = 100;
	public int availableWidth, currentIndex;
	public float size,used, original;
	public Pile [] piles;
	
	//Contrs
	public Trolley()
	{
		availableWidth = MAX_WIDTH;
		original = MAX_HEIGHT * MAX_WIDTH;
		size = MAX_HEIGHT * MAX_WIDTH;
		piles = new Pile [100000];
		currentIndex = 0;
	}
	
	//method to print out the contents of the trolley.
	public void print()
	{
		System.out.print("\n\nAvailable Width: " + availableWidth  + " Percentage of size used: " +((original - size)/(MAX_HEIGHT * MAX_WIDTH) ) * 100f + "%\n");
		System.out.print("--------------------------------------------");
		
		for(Pile j : piles)
		{
			System.out.print("\nPile: " + j + " Remaining Height: " + (100- j.getHeight()) + "\n" );
			j.display();
		}
	}
	
	public boolean placePacket(Packet insert)
	{	
		boolean placed = false;
		if((noOfCust < 2 || checkCust(insert.type) == true))
		{
			
		
			if(availableWidth - insert.getWidth() >= 0  && piles[0] == null) 
			{
				Pile tempPile = new Pile();
				placed = tempPile.stack(insert);
				availableWidth -= insert.getWidth();
				size = size - insert.size;
				piles[0] = tempPile;
			}
			else
			{			
				int i = 0;
				while( placed == false && i< piles.length)
				{
				
					if(piles[i].getHeight() + insert.getHeight() <= MAX_HEIGHT && piles[i].getCustType().equals(insert.getType()))
					{
						placed = piles[i].stack(insert);
						size = size - insert.size;
					}
					i++;
				}
			
			}
		}
		return placed;
		
	}
	
	public boolean checkCust(String cust)
	{
		boolean present = false;
		
		ListIterator<String> itr = custList.listIterator();
		while(itr.hasNext())
		{
			if(itr.next() == cust)
			{
				present = true;
			}
		}
		
		return present;
	}
	
	 public void pop()
	 {
		 Pile tempPile = new Pile();
		 for(Pile p : piles)
		 {
			 tempPile.populate();
			 p = tempPile;
		 }
		 
	 }

	
	public void setCust(String cust)
	{
		noOfCust = noOfCust + 1;
		custList.add(cust);
	}
	
	public int custNo()
	{
		return noOfCust;
	}
	
	

}

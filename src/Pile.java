import java.util.ArrayList;
import java.util.ListIterator;

	public class Pile 
	{
		public int pileHeight;
		public String customer;
		public Packet[] pile;
		public int currentIndex;
		public Pile()
		{
			pileHeight = 0;
			currentIndex = 0;
			pile = new Packet [100000];
		}
		
		public void populate()
		{
			Packet empty = new Packet(0, 0, null);
			for(Packet p: pile)
			{
				p = empty;
			}
		}
		
		//method to place the Parcel into the pile
		public boolean stack(Packet insert)
		{

			if(pile[0] == null) 
			{
				pile[0]=insert;
				pileHeight = pileHeight + insert.getHeight();
				customer = insert.getType();
				return true;
			} 
			else
			{ 
				
				if(pile[currentIndex].getWidth() >= insert.getWidth())
				{
					currentIndex++;
					pile[currentIndex]=insert;
					pileHeight = pileHeight +  insert.getHeight();
					return true;	
				}	
			}
			return false;
		}
		
		public void display()
		{
			for(Packet p: pile)
			{
				System.out.print("| "+p+ " | ");
			}
		}
		
		public String getCustType()
		{
			return customer;
		}
		public int getHeight()
		{
			return pileHeight;
		}
	}
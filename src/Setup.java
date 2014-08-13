
public class Setup 
{
	 int randHeight;
	 int randWidth;
	 String randString;
	 String[] rootString;
	
	 public Packet[] optimum(int n)
	{
			Packet[] array = new Packet[n];
			rootString = new String[3];
			rootString[0] = "A";
			rootString[1] = "B";
			rootString[2] = "C";
			
			for (int i = 0; i<n; i++)
			{
				randHeight = ((int)(Math.random() * 100) + 1);
				randWidth = (int)(Math.random() * 100) + 1;
				
				if(i<= (n/3))
				{
					randString = rootString[0];
				}
				else if (i>(n/3) && i<= 2*(n/3))
				{
					randString = rootString[1];
				}
				else 
				{
					randString = rootString[2];
				}
				Packet randPacket = new Packet(randHeight,randWidth,randString);
				array[i] = randPacket;		
			}
			
			return array;
	}
	 
	public Packet[] createRandomPackets(int n)
	{
		Packet[] array = new Packet[n];
		rootString = new String[3];
		rootString[0] = "A";
		rootString[1] = "B";
		rootString[2] = "C";
		
		for (int i = 0; i<n; i++)
		{
			randHeight = ((int)(Math.random() * 100) + 1);
			randWidth = (int)(Math.random() * 100) + 1;
			
			
			randString = rootString[((int)(Math.random() * 3))];

			Packet randPacket = new Packet(randHeight,randWidth,randString);
			array[i] = randPacket;		
		}
		
		return array;
	}
	
	public void QuickSort(Packet[] a,int l, int r)
	{
		
		if (r >l)
		{
			int p = Partition(a,l,r);
			QuickSort(a,l,p-1);
			QuickSort(a,p+1,r);
		}
	}
	
	public int Partition(Packet[] array,int l, int r)
	{
		int v = array[r].getSize();
		int pL = l;
		int pR = r;
		while(pL < pR)
		{
			while(array[pL].getSize()> v) 
			{
				pL = pL+1;
			}
			while(array[pR].getSize() <= v && pR > l)
			{
				pR = pR -1;
			}
			if (pL < pR)
			{
				swap(array,pL,pR);
			}
		}
		
		swap(array,pL,r);
		return pL;
	}
	
	public void swap(Packet [] a, int l, int r)
	{
		Packet temp;
		
		temp = a[l];
		
		a[l] = a[r];
		
		a[r] = temp;
	}
	
	
	public void online(Trolley[] trolleyList,Packet [] parcels)
	{
		for(Packet p : parcels)
		{
			boolean success = false;
			int i = 0;
			while(success == false && i < trolleyList.length)
			{
				success = trolleyList[i].placePacket(p);
				i++;
			}
		}
	}
	
	public void offline(Trolley[] trolleyList,Packet [] parcels)
	{
		QuickSort(parcels, 0, parcels.length-1);
		
		for(Packet p : parcels)
		{
			boolean success = false;
			int i = 0;
			while(success == false && i < trolleyList.length)
			{
				success = trolleyList[i].placePacket(p);
				i++;
			}
		}
	}
}

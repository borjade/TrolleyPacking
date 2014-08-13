
public class Test 
{
	static int GLOBAL_SIZE = 100;
	public  static void main(String[] args)
	{
		Setup setup = new Setup();
		
		Packet[] packets = setup.createRandomPackets(GLOBAL_SIZE);
		Trolley[] offlineTrolleys = new Trolley[GLOBAL_SIZE];
		Trolley[] onlineTrolleys = new Trolley[GLOBAL_SIZE];
		
		//Populate the arrays with empty trolleys
		for(int i = 0; i < offlineTrolleys.length; i++)
		{
			 Trolley newTrolley = new Trolley();
			 newTrolley.pop();
			 offlineTrolleys[i] = newTrolley;
		}
		for(int i = 0; i < onlineTrolleys.length; i++)
		{
			 Trolley newTrolley = new Trolley();
			 newTrolley.pop();
			 onlineTrolleys[i] = newTrolley;
		}
		
		//Time Tests
		float durationMS = 0;
		for (int i = 0; i <100; i++)
		{
			long startTimeNano = System.nanoTime();
			setup.online(onlineTrolleys, packets);
			long endTimeNano = System.nanoTime();
			durationMS = durationMS +   (endTimeNano - startTimeNano);
		}
		durationMS= durationMS/100;
		System.out.print("\n....:::::online Test 100 tests:::::...."); 
		System.out.print("\nAverage Duration in milliseconds: " + durationMS/1000000f);
		System.out.print("\n......::::::::::::::::::::......\n");
		
		
	
		
		float durationMS2 = 0;
		for (int i = 0; i <100; i++)
		{
			long startTimeNano2 = System.nanoTime( );
			setup.offline(offlineTrolleys, packets);
			long endTimeNano2 = System.nanoTime( );
			durationMS2 = durationMS2+  (endTimeNano2 - startTimeNano2);
		}
		durationMS2= durationMS2/100;
		System.out.print("\n....:::::offline Test 100 tests:::::....");	
		System.out.print("\nAverage Duration in milliseconds: " + durationMS2/1000000f);
		System.out.print("\n......::::::::::::::::::::......\n"); 
		
		
		//Packing Tests
		Packet[] packets2 = setup.createRandomPackets(GLOBAL_SIZE);
		Trolley[] offlineTrolleys2 = new Trolley[GLOBAL_SIZE];
		Trolley[] onlineTrolleys2 = new Trolley[GLOBAL_SIZE];
		
		
		//Populate the arrays with empty trolleys
		for(int i = 0; i < offlineTrolleys2.length; i++)
		{
			 Trolley newTrolley = new Trolley();
			 newTrolley.pop();
			 offlineTrolleys2[i] = newTrolley;
		}
		for(int i = 0; i < onlineTrolleys2.length; i++)
		{
			 Trolley newTrolley = new Trolley();
			 newTrolley.pop();
			 onlineTrolleys2[i] = newTrolley;
		}
		
		setup.online(onlineTrolleys2, packets2);
		setup.offline(offlineTrolleys2, packets2);
		
		System.out.print("\n....:::::online Test:::::....");
		int onlineCount = 0;
		for(Trolley t :onlineTrolleys2 )
		{
			if (!(t ==null)) { t.print(); onlineCount++;}
		}
		System.out.print("\nNo. of Trolleys: "+onlineCount); 
		System.out.print("\n....:::::offline Test:::::....");
		int offlineCount = 0;
		for(Trolley t :offlineTrolleys2 )
		{
			if (!(t ==null)) { t.print();  offlineCount++;}
		}
		System.out.print("\nNo. of Trolleys: "+offlineCount);  
		
	}
	
		
}



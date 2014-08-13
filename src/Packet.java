
public class Packet 
{
	public int height,width,size;
	public String type;
	
	public Packet(int h,int w, String t)
	{
		height = h;
		width = w;
		type=t; 
		size = height * width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public String getType()
	{
		return type;
	}
	
	public int getSize()
	{
		return size;
	}
	
	public String toString()
	{
		return ""+ type + " height:" + height + " width:"+width;
	}
}

package package2;
import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> names= new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Alekhya");
		names.add("Adam");
		names.add("Reenu");
		int count=0;
		for(int i=0;i<names.size();i++)
		{
			String actualName=names.get(i);
			if(actualName.startsWith("Ad"))
			{
				count++;
			}
			
			
	}
		System.out.println(count);

	}}


public class CoreJavaBrushUp3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "Nitin Dixit Academy";
		
		String[] splittedString=s.split("Dixit");
	
		System.out.println(splittedString[0]);

		System.out.println(splittedString[1].trim());

		//System.out.println(splittedString[2]);
		for(int i=s.length()-1; i>=0; i--)
		{
			
			System.out.println(s.charAt(i));
		}

	}

}


public class CoreJavaBrushUp1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num=5;
		System.out.println(num  + "is the number stored");
		
		int[] arr = new int[5];
		arr[0]=7;
		arr[1]=2;
		arr[2]=8;
		arr[3]=4;
		arr[4]=5;
		int[] arr2= {1,2,4,6};
		System.out.println(arr2[2]);
		
		for(int i=0 ; i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
		
		
		String[] name= {"Nitin", "Reenu" ,"Navya" , "Kunj"};
		
		for(int i =0 ; i<name.length;i++)
		{
			System.out.println(name[i]);

        }
		
		for(String s: name)
		{
			System.out.println(s);
		}
			

	}

}

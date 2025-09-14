package package2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTest {
	
	//@Test
	public void regular() {
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
		if(actualName.startsWith("A"))
		{
			count++;
		}
		
		
}
	System.out.println(count);
	}
	
	//@Test
	public void streamFilter()
	{
		ArrayList<String> names= new ArrayList<String>();
		names.add("Abhijeet");
		names.add("Don");
		names.add("Alekhya");
		names.add("Adam");
		names.add("Reenu");
		//there is no life for intermediate operation if there is no terminal op
		//terminal operation will execute only if intermediate op return true
		//we can create with stream package
		Long c =names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);
		
		long d=Stream.of("Abhijeet" ,"Don","Alekhya","Adam","Reenu").filter(s->
		{
			s.startsWith("A");
			return true;
		}).count();
		
		System.out.println(d);
		
		//print all the names of arraylist
		//names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
	}
	@Test
	
	public void StreamMap()
	{
		//print names which have last letter as "a"
	Stream.of("Abhijeet" ,"Don","Alekhya","Adam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		//print which have first letter as with upper case and sorted
	Stream.of("Abhijeet" ,"Don","Alekhya","Adam","Rama").filter(s->s.startsWith("a")).map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		
		List<String> names1= Arrays.asList("Azhijeet" ,"Don","Alekhya","Adam","Rama");
		//names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		
		ArrayList<String> names2= new ArrayList<String>();
		names2.add("bhijeet");
		names2.add("Mon");
		names2.add("Blekhya");
		names2.add("Adam");
		names2.add("Reenu");
		//merging two differents list
		Stream<String> newStream=Stream.concat(names1.stream(), names2.stream());
		//newStream.sorted().forEach(s->System.out.println(s));
		boolean flag=newStream.anyMatch(s->s.equalsIgnoreCase("Adam"));
		System.out.println(flag);
		Assert.assertTrue(flag);
		
	}
	
	
	@Test
	public void streamCollect()
	{
		List<String> newList=Stream.of("Abhijeet" ,"Don","Alekhya","Adam","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).collect(Collectors.toList());
		System.out.println(newList.get(0));
	
		List<Integer> values= Arrays.asList(1,2,2,5,6,7);
		//print unique number from this array
		//sort the array -3rd index
		
		values.stream().distinct().forEach(s->System.out.println(s));
		List<Integer> ls=values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(ls.get(2));
	}
	
}



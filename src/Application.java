import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//learning how to sort lists
//this lesson will work for any list
//but we'll focus on ArrayList because it's the simplest

public class Application {

	public static void main(String[] args) {

		List<String> animals = new ArrayList<String>();

		animals.add("cat");
		animals.add("dog");
		animals.add("bird");
		animals.add("bear");
		animals.add("zebra");
		animals.add("snake");

		Collections.sort(animals);

		for (String animal : animals) {
			System.out.println(animal);
		}

		List<Integer> numbers = new ArrayList<Integer>();

		numbers.add(4);
		numbers.add(9);
		numbers.add(1);
		numbers.add(-5);
		numbers.add(8);
		numbers.add(2);

		Collections.sort(numbers);

		for (Integer number : numbers) {
			System.out.println(number);
		}

		// "sort" does natural order.
		// how do you sort in another order?
		// we need a comparator class,
		// that we create ourselves
		// and that inherits the built-in Comparator class
		// see below

		// and here is where we create an instance of that class:
		Collections.sort(animals, new StringLengthComparator());
		
		for (String animal : animals) {
			System.out.println(animal);
		}
		
		//reverse alpha order:
		//start with creating a comparator class to sort alphabetically, below.
		
		Collections.sort(animals, new AlphabeticalComparator());
		
		for (String animal : animals) {
			System.out.println(animal);
		}
		
		Collections.sort(animals, new ReverseAlphaComparator());
		
		for (String animal : animals) {
			System.out.println(animal);
		}
		
		//this next block comes later in the video.
		//you don't have to create a class to do the work
		//you can just create a method
		//here we have a method to reverse order our integers
		//I think it works because Comparator is already a class somewhere
		//and we just write the method we want
		Collections.sort(numbers, new Comparator<Integer>() {

			@Override
			public int compare(Integer n1, Integer n2) {
				return -n1.compareTo(n2);
			}
			
		});
		
		//you'll see it work here:
		for (Integer number : numbers) {
			System.out.println(number);
		}
		
		//and here's how you sort your own objects
		//we'll sort Person, which are created in a class below.
		List<Person> people = new ArrayList<Person>();
		
		people.add(new Person(1, "Joe"));
		people.add(new Person(5, "Bob"));
		people.add(new Person(2, "Sue"));
		people.add(new Person(4, "Meg"));
		people.add(new Person(3, "Sam"));
		
		//this will print them in order entered.
		for (Person person : people) {
			System.out.println(person);
		}
		
		//to sort some other way:
		//we have to create a comparator
		//(presumably either here or in a class)
		//note we can't use regular "sort" because
		//objects we create (as opposed to built-in types)
		//don't have a natural way to sort
		//ie, java can't read your mind
		
		//this will sort via value of id:
		Collections.sort(people, new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				
				if (p1.getId() > p2.getId()) {
					return 1;
				}
				
				else if (p1.getId() < p2.getId()) {
					return -1;
				}
				
				else {
					return 0;
				}
			}
			
		});
		
		//this will now print in order of id
		for (Person person : people) {
			System.out.println(person);
		}
		
		//sort in order of name:
		Collections.sort(people, new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				return p1.getName().compareTo(p2.getName());
			}
			
		});
		
		//this will now print in order of name (alphabetical)
		for (Person person : people) {
			System.out.println(person);
		}
	}
}

class StringLengthComparator implements Comparator<String> {
	// use the red X to import the util then add the compare method
	// java provides the bare bones, you need to write the comparisons

	@Override
	public int compare(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();

		if (len1 < len2) {
			return -1;
		}

		else if (len1 > len2) {
			return 1;
		}
		
		else  {
			return 0;
		}

	}

}

class AlphabeticalComparator implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {

		return s1.compareTo(s2);
		//we'll look at compareTo in the next lesson
		//in short: this is how you get natural order
	}
	
}

class ReverseAlphaComparator implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {
		return -s1.compareTo(s2);
		//the only difference here is the minus sign
		//it reverses the natural order
	}
	
}

class Person{
	private int id;
	private String name;
	
	public Person (int id, String name) {
		this.id = id;
		this.name = name;
	}

	//rt-click, source, getters and setters:
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}

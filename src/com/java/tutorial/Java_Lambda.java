package com.java.tutorial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Java_Lambda {
	/*
	 * References: 
	 * https://www.mkyong.com/java8/java-8-foreach-examples/ 
	 * https://www.mkyong.com/java8/java-8-lambda-comparator-example/
	 * http://www.tutorialspoint.com/java8/java8_lambda_expressions.htm
	 */

	public static void main(String args[]) {

		Java_Lambda lambda = new Java_Lambda();

		System.out.println(" Lambda for Interface Impl 1 *********");
		lambda.lambdaForInterfaceImpl1();
		System.out.println(" Lambda for Interface Impl 2 *********");
		lambda.lambdaForInterfaceImpl2();
		System.out.println(" Lambda for ForEach ********* ");
		lambda.lamdasForEach();
		System.out.println(" Lambda for ForEach and Map ********* ");
		lambda.lamdasForEachAndMap();
		System.out.println(" Lambda for Sort  ********* ");
		lambda.sortWithLambda();
	}

	private boolean String;

	// lamdas for Interface Impl
	public void lambdaForInterfaceImpl1() {
		/*
		 * This is an example for Java 8 lambda expression. We have
		 * MathOperation as an interface. We have passed in 4 different
		 * implementation at runtime. Before Java 8 if we had to code this we
		 * will have create four different implementation classes of Interface
		 * MathOperation. eg AdditionOperation implements MathOperation and call
		 * it as MathOperation addition = new AdditionOperation();
		 * addition.operate. But we lambda expression we are passing the
		 * implmentation at run time. Also the syntax of lambda expression is
		 * ()->{}. () can have optional params {} has implementation.
		 */
		Java_Lambda lambda = new Java_Lambda();
		// with type declaration
		MathOperation addition = (int a, int b) -> a + b;

		// with out type declaration
		MathOperation subtraction = (a, b) -> a - b;

		// with return statement along with curly braces
		MathOperation multiplication = (int a, int b) -> {
			return a * b;
		};

		// without return statement and without curly braces
		MathOperation division = (int a, int b) -> a / b;

		System.out.println("10 + 5 = " + lambda.operate(10, 5, addition));
		System.out.println("10 - 5 = " + lambda.operate(10, 5, subtraction));
		System.out.println("10 x 5 = " + lambda.operate(10, 5, multiplication));
		System.out.println("10 / 5 = " + lambda.operate(10, 5, division));
	}

	// lamdas for Interface Impl
	public void lambdaForInterfaceImpl2() {
		/*
		 * This is an example for Java 8 lambda expression. We have Test as an
		 * interface. We have passed in 4 different implementation at runtime.
		 * Before Java 8 if we had to code this we will have create four
		 * different implementation classes of Interface Test. eg Test1
		 * implements Test and call it as Test t = new Test1(); t.test(); But we
		 * lambda expression we are passing the implementation at run time.
		 */

		Test testing1 = () -> {
			System.out.println(" This is a testing first implementation ");
		};

		Test testing2 = () -> {
			int i = 10;
			int j = 20;
			System.out.println(i + j + " This is a testing second implementation");
		};

		Test testing3 = () -> {
			System.out.println(" This is testing third implementation ");
		};

		Test testing4 = () -> {
			System.out.println(" This is testing fourth implementation ");
		};

		testing1.test();
		testing2.test();
		testing3.test();
		testing4.test();
	}

	// lamdas for each
	public void lamdasForEach() {
		/*
		 * Before java 8 we would use for Each as follows
		 * 
		 * forEach(String s : list){
		 *  System.out.println(s.toUpperCase()); 
		 * }
		 */
		ArrayList<String> list = new ArrayList<String>() {
			{
				add("Kohli");
				add("Tendulkar");
				add("Rahane");
			}
		};

		list.forEach(item -> {
			System.out.println(item.toString().toUpperCase());
		});
	}

	// lamdas for each and map
	public void lamdasForEachAndMap() {

		/*
		 * Before java 8 we would iterate map as follows 
		 * Iterator entries =items.entrySet().iterator(); 
		 * while (entries.hasNext()) 
		 * { Map.Entry entry = (Map.Entry) entries.next(); 
		 *  Integer key = (Integer)entry.getKey(); 
		 *  Integer value = (Integer)entry.getValue();
		 *  System.out.println("Key = " + key + ", Value = " + value); }
		 */

		Map<String, Integer> items = new HashMap<String, Integer>() {
			{
				put("A", 10);
				put("B", 20);
				put("C", 30);
				put("D", 40);
				put("E", 50);
				put("F", 60);
			}
		};

		items.forEach((k, v) -> {
			System.out.println("key " + k + "value " + v);
		});
	}

	// lambdas for sort
	public void sortWithLambda() {
		
		/* 
		 * Before Java 8 we would comapre ages like this 
		  	//sort by age
		    Collections.sort(listDevs, new Comparator<Developer>() {
			@Override
			public int compare(Developer o1, Developer o2) {
				return o1.getAge() - o2.getAge();
			}
		  });
		  
		  //sort by name
          Collections.sort(listDevs, new Comparator<Developer>() {
	      @Override
	      public int compare(Developer o1, Developer o2) {
		  return o1.getName().compareTo(o2.getName());
	      }
          });
		 */

		Developer d1 = new Developer().setName("aniket").setAge(28);
		Developer d2 = new Developer().setName("andy").setAge(27);
		Developer d3 = new Developer().setName("lucy").setAge(24);

		List<Developer> sortIt = new ArrayList<Developer>();
		sortIt.add(d1);
		sortIt.add(d2);
		sortIt.add(d3);

		sortIt.sort((o1, o2) -> o1.getAge() - o2.getAge());

		sortIt.forEach((d) -> {
			System.out.println(d.toString());
		});

		sortIt.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));

		sortIt.forEach((d) -> {
			System.out.println(d.toString());
		});
	}

	// create interface and pass lamdas from implementation
	interface MathOperation {
		int operation(int a, int b);
	}

	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}

	interface Test {
		void test();
	}

	private class Developer {

		private String name;
		private int age;

		public Developer setName(String name) {
			this.name = name;
			return this;
		}

		public Developer setAge(int age) {
			this.age = age;
			return this;
		}

		public String getName() {
			return name;
		}

		public int getAge() {
			return age;
		}

		@Override
		public String toString() {
			return "Developer [name=" + name + ", age=" + age + "]";
		}
	}

}

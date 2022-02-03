package c.demo.graalvm.js;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;

public class GraalvmDemo {

	public static void main(String[] args) throws IOException {

		Context polyglot = Context.create();
		polyglot.eval("js", "print('Hello From JavaScript!')");

		String totalString = "";
		File file = new File("E:\\js\\demo.js");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(file);
		sc.useDelimiter("\\Z");
		while (sc.hasNext()) {
			totalString = totalString + sc.next();
		}
		Value helloWorldFunction = polyglot.eval("js", totalString);
		String greeting = helloWorldFunction.execute("Akshant").asString();
		System.out.println(greeting);
		
	}
}

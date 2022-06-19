package utility;
/**
 * Tests key input values and resulting functionality for all methods
 * in the Util class.
 */
public class UtilRunner {
	public static void main(String[] args) {
		trySpecialCases();
		
		printBlankLine();
		print("iterativeFactorial(0)", Util.iterativeFactorial(0), 1);
		print("recursiveFactorial(0)", Util.recursiveFactorial(0), 1);
		print("iterativeFactorial(5)", Util.iterativeFactorial(5), 120);
		print("recursiveFactorial(5)", Util.recursiveFactorial(5), 120);
		print("iterativeFactorial(10)", Util.iterativeFactorial(10), 3628800);
		print("recursiveFactorial(10)", Util.recursiveFactorial(10), 3628800);

		printBlankLine();
		print("iterativeDigitSum(0)", Util.iterativeDigitSum(0), 0);
		print("recursiveDigitSum(0)", Util.recursiveDigitSum(0), 0);
		print("iterativeDigitSum(10)", Util.iterativeDigitSum(10), 1);
		print("recursiveDigitSum(10)", Util.recursiveDigitSum(10), 1);
		print("iterativeDigitSum(Long.MAX_VALUE)", 
			Util.iterativeDigitSum(Long.MAX_VALUE), 88);
		print("recursiveDigitSum(Long.MAX_VALUE)", 
			Util.recursiveDigitSum(Long.MAX_VALUE), 88);
		
		printBlankLine();
		print("iterativeFibonacci(1)", Util.iterativeFibonacci(1), 0);
		print("recursiveFibonacci(1)", Util.recursiveFibonacci(1), 0);
		print("iterativeFibonacci(9)", Util.iterativeFibonacci(9), 21);
		print("recursiveFibonacci(9)", Util.recursiveFibonacci(9), 21);

		printBlankLine();
		print("iterativeStringGen(\"Hi\", 0)", 
			Util.iterativeStringGen("Hi", 0), "");
		print("recursiveStringGen(\"Hi\", 0)", 
			Util.recursiveStringGen("Hi", 0), "");
		print("iterativeStringGen(\"Hi\", 1)", 
			Util.iterativeStringGen("Hi", 1), "Hi");
		print("recursiveStringGen(\"Hi\", 1)", 
			Util.recursiveStringGen("Hi", 1), "Hi");
		print("iterativeStringGen(\"Hi\", 4)", 
			Util.iterativeStringGen("Hi", 4), "Hi, Hi, Hi, Hi");
		print("recursiveStringGen(\"Hi\", 4)", 
			Util.recursiveStringGen("Hi", 4), "Hi, Hi, Hi, Hi");
		
		printBlankLine();
		int[] emptyArray = new int[0];
		print("iterativeArraySum(*empty array*)", 
			Util.iterativeArraySum(emptyArray), 0);
		print("recursiveArraySum(*empty array*)",
			Util.recursiveArraySum(emptyArray), 0);
		int[] array = {50, 97, 183, 22, 35, 106, -73, 16, 44, 400, -199};
		print("iterativeArraySum(*array*)", Util.iterativeArraySum(array), 681);
		print("recursiveArraySum(*array*)", Util.recursiveArraySum(array), 681);
	
		printBlankLine();
		int[] someEvens = {-2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] noEvens = {3, 7, 9, 11, 15, 1, -3};
		print("iterativeCountOnlyEvens(*empty array*)", 
			Util.iterativeCountOnlyEvens(emptyArray), 0);
		print("recursiveCountOnlyEvens(*empty array*)", 
			Util.recursiveCountOnlyEvens(emptyArray), 0);
		print("iterativeCountOnlyEvens(*some evens*)", 
			Util.iterativeCountOnlyEvens(someEvens), 7);
		print("recursiveCountOnlyEvens(*some evens*)", 
			Util.recursiveCountOnlyEvens(someEvens), 7);
		print("iterativeCountOnlyEvens(*no evens*)", 
			Util.iterativeCountOnlyEvens(noEvens), 0);
		print("recursiveCountOnlyEvens(*no evens*)", 
			Util.recursiveCountOnlyEvens(noEvens), 0);
	}
	
	private static void trySpecialCases() {
		String callDescription = null;
		try { 
			callDescription = "iterativeFactorial(-5)";
			Util.iterativeFactorial(-5);
			reportBad(callDescription);
		} catch (IllegalArgumentException e) {
			reportGood(callDescription);
		}
		try { 
			callDescription = "recursiveFactorial(-5)";
			Util.recursiveFactorial(-5);
			reportBad(callDescription);
		} catch (IllegalArgumentException e) {
			reportGood(callDescription);
		}
		try { 
			callDescription = "iterativeDigitSum(-5)";
			Util.iterativeDigitSum(-5);
			reportBad(callDescription);
		} catch (IllegalArgumentException e) {
			reportGood(callDescription);
		}
		try { 
			callDescription = "recursiveDigitSum(-5)";
			Util.recursiveDigitSum(-5);
			reportBad(callDescription);
		} catch (IllegalArgumentException e) {
			reportGood(callDescription);
		}
		try { 
			callDescription = "iterativeFibonacci(0)";
			Util.iterativeFibonacci(0);
			reportBad(callDescription);
		} catch (IllegalArgumentException e) {
			reportGood(callDescription);
		}
		try { 
			callDescription = "recursiveFibonacci(0)";
			Util.recursiveFibonacci(0);
			reportBad(callDescription);
		} catch (IllegalArgumentException e) {
			reportGood(callDescription);
		}
		try { 
			callDescription = "iterativeStringGen(\"abc\", -1)";
			Util.iterativeStringGen("abc", -1);
			reportBad(callDescription);
		} catch (IllegalArgumentException e) {
			reportGood(callDescription);
		}
		try { 
			callDescription = "recursiveStringGen(\"abc\", -1)";
			Util.recursiveStringGen("abc", -1);
			reportBad(callDescription);
		} catch (IllegalArgumentException e) {
			reportGood(callDescription);
		}
	}
	
	private static void reportBad(String s) {
		System.out.println("Error: Exception not thrown for " + s + ".");
	}
	
	private static void reportGood(String s) {
		System.out.println("Good: Exception being generated for " + s + ".");
	}
	
	private static void print(String methodCall, long result, long expected) {
		System.out.print("Result of " + methodCall + ": [" + result + "] ");
		if (result == expected) System.out.println("Good!");
		else System.out.println("Incorrect. Expected [" + expected + "]");
	}

	private static void print(String methodCall, String result, 
			String expected) {
		System.out.print("Result of " + methodCall + ": [" + result + "] ");
		if (result.equals(expected)) System.out.println("Good!");
		else System.out.println("Incorrect. Expected [" + expected + "]");
	}
	
	private static void printBlankLine() {
		System.out.println();
	}
}

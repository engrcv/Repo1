package java3_CalculatorPack;

import java.util.Scanner;

public class MyCalculatorSimple {

    public static void main(String[] args) {

    	double num1, num2;
    	
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first number:");
         
        num1 = scanner.nextDouble();
        System.out.print("Enter second number:");
        num2 = scanner.nextDouble();

        System.out.print("Enter an operator (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        scanner.close();
        
      //Double is used so that user can enter integer as well as floating point value
        Double output;
        Double n1 = num1, n2 = num2; //Auto-boxing

        switch(operator)
        {
            case '+':
            	output = n1 + n2;
                break;

            case '-':
            	output = n1 - n2;
                break;

            case '*':
            	output = n1 * n2;
                break;

            case '/':
            	output = n1 / n2;
                break;

            default:
                System.out.printf("You have entered wrong operator");
                return;
        }
        double result = output; //unboxing
        System.out.println(num1+" "+operator+" "+num2+": "+result);
    }
}
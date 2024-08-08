import java.util.Scanner;

class Calculate {
    private Double num1;
    private Double num2;
    private Character operator;

    public Calculate (Double num1, Double num2, Character operator) {
        this.num1 = num1;
        this.num2 = num2;
        this.operator = operator;
    }

    public Double add() {
        return num1 + num2;
    }
    public Double subtract() {
        return  num1 - num2;
    }
    public Double multiply(){
        return num1 * num2;
    }
    public Double divide(){
        return num1 / num2;
    }
    public Double power(){
        return Math.pow(num1, num2);
    }
    public Double modulo(){
        return num1 % num2;
    }
    // Method to calculate result based on operator
    public Double calculate(){
        switch (operator){
            case '+':
                return add();
            case '-':
                return subtract();
            case '*':
                return multiply();
            case '/':
                return divide();
            case '^':
                return power();
            case '%':
                return modulo();
            default:
                System.out.println("Invalided operator");
            return 0.0;    // Indicates a valid, but specific, result
        }
    }
}
public class Exercise2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //asking user to enter numbers and operator
        System.out.println("Enter number1, operator and number2 separated by space : ");
        Double num1 = scanner.nextDouble();
        Character operator = scanner.next().charAt(0);  // method returns the character at the specified index of the String
                                                        //In this case, 0 is the index, so charAt(0) returns the first character of the String.
        Double num2 = scanner.nextDouble();

        // object of Calculate
        Calculate calculate = new Calculate(num1, num2, operator);


        System.out.println("Result of Calculating  : " + calculate.calculate()); // calculate(): confirm operator


    }
}

/* NaN = Not a Numbers
“Nan” is produced if a floating point operation has some input parameters
that cause the operation to produce some undefined result.
For example, 0.0 divided by 0.0 is arithmetically undefined.
*/
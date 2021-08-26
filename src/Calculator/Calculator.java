package Calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        startCalc();

        while (true) {

            System.out.println("Input: ");
            String line = scanner.nextLine();

            if (line.equals("exit")) {
                exitCalc();
                break;
            }

            try {
                String[] symbols = line.split(" "); {
                    //Добавлен пробел для соответствия заданию и улучшения читаемости.
                    if (symbols.length == 1)
                        throw new  Exception("Строка не является математической операцией");
                    else if (symbols.length != 3)
                        throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                }
                Number firstNumber = NumberService.parseAndValidate(symbols[0]);
                Number secondNumber = NumberService.parseAndValidate(symbols[2], firstNumber.getType());
                String result = ActionService.calculate(firstNumber, secondNumber, symbols[1]);
                System.out.println("Output: \n" + result);

            } catch (Exception e) {
                System.out.println(e.getMessage());
                exitCalc();
                break;
            }
        }

        scanner.close();
    }

    private static void startCalc() {
        System.out.println("Добро пожаловать в Калькулятор , он работает только с арабскими и римскими цифрами от 1 до 10");
        System.out.println("Пожалуйста, вводите исходные данные через знак ПРОБЕЛ!");
        System.out.println("Если Вы хотите покинуть программу, введите 'exit'");
    }

    private static void exitCalc() {

        System.out.println("До скорых встреч!");

    }
}

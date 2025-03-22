import java.util.Scanner;

public class Main {
    public static int minPasswordLength;
    public static int maxRepeats;

    public static void main(String[] args) {
        PasswordChecker passwordChecker = new PasswordChecker();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите мин. длину пароля: ");
            minPasswordLength = Integer.parseInt(scanner.nextLine());
            passwordChecker.setMinLength(minPasswordLength);

            System.out.print("Введите макс. допустимое количество повторений символа подряд: ");
            maxRepeats = Integer.parseInt(scanner.nextLine());
            passwordChecker.setMaxRepeats(maxRepeats);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            while (true) {
                Scanner scanner2 = new Scanner(System.in);
                System.out.print("Введите пароль или end: ");
                String input = scanner2.nextLine();
                if (input.equals("end")) {
                    System.out.println("Программа завершена");
                    break;
                } else {
                    System.out.println(passwordChecker.verify(input) ? "Подходит!" : "Не подходит!");
                }
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}

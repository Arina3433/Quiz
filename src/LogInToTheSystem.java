import java.util.InputMismatchException;
import java.util.Scanner;

public class LogInToTheSystem {

    private int inputToSelectRole;

    public LogInToTheSystem() {
        System.out.println("Здравствуйте! Добро пожаловать в систему.\nПожалуйста, выберите как вы хотите войти:");
    }

    public void inputToSelectRoleSetValue() {
        while (true) {
            try {
                System.out.println("\nВведите \"1\" если хотите войти как " +
                        "учитель\nВведите \"2\" если хотите войти как ученик");
                this.inputToSelectRole = new Scanner(System.in).nextInt();
                if (inputToSelectRole == 1) {
                    System.out.println("Учитель, добро пожаловать");
                    break;
                }
                else if (inputToSelectRole == 2) {
                    System.out.println("Ученик, добро пожаловать");
                    break;
                }
                else
                    System.out.println("Некорректный формат ввода, попробуйте еще раз");
                } catch (Exception e) {
                System.out.println("Некорректный формат ввода, попробуйте еще раз");
                }
            }
    }
}

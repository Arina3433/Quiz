import java.util.LinkedList;

public class InformationOutput {

    public void logInToTheSystemGreeting() {
        System.out.println("Добро пожаловать в систему!\nПожалуйста, выберите как вы хотите войти:");
    }

    public void askForRoleSelectionText() {
        System.out.println("\tВведите \"1\" если хотите войти как учитель" +
                "\n\tВведите \"2\" если хотите войти как ученик");
    }

    public void askForDesireToContinueText() {
        System.out.println("\nЖелаете продолжить?" +
                "\n\tВведите \"1\" если хотите вернуться к списку действий" +
                "\n\tВведите \"2\" если хотите выйти из приложения");
    }

    public void outputErrorMessage() {
        System.out.println("Некорректный формат ввода, попробуйте еще раз");
    }

    public void teacherModeGreeting() {
        System.out.println("Приветствуем, учитель! Выберете, что вы хотите сделать:");
    }

    public void StudentModeGreeting() {
        System.out.println("Приветствуем, ученик! Вам доступен квиз из 5 вопросов");
    }



}

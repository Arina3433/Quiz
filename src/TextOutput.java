public class TextOutput {

    public static void logInToTheSystemGreeting() {
        System.out.println("Добро пожаловать в систему!\nПожалуйста, выберите как вы хотите войти:");
    }

    public static void logInToTheTeacherModeGreeting() {
        System.out.println("Приветствуем, учитель! Выберете, что вы хотите сделать:");
    }

    public static void logInToTheStudentModeGreeting() {
        System.out.println("Приветствуем, ученик! Вам доступен квиз из 5 вопросов\nГотовы начать?");
    }

    public static void askForRoleSelectionText() {
        System.out.println("\tВведите \"1\" если хотите войти как учитель" +
                "\n\tВведите \"2\" если хотите войти как ученик");
    }

    public static void outputErrorMessage() {
        System.out.println("Некорректный формат ввода, попробуйте еще раз");
    }

    public static void askForTeacherSelectAction() {
        System.out.println("\tВведите \"1\" если хотите добавить вопрос " +
                "\n\tВведите \"2\" если хотите вывести на экран все вопросы из базы" +
                "\n\tВведите \"3\" если хотите вернуться к выбору роли" +
                "\n\tВведите \"4\" если хотите выйти из приложения");
    }

    public static void askForDesireToContinueEnterQuestionText() {
        System.out.println("Хотите ввести еще один вопрос?" +
                "\n\t\"1\" - да" +
                "\n\t\"2\" - нет");
    }

    public static void denyStudentAccessText() {
        System.out.println("В базе менее 5 вопросов, прохождение квиза на данный момент невозможно." +
                "\nПовторите попытку позже");
    }

    public static void askingForReadyToStartText() {
        System.out.println("\tВведите \"1\" если хотите приступить" +
                "\n\tВведите \"2\" если хотите вернуться к выбору роли" +
                "\n\tВведите \"3\" если хотите выйти из приложения");
    }

    public static void askForDesireToContinueText() {
        System.out.println("Желаете продолжить?" +
                "\n\tВведите \"1\" если хотите вернуться к списку действий" +
                "\n\tВведите \"2\" если хотите вернуться к выбору роли" +
                "\n\tВведите \"3\" если хотите выйти из приложения");
    }


}

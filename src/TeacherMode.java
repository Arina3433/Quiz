import java.util.LinkedList;
import java.util.Scanner;

public class TeacherMode {

    private int inputToSelectAction;
    private LinkedList<String> questionsList;

    public TeacherMode(LinkedList<String> questionsList) {
        this.questionsList = questionsList;
        System.out.println("Приветствуем, учитель! Выберете, что вы хотите сделать:");
    }

    public void inputToSelectActionSetValue() {
        while (true) {
            try {
                System.out.println("\tВведите \"1\" если хотите добавить вопрос " +
                        "\n\tВведите \"2\" если хотите вывести на экран все вопросы из базы" +
                        "\n\tВведите \"3\" если хотите выйти из приложения");
                this.inputToSelectAction = new Scanner(System.in).nextInt();
                if (inputToSelectAction == 1) {
                    selectedAddQuestion();
                    askingForDesireToContinue();
                } else if (inputToSelectAction == 2) {
                    selectedDisplayAllQuestions();
                    askingForDesireToContinue();
                } else if (inputToSelectAction == 3) {
                    System.exit(0);
                } else
                    System.out.println("Некорректный формат ввода, попробуйте еще раз");
            } catch (Exception e) {
                System.out.println("Некорректный формат ввода, попробуйте еще раз");
            }
        }
    }

    public void selectedAddQuestion() {
        System.out.println("Введите вопрос, который хотите добавить:");
        questionsList.add(new Scanner(System.in).nextLine());
    }

    public void selectedDisplayAllQuestions() {
        System.out.println("Вывести на экран все вопросы из базы");
        for (String el: questionsList) {
            int i = 0;
            i++;
            System.out.println(i + "." + el);
        }
    }

    public void askingForDesireToContinue() {
        while (true) {
            try {
                System.out.println("\nЖелаете продолжить?" +
                        "\n\tВведите \"1\" если хотите вернуться к списку действий" +
                        "\n\tВведите \"2\" если хотите выйти из приложения");
                this.inputToSelectAction = new Scanner(System.in).nextInt();
                if (inputToSelectAction == 1) {
                    System.out.println("Что вы хотите сделать:");
                    break;
                }
                else if (inputToSelectAction == 2) {
                    System.exit(0);
                } else
                    System.out.println("Некорректный формат ввода, попробуйте еще раз");
            } catch (Exception e) {
                System.out.println("Некорректный формат ввода, попробуйте еще раз");
            }
        }
    }
}

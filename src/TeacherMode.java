import java.util.LinkedList;
import java.util.Scanner;

public class TeacherMode {

    private int inputToSelectAction;
    private ListRepository questionsRepository;

    public TeacherMode(ListRepository questionsRepository) {
        this.questionsRepository = questionsRepository;
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
        Question question = new Question();

        System.out.println("Введите вопрос, который хотите добавить:");
        question.setText(new Scanner(System.in).nextLine());

        System.out.println("Введите варианты ответа:");
        LinkedList<String> answers = new LinkedList<>();
        for () {
            answers.add(new Scanner(System.in).nextLine());
        }
        question.setAnswers(answers);
        //добавляем правильный ответ
        question.setCorrectAnswer(new Scanner(System.in).nextInt());

        questionsRepository.addQuestionToList(question);

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

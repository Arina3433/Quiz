import java.util.Scanner;

public class DataProcessing {

    private int inputToSelectRole;
    private static int inputToSelectDesireToContinue;

// ???
static InformationOutput informationOutput = new InformationOutput();

    public void inputToSelectRoleSetValue() {
        while (true) {
            try {
                informationOutput.askForRoleSelectionText();
                this.inputToSelectRole = new Scanner(System.in).nextInt();
                if (inputToSelectRole == 1) {
                    selectedTeacher();
                    break;
                } else if (inputToSelectRole == 2) {
                    selectedStudent();
                    break;
                } else
                    informationOutput.outputErrorMessage();
            } catch (Exception e) {
                informationOutput.outputErrorMessage();
            }
        }
    }

    public static void askingForDesireToContinue() {
        while (true) {
            try {
                informationOutput.askForDesireToContinueText();
                inputToSelectDesireToContinue = new Scanner(System.in).nextInt();
                if (inputToSelectDesireToContinue == 1) {
                    System.out.println("Что вы хотите сделать:");
                    break;
                } else if (inputToSelectDesireToContinue == 2) {
                    System.exit(0);
                } else
                    informationOutput.outputErrorMessage();
            } catch (Exception e) {
                informationOutput.outputErrorMessage();
            }
        }
    }



    public void selectedTeacher() {
        TeacherMode teacherMode = new TeacherMode(questionsList);
        teacherMode.inputToSelectActionSetValue();
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
        for (String el : questionsList) {
            int i = 0;
            i++;
            System.out.println(i + "." + el);
        }
    }



    public void selectedStudent() {
// ПРОПИСАТЬ УСЛОВИЕ ПРО 5 ВОПРОСОВ
        StudentMode studentMode = new StudentMode();
    }
}


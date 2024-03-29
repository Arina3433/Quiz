import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class TeacherMode {

    private ListRepository questionsRepository;

    public TeacherMode(ListRepository questionsRepository) {
        this.questionsRepository = questionsRepository;
        TextOutput.logInToTheTeacherModeGreeting();
    }

    public void inputToSelectActionSetValue() {
        while (true) {
            try {
                TextOutput.askForTeacherSelectAction();
                switch (new Scanner(System.in).nextInt()) {
                    case 1:
                        selectedAddQuestion();
                        askingForDesireToContinue();
                        break;
                    case 2:
                        selectedDisplayAllQuestions(questionsRepository.getQuestionsList());
                        askingForDesireToContinue();
                        break;
                    case 3:
                        SelectRole selectRole = new SelectRole(questionsRepository);
                        selectRole.inputToSelectRoleSetValue();
                        break;
                    case 4:
                        System.exit(0);
                    default:
                        TextOutput.outputErrorMessage();
                }
            } catch (Exception e) {
                TextOutput.outputErrorMessage();
            }
        }
    }

    public void selectedAddQuestion() {
        loop:
        while (true) {
            Question question = new Question();

            LinkedList<String> answers = new LinkedList<>();

            question.setText(acceptQuestionText());

            question.setAnswers(acceptAnswerOptions(answers));

            question.setNumberOfCorrectAnswer(acceptNumberOfCorrectAnswer(answers));

            questionsRepository.addQuestionToList(question);

            lowerLoop:
            while (true) {
                try {
                    System.out.println("Вы ввели " + questionsRepository.getQuestionsList().size() + " вопрос(а/ов)");
                    TextOutput.askForDesireToContinueEnterQuestionText();
                    switch (new Scanner(System.in).nextInt()) {
                        case 1:
                            System.out.println("Следующий вопрос:");
                            break lowerLoop;
                        case 2:
                            break loop;
                        default:
                            TextOutput.outputErrorMessage();
                    }
                } catch (Exception e) {
                    TextOutput.outputErrorMessage();
                }
            }
        }
    }

    public String acceptQuestionText() {
        System.out.println("Введите вопрос, который хотите добавить:");
        String questionText = new Scanner(System.in).nextLine();

        return questionText;
    }

    public LinkedList<String> acceptAnswerOptions(LinkedList<String> answers) {
        System.out.println("Введите варианты ответа. Когда введете необходимое вам число ответов," +
                "\nпропишите ключевое слово \"стоп\"");
        while (true) {
            String teacherScan = new Scanner(System.in).nextLine();
            if (!Objects.equals(teacherScan, "стоп")) {
                answers.add(teacherScan);
            } else if (Objects.equals(teacherScan, "стоп") && answers.size() < 2) {
                System.out.println("Должно быть как минимум 2 варианта ответа на вопрос. Введите следующий:");
            } else {
                System.out.println("Вы ввели " + answers.size() + " ответов(а).");
                break;
            }
        }

        return answers;
    }

    public int acceptNumberOfCorrectAnswer(LinkedList<String> answers) {

        int numberOfCorrectAnswer = 0;
        while (true) {
            System.out.println("Введите номер правильного ответа:");
            try {
                int scanNumberOfCorrectAnswer = new Scanner(System.in).nextInt();
                if (scanNumberOfCorrectAnswer <= answers.size() && scanNumberOfCorrectAnswer > 0) {
                    numberOfCorrectAnswer = scanNumberOfCorrectAnswer;
                    break;
                } else {
                    TextOutput.outputErrorMessage();
                }
            } catch (Exception e) {
                TextOutput.outputErrorMessage();
                System.out.println("Error");
            }
        }

        return numberOfCorrectAnswer;
    }

    public void selectedDisplayAllQuestions(ArrayList<Question> questionsList) {
        System.out.println("В базе найдены следующие вопросы:");
        for (int i = 0; i < questionsList.size(); i++) {
            System.out.println((i + 1) + ". " + questionsList.get(i).getText());
        }
        System.out.println();
    }

    public void askingForDesireToContinue() {
        loop:
        while (true) {
            try {
                TextOutput.askForDesireToContinueText();
                switch (new Scanner(System.in).nextInt()) {
                    case 1:
                        System.out.println("Что вы хотите сделать:");
                        break loop;
                    case 2:
                        SelectRole selectRole = new SelectRole(questionsRepository);
                        selectRole.inputToSelectRoleSetValue();
                        break;
                    case 3:
                        System.exit(0);
                    default:
                        TextOutput.outputErrorMessage();
                }
            } catch (Exception e) {
                TextOutput.outputErrorMessage();
            }
        }
    }

}

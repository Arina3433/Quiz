import java.util.ArrayList;
import java.util.Scanner;

public class StudentMode {

    private ListRepository questionsRepository;

    public StudentMode(ListRepository questionsRepository) {
        TextOutput.logInToTheStudentModeGreeting();
        this.questionsRepository = questionsRepository;
    }

    public void askingForReadyToStart() {
        while (true) {
            try {
                TextOutput.askingForReadyToStartText();
                switch (new Scanner(System.in).nextInt()) {
                    case 1:
                        passQuiz();
                        askingForDesireToContinue();
                        break;
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

    public void passQuiz() {

        int studentAssessment = outputOfQuestionsAndReceptionOfAnswers();

        System.out.println("Вы прошли квиз! Ваш результат " + studentAssessment + "/5\n");
    }

    public ArrayList<Question> creatingQuestionsForQuizList() {
        RandomNumber randomNumberArray = new RandomNumber();
        randomNumberArray.generateRandomNumber(questionsRepository.getQuestionsList().size());
        ArrayList<Question> questionsForQuizList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int numberOfRandomQuestion = randomNumberArray.getRandomNumbers().get(i);
            questionsForQuizList.add(questionsRepository.getQuestionsList().get(numberOfRandomQuestion - 1));
        }
        return questionsForQuizList;
    }

    public int outputOfQuestionsAndReceptionOfAnswers() {

        int studentAssessment = 0;
        int answerEnteredStudent;
        ArrayList<Question> questionsForQuizList = creatingQuestionsForQuizList();

        for (int i = 0; i < 5; i++) {
            System.out.println("Вопрос " + (i + 1) + ": " + questionsForQuizList.get(i).getText());

            for (int j = 0; j < questionsForQuizList.get(i).getAnswers().size(); j++) {
                System.out.print((j + 1) + ". " + questionsForQuizList.get(i).getAnswers().get(j) + "     ");
            }

            System.out.println();

            try {
                while (true) {
                    answerEnteredStudent = new Scanner(System.in).nextInt();

                    if (answerEnteredStudent <= questionsForQuizList.get(i).getAnswers().size() &&
                            answerEnteredStudent > 0 &&
                            answerEnteredStudent == questionsForQuizList.get(i).getNumberOfCorrectAnswer()) {
                        studentAssessment++;
                        break;
                    } else if (answerEnteredStudent <= questionsForQuizList.get(i).getAnswers().size() &&
                            answerEnteredStudent > 0) {
                        break;
                    } else {
                        TextOutput.outputErrorMessage();
                    }
                }
            } catch (Exception e) {
                TextOutput.outputErrorMessage();
            }
        }
        return studentAssessment;
    }

    public void askingForDesireToContinue() {
        while (true) {
            try {
                TextOutput.askForDesireToPassAnotherQuiz();
                switch (new Scanner(System.in).nextInt()) {
                    case 1:
                        passQuiz();
                        break;
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

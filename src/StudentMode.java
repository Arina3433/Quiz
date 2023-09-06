import java.util.ArrayList;
import java.util.Scanner;

public class StudentMode {

    private int inputToSelectAction;
    private int studentAssessment = 0;
    private ListRepository questionsRepository;
    private RandomNumber randomNumberArray;
    private ArrayList<Question> questionsForQuizList;

    public StudentMode(ListRepository questionsRepository) {
        TextOutput.logInToTheStudentModeGreeting();
        this.questionsRepository = questionsRepository;
    }

    public void askingForReadyToStart() {
        while (true) {
            try {
                TextOutput.askingForReadyToStartText();
                this.inputToSelectAction = new Scanner(System.in).nextInt();
                switch (inputToSelectAction) {
                    case 1:
                        pussQuiz();
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

    public void pussQuiz() {
        studentAssessment = 0;

        creatingQuestionsForQuizList();

        outputOfQuestionsAndReceptionOfAnswers();

        System.out.println("Вы прошли квиз! Ваш результат " + studentAssessment + "/5\n");
    }

    public void creatingQuestionsForQuizList() {
        randomNumberArray = new RandomNumber();
        randomNumberArray.generateRandomNumber(questionsRepository.getQuestionsList().size());
        questionsForQuizList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int numberOfRandomQuestion = randomNumberArray.getRandomNumbers().get(i);
            questionsForQuizList.add(questionsRepository.getQuestionsList().get(numberOfRandomQuestion - 1));
        }
    }

    public void outputOfQuestionsAndReceptionOfAnswers() {
        int answerEnteredStudent;

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
    }

    public void askingForDesireToContinue() {
        while (true) {
            try {
                TextOutput.askForDesireToPassAnotherQuiz();
                inputToSelectAction = new Scanner(System.in).nextInt();
                switch (inputToSelectAction) {
                    case 1:
                        pussQuiz();
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

import java.util.LinkedList;
import java.util.Scanner;

public class LogInToTheSystem {

    private int inputToSelectRole;
    private ListRepository questionsRepository;

    public LogInToTheSystem(ListRepository questionsRepository) {
        this.questionsRepository = questionsRepository;
        TextOutput.logInToTheSystemGreeting();
    }

    public void inputToSelectRoleSetValue() {
        while (true) {
            try {
                TextOutput.askForRoleSelectionText();
                this.inputToSelectRole = new Scanner(System.in).nextInt();
                if (inputToSelectRole == 1) {
                    selectedTeacher();
                    break;
                }
                else if (inputToSelectRole == 2) {
                    selectedStudent();
                    break;
                }
                else
                    TextOutput.outputErrorMessage();
                } catch (Exception e) {
                TextOutput.outputErrorMessage();
                }
            }
    }

    public void selectedTeacher () {
        TeacherMode teacherMode = new TeacherMode(questionsRepository);
        teacherMode.inputToSelectActionSetValue();
    }

    public void selectedStudent () {
// ПРОПИСАТЬ УСЛОВИЕ ПРО 5 ВОПРОСОВ
        StudentMode studentMode = new StudentMode();
    }
}

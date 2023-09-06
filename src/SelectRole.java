import java.util.Scanner;

public class SelectRole {

    private int inputToSelectRole;
    private ListRepository questionsRepository;

    public SelectRole(ListRepository questionsRepository) {
        this.questionsRepository = questionsRepository;
    }

    public void inputToSelectRoleSetValue() {
        while (true) {
            try {
                TextOutput.askForRoleSelectionText();
                this.inputToSelectRole = new Scanner(System.in).nextInt();
                switch (inputToSelectRole) {
                    case 1:
                        selectedTeacher();
                        break;
                    case 2:
                        if (questionsRepository.getQuestionsList().size() >= 5) {
                            selectedStudent();
                            break;
                        } else {
                            TextOutput.denyStudentAccessText();
                        }
                    default:
                        TextOutput.outputErrorMessage();
                }
            } catch (Exception e) {
                TextOutput.outputErrorMessage();
            }
        }
    }

    public void selectedTeacher() {
        TeacherMode teacherMode = new TeacherMode(questionsRepository);
        teacherMode.inputToSelectActionSetValue();
    }

    public void selectedStudent() {
        StudentMode studentMode = new StudentMode(questionsRepository);
        studentMode.askingForReadyToStart();
    }


}

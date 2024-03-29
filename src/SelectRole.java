import java.util.Scanner;

public class SelectRole {

    private ListRepository questionsRepository;

    public SelectRole(ListRepository questionsRepository) {
        this.questionsRepository = questionsRepository;
    }

    public void inputToSelectRoleSetValue() {
        while (true) {
            try {
                TextOutput.askForRoleSelectionText();
                switch (new Scanner(System.in).nextInt()) {
                    case 1:
                        selectedTeacher();
                        break;
                    case 2:
                        if (questionsRepository.getQuestionsList().size() >= 5) {
                            selectedStudent();
                            break;
                        } else {
                            TextOutput.denyStudentAccessText();
                            continue;
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

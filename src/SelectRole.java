import java.util.Scanner;

public class SelectRole {

    public SelectRole() {
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
                        if (ListRepository.readQuestionsFromFile().size() >= 5) {
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
        TeacherMode teacherMode = new TeacherMode();
        teacherMode.inputToSelectActionSetValue();
    }

    public void selectedStudent() {
        StudentMode studentMode = new StudentMode();
        studentMode.askingForReadyToStart();
    }


}

import java.util.LinkedList;
import java.util.Scanner;

public class LogInToTheSystem {

    private int inputToSelectRole;
    private ListRepository questionsRepository;

    public LogInToTheSystem(ListRepository questionsRepository) {
        this.questionsRepository = questionsRepository;
        System.out.println("Добро пожаловать в систему!\nПожалуйста, выберите как вы хотите войти:");
    }

    public void inputToSelectRoleSetValue() {
        while (true) {
            try {
                System.out.println("\tВведите \"1\" если хотите войти как " +
                        "учитель\n\tВведите \"2\" если хотите войти как ученик");
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
                    System.out.println("Некорректный формат ввода, попробуйте еще раз");
                } catch (Exception e) {
                System.out.println("Некорректный формат ввода, попробуйте еще раз");
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

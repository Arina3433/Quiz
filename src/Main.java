public class Main {
    public static void main(String[] args) {
        ListRepository questionsRepository = new ListRepository();
        SelectRole selectRole = new SelectRole(questionsRepository);
        TextOutput.logInToTheSystemGreeting();
        selectRole.inputToSelectRoleSetValue();
    }
}
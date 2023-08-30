public class Main {
    public static void main(String[] args) {
        ListRepository repository = new ListRepository();
        LogInToTheSystem logInToTheSystem = new LogInToTheSystem(repository);
        logInToTheSystem.inputToSelectRoleSetValue();
    }
}
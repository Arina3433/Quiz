public class Main {
    public static void main(String[] args) {

        QuestionsRepository questionsRepository = new QuestionsRepository();
        DataProcessing dataProcessing = new DataProcessing();
        InformationOutput informationOutput = new InformationOutput();

        informationOutput.logInToTheSystemGreeting();
        dataProcessing.inputToSelectRoleSetValue();

    }
}
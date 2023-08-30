public class TeacherDataService {

    private ListRepository questionsRepository;

    //конструктор

    public void collectQuestionData(Question question) {
        questionsRepository.addQuestionToList(question);
    }
}

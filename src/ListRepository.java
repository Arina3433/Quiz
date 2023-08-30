import java.util.ArrayList;

public class ListRepository {

    private ArrayList<Question> questionsList = new ArrayList<>();

    public void addQuestionToList(Question question) {
        questionsList.add(question);
    }

    public ArrayList<Question> getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(ArrayList<Question> questionsList) {
        this.questionsList = questionsList;
    }
}

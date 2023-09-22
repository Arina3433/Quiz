import com.fasterxml.jackson.annotation.JsonGetter;

import java.io.Serializable;
import java.util.LinkedList;

public class Question  implements Serializable {
    private String text;
    private LinkedList<String> answers;
    private int numberOfCorrectAnswer;

    @JsonGetter("Текст вопроса")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @JsonGetter("Варианты ответов")
    public LinkedList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(LinkedList<String> answers) {
        this.answers = answers;
    }

    @JsonGetter("Правильный ответ")
    public int getNumberOfCorrectAnswer() {
        return numberOfCorrectAnswer;
    }

    public void setNumberOfCorrectAnswer(int numberOfCorrectAnswer) {
        this.numberOfCorrectAnswer = numberOfCorrectAnswer;
    }
}

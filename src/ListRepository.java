import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListRepository {

    private static File file = new File("QuestionRepository.json");

    public static void writeQuestionsToFile(Question question) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ArrayList<Question> questionList = new ArrayList<>();

        if (file.length() != 0) {
            questionList = (ArrayList<Question>) mapper.readValue(file, new TypeReference<List<Question>>() {});
        }
        questionList.add(question);
        mapper.writeValue(file, questionList);
    }

    public static ArrayList<Question> readQuestionsFromFile() throws IOException {
        ArrayList<Question> questionList = new ArrayList<>();

        if (file.length() != 0) {
            questionList = (ArrayList<Question>) new ObjectMapper().readValue(file, new TypeReference<List<Question>>() {});
        } else {
            System.out.println("Файл пуст");
        }

        return questionList;
    }
}
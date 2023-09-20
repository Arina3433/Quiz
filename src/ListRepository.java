import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.*;
import java.util.ArrayList;

public class ListRepository {

    private static File file = new File("QuestionRepository.json");

    public static void writeQuestionsToFile(Question question) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        if (file.length() == 0) {
            ObjectNode root = mapper.createObjectNode();
            root.putArray("questionList");
            mapper.writer().writeValue(file, root);
        }
        ObjectNode root = (ObjectNode) mapper.readTree(file);
        ArrayNode questionList = (ArrayNode) root.get("questionList");
        questionList.add(mapper.convertValue(question, JsonNode.class));
        mapper.writer().writeValue(file, root);
    }

    public static ArrayList<Question> readQuestionsFromFile() throws IOException {
        ArrayList<Question> questionList = new ArrayList<>();

        if (file.length() != 0) {

            ObjectMapper mapper = new ObjectMapper();
            ObjectNode objectNode = (ObjectNode) mapper.readTree(file);
            ArrayNode arrayNode = (ArrayNode) objectNode.get("questionList");

            for (JsonNode el : arrayNode) {
                questionList.add(mapper.convertValue(el, Question.class));
            }
        } else {
            System.out.println("Файл пуст");
        }

        return questionList;
    }
}
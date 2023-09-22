import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

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

            questionList = mapper.convertValue(arrayNode, new TypeReference<ArrayList<Question>>() {
            });

        } else {
            System.out.println("Файл пуст");
        }

        return questionList;
    }

    public static void editQuestionInFile() {
        editNumberOfCorrectQuestion(editQuestionText());
        System.out.println("Изменения сохранены");
    }

    public static int editQuestionText() {
        int numberOfQuestionToEditScan;
        while (true) {
            try {
                System.out.println("Какой вопрос вы хотите изменить?");

                numberOfQuestionToEditScan = new Scanner(System.in).nextInt();

                if (numberOfQuestionToEditScan <= ListRepository.readQuestionsFromFile().size()
                        && numberOfQuestionToEditScan > 0) {
                    System.out.println("Введите новую формулировку вопроса (если не хотите менять, просто нажмите Enter):");
                    String newWordingOfQuestion = new Scanner(System.in).nextLine();
                    if (!newWordingOfQuestion.equals("")) {
                        ObjectMapper mapper = new ObjectMapper();
                        JsonNode fileJsonNode = mapper.readTree(file);
                        JsonNode arrayJsonNode = fileJsonNode.get("questionList");
                        ObjectNode objectNode = (ObjectNode) arrayJsonNode.get(numberOfQuestionToEditScan - 1);
                        objectNode.put("text", newWordingOfQuestion);
                        mapper.writer().writeValue(file, fileJsonNode);
                    }
                    break;
                } else {
                    TextOutput.outputErrorMessage();
                }
            } catch (Exception e) {
                TextOutput.outputErrorMessage();
            }
        }

        return numberOfQuestionToEditScan;
    }

    public static void editNumberOfCorrectQuestion(int numberOfQuestionToEditScan) {

        while (true) {
            try {
                System.out.println("Варианты ответов:");
                for (int j = 0; j < ListRepository.readQuestionsFromFile().get(numberOfQuestionToEditScan - 1).getAnswers().size(); j++) {
                    System.out.print(ListRepository.readQuestionsFromFile().get(numberOfQuestionToEditScan - 1).getAnswers().get(j) + "  ");
                }
                System.out.println("\nНомер правильного ответа:\n" + ListRepository.readQuestionsFromFile().get(numberOfQuestionToEditScan - 1).getNumberOfCorrectAnswer());
                System.out.println("Введите новый номер правильного ответа (если не хотите менять, просто нажмите Enter):");
                String newNumberOfCorrectAnswer = new Scanner(System.in).nextLine();
                if (!newNumberOfCorrectAnswer.equals("")) {
                    if (parseInt(newNumberOfCorrectAnswer) <= ListRepository.readQuestionsFromFile().get(numberOfQuestionToEditScan - 1).getAnswers().size()
                            && parseInt(newNumberOfCorrectAnswer) > 0) {

                        ObjectMapper mapper = new ObjectMapper();
                        JsonNode fileJsonNode = mapper.readTree(file);
                        JsonNode arrayJsonNode = fileJsonNode.get("questionList");
                        ObjectNode objectNode = (ObjectNode) arrayJsonNode.get(numberOfQuestionToEditScan - 1);
                        objectNode.put("numberOfCorrectAnswer", parseInt(newNumberOfCorrectAnswer));
                        mapper.writer().writeValue(file, fileJsonNode);
                    } else {
                        TextOutput.outputErrorMessage();
                        continue;
                    }
                }
                break;
            } catch (Exception e) {
                TextOutput.outputErrorMessage();
            }
        }
    }

    public static void deleteQuestionFromFile() throws IOException {
        while (true) {
            try {
                System.out.println("Какой вопрос вы хотите удалить?");

                int numberOfQuestionToDeleteScan = new Scanner(System.in).nextInt();

                if (numberOfQuestionToDeleteScan <= ListRepository.readQuestionsFromFile().size()
                        && numberOfQuestionToDeleteScan > 0) {
                    ObjectMapper mapper = new ObjectMapper();
                    JsonNode fileJsonNode = mapper.readTree(file);
                    ArrayNode arrayJsonNode = (ArrayNode) fileJsonNode.get("questionList");
                    arrayJsonNode.remove(numberOfQuestionToDeleteScan - 1);
                    mapper.writer().writeValue(file, fileJsonNode);

                    break;
                } else {
                    TextOutput.outputErrorMessage();
                }
            } catch (Exception e) {
                TextOutput.outputErrorMessage();
            }
        }

        System.out.println("Изменения сохранены");
    }
}
import java.io.*;
import java.util.ArrayList;

public class ListRepository {

    public static void writeQuestionsToFile(Question question) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("QuestionRepository.txt", true))) {
            objectOutputStream.writeObject(question);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Question> readQuestionsFromFile() {
        ArrayList<Question> questionsList = new ArrayList<>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("QuestionRepository.txt"))) {
            while (objectInputStream.readObject() != null) {
                questionsList.add((Question) objectInputStream.readObject());
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return questionsList;
    }
}
import java.io.*;
import java.util.ArrayList;

public class ListRepository {

    private static File file = new File("QuestionRepository.txt");

    public static void writeQuestionsToFile(Question question) {
        try {

            FileOutputStream fileOutputStream = new FileOutputStream("QuestionRepository.txt", true);

            if (file.length() == 0) {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(question);
                objectOutputStream.close();

            } else {
                MyObjectOutputStream myObjectOutputStream = new MyObjectOutputStream(fileOutputStream);
                myObjectOutputStream.writeObject(question);
                myObjectOutputStream.close();
            }

            fileOutputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Question> readQuestionsFromFile() {
        ArrayList<Question> questionsList = new ArrayList<>();

        if (file.length() != 0) {

            try {

                FileInputStream fileInputStream = new FileInputStream("QuestionRepository.txt");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                while (fileInputStream.available() != 0) {
                    questionsList.add((Question) objectInputStream.readObject());
                }

                objectInputStream.close();
                fileInputStream.close();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Файл пуст");
        }

        return questionsList;
    }
}
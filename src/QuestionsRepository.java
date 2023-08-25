import java.util.ArrayList;
import java.util.Random;

public class QuestionsRepository {

    private ArrayList<String> questionsList = new ArrayList<>();
    private ArrayList<Integer> randomNumbers = new ArrayList<>();

    public ArrayList<Integer> getRandomNumbersArray() {

        for (int i = 0; i < 5; i++) {
            Random randNumber = new Random();
            int newNumber = randNumber.nextInt(questionsList.size());

            if (!randomNumbers.contains((newNumber+ 1))) {
                randomNumbers.add((newNumber + 1));
            } else {
                i--;
            }
        }
        return randomNumbers;
    }


}

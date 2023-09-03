import java.util.ArrayList;
import java.util.Random;

public class RandomNumber {

    private ListRepository questionsRepository;
    private ArrayList<Integer> randomNumbers = new ArrayList<>() {
    };

    public RandomNumber(ListRepository questionsRepository) {
        this.questionsRepository = questionsRepository;
        generateRandomNumber();
    }

    public ArrayList<Integer> getRandomNumbers() {
        return randomNumbers;
    }

    public void setRandomNumbers(ArrayList<Integer> randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    public ArrayList<Integer> generateRandomNumber() {

        for (int i = 0; i < 5; i++) {
            Random randNumber = new Random();
            int newNumber = randNumber.nextInt(questionsRepository.getQuestionsList().size());

            if (!randomNumbers.contains((newNumber + 1))) {
                randomNumbers.add((newNumber + 1));
            } else {
                i--;
            }
        }
        return randomNumbers;
    }
}

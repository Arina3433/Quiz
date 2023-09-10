import java.util.ArrayList;
import java.util.Random;

public class RandomNumber {

    private ArrayList<Integer> randomNumbers = new ArrayList<>() {
    };

    public RandomNumber() {
    }

    public ArrayList<Integer> getRandomNumbers() {
        return randomNumbers;
    }

    public void setRandomNumbers(ArrayList<Integer> randomNumbers) {
        this.randomNumbers = randomNumbers;
    }

    public ArrayList<Integer> generateRandomNumber(int sizeOfQuestionsRepository) {

        for (int i = 0; i < 5; i++) {
            Random randNumber = new Random();
            int newNumber = randNumber.nextInt(sizeOfQuestionsRepository);

            if (!randomNumbers.contains((newNumber + 1))) {
                randomNumbers.add((newNumber + 1));
            } else {
                i--;
            }
        }
        return randomNumbers;
    }
}

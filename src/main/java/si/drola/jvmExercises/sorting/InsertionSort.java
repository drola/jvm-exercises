package si.drola.jvmExercises.sorting;

public class InsertionSort implements ISorter {
    public int[] sort(int[] numbers) {
        for(int i = 1; i < numbers.length; i++) {
            for(int j = i; j > 0; j--) {
                if (numbers[j] < numbers[j-1]) {
                    int t = numbers[j];
                    numbers[j] = numbers[j-1];
                    numbers[j-1] = t;
                }
            }
        }

        return numbers;
    }
}

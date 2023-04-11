package lesson6;

public class ArrayHandler {
    public int[] getValueAfterLastFour(int[] originalArray) {
        for (int i = originalArray.length - 1; i >= 0; i--) {
            if (originalArray[i] == 4) {
                return getSliceArray(i + 1, originalArray);
            }
        }
        throw new RuntimeException();
    }

    private int[] getSliceArray(int fromIndex, int[] originalArray) {
        int[] resultArray = new int[originalArray.length - fromIndex];
        for (int i = fromIndex, j = 0; i < originalArray.length; i++, j++) {
            resultArray[j] = originalArray[i];
        }
        return resultArray;
    }

    public boolean findFourOrOneNumberInArray(int[] array) {
        boolean hasFour = false;
        boolean hasOne = false;

        for (int num : array
        ) {
            if (num == 4) {
                hasFour = true;
            } else if (num == 1) {
                hasOne = true;
            } else {
                return false;
            }

        }
        return hasFour && hasOne;
    }
}

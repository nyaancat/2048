package sample;


import java.util.Random;
import java.util.Vector;

public class Field {

    public int count = 0; // количество занятных ячеек
    private int mSize = 4;
    public int[][] fieldArr = new int [mSize][mSize];

    Field()
    {
        for (int i = 0; i < mSize; i++)
            for (int j = 0; j < mSize; j++)
                fieldArr[i][j] = 0;
    }

    //делает сдвиг массива влево с "склеиванием" одинаковых элементов
    public int[] offset(int[] arr) {
        int[] result = new int[mSize];
        int j = 1;
        result[0] = arr[0];
        boolean [] flag = new boolean [mSize];

        for (int i = 0; i < mSize; i++)
            flag[i] = false;

        for (int i = 1; i < mSize; i++)
            if (arr[i] != 0)
            {
                if ((result[j - 1] == arr[i] || result [j - 1] == 0) && !flag[j - 1]) {
                    if (result[j - 1] != 0)
                        flag[j - 1] = true;
                    result[j - 1] += arr[i];

                }
                else
                {
                    result[j] = arr[i];
                    j++;
                }
            }

        for (int i = j + 1; i < mSize; i++)
            result[j] = 0;

        return result;
    }

    public int[][] down () {
        for (int i = 0; i < mSize; i++) {
            int [] arr = new int[mSize];
            for (int j = mSize - 1; j >= 0; j--)
                arr[j] = fieldArr[j][i];
            arr = offset(arr);

            for (int j = 0; j < mSize; j++)
                fieldArr[j][i] = arr[j];
        }

        return fieldArr;
    }

    public int[][] up () {
        int[][] oppField = down().clone();
        for (int i = 0; i < mSize; i++)
            oppField[i] = fieldArr[i].clone();

        for (int i = 0; i < mSize; i++)
            for (int j = 0; j < mSize; j++)
                fieldArr[2 - i][j] = oppField[i][j];

        return fieldArr;
    }

    public int[][] left () {
        for (int i = 0; i < mSize; i++) {
            int [] arr = fieldArr[i];
            arr = offset(arr);
            fieldArr[i] = arr;
        }

        return fieldArr;
    }

    public int[][] right () {
        int[][] oppField = left().clone();
        for (int i = 0; i < mSize; i++)
            oppField[i] = fieldArr[i].clone();

        for (int i = 0; i < mSize; i++)
            for (int j = 0; j < mSize; j++)
                fieldArr[i][mSize - 1 - j] = oppField[i][j];

        return fieldArr;
    }

    public int[][] newNumber() {
        //Vector blank = new Vector();
        Random r = new Random(System.currentTimeMillis());
        int num = r.nextInt(mSize * mSize - count + 1);
        int k = 0;

        for (int i = 0; i < mSize; i++)
            for (int j = 0; j < mSize; j++) {
                if (fieldArr[i][j] == 0){
                    if (k == num) {
                        fieldArr[i][j] = 2;
                        return fieldArr;
                    }
                    else k++;
                }
            }

            return fieldArr;
    }
}

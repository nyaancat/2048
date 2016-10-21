package sample;


import java.util.Arrays;
import java.util.Random;
import java.util.Vector;

public class Field {

    private int count = 0; // количество занятных ячеек
    private int mSize = 4; //размер поля
    public int[][] fieldArr = new int [mSize][mSize];
    public boolean gameOver = false;

    Field()
    {
        for (int i = 0; i < mSize; i++)
            for (int j = 0; j < mSize; j++)
                fieldArr[i][j] = 0;
    }

    //обновление количества занятых ячеек. выполняется после каждой попытки сдвига
    private void refreshCount()
    {
        count = 0;
        for (int i = 0; i < mSize; i++)
            for (int j = 0; j < mSize; j++)
                if (fieldArr[i][j] > 0) count++;

        if (count == mSize * mSize)
            checkGameOver();

    }

    //проверка на отсутствие возможного хода
    private void checkGameOver()
    {//смещения по х и у
        int [] dx = {0, 1, 0, -1};
        int [] dy = {1, 0, -1, 0};

        //для каждой ячейки
        for (int i = 0; i < mSize; i++)
            for (int j = 0; j < mSize; j++)
                for (int k = 0; k < 4; k++)
                {//проверяем 4 соседние клетки
                    int x = i + dx[k];
                    int y = j + dy[k];
                    //если нет выхода за предел поля
                    if (x < mSize && x >= 0 &&
                        y < mSize && y >= 0){
                        if (fieldArr[i][j] == fieldArr[x][y])//если можно сделать ход
                            return;
                    }
                }
        gameOver = true;
    }


    //делает сдвиг массива влево с "склеиванием" одинаковых элементов
    private int[] offset(int[] arr) {
        int[] result = new int[mSize];
        int j = 1;
        result[0] = arr[0];
        boolean [] flag = new boolean [mSize];

        for (int i = 0; i < mSize; i++)
            flag[i] = false;

        for (int i = 1; i < mSize; i++)
            if (arr[i] != 0)
            {//если два соседних элемента одинаковые и в этой ячейке еще не происходило сложение
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

    //сдвиг вниз
    public boolean down () {
        boolean flag = false;

        for (int i = 0; i < mSize; i++) {
            int [] arr = new int[mSize];
            for (int j = mSize - 1; j >= 0; j--)
                arr[mSize - j - 1] = fieldArr[j][i];
            arr = offset(arr);

            //обновление поля и проверка на наличие изменений
            for (int j = 0; j < mSize; j++) {
                if (fieldArr[j][i] != arr[mSize - 1 - j]){
                    flag = true;
                    fieldArr[j][i] = arr[mSize - 1 - j];
                }
            }
        }
        refreshCount();
        return flag;
    }

    //сдвиг вверх
    public boolean up () {
        boolean flag = false;

        for (int i = 0; i < mSize; i++) {
            int [] arr = new int[mSize];
            for (int j = mSize - 1; j >= 0; j--)
                arr[j] = fieldArr[j][i];
            arr = offset(arr);

            //обновление поля и проверка на наличие изменений
            for (int j = 0; j < mSize; j++)
                if (fieldArr[j][i] != arr[j]){
                    fieldArr[j][i] = arr[j];
                    flag = true;
                }
        }
        refreshCount();
        return flag;
    }

    //сдвиг влево
    public boolean left () {
        boolean flag = false;
        for (int i = 0; i < mSize; i++) {
            int [] arr = fieldArr[i];
            arr = offset(arr);

            //обновление поля и проверка на наличие изменений
            if (!Arrays.equals(fieldArr[i], arr)){
                fieldArr[i] = arr;
                flag = true;
            }
        }
        refreshCount();
        return flag;
    }

    //сдвиг вправо
    public boolean right () {
        boolean flag = false;

        for (int i = 0; i < mSize; i++) {
            int [] arr = new int [mSize];
            for (int j = 0; j < mSize; j++)
                arr[j] = fieldArr[i][mSize - 1 - j];
            arr = offset(arr);

            //обновление поля и проверка на наличие изменений
            for (int j = 0; j < mSize; j++)
                if (fieldArr[i][j] != arr[mSize - j - 1]){
                    fieldArr[i][j] = arr[mSize - j - 1];
                    flag = true;
                }
        }

        refreshCount();
        return flag;
    }

    //добавление 2 в случайную свободную ячейку. выполняется после любого успешного сдвига
    public void newNumber() {
        Random r = new Random(System.currentTimeMillis());
        //System.out.println("count: " + count);
        int num = r.nextInt(mSize * mSize - count);
        int k = 0;


        for (int i = 0; i < mSize; i++)
            for (int j = 0; j < mSize; j++) {
                if (fieldArr[i][j] == 0){
                    if (k == num) {
                        fieldArr[i][j] = 2;
                        count++;
                        if (count == mSize * mSize)
                            checkGameOver();
                        return;
                    }
                    else k++;
                }
            }
    }
}

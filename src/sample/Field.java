package sample;


public class Field {
    public int[][] field_mas = new int [3][3];
    public int count = 0;

    Field()
    {
        field_mas[0][0] = 0;
        field_mas[0][1] = 4;
        field_mas[0][2] = 0;
        field_mas[1][0] = 0;
        field_mas[1][1] = 2;
        field_mas[1][2] = 0;
        field_mas[2][0] = 0;
        field_mas[2][1] = 2;
        field_mas[2][2] = 0;

        System.out.println(field_mas[2][0]);
    }

    public int[] offset(int[] mas) {
       // System.out.println("got it");
        int[] res_mas = new int[3];
        int j = 1;
        res_mas[0] = mas[0];
        boolean flag = false;
        for (int i = 1; i < 3; i++)
            if (mas[i] != 0)
            {
                if ((res_mas[j - 1] == mas[i] || res_mas [j - 1] == 0) && !flag) {
                    if (res_mas[j - 1] != 0)
                        flag = true;
                    res_mas[j - 1] += mas[i];

                }
                else
                {
                    res_mas[j] = mas[i];
                    j++;
                }
            }

        for (int i = j + 1; i < 3; i++)
            res_mas[j] = 0;

        return res_mas;
    }

    public int[][] down ()
    {
        int [] mas1 = {field_mas[2][0],
                field_mas[1][0],
                field_mas[0][0]};

        mas1 = offset(mas1);


        int [] mas2 = {field_mas[2][1],
                field_mas[1][1],
                field_mas[0][1]};
        mas2 = offset(mas2);

        int [] mas3 = {field_mas[2][2],
                field_mas[1][2],
                field_mas[0][2]};

        mas3 = offset(mas3);

        for (int i = 0; i < 3; i++)
            field_mas[i][0] = mas1[2 - i];
        for (int i = 0; i < 3; i++)
            field_mas[i][1] = mas2[2 - i];
        for (int i = 0; i < 3; i++)
            field_mas[i][2] = mas3[2 - i];

        return field_mas;
    }

    public int[][] up ()
    {
        int[][] opp_field = down().clone();
        for (int i = 0; i < 3; i++)
            opp_field[i] = field_mas[i].clone();


        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                field_mas[2 - i][j] = opp_field[i][j];

        return field_mas;
    }

    public int[][] left ()
    {
        int [] mas1 = field_mas[0];
        mas1 = offset(mas1);

        int [] mas2 = field_mas[1];
        mas2 = offset(mas2);

        int [] mas3 = field_mas[2];
        mas3 = offset(mas3);

        field_mas[0] = mas1;
        field_mas[1] = mas2;
        field_mas[2] = mas3;

        return field_mas;
    }

    public int[][] right ()
    {
        int[][] opp_field = left().clone();
        for (int i = 0; i < 3; i++)
            opp_field[i] = field_mas[i].clone();


        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                field_mas[i][2 - j] = opp_field[i][j];

        return field_mas;
    }
}

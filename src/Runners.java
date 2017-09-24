import bean.EmptyField;
import bean.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runners {

    public static Rules game;



    public static void main(String[] args) {
        int width, height;
      /*  Scanner scanner=new Scanner(System.in);
        System.out.println("Введите ширину экрана");
        width=scanner.nextInt();
        System.out.println("Введите высоту экрана");
        height=scanner.nextInt();
        System.out.println("Введите координаты пустоты");
        int fieldX=scanner.nextInt();
        int fieldY=scanner.nextInt();*/



        game=new Rules(mock(),mockFinish());
        game.run();




    }

    private static Room mockFinish() {
        int [][] arr =new int[3][3];
        arr[0][0]=1;
        arr[0][1]=2;
        arr[0][2]=3;

        arr[1][0]=8;
        arr[1][1]=0;
        arr[1][2]=4;

        arr[2][0]=7;
        arr[2][1]=6;
        arr[2][2]=5;

        return new Room(arr, new EmptyField(1,1));
    }

    private static Room mock() {
        int [][] arr =new int[3][3];
        arr[0][0]=2;
        arr[0][1]=6;
        arr[0][2]=3;

        arr[1][0]=1;
        arr[1][1]=0;
        arr[1][2]=4;

        arr[2][0]=8;
        arr[2][1]=7;
        arr[2][2]=5;
        return new Room(arr, new EmptyField(1,1));
    }


}

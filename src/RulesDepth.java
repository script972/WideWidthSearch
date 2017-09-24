import bean.EmptyField;
import bean.Room;

import java.util.ArrayList;
import java.util.List;

public class RulesDepth {

    Room room;
    Room finish;
    List<Room> open=new ArrayList<>();
    List<Room> closed=new ArrayList<>();
    int counter;

    public RulesDepth(Room room, Room finish) {
        this.room=room;
        this.finish=finish;
        open.add(room);
        System.out.println("Нужно для выиграша");
        finish.print();
    }


    public void run() {
       /* Room room=mock();
        rightStep(room);
        room=mock();
        rightStep(room);

        return;*/
        while (true) {
            counter++;
            if(open.size()==0) {
                System.out.println("Игра проиграна");
                return;
            }
            try {
                room = open.get(0).clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            open.remove(0);

            if(checkWin(room)){
                return;
            }


            Room temp = room;
            //temp=mock();
            closed.add(room);


            System.out.println("Start Moved " + counter);
            System.out.println("До шага влево");
            try {
                temp =  room.clone();
                temp=leftStep(temp);
                doingCheck(temp);
                System.out.println("ROOM ");
                room.print();
                System.out.println("---------");
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            System.out.println("До шага вправо");
            try {
                temp =  room.clone();
                temp=rightStep(temp);
                doingCheck(temp);

                System.out.println("ROOM ");
                room.print();
                System.out.println("---------");
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            System.out.println("До шага вверх");
            try {
                temp =room.clone();
                temp=upStep(temp);
                doingCheck(temp);

            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            System.out.println("До шага вниз");

            try {
                temp =  room.clone();
                temp=downStep(temp);
                doingCheck(temp);
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            System.out.println("FinishedMoved " + counter);
        }

    }

    //крок 5
    private void doingCheck(Room temp) {
        boolean consist=false;
        if(temp==null)
            return;
        for (Room obj :
                open) {
            if (obj.equals(temp)) {
                open.remove(temp);
                consist=true;
            }
        }

        for (Room obj :
                closed) {
            if (obj.equals(temp)) {
                closed.remove(obj);
                consist=true;
            }
        }
        if(!consist)
            open.add(0, temp);
    }

    //check
    private Room downStep(Room temp) {
        temp.print();
        int valueTemp=0;
        // System.out.println("down Start");
        // temp.print();
        if(temp.getZeroField().getX()<temp.getMatrix().length-1){
            valueTemp=temp.getMatrix()[temp.getZeroField().getX()+1][temp.getZeroField().getY()];
            //  System.out.println("value Temp="+valueTemp);
            temp.setElemetMatrix(temp.getZeroField().getX(), temp.getZeroField().getY(), valueTemp);
            System.out.println(temp.setElemetMatrix(temp.getZeroField().getX()+1, temp.getZeroField().getY(), 0));
            temp.setZero(new EmptyField(temp.getZeroField().getX()+1, temp.getZeroField().getY()));
            //  System.out.println("Шаг down");
            System.out.println("После шага вниз");
            temp.print();
            //  System.out.println("Значение 0 "+temp.getZero());
            //markAction(temp);
            return temp;
        }
        System.out.println(temp.getZero());


        return null;
    }

    //Check
    private Room upStep(Room temp) {
        temp.print();
        int valueTemp=0;
        //  System.out.println("Up Start");
        // temp.print();
        //  System.out.println("figak="+temp.getZeroField().getY());
        // System.out.println("figak="+temp.getMatrix()[0].length);
        if(temp.getZeroField().getX()>0){
            // System.out.println("Input");
            valueTemp=temp.getMatrix()[temp.getZeroField().getX()-1][temp.getZeroField().getY()];
            // System.out.println("value Temp="+valueTemp);
            temp.setElemetMatrix(temp.getZeroField().getX(), temp.getZeroField().getY(), valueTemp);
            System.out.println(temp.setElemetMatrix(temp.getZeroField().getX()-1, temp.getZeroField().getY(), 0));
            temp.setZero(new EmptyField(temp.getZeroField().getX()-1, temp.getZeroField().getY()));
            //  System.out.println("Шаг Up");
            System.out.println("После шага вверх");

            temp.print();
            //markAction(temp);
            return temp;
            //   System.out.println("Значение 0 "+temp.getZero());
        }
        System.out.println(temp.getZero());

        return null;
    }

    //Check
    private Room rightStep(Room tempRight) {
        tempRight.print();
        int valueTemp=0;
        // System.out.println("Rigth Start");
        //  tempRight.print();
        if(tempRight.getZeroField().getY()<tempRight.getMatrix()[0].length-1){
            // System.out.println("Input");
            valueTemp=tempRight.getMatrix()[tempRight.getZeroField().getX()][tempRight.getZeroField().getY()+1];
            // System.out.println("value Temp="+valueTemp);
            tempRight.setElemetMatrix(tempRight.getZeroField().getX(), tempRight.getZeroField().getY(), valueTemp);
            System.out.println(tempRight.setElemetMatrix(tempRight.getZeroField().getX(), tempRight.getZeroField().getY()+1, 0));
            tempRight.setZero(new EmptyField(tempRight.getZeroField().getX(), tempRight.getZeroField().getY()+1));
            // System.out.println("Шаг вправо");
            System.out.println("После шага вправо");

            tempRight.print();
            return tempRight;
           // markAction(tempRight);
            //  System.out.println("Значение 0 "+tempRight.getZero());
        }
        //System.out.println(tempRight.getZero());


        return null;
    }

    //check
    private Room leftStep(Room temp) {
        temp.print();
        int valueTemp=0;
        // temp.print();
        if(temp.getZeroField().getY()>0){
            System.out.println("Input");
            valueTemp=temp.getMatrix()[temp.getZeroField().getX()][temp.getZeroField().getY()-1];
            // System.out.println("value Temp="+valueTemp);
            temp.setElemetMatrix(temp.getZeroField().getX(), temp.getZeroField().getY(), valueTemp);
            temp.setElemetMatrix(temp.getZeroField().getX(), temp.getZeroField().getY()-1, 0);
            temp.setZero(new EmptyField(temp.getZeroField().getX(), temp.getZeroField().getY()-1));
            System.out.println("После шага влево");
            temp.print();
           // markAction(temp);
            return temp;


        }
        return null;


    }

    private void markAction(Room temp) {
        System.out.println("MARK ACTION SIZE="+open.size());
        boolean add=true;
        for (Room aClosed : closed) {
            if (aClosed.equals(temp)) {
                System.out.println("Равны значения");
                temp.print();
                System.out.println("------");
                aClosed.print();
                add = false;
            }
        }
        for (Room anOpen : open) {
            if (anOpen.equals(temp)) {
                System.out.println("Равны значения");
                temp.print();
                System.out.println("-----");
                anOpen.print();
                add = false;
            }
        }

        if (add){
            open.add(temp);
            System.out.println("Добавили в список Open. Размер списка="+open.size());
            temp.print();

        }
    }

    private boolean checkWin(Room room) {
        if (room.equals(finish)) {
            System.out.println("Game Finish on counter=" + counter);
            return true;
        }
        return false;
    }

    public Room mock(){
        int [][] arr =new int[3][3];
        arr[0][0]=0;
        arr[0][1]=1;
        arr[0][2]=3;

        arr[1][0]=8;
        arr[1][1]=9;
        arr[1][2]=2;

        arr[2][0]=7;
        arr[2][1]=6;
        arr[2][2]=5;

        return new Room(arr, new EmptyField(0,0));
    }
}

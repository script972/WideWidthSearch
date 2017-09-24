package bean;

import bean.EmptyField;

import java.util.Arrays;

public class Room implements Cloneable{


    int [][] matrix;
    EmptyField zero;

    private int value;

    public Room(int[][] matrix, EmptyField zero) {
        this.matrix = matrix;
        this.zero=zero;
    }


    public Room() {
    }

    public void print(){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Room room = (Room) o;
        for (int i = 0; i < room.getMatrix().length; i++) {
            for (int j = 0; j < room.getMatrix()[0].length; j++) {
                if(room.getMatrix()[i][j]!=matrix[i][j])
                    return false;
            }
        }
        if(room.getZeroField().getX()!=getZeroField().getX())
            return false;
        if(room.getZeroField().getY()!=getZeroField().getY())
            return false;


        return true ;
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(matrix);
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int getZero() {
        return matrix[zero.getX()][zero.getY()];
    }

    public void setZero(EmptyField zero) {
        this.zero = zero;
    }

    public EmptyField getZeroField() {
        return zero;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean setElemetMatrix(int x, int y, int value){
        if(x<0 || x>matrix.length-1)
            return false;
        if(y<0 || y>matrix[0].length-1)
            return false;
        matrix[x][y]=value;
        return true;
    }

    public Room clone()throws CloneNotSupportedException{
        int [][] copy=new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                copy[i][j]=matrix[i][j];
            }
        }
        Room room=new Room(copy, getZeroField());


        return room;
    }


}

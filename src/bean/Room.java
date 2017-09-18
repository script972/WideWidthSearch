package bean;

import bean.EmptyField;

import java.util.Arrays;

public class Room implements Cloneable{


    int [][] matrix;
    EmptyField zero;

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

        return Arrays.deepEquals(matrix, room.matrix);
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

    public boolean setElemetMatrix(int x, int y, int value){
        if(x<0 || x>matrix.length-1)
            return false;
        if(y<0 || y>matrix[0].length-1)
            return false;
        matrix[x][y]=value;
        return true;
    }

    public Room clone()throws CloneNotSupportedException{
        return (Room)super.clone();
    }


}

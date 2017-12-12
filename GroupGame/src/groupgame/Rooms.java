/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupgame;

/**
 *
 * @author ryanlingxiao
 */
public class Rooms {
    public int row;
    public int col;
    public boolean clear;
    public boolean current;
            
    public Rooms(int row, int col, boolean clear, boolean current) {
        this.row = row;
        this.col = col;
        this.clear = clear;
        this.current = current;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setClear(boolean clear) {
        this.clear = clear;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isClear() {
        return clear;
    }

    public boolean isCurrent() {
        return current;
    }
    
}

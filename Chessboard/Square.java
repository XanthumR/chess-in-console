package Chessboard;

import Pieces.Pawn;
import Pieces.Piece;
;import static java.lang.Math.abs;

public class Square {
    int row;
    int collumn;
    int color;


    ChessBoard board = new ChessBoard();
    public Square(int row, int collumn) {
        this.row = row;
        this.collumn = collumn;
    }

    public int getRow() {
        return row;
    }

    public int getCollumn() {
        return collumn;
    }

    public ChessBoard getBoard(){

        return board;
    }

    public int getRowDistance(Square location) {
        return row - location.getRow()  ;
    }
    public int getColDistance(Square location) {
        return collumn - location.getCollumn()  ;
    }

    public boolean isAtSameColumn(Square targetLocation) {
        return collumn - targetLocation.getCollumn() == 0;
    }
    public boolean isAtSameRow(Square targetLocation) {
        return row - targetLocation.getRow() == 0;
    }


    public boolean isEmpty() {
        return ChessBoard.b[row-1][collumn-1].contains(" ");
    }

    public boolean isNeighborColumn(Square targetLocation) {
        if (collumn == targetLocation.getCollumn()-1)
            return true;
        else if (collumn == targetLocation.getCollumn()+1) {
            return true;
        }
        else
            return false;
    }
    public boolean isNeighborRow(Square targetLocation) {
        if (row == targetLocation.getRow()-1)
            return true;
        else if (row == targetLocation.getRow()+1) {
            return true;
        }
        else
            return false;
    }

    public Piece getPiece() {
        String  a = ChessBoard.b[row-1][collumn-1];
        String m = a.toLowerCase();
        if (a.contains(m))
            return new Piece(ChessBoard.BLACK,new Square(row,collumn));
        else
            return new Piece(ChessBoard.WHITE,new Square(row,collumn));
    }

    public boolean isAtLastRow(int color) {
        if (color==ChessBoard.WHITE && row==8)
            return true;
        else if (color==ChessBoard.BLACK && row ==1) {
            return true;

        }
        else
            return false;

    }

    public void putNewQueen(int color) {

        if (color==ChessBoard.WHITE)
            board.getB()[row-1][collumn-1]="Q";
        else
            board.getB()[row-1][collumn-1]="q";



    }

    public void setPiece(Piece piece2) {
        board.getB()[row-1][collumn-1]= piece2.toString() ;


    }

    public void clear() {
        board.getB()[row-1][collumn-1]=" ";
    }
}

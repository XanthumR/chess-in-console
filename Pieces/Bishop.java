package Pieces;

import Chessboard.ChessBoard;
import Chessboard.Square;

import static java.lang.Math.abs;

public class Bishop extends Piece{
    boolean initialLocation = true;
    public Bishop(int color, Square location) {
        super(color, location);
    }
    @Override
    public boolean canMove(String to) {
        boolean validMove = false;
        Square targetLocation = location.getBoard().getSquareAt(to);
        if (!this.location.isAtSameColumn(targetLocation) && !this.location.isAtSameRow(targetLocation)&& abs(targetLocation.getRow()-location.getRow())==abs(targetLocation.getCollumn()-location.getCollumn()) ){

            if (initialLocation) {
                boolean count =true;
                Square[] between = location.getBoard().getSquaresBetweenDiognal(location,
                        targetLocation);
                for (int n = 1; n < abs(targetLocation.getCollumn() - location.getCollumn()); ++n) {
                    if (!between[n-1].isEmpty()){
                        count=false;}
                }
                if (count && targetLocation.isEmpty()){
                    validMove = targetLocation.isEmpty();}
                else if (count) {
                    if (color == ChessBoard.WHITE) {
                        validMove = !targetLocation.isEmpty() && targetLocation.getPiece().getColor() ==
                                ChessBoard.BLACK;
                    } else if (color == ChessBoard.BLACK) {
                        validMove = !targetLocation.isEmpty() && targetLocation.getPiece().getColor() ==
                                ChessBoard.WHITE;
                    }
                }
            }
        }
        return validMove;
    }
    @Override
    public void move(String to) {
        Square targetLocation = location.getBoard().getSquareAt(to);
        //promoteToQueen
        targetLocation.setPiece(this);
        //clear previous location
        location.clear();
        //update current location
        location = targetLocation;
        location.getBoard().nextPlayer();
    }
    @Override
    public String toString() {
        return !(ChessBoard.turn%2==0) ? "B" : "b";
    }
}

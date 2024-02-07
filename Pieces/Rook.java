package Pieces;

import Chessboard.ChessBoard;
import Chessboard.Square;

import static java.lang.Math.abs;

public class Rook extends Piece{
    boolean initialLocation = true;
    public Rook(int color, Square location) {
        super(color, location);
    }
    @Override
    public boolean canMove(String to) {
        boolean validMove = false;
        Square targetLocation = location.getBoard().getSquareAt(to);
        int rowDistance = targetLocation.getRowDistance(location);
        if (this.location.isAtSameColumn(targetLocation) ){

            if (initialLocation){
                boolean count =true;

                Square[] between = location.getBoard().getSquaresBetweenSameColumn(location,
                        targetLocation);
                for (int n=1;n< abs(targetLocation.getRow()-location.getRow());++n){
                    if (!between[n-1].isEmpty()){
                        count=false;}
                }
                if (count && targetLocation.isEmpty()) {
                    validMove = targetLocation.isEmpty();
                }
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

            return validMove;
        }
        else if (this.location.isAtSameRow(targetLocation) ){

            if (initialLocation){
                boolean count =true;
                Square[] between = location.getBoard().getSquaresBetweenSameRow(location,
                        targetLocation);
                for (int n=1;n< abs(targetLocation.getCollumn()-location.getCollumn());++n){
                    if (!between[n-1].isEmpty())
                        count=false;
                }
                if (count && targetLocation.isEmpty()) {
                    validMove = targetLocation.isEmpty();
                }
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
            return validMove;
        }
        return validMove;

}
    @Override
    public void move(String to) {
        Square targetLocation = location.getBoard().getSquareAt(to);
        targetLocation.setPiece(this);
        location.clear();
        location = targetLocation;
        location.getBoard().nextPlayer();
    }
    @Override
    public String toString() {
        return !(ChessBoard.turn%2==0) ? "R" : "r";
    }
}

package Pieces;

import Chessboard.ChessBoard;
import Chessboard.Square;

import static java.lang.Math.abs;

public class King extends Piece{
    boolean initialLocation = true;
    public King(int color, Square location) {
        super(color, location);
    }

    @Override
    public boolean canMove(String to) {
        boolean validMove = false;
        Square targetLocation = location.getBoard().getSquareAt(to);
        int rowDistance = targetLocation.getRowDistance(location);
        int colDistance = targetLocation.getColDistance(location);
        if (this.location.isAtSameColumn(targetLocation)&&abs(rowDistance)==1 ){
            if (initialLocation){
                if (targetLocation.isEmpty()){
                validMove=targetLocation.isEmpty();}

                else if (!targetLocation.isEmpty()) {
                    if (color == ChessBoard.WHITE) {
                        validMove = targetLocation.getPiece().getColor() ==
                                ChessBoard.BLACK;
                    } else if (color == ChessBoard.BLACK) {
                        validMove = targetLocation.getPiece().getColor() ==
                                ChessBoard.WHITE;
                    }

                }
            }

            return validMove;
        }
        else if (this.location.isAtSameRow(targetLocation)&&abs(colDistance)==1 ){
            if (initialLocation){
                if (targetLocation.isEmpty()){
                    validMove=targetLocation.isEmpty();}

                else if (!targetLocation.isEmpty()) {
                    if (color == ChessBoard.WHITE) {
                        validMove = targetLocation.getPiece().getColor() ==
                                ChessBoard.BLACK;
                    } else if (color == ChessBoard.BLACK) {
                        validMove = targetLocation.getPiece().getColor() ==
                                ChessBoard.WHITE;
                    }

                }
            }

            return validMove;
        }
        else if (!this.location.isAtSameColumn(targetLocation) && !this.location.isAtSameRow(targetLocation)&& abs(targetLocation.getRow()-location.getRow())==abs(targetLocation.getCollumn()-location.getCollumn())&&abs(rowDistance)==1&&abs(colDistance)==1 ){
            if (initialLocation){
                if (targetLocation.isEmpty()){
                    validMove=targetLocation.isEmpty();}

                else if (!targetLocation.isEmpty()) {
                    if (color == ChessBoard.WHITE) {
                        validMove = targetLocation.getPiece().getColor() ==
                                ChessBoard.BLACK;
                    } else if (color == ChessBoard.BLACK) {
                        validMove = targetLocation.getPiece().getColor() ==
                                ChessBoard.WHITE;
                    }

                }
            }return validMove;}
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
        return !(ChessBoard.turn%2==0) ? "K" : "k";
    }


}

package Pieces;

import Chessboard.ChessBoard;
import Chessboard.Square;

import static java.lang.Math.abs;

public class Knight extends Piece{
    boolean initialLocation = true;
    public Knight(int color, Square location) {
        super(color, location);
    }
    @Override
    public boolean canMove(String to){
        boolean validMove = false;
        Square targetLocation = location.getBoard().getSquareAt(to);
        int rowDistance = targetLocation.getRowDistance(location);
        int colDistance = targetLocation.getColDistance(location);
        if (abs(rowDistance)==2&&abs(colDistance)==1){
            if (targetLocation.isEmpty()){
            validMove=true;}
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
        else if (abs(rowDistance)==1&&abs(colDistance)==2) {
            if (targetLocation.isEmpty()){
                validMove=true;
            } else if (!targetLocation.isEmpty()) {
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
        return !(ChessBoard.turn%2==0) ? "N" : "n";
    }
}

package Pieces;
import Chessboard.ChessBoard;
import Chessboard.Square;
public  class Piece {
    int color;
     Square location;

    public Piece(int color, Square location) {
        this.color =color;
        this.location=location;
    }

    public boolean canMove(String to){
        return true;
    }
    public void move(String to){

    }

    public int getColor() {
        return color;
    }
    public Piece whatType(){
        if (ChessBoard.b[location.getRow()-1][location.getCollumn()-1].contains("p")&& (ChessBoard.turn%2==0))
            return new Pawn(ChessBoard.BLACK,location);
        else if (ChessBoard.b[location.getRow()-1][location.getCollumn()-1].contains("P")&&!(ChessBoard.turn%2==0))
            return new Pawn(ChessBoard.WHITE,location);
        else if (ChessBoard.b[location.getRow()-1][location.getCollumn()-1].contains("q")&& (ChessBoard.turn%2==0))
            return new Queen(ChessBoard.BLACK,location);
        else if (ChessBoard.b[location.getRow()-1][location.getCollumn()-1].contains("Q")&&!(ChessBoard.turn%2==0))
            return new Queen(ChessBoard.WHITE,location);
        else if (ChessBoard.b[location.getRow()-1][location.getCollumn()-1].contains("r")&& (ChessBoard.turn%2==0))
            return new Rook(ChessBoard.BLACK,location);
        else if (ChessBoard.b[location.getRow()-1][location.getCollumn()-1].contains("R")&&!(ChessBoard.turn%2==0))
            return new Rook(ChessBoard.WHITE,location);
        else if (ChessBoard.b[location.getRow()-1][location.getCollumn()-1].contains("b")&& (ChessBoard.turn%2==0))
            return new Bishop(ChessBoard.BLACK,location);
        else if (ChessBoard.b[location.getRow()-1][location.getCollumn()-1].contains("B")&&!(ChessBoard.turn%2==0))
            return new Bishop(ChessBoard.WHITE,location);
        else if (ChessBoard.b[location.getRow()-1][location.getCollumn()-1].contains("n")&& (ChessBoard.turn%2==0))
            return new Knight(ChessBoard.BLACK,location);
        else if (ChessBoard.b[location.getRow()-1][location.getCollumn()-1].contains("N")&&!(ChessBoard.turn%2==0))
            return new Knight(ChessBoard.WHITE,location);
        else if (ChessBoard.b[location.getRow()-1][location.getCollumn()-1].contains("k")&& (ChessBoard.turn%2==0))
            return new King(ChessBoard.BLACK,location);
        else if (ChessBoard.b[location.getRow()-1][location.getCollumn()-1].contains("K")&&!(ChessBoard.turn%2==0))
            return new King(ChessBoard.WHITE,location);
        else
            return null;
    }

}



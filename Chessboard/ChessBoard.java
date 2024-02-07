package Chessboard;
import Pieces.Pawn;
import Pieces.Piece;
import static java.lang.Math.abs;

public class ChessBoard {
    public static int WHITE=1;
    public static int BLACK=0;

    public static int turn=1;

    public String[][] getB() {
        return b;
    }

     public static String[][] b = { { "R", "N", "B" , "Q", "K", "B", "N", "R"}, { "P", "P", "P", "P", "P", "P", "P", "P" }, { " ", " ", " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " ", " ", " " }, { "p", "p", "p", "p", "p", "p", "p", "p" }, { "r", "n", "b", "q", "k", "b", "n", "r" } };

    char[] letters ={'A','B','C','D','E','F','G','H'};
    int[] c={1,2,3,4,5,6,7,8};
    int[] loop={0,1,2,3,4,5,6,7};
    Square square;


public String drawBoard(){
    String board="";
    for ( char c: letters){

        if (c=='A')
            board+= "    "+c+"   ";
        else if (c=='H')
            board+= c+"\n";
        else
            board+= c+"   ";
    }
    board +="   -------------------------------"+"\n";

    for (int r=7;r>-1; --r) {
        board += (r+1)+" ";
        for (int v=0;v<c.length; ++v){

            if (v==7)
                board+= "|"+" " + b[r][v] + " "+"| "+(r+1)+"\n";
            else
                board+= "|"+" " + b[r][v] + " ";
        }
        board += "   -------------------------------"+"\n";
    }
    for ( char c: letters){

        if (c=='A')
            board+= "    "+c+"   ";
        else if (c=='H')
            board+= c+"\n";
        else
            board+= c+"   ";
    }
    return board;

}
        public boolean isGameEnded(){
        boolean game=false;
        int countwhite =0;
        int countblack =0;
            for (int r:loop){
                for (int v:loop){
                    if (b[v][r].toLowerCase().contains(b[v][r]) &&!b[v][r].toUpperCase().contains(b[v][r]) && !b[v][r].contains(" "))
                        ++countblack;
                    else if (b[v][r].toUpperCase().contains(b[v][r]) &&!b[v][r].toLowerCase().contains(b[v][r]) && !b[v][r].contains(" ")) {
                        ++countwhite;
                    }
                }
            }
            if (countblack==0&&countwhite>0){
                System.out.println("White Wins");
                return game =true;}
            else if (countwhite==0&&countblack>0) {
                System.out.println("Black Wins");
                return game=true;
            }
            else
                return game;
        }
public static int ds=0;
    public boolean isWhitePlaying(){
        return ds % 2 == 0;

    }
    public Piece getPieceAt( String from){
        String[] a =from.split("");
        String lower = from.toLowerCase();
        int i = Integer.parseInt(a[1]);
        int col = WHITE;
        if (ChessBoard.turn%2==0 ) {
            col = BLACK;
        }
            if (lower.contains("a")&& i<9)
                return new Piece(col, new Square(i, 1)).whatType();
            else if (lower.contains("b")&& i<9)
                    return new Piece(col, new Square(i, 2)).whatType();
            else if (lower.contains("c")&& i<9)
                return new Piece(col, new Square(i, 3)).whatType();
            else if (lower.contains("d")&& i<9)
                 return new Piece(col, new Square(i, 4)).whatType();
            else if (lower.contains("e")&& i<9)
                return new Piece(col, new Square(i, 5)).whatType();
            else if (lower.contains("f")&& i<9)
                return new Piece(col, new Square(i, 6)).whatType();
            else if (lower.contains("g")&& i<9)
                return new Piece(col, new Square(i, 7)).whatType();
            else if (lower.contains("h")&& i<9)
                return new Piece(col, new Square(i, 8)).whatType();
            else
                return null;
    }
    public Square getSquareAt(String o){
        String[] a =o.split("");
        String lower = o.toLowerCase();
        int i = Integer.parseInt(a[1]);

        if (o.contains("a") )
            return new Square(i,1);
        else if (lower.contains("b") )
            return new Square(i,2);
        else if (lower.contains("c") )
            return new Square(i,3);
        else if (lower.contains("d") )
            return new Square(i,4);
        else if (lower.contains("e") )
            return new Square(i,5);
        else if (lower.contains("f") )
            return new Square(i,6);
        else if (lower.contains("g") )
            return new Square(i,7);
        else if (lower.contains("h") )
            return new Square(i,8);
        else
            return null;

    }


    public Square[] getSquaresBetweenSameColumn(Square location, Square targetLocation) {
        Square[] a=new Square[8];
        for (int n=1;n< abs(targetLocation.getRow()-location.getRow());++n){
            if ( 0 <targetLocation.getRow()-location.getRow()) {
                Square s = new Square(targetLocation.getRow()-n,location.getCollumn());
                a[n-1]= s;
            }
            else {
                Square bc = new Square(targetLocation.getRow()+n, location.getCollumn());
                a[n-1]= bc;
            }
        }
        return a;
    }
    public Square[] getSquaresBetweenSameRow(Square location, Square targetLocation){
        Square[] c=new Square[8];
        for (int n=1;n< abs(targetLocation.getCollumn()-location.getCollumn());++n){
            if ( 0 <targetLocation.getCollumn()-location.getCollumn()) {
                Square s = new Square(location.getRow(),location.getCollumn()+n);
                c[n-1]= s;
            }
            else {
                Square bc = new Square(location.getRow(), location.getCollumn()-n);
                c[n-1]= bc;
            }
        }
        return c;

    }
        public Square[] getSquaresBetweenDiognal(Square location, Square targetLocation){
        Square[] diag=new Square[8];
        for (int n=1;n< abs(targetLocation.getCollumn()-location.getCollumn());++n){
            if ( 0 <targetLocation.getCollumn()-location.getCollumn()&& 0<targetLocation.getRow()-location.getRow()) {
                Square s = new Square(location.getRow()+n,location.getCollumn()+n);
                diag[n-1]= s;
            }
            else if (0>targetLocation.getCollumn()-location.getCollumn()&& 0>targetLocation.getRow()-location.getRow()){
                Square bc = new Square(location.getRow()-n, location.getCollumn()-n);
                diag[n-1]= bc;
            }
            else if (0 <targetLocation.getCollumn()-location.getCollumn()&& 0>targetLocation.getRow()-location.getRow()){
                Square bc = new Square(location.getRow()-n, location.getCollumn()+n);
                diag[n-1]= bc;
            }
            else if (0 >targetLocation.getCollumn()-location.getCollumn()&& 0<targetLocation.getRow()-location.getRow()){
                Square bc = new Square(location.getRow()+n, location.getCollumn()-n);
                diag[n-1]= bc;
            }
            else
                return diag;
        }
        return diag;





    }

    public void nextPlayer() {
        ++turn;
    }

}

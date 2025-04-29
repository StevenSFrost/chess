package chess;

import java.util.Collection;
import java.util.Objects;

/**
 * Represents a single chess piece
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessPiece {

    private final ChessGame.TeamColor color;
    private ChessPiece.PieceType type;
    private boolean hasMoved;

    public ChessPiece(ChessGame.TeamColor pieceColor, ChessPiece.PieceType pieceType) {
        this.color = pieceColor;
        this.type = pieceType;
        this.hasMoved = false;
    }

    /**
     * The various different chess piece options
     */
    public enum PieceType {
        KING,
        QUEEN,
        BISHOP,
        KNIGHT,
        ROOK,
        PAWN
    }

    /**
     * @return Which team this chess piece belongs to
     */
    public ChessGame.TeamColor getTeamColor() {
        return color;
    }

    /**
     * @return which type of chess piece this piece is
     */
    public PieceType getPieceType() {
        return type;
    }

    /**
     * @return true if the piece has moved or false otherwise
     */
    public boolean hasPieceMoved() {
        return hasMoved;
    }

    /**
     * Indicates that the piece has moved.
     */
    public void pieceMoved() {
        hasMoved = true;
    }

    public String toBoardString() {
        switch (this.type) {
            case KING:
                return color == ChessGame.TeamColor.WHITE ? "K" : "k";
            case QUEEN:
                return color == ChessGame.TeamColor.WHITE ? "Q" : "q";
            case BISHOP:
                return color == ChessGame.TeamColor.WHITE ? "B" : "b";
            case KNIGHT:
                return color == ChessGame.TeamColor.WHITE ? "N" : "n";
            case ROOK:
                return color == ChessGame.TeamColor.WHITE ? "R" : "r";
            case PAWN:
                return color == ChessGame.TeamColor.WHITE ? "P" : "p";
        }
        return " ";
    }

    /**
     * Calculates all the positions a chess piece can move to
     * Does not take into account moves that are illegal due to leaving the king in
     * danger
     *
     * @return Collection of valid moves
     */
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition) {
        switch (getPieceType()) {
            case KING:
                KingMovesCalculator kingCalc = new KingMovesCalculator();
                return kingCalc.pieceMoves(board, myPosition);
            case QUEEN:
                QueenMovesCalculator queenCalc = new QueenMovesCalculator();
                return queenCalc.pieceMoves(board, myPosition);
            case BISHOP:
                BishopMovesCalculator bishopCalc = new BishopMovesCalculator();
                return bishopCalc.pieceMoves(board, myPosition);
            case KNIGHT:
                KnightMovesCalculator knightCalc = new KnightMovesCalculator();
                return knightCalc.pieceMoves(board, myPosition);
            case ROOK:
                RookMovesCalculator rookCalc = new RookMovesCalculator();
                return rookCalc.pieceMoves(board, myPosition);
            case PAWN:
                PawnMovesCalculator pawnCalc = new PawnMovesCalculator();
                return pawnCalc.pieceMoves(board, myPosition);
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessPiece that = (ChessPiece) o;
        return hasMoved == that.hasMoved && color == that.color && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type, hasMoved);
    }

    @Override
    public String toString() {
        return "ChessPiece{" +
                "color=" + color +
                ", type=" + type +
                ", hasMoved=" + hasMoved +
                '}';
    }
}

package chess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * A chessboard that can hold and rearrange chess pieces.
 * <p>
 * Note: You can add to this class, but you may not alter
 * signature of the existing methods.
 */
public class ChessBoard {
    private ChessPiece[][] squares = new ChessPiece[8][8];
    private final ArrayList<ChessPiece.PieceType> basicOrder = new ArrayList<>(Arrays.asList(
            ChessPiece.PieceType.ROOK, ChessPiece.PieceType.KNIGHT,
            ChessPiece.PieceType.BISHOP, ChessPiece.PieceType.QUEEN,
            ChessPiece.PieceType.KING, ChessPiece.PieceType.BISHOP,
            ChessPiece.PieceType.KNIGHT, ChessPiece.PieceType.ROOK));

    public ChessBoard() {
    }

    /**
     * Adds a chess piece to the chessboard
     *
     * @param position where to add the piece to
     * @param piece    the piece to add
     */
    public void addPiece(ChessPosition position, ChessPiece piece) {
        squares[position.getRow() - 1][position.getColumn() - 1] = piece;
    }

    /**
     * Gets a chess piece on the chessboard
     *
     * @param position The position to get the piece from
     * @return Either the piece at the position, or null if no piece is at that
     * position
     */
    public ChessPiece getPiece(ChessPosition position) {
        if (0 < position.getRow() && position.getRow() < 9 && 0 < position.getColumn() && position.getColumn() < 9) {
            return squares[position.getRow() - 1][position.getColumn() - 1];
        }
        return null;
    }

    /**
     * Sets the board to the default starting board
     * (How the game of chess normally starts)
     */
    public void resetBoard() {
        squares = new ChessPiece[8][8];
        for (int i = 0; i < 8; i++) {
            squares[0][i] = new ChessPiece(ChessGame.TeamColor.WHITE, basicOrder.get(i));
            squares[1][i] = new ChessPiece(ChessGame.TeamColor.WHITE, ChessPiece.PieceType.PAWN);
            squares[7][i] = new ChessPiece(ChessGame.TeamColor.BLACK, basicOrder.get(i));
            squares[6][i] = new ChessPiece(ChessGame.TeamColor.BLACK, ChessPiece.PieceType.PAWN);
        }


    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessBoard that = (ChessBoard) o;
        return Objects.deepEquals(squares, that.squares);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(squares);
    }

    @Override
    public String toString() {
        StringBuilder repr = new StringBuilder();
        repr.append("");
        for (int x = 1; x < 9; x++) {
            repr.append('|');
            for (int y = 1; y < 9; y++) {
                ChessPosition pos = new ChessPosition(x, y);
                repr.append((getPiece(pos) != null ? getPiece(pos).toBoardString() : ' '));
                repr.append('|');
            }
            repr.append("\n");
        }
        return repr.toString();
    }
}

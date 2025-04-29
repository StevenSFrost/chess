package chess;

import java.util.Collection;

public interface PieceMovesCalculator {
    Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition position);

    default boolean isWithinBounds(ChessMove move) {
        return !( move.getEndPosition().getColumn() > 8 | move.getEndPosition().getColumn() < 0 | move.getEndPosition().getRow() > 8 | move.getEndPosition().getRow() < 0);
    }

    default boolean enemyPiecePresent(ChessBoard board, ChessMove move) {
        return ( board.getPiece(move.getEndPosition()) != null);
    }
}

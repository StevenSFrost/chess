package chess;

import java.util.Collection;

public interface PieceMovesCalculator {
    Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition position);

    default boolean isWithinBounds(ChessMove move) {
        return !( move.getEndPosition().getColumn() > 8 | move.getEndPosition().getColumn() < 1 | move.getEndPosition().getRow() > 8 | move.getEndPosition().getRow() < 1);
    }

    default boolean enemyPiecePresent(ChessBoard board, ChessMove move) {
        return board.getPiece(move.getEndPosition()) != null
                ? board.getPiece(move.getEndPosition()).getTeamColor() != board.getPiece(move.getStartPosition()).getTeamColor()
                : false;
    }

    default boolean friendlyPiecePresent(ChessBoard board, ChessMove move) {
        return board.getPiece(move.getEndPosition()) != null
                ? board.getPiece(move.getEndPosition()).getTeamColor() == board.getPiece(move.getStartPosition()).getTeamColor()
                : false;
    }
}

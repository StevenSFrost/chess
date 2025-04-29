package chess;

import java.util.ArrayList;
import java.util.Collection;

public class PawnMovesCalculator implements PieceMovesCalculator {
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition position) {
        ArrayList<ChessMove> validMoves = new ArrayList<>();
        ChessPiece piece = board.getPiece(position);

        int [][] possibleCaptures = {{1, 1}, {-1, 1}};
        int [][] possibleMoves = piece.hasPieceMoved() ? new int [][] {{1, 0}} : new int[][] {{1, 0}, {2, 0}}; // allows moving two spaces forward if the piece has not yet moved.

        for (int [] move : possibleCaptures) { // Checks the possible diagonal captures and adds them if they are valid and there is an enemy piece.
            ChessPosition moveTo = new ChessPosition(position.getRow() + move[0], position.getColumn() + move[1]);
            ChessMove possibleMove = new ChessMove(position, moveTo, null);
            if (isWithinBounds(possibleMove)) {
                if (enemyPiecePresent(board, possibleMove)) {
                    validMoves.add(possibleMove);
                }
            }
        }

        for (int [] move : possibleMoves) { // Checks the possible directional moves, adding them if there is not an enemy present.
            ChessPosition moveTo = new ChessPosition(position.getRow() + move[0], position.getColumn() + move[1]);
            ChessMove possibleMove = new ChessMove(position, moveTo, null);
            if (enemyPiecePresent(board, possibleMove)) break;
            if (isWithinBounds(possibleMove)) validMoves.add(possibleMove);
        }
        return validMoves;
    }
}

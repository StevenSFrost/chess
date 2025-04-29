package chess;

import java.util.ArrayList;
import java.util.Collection;

public class KingMovesCalculator implements PieceMovesCalculator {
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition position) {
        ArrayList<ChessMove> validMoves = new ArrayList<>();

        int [][] possibleMoves = {{1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}};

        for (int [] move : possibleMoves) { // Checks the possible directional moves, adding them if there is not an enemy present.
            ChessPosition moveTo = new ChessPosition(position.getRow() + move[0], position.getColumn() + move[1]);
            ChessMove possibleMove = new ChessMove(position, moveTo, null);
            if (isWithinBounds(possibleMove) && !friendlyPiecePresent(board, possibleMove)) validMoves.add(possibleMove);
        }

        return validMoves;
    }
}

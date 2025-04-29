package chess;

import java.util.ArrayList;
import java.util.Collection;

public class RookMovesCalculator implements PieceMovesCalculator {
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition position) {
        ArrayList<ChessMove> validMoves = new ArrayList<>();

        int [][] possibleMoves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int [] move : possibleMoves) { // Checks the possible diagonal moves, adding them if an enemy is present and stopping, or stopping if there's a friendly
            for (int i = 0; true; i++) {
                ChessPosition moveTo = new ChessPosition(position.getRow() + move[0] * i, position.getColumn() + move[1] * i);
                ChessMove possibleMove = new ChessMove(position, moveTo, null);
                if (enemyPiecePresent(board, possibleMove)) {
                    validMoves.add(possibleMove);
                    break;
                } else if (friendlyPiecePresent(board, possibleMove)) {
                    break;
                } else if (isWithinBounds(possibleMove)) {
                    validMoves.add(possibleMove);
                    continue;
                }
                break;
            }
        }

        return validMoves;
    }
}

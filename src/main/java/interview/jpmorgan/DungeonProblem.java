package interview.jpmorgan;

import java.util.LinkedList;
import java.util.Queue;

class DungeonProblem {
    public static void main(String[] args) {

    }

    public static int solve(char[][] matrix) {
        int startRow = -1, startCol = -1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 'S') {
                    startRow = i;
                    startCol = j;
                    break;
                }
            }
        }
        Queue<Integer> rowQueue = new LinkedList<>();
        Queue<Integer> colQueue = new LinkedList<>();
        rowQueue.add(startRow);
        colQueue.add(startCol);

        int nodesInNextLayer = 0, nodesLeftInLayer = 0, moveCount = 0;

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        boolean reachedEnd = false;
        while (!rowQueue.isEmpty()) {
            int r = rowQueue.poll();
            int c = colQueue.poll();

            if (matrix[r][c] == 'E') {
                reachedEnd = true;
                break;
            }

            exploreNeighbours(rowQueue, colQueue, r, c, matrix, visited, nodesInNextLayer);
            nodesLeftInLayer--;
            if (nodesLeftInLayer == 0) {
                nodesLeftInLayer = nodesInNextLayer;
                nodesInNextLayer = 0;
                moveCount++;
            }
        }

        if (reachedEnd) {
            return moveCount;
        } else {
            return -1;
        }
    }

    private static void exploreNeighbours(Queue<Integer> rowQueue, Queue<Integer> colQueue, int r, int c,
            char[][] matrix, boolean[][] visited, int nodesInNextLayer) {
        int dr[] = new int[] { 1, 0, -1, 0 };
        int dc[] = new int[] { 0, 1, 0, -1 };

        for (int i = 0; i < 4; i++) {
            int newR = r + dr[i];
            int newC = c + dc[i];

            if (newR < 0 || newC < 0 || newR >= matrix.length || newC >= matrix[0].length || visited[newR][newC]
                    || matrix[newR][newC] == '#') {
                continue;
            }

            rowQueue.add(newR);
            colQueue.add(newC);

            visited[newR][newC] = true;
            nodesInNextLayer++;

        }
    }
}
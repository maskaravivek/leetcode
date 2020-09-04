package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PathCrossing {
    public boolean isPathCrossing(String path) {
        char[] p = path.toCharArray();

        List<String> coords = new ArrayList<>();

        int centerX = 0, centerY = 0;
        coords.add(centerX + "," + centerY);

        for (int i = 0; i < p.length; i++) {
            switch (p[i]) {
                case 'N':
                    centerY = centerY + 1;
                    break;
                case 'S':
                    centerY = centerY - 1;
                    break;
                case 'E':
                    centerX = centerX + 1;
                    break;
                case 'W':
                    centerX = centerX - 1;
                    break;
            }
            String coord = centerX + "," + centerY;
            if (coords.contains(coord)) {
                return true;
            }
            coords.add(coord);
        }
        System.out.println(coords);
        return false;
    }
}
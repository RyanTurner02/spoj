import java.util.*;
import java.io.*;

class ELEVTRBL {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String[] fsgud = br.readLine().split(" ");
            int f = Integer.valueOf(fsgud[0]);
            int s = Integer.valueOf(fsgud[1]);
            int g = Integer.valueOf(fsgud[2]);
            int u = Integer.valueOf(fsgud[3]);
            int d = Integer.valueOf(fsgud[4]);

            int[] distances = new int[f + 1];
            Arrays.fill(distances, -1);

            int numPushes = BFS(distances, f, s, g, u, d);

            if (numPushes == -1) {
                System.out.println("use the stairs");
            } else {
                System.out.println(numPushes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int BFS(int[] distances, int f, int s, int g, int u, int d) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        distances[s] = 0;

        while (!queue.isEmpty()) {
            int currDist = queue.poll();

            if (currDist == g) {
                return distances[currDist];
            }

            int upDist = currDist + u;
            int downDist = currDist - d;

            if (upDist <= f && distances[upDist] == -1) {
                distances[upDist] = distances[currDist] + 1;
                queue.add(upDist);
            }

            if (downDist >= 1 && distances[downDist] == -1) {
                distances[downDist] = distances[currDist] + 1;
                queue.add(downDist);
            }
        }
        return -1;
    }
}

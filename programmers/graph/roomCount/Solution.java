package algoStudy.programmers.graph.roomCount;

import java.util.HashSet;

public class Solution {

    static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
    static int[] dy = { 1, 1, 0, -1, -1, -1, 0, 1 };
    static int[] dz = { 4, 5, 6, 7, 0, 1, 2, 3, };

    static HashSet<Edge> edge = new HashSet<>();
    static HashSet<Node> node = new HashSet<>();

    public int solution(int[] arrows) {
        int x1 = 0, y1 = 0, answer = 0;
        int x2 = 0, y2 = 0, dir2 = 0;
        node.add(new Node(x1, y1));

        for (int dir : arrows) {
            x2 = x1 + dx[dir];
            y2 = y1 + dy[dir];
            dir2 = dz[dir];

            Edge e1 = new Edge(x1, y1, dir);
            Edge e2 = new Edge(x2, y2, dir2);
            if (!edge.contains(e1)) {
                edge.add(e1);
                edge.add(e2);
                if (node.contains(new Node(x2, y2))) {
                    answer++;
                } else {
                    node.add(new Node(x2, y2));
                }

                if (dir % 2 == 1) {
                    Edge ed;
                    switch (dir) {
                        case 1:
                            ed = new Edge(x1, y1 + 1, 3);
                            break;
                        case 3:
                            ed = new Edge(x1, y1 - 1, 1);
                            break;
                        case 5:
                            ed = new Edge(x1, y1 - 1, 7);
                            break;
                        case 7:
                            ed = new Edge(x1, y1 + 1, 5);
                            break;
                        default:
                            ed = new Edge(0, 0, 0);
                            break;
                    }
                    if (edge.contains(ed))
                        answer++;

                }
            }
            x1 = x2;
            y1 = y2;

        }

        return answer;
    }

    static class Edge {
        int x;
        int y;
        int dir;

        public Edge(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + dir;
            result = prime * result + x;
            result = prime * result + y;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Edge other = (Edge) obj;
            if (dir != other.dir)
                return false;
            if (x != other.x)
                return false;
            if (y != other.y)
                return false;
            return true;
        }

    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + x;
            result = prime * result + y;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Node other = (Node) obj;
            if (x != other.x)
                return false;
            if (y != other.y)
                return false;
            return true;
        }
    }
}

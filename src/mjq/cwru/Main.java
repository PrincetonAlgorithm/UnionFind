package mjq.cwru;

public class Main {

    public static void main(String[] args) {
        // write your code here
    }

    public class QuickFindUF {
        private int[] id;

        public QuickFindUF(int N) {
            id = new int[N];
            for (int i = 0; i < N; i++) {
                id[i] = i;
            }
        }

        public boolean connected(int p, int q) {
            return id[p] == id[q];
        }

        public void union(int p, int q) {
            int pid = id[p];
            int qid = id[q];
            for (int i = 0; i < id.length; i++) {
                //find all items whose id[i] is pid and change them to qid
                if (id[i] == pid) {
                    id[i] = qid;
                }
            }
        }
    }

    /**
     *   0  1   9
     *          /\
     *         2  4
     *             |
     *             3
     *
     *
     *     2,3,4,9 are connected
     */

    public class QuickUnionUF {
        private int[] id;
        private int[] size;

        public QuickUnionUF(int N) {
            id = new int[N];
            size = new int[N];
            for (int i = 0; i < N; i++) {
                id[i] = i;
                size[i] = 1;
            }
        }

        //path compression to make the tree flat
        private int root(int i) {
            while (i != id[i]) {
                //connect id[i] to it's parent's parent;
                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }

        public boolean connected(int p, int q) {
            return root(p) == root(q);
        }

        // weighting to make the height lower
        public void union(int p, int q) {
            int i = root(p);
            int j = root(q);
            if (size[i] <= size[j]) {
                id[i] = j;
                size[j] += size[i];
            } else {
                id[j] = i;
                size[i] += size[j];
            }
        }
    }

    public static int binarySearh(int[] a, int key) {
        int lo = 0, hi = a.length - 1;

        while (lo < hi) {
            int mid = (hi - lo)/2 + lo;
            if (a[mid] < key) {
                lo = mid + 1;
            } else if(a[mid] > key) {
                hi = mid - 1;
            } else {
                return mid;
            }
         }

        return -1;
    }

}

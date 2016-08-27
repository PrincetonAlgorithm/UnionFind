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

    
}

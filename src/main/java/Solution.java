import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] e : edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        int[] res = new int[n];

        dfs(graph, 0, labels, res, 0);

        return res;

    }
    int[] dfs(List<List<Integer>> graph, int node, String labels, int[] res, int prev){
        if(graph.get(node).size() == 1 && node != 0){
            res[node] = 1;
            int[] chars = new int[26];
            chars[labels.charAt(node) - 'a']++;
            return chars;
        }

        int[] freq = new int[26];
        freq[labels.charAt(node) - 'a']++;
        List<Integer> neigh = graph.get(node);
        for(int i = 0; i < neigh.size(); i++){
            if(neigh.get(i) != prev){
                freq = add(freq, dfs(graph, neigh.get(i), labels, res, node));
            }
        }

        res[node] = freq[labels.charAt(node) - 'a'];
        return freq;
    }

    int[] add(int[] a1, int[] a2){
        for(int i =0; i < 26; i++){
            a1[i] = a1[i] + a2[i];
        }
        return a1;
    }

}

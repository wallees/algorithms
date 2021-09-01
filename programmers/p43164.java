package programmers;

import java.util.*;

public class P43164 {

    private ArrayList<String> list;
    private boolean[] used;

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        list = new ArrayList<>();
        used = new boolean[tickets.length];
        dfs(tickets, used, "ICN", "ICN", 0);
        Collections.sort(list);
        answer = list.get(0).split(" ");
        return answer;
    }

    public void dfs(String[][] tickets, boolean[] used, String current, String plan, int count) {
        if (count == tickets.length) {
            list.add(plan);
            return;
        }

        for (int i=0; i<tickets.length; i++) {
            if (used[i] == false && tickets[i][0].equals(current)) {
                used[i] = true;
                dfs(tickets, used, tickets[i][1], plan + " " + tickets[i][1], count+1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
//        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
        System.out.println((new P43164()).solution(tickets));
    }

}

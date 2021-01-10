package leetcode;

public class BrowserHistory {

    String[] arr = new String[5000];
    int idx = 0, currentIdx = 0;

    public BrowserHistory(String homepage) {
        arr[idx] = homepage;
        currentIdx = idx;
    }

    public void visit(String url) {
        idx = currentIdx + 1;
        arr[idx] = url;
        currentIdx = idx;
    }

    public String back(int steps) {
        currentIdx = currentIdx - steps >= 0 ? currentIdx - steps : 0;
        return arr[currentIdx];
    }

    public String forward(int steps) {
        currentIdx = currentIdx + steps > idx ? idx : currentIdx + steps;
        return arr[currentIdx];
    }
}
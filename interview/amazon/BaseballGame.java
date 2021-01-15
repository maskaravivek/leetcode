package interview.amazon;

import java.util.*;

class BaseballGame {
    public int calPoints(String[] ops) {
        List<Integer> records = new ArrayList<>();
        
        for(int i=0; i< ops.length; i++) {
            if(ops[i].equals("C")) {
                records.remove(records.size() - 1);
            } else if(ops[i].equals("D")) {
                records.add(records.get(records.size() - 1) * 2);
            } else if(ops[i].equals("+")) {
                records.add(records.get(records.size() - 1) + records.get(records.size() - 2));
            } else {
                records.add(Integer.parseInt(ops[i]));
            }
        }
        
        int sum = 0;
        for(int i=0; i< records.size(); i++) {
            sum += records.get(i);           
        }
        return sum;
    }
}

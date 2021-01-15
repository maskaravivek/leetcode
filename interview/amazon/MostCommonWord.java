package interview.amazon;

import java.util.*;

class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        paragraph = paragraph.replace("!", " ").replace("?", " ").replace("\'", " ").replace(",", " ").replace(";", " ").replace(".", " ");
        String[] words = paragraph.split(" ");
        
        List<String> bannedWords = new ArrayList<>();
        
        for(int i=0; i< banned.length; i++) {
            bannedWords.add(banned[i]);
        }
        
        
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i< words.length; i++) {
            
            String cleanedWord = words[i].trim();
            
            cleanedWord = cleanedWord.toLowerCase();
            if(cleanedWord.length() == 0) {
                continue;
            }
            
            if(!bannedWords.contains(cleanedWord)) {
                map.put(cleanedWord, map.getOrDefault(cleanedWord, 0) + 1);    
            }
        }
        
        PriorityQueue<String> queue = new PriorityQueue<>((a, b) -> {
            return map.get(b) - map.get(a);
        });
        
        queue.addAll(map.keySet());
        
        return queue.poll();
        
    }
}
public class MaxScore {
    public static int maxScore(String word[], int freq[], int score[], int idx) {
        int t =0;
        if(idx == word.length) return 0;
        boolean flag=true;
        int sw =0;
        for(int i=0;i<word[idx].length();i++) {
            char c = word[idx].charAt(i);
            if (freq[c -'a']==0) flag =false;
            freq[c-'a'] -= 1;
            sw += score[c-'a'];
        }

        if(flag) t = Math.max(sw+maxScore(word,freq,score,idx+1), maxScore(word,freq,score,idx+1));
        else t = maxScore(word,freq,score,idx+1);
        for(int i=0;i<word[idx].length();i++) {
            char c = word[idx].charAt(i);
            freq[c-'a'] += 1;
        }
        return t;
    }

    public static void main(String args[]) {

    }
}

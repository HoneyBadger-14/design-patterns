package Scramble;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ScrambleOne {

    public int secondHighest(String s) {
    	int first = -1, sec=-1;
    	for(int i =0; i < s.length(); i++) {
    		char c = s.charAt(i);
    		if(Character.isDigit(c)) {
    			int d = c - '0';
    			if(first < d) {
    				sec = first;
    				first = d;
    			} else if(sec < d && d < first) {
    				sec = d;
    			}
    		}
    	}
    	 return sec;
    }
    
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            }
            map.put(nums[i], i);
        }
        return result;
    }
    
    
    public boolean resultString(String fi, String sec, String target) {
    	return getStringValue(fi) + getStringValue(sec) == getStringValue(target);
    }
    
    private short getStringValue(String s) {
    	short res = 0;
    	for(short i = 0; i < s.length(); i++) {
    		res = (short) (res * 10 + (s.charAt(i) - 'a'));
    	}
    	return res;
    }
    
    
    private void rotateMat(int [][] mat) {
    	for(int i=0, j=mat.length-1; i<j; i++, --j) {
    		int[] temp = mat[i];
    		mat[i] = mat[j];
    		mat[j] = temp;
    	}
    	
    	for(int r = 0, R = mat.length; r < R ; r++) {
    		for(int c =r+1; c<R; c++ ) {
    			int temp = mat[c][r];
    			mat[c][r] = mat[r][c];
    			mat[r][c] = temp;
    		}
    	}
    }
    
    public boolean findRotation(int[][] mat, int[][] target) {
    	for(int i =0; i<4; i++) {
    		if(Arrays.deepEquals(mat, target)) {
    			return true;
    		}
    		rotateMat(mat);
    	}
    	return false;
    }
    
    
    public boolean isCovered(int[][] ranges, int left, int right) {
    	//Arrays.sort(ranges, (x,y) -> x[0]-y[0]);
    	for(int[] range : ranges) {
    		if(left >= range[0] && left <=range[1]) {
    			left = range[0] +1;
    		}
    	}
    	return left > right;
    
    }
    
    
    public boolean areAlmostEqual(String s1, String s2) {
    	if(s1.length() != s2.length()) {
    		return false;
    	}
    	if(s1.equals(s2)) {
    		return true;
    	}
    	
    	short count = 0;
    	char firstS1 = s1.charAt(0);
    	char firstS2 = s2.charAt(0);
    	
    	for(short i =0; i<s1.length(); i++) {
    		if(count > 2) {
    			return false;
    		}
    		if(s1.charAt(i)!=s2.charAt(i)) {
    			if(count == 0) {
    				firstS1 = s1.charAt(i);
    				firstS2 = s2.charAt(i);
    			}
    			if(count == 1) {
    				if(firstS1 != s2.charAt(i) || firstS2 != s1.charAt(i)) {
    					return false;
    				}
    			}
    			count++;
    		}
    	}
    	return count == 2 ? true : false;
    }
    
    // Arraging the string in zig zag and appending each row in string buffer
    public String convert(String s, int nRows) {
        char[] c = s.toCharArray();
        int len = c.length;
        StringBuffer[] sb = new StringBuffer[nRows];
        for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();
        
        int i = 0;
        while (i < len) {
            for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
                sb[idx].append(c[i++]);
            for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
                sb[idx].append(c[i++]);
        }
        for (int idx = 1; idx < sb.length; idx++)
            sb[0].append(sb[idx]);
        return sb[0].toString();
    }
}

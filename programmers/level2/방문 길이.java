import java.util.*;

class Solution {
    
    private static final int X = 0;
    private static final int Y = 1;
    
    public int solution(String dirs) {
        int[] xy = {0,0};
        List<Set<String>> visits = new ArrayList<>();
        char[] directs = dirs.toCharArray();
        for(char direct : directs){
            Set<String> path = move(xy,direct);
            if(path != null && !visits.contains(path)){
                visits.add(path);
            }
        }
        return visits.size();
    }
    
    private Set<String> move(int[] xy, char direct){
        Set<String> pathSet = new HashSet<>();
        pathSet.add(getStringCoordinate(xy));
        switch(direct){
            case 'L':
                xy[X] -= 1;
                if(xy[X] < -5){
                    xy[X] += 1;
                    return null;
                }
                break;
                
            case 'D':
                xy[Y] -= 1;
                if(xy[Y] < -5){
                    xy[Y]+= 1;
                    return null;
                }
                break;
                
            case 'R':
                xy[X] += 1;
                if(xy[X] > 5){
                    xy[X] -= 1;
                    return null;
                }
                break;
                
            case 'U':
                xy[Y] += 1;
                if(xy[Y] > 5){
                    xy[Y] -= 1;
                    return null;
                }
                break;
        }
        pathSet.add(getStringCoordinate(xy));
        return pathSet;
    }
    
    private String getStringCoordinate(int[] xy){
        return String.valueOf(xy[X]) + String.valueOf(xy[Y]);
    }
}
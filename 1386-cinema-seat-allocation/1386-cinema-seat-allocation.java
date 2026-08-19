
class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        

        for (int[] seat : reservedSeats) {
            map.putIfAbsent(seat[0], new HashSet<>());
            map.get(seat[0]).add(seat[1]);
        }
        
        int ans = (n - map.size()) * 2;
        
        for (Set<Integer> reserved : map.values()) {
            boolean left = !(reserved.contains(2) || reserved.contains(3) || reserved.contains(4) || reserved.contains(5));
            boolean right = !(reserved.contains(6) || reserved.contains(7) || reserved.contains(8) || reserved.contains(9));
            
            if (left && right) {
                ans += 2;
            } else if (left || right) {
                ans += 1;
            } else {
 
                boolean middle = !(reserved.contains(4) || reserved.contains(5) || reserved.contains(6) || reserved.contains(7));
                if (middle) ans += 1;
            }
        }
        
        return ans;
    }
}

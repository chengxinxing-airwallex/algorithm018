class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (String str : strs){
            char[] tmp = str.toCharArray();
            Arrays.sort(tmp);
            String strtmp = String.valueOf(tmp);
            if (!map.containsKey(strtmp))
                map.put(strtmp, new ArrayList<String>());
            map.get(strtmp).add(str);
        }
        return new ArrayList<>(map.values());
    }
}

/*
* 现有一个小写英文字母组成的字符串s和一个包含较短小写英文字符串的数组p，
* 请设计一个高效算法，对于p中的每一个较短字符串，判断其是否为s的子串。*/
public class Substr {
    public boolean[] chkSubStr(String[] p, int n, String s) {
        boolean[] res = new boolean[n];
        for (int i = 0; i < n; i++) {
            res[i] = s.contains(p[i]);
        }
        return res;
    }
}

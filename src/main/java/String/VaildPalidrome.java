package String;

/**
 * 680题：验证回文字符串
 * 贪心算法
 * 1.初始化两个指针i=0,j=s.length-1
 * 2.使用循环判断s[i],s[i+1],...,s[j]是否形成回文
 * 3.如果i>=j，结束循环
 * 4.如果s[i]=s[j]，继续比较i++,j--，否则回文必须是s[i+1],s{i+2],...,s[j]或者s[i],s[i+1],...s[j-1]这两种情况
 *
 * 时间复杂度为O(n)，空间复杂度为O(1)
 */
public class VaildPalidrome {

    public static void main(String[] args) {
        String s= "abbcda";
        VaildPalidrome vaildPalidrome = new VaildPalidrome();
        Boolean result = vaildPalidrome.validPalindrome( s );
        System.out.println(result);
    }

    /**
     * 判断是否是回文串
     * @param s 字符串
     * @param i 首字母
     * @param j 尾字母
     * @return
     */
    public boolean isPalindromeRange(String s,int i,int j){
        for (int k = i; k <=i+(j-i)/2; k++) {
            if (s.charAt( k ) != s.charAt( j - k + i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断删除一个元素后是否构成回文串
     * @param s
     * @return
     */
    public boolean validPalindrome(String s){
        int i=0,j=s.length()-1;
        while (i < j) {
            if (s.charAt( i ) != s.charAt( j )) {
                return (isPalindromeRange( s, i + 1, j ) || isPalindromeRange( s, i, j - 1 ));
            }
            i++;
            j--;
        }
        return true;
    }
}

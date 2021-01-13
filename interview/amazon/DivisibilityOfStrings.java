package interview.amazon;

public class DivisibilityOfStrings {
    public static void main (String[] args) throws java.lang.Exception
	{
		String s1 = "bcdbcdbcd", s2 = "bcdbcd";
		String s3 = "bcdbcdbcdbcd", s4 = "bcdbcd";
		String s5 = "aaaaaa", s6 = "a";
		String s7 = "wqzpuogsqcxpqizenbrhcbijieufuxgqpfijuobkqacjkdnzggijhqurwqyrnejckrnghqsyswhczwdicltjdndaebrtgcysulydcsbupkzogewkqpwtfzvjameircaloaqstsoiepynuvxmmthrsdcvrhdijgvzgmtzeijkzixtfxhrqpllspijwnsitnjazdwqzpuogsqcxpqizenbrhcbijieufuxgqpfijuobkqacjkdnzggijhqurwqyrnejckrnghqsyswhczwdicltjdndaebrtgcysulydcsbupkzogewkqpwtfzvjameircaloaqstsoiepynuvxmmthrsdcvrhdijgvzgmtzeijkzixtfxhrqpllspijwnsitnjazdwqzpuogsqcxpqizenbrhcbijieufuxgqpfijuobkqacjkdnzggijhqurwqyrnejckrnghqsyswhczwdicltjdndaebrtgcysulydcsbupkzogewkqpwtfzvjameircaloaqstsoiepynuvxmmthrsdcvrhdijgvzgmtzeijkzixtfxhrqpllspijwnsitnjazdwqzpuogsqcxpqizenbrhcbijieufuxgqpfijuobkqacjkdnzggijhqurwqyrnejckrnghqsyswhczwdicltjdndaebrtgcysulydcsbupkzogewkqpwtfzvjameircaloaqstsoiepynuvxmmthrsdcvrhdijgvzgmtzeijkzixtfxhrqpllspijwnsitnjazd";
		String s8 = "wqzpuogsqcxpqizenbrhcbijieufuxgqpfijuobkqacjkdnzggijhqurwqyrnejckrnghqsyswhczwdicltjdndaebrtgcysulydcsbupkzogewkqpwtfzvjameircaloaqstsoiepynuvxmmthrsdcvrhdijgvzgmtzeijkzixtfxhrqpllspijwnsitnjazdwqzpuogsqcxpqizenbrhcbijieufuxgqpfijuobkqacjkdnzggijhqurwqyrnejckrnghqsyswhczwdicltjdndaebrtgcysulydcsbupkzogewkqpwtfzvjameircaloaqstsoiepynuvxmmthrsdcvrhdijgvzgmtzeijkzixtfxhrqpllspijwnsitnjazd";
		System.out.println(divisibilityOfStrings(s1, s2));
		System.out.println(divisibilityOfStrings(s3, s4));
		System.out.println(divisibilityOfStrings(s5, s6));
		System.out.println(divisibilityOfStrings(s7, s8));
	}
	
	public static int divisibilityOfStrings(String s, String t) {
        if (s.length() % t.length() != 0) {
            return -1;
        }

        int l2 = t.length();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i % l2)) {
                return -1;
            }
        }

        for (int i = 0; i < t.length(); i++) {
            int j = 0;
            for (; j < t.length(); j++) {
                if (t.charAt(j) != t.charAt(j % (i + 1))) {
                    break;
                }
            }

            if (j == t.length()) {
                return i + 1;
            }
        }

        return -1;
    }
}



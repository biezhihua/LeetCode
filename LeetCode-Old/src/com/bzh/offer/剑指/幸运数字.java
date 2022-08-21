package com.bzh.offer.剑指;

/**
 * Created by biezhihua on 16-9-7.
 */
public class 幸运数字 {

    /**
     * 题目:
     * 我们把只包含4或7的数称为幸运数字.
     * 例如:4,7,44,47,74,77等等是幸运数字,而41,42不是幸运数字.
     * 求从小到大的顺序第M个幸运数字.而M的大小是,0<M<10^18次幂
     * <p>
     * 思路:
     * 先通过2^k -1 = (M+1) 得到处于二叉树的第几层,
     * 例如:M=7 , k = log2(7+1)+1 = 4
     * <p>
     * 然后再通过 M - (2^(k-1)-1)得到索引值.
     * 例如:
     * 7 - (2^(4-1)-1) =  7 - 7 = 0
     * 8 - (2^(3)-1) = 8-7 = 1
     * 9 - (2^3 - 1) = 9-7=2
     * <p>
     * 然后因为处在第4层,数是有规律的,只有三位数,最左侧是444,最右侧是777
     * 将索引转换为3位的二进制数,碰到一个碰到一个0就追加一个4,碰到一个1就追加一个7
     */

    public static void main(String[] args) {
        System.out.println(  printLuckNumber(7));
    }

    private static String printLuckNumber(int m) {

        // 求出m所在的深度
        int k = (int) Math.ceil(Math.log((double) (m + 1)) / Math.log((double) 2));
        // 求出m-1深度所有节点数
        int preCount = (int) (Math.pow(2, k - 1 + 1 ) - 1);
        // 计算索引
        int index = (m - preCount);

        // 追加0/1
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append((index & 0x1) == 1 ? '7' : '4');
            index >>>= 1;
        }
        return sb.reverse().toString();
    }
}

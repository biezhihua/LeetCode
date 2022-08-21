package com.bzh.leetcode.sort_search;

import org.junit.Assert;
import org.junit.Test;

public class FirstBadVersion {
    boolean isBadVersion(int version) {
        return version >= 2;
    }

    @Test
    public void tst() {
        Assert.assertEquals(2, firstBadVersion(100));
    }

    //https://www.zhihu.com/question/36132386
    public int firstBadVersion(int n) {

        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) right = mid-1;
            else left = mid+1;
        }
        return left;
    }

}

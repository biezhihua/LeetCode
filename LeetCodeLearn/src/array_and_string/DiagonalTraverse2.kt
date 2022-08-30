package array_and_string

/**
 * https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1167/
 */
class DiagonalTraverse2 {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(findDiagonalOrder(Array<IntArray>(3) { index ->
                when (index) {
                    0 -> intArrayOf(1, 2, 3)
                    1 -> intArrayOf(4, 5, 6)
                    2 -> intArrayOf(7, 8, 9)
                    else -> intArrayOf()
                }
            }).contentToString())

            println(findDiagonalOrder(Array<IntArray>(2) { index ->
                when (index) {
                    0 -> intArrayOf(1, 2)
                    1 -> intArrayOf(3, 4)
                    else -> intArrayOf()
                }
            }).contentToString())

            println(findDiagonalOrder(Array<IntArray>(2) { index ->
                when (index) {
                    0 -> intArrayOf(1, 2, 3)
                    1 -> intArrayOf(4, 5, 6)
                    else -> intArrayOf()
                }
            }).contentToString())

            println(findDiagonalOrder(Array<IntArray>(1) { index ->
                when (index) {
                    0 -> intArrayOf(1)
                    else -> intArrayOf()
                }
            }).contentToString())

            println(findDiagonalOrder(Array<IntArray>(1) { index ->
                when (index) {
                    0 -> intArrayOf(2, 3)
                    else -> intArrayOf()
                }
            }).contentToString())
        }

        // https://leetcode.com/problems/diagonal-traverse/solution/
        // https://leetcode.com/problems/diagonal-traverse/discuss/97711/Java-15-lines-without-using-boolean
        private fun findDiagonalOrder(matrix: Array<IntArray>): IntArray? {
            if (matrix.isEmpty()) return IntArray(0)
            var r = 0
            var c = 0
            val m = matrix.size
            val n = matrix[0].size
            val arr = IntArray(m * n)
            for (i in arr.indices) {
                arr[i] = matrix[r][c]

                // r+c determines which diagonal you are on.
                // For ex: [2,0],[1,1],[0,2] are all on same diagonal with r+c =2.
                // If you check the directions of diagonals, first diagonal is up, second diagonal is down third one is up and so on..
                // therefore (r+c)%2 simply determines direction.

                // 在多维数组中，对角线上的元素下标索引之和，可以按照奇数和偶数区分

                // The direction is always up when the sum of row & col is even
                if ((r + c) % 2 == 0) {

                    // 对于向上的对角线，会有三种情况
                    // 1. 碰到上边界，列数需要增加
                    // 2. 碰到右边界，行数需要增加
                    // 3. 在对角线内，行数减、列数加

                    // moving up

                    // For last column, go down
                    if (c == n - 1) {
                        r++
                    }
                    // For first row & non-last columns, go right
                    else if (r == 0) {
                        c++
                    }
                    // For not first row & non-last columns, go up and to the right
                    else {
                        r--
                        c++
                    }
                }
                // The direction is always down when the sum of row & col is odd
                else {
                    // moving down

                    // 对于向下的对角线，会有三种情况
                    // 1. 碰到下边界，列数需要增加
                    // 2. 碰到左边界，行数需要增加
                    // 3. 在对角线内，行数加、列数减


                    // For last row, go right
                    if (r == m - 1) {
                        c++
                    }
                    //  For non-last row & first column, go down
                    else if (c == 0) {
                        r++
                    }
                    // For non-last row & non-first column, go down and to the left
                    else {
                        r++
                        c--
                    }
                }
            }
            return arr
        }
    }
}
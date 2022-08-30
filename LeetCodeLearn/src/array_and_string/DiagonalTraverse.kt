package array_and_string

/**
 * https://leetcode.com/explore/learn/card/array-and-string/202/introduction-to-2d-array/1167/
 */
class DiagonalTraverse {
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
        private fun findDiagonalOrder(mat: Array<IntArray>): IntArray {

            // Check for empty matrices
            if (mat.isEmpty()) {
                return intArrayOf()
            }

            // Variables track the size of the matrix
            val rowSize = mat.size
            val columnSize = mat[0].size

            // The two arrays as explained in the algorithm
            val result = IntArray(rowSize * columnSize)
            var k = 0
            val intermediate = mutableListOf<Int>()

            // We have to go over all the elements in the first row and the last column to cover all possible diagonals
            for (d in 0 until rowSize + columnSize - 1) {

                // Clear the intermediate array every time when we start to process another diagonal
                intermediate.clear()

                // We need to figure out the 'head' of this diagonal
                // The elements in the first row and the last column are the respective heads.
                var rowIndex = if (d < columnSize) 0 else d - columnSize + 1
                var columnIndex = if (d < columnSize) d else columnSize - 1

                while (rowIndex < rowSize && columnIndex > -1) {
                    intermediate.add(mat[rowIndex][columnIndex])
                    rowIndex++
                    columnIndex--
                }

                // Reverse even numbered diagonals.
                // The article says that we have to reverse odd numbered articles but her, the numbering is tarting from 0
                if (d % 2 == 0) {
                    intermediate.reverse()
                }

                for (i in intermediate) {
                    result[k++] = i
                }
            }

            return result
        }
    }
}
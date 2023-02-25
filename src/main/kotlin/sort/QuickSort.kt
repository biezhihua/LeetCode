package sort

object QuickSort {

    fun quickSort(array: IntArray, p: Int, r: Int) {
        if (p < r) {
            val q = partition(array, p, r)
            quickSort(array, p, q - 1)
            quickSort(array, q + 1, r)
        }
    }

    private fun partition(array: IntArray, p: Int, r: Int): Int {

        // 选取主元
        val x = array[r]

        // 数组左边的索引
        var i = p - 1

        // 遍历数组
        for (j in p until r) {

            // 如果当前元素小于主元，则交换
            if (array[j] < x) {
                i++
                swap(array, i, j)
            }
        }
        swap(array, i + 1, r)
        return i + 1
    }

    private fun swap(array: IntArray, i: Int, j: Int) {
        val tmp = array[i]
        array[i] = array[j]
        array[j] = tmp
    }
}
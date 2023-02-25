package sort

object MergeSort {

    fun mergeSort(array: IntArray, p: Int, r: Int) {
        // 归并排序
        if (p < r) {
            // 分解
            val q = (p + r) / 2

            // 解决
            mergeSort(array, p, q)
            mergeSort(array, q + 1, r)

            // 合并
            merge(array, p, q, r)
        }
    }

    private fun merge(array: IntArray, p: Int, q: Int, r: Int) {

        // 创建两个临时数组，用于存储待排序的元素
        val n1 = q - p + 1
        val n2 = r - q

        val left = IntArray(n1 + 1)
        val right = IntArray(n2 + 1)

        // 存储临时待排序数组
        for (i in 0 until n1) {
            left[i] = array[i]
        }

        for (i in 0 until n2) {
            right[i] = array[q + 1 + i]
        }

        // 使用哨兵，减少判断条件
        left[n1] = Int.MAX_VALUE
        right[n2] = Int.MAX_VALUE

        // 排序两个数组到原数组中
        var i = 0
        var j = 0
        for (k in p..r) {

            // 如果碰见哨兵，会将另一个数组的剩余元素复制完
            if (left[i] <= right[j]) {
                array[k] = left[i]
                i++
            } else {
                array[k] = right[j]
                j++
            }
        }
    }
}
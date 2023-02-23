package sort

object InsertionSort {

    fun insertionSort(array: IntArray) {

        // 如果只有一个元素，认为已经排序好，不需要再排序了
        if (array.size <= 1) {
            return
        }

        // 从第二个元素开始，第一个元素可以认为已经排序好了
        // 要执行n-1次
        for (i in 1 until array.size) {

            // key作为待排序元素，需要找到合适的位置插入
            val key = array[i]

            // 从已经排序好的元素倒序遍历，寻找可插入的位置。如果大于待排序元素，则后移，空出j这个位置
            var j = i - 1

            // 逐个对比i-1 .. 0区间的元素，如果元素大于待排序元素，则后移
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j]
                j--
            }

            // 将待排序字段放入到合适的位置
            array[j + 1] = key
        }
    }
}
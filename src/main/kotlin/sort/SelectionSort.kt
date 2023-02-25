package sort

object SelectionSort {

    fun selectionSort(array: IntArray) {

        // 基本思路：每次从未排序的部分选出最小的元素，放在已排序的末尾，重复该操作直到所有元素都排序好。

        // 对于n个元素的数组，需要排序n-1次才能让数组有序
        for (i in 0 until array.size - 1) {

            // 选取默认最小值索引
            var minIndex = i

            // 找到最小的索引
            for (j in i + 1 until array.size) {
                if (array[j] < array[minIndex]) {
                    minIndex = j
                }
            }

            // 交换
            if (minIndex != i) {
                val temp = array[i]
                array[i] = array[minIndex]
                array[minIndex] = temp
            }
        }
    }

}
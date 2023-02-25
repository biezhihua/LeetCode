package sort

object HeapSort {

    fun heapSort(array: IntArray) {
        // 堆排序的基本思想：
        // 首先构造一个最大堆，然后将堆顶元素和序列尾部元素进行交换，此时最大元素已经被放在了序列尾部。
        // 然后，接着将剩余的元素再构造一个大顶堆
        // 重复上述操作，直到元素都被排序

        buildMaxHeap(array)

        for (i in array.size - 1 downTo 1) {
            swap(array, 0, i)
            maxHeapify(array, 0, i)
        }
    }

    private fun maxHeapify(array: IntArray, i: Int, headSize: Int) {
        val left = 2 * i + 1
        val right = 2 * i + 2
        var largest = i

        if (left < headSize && array[left] > array[largest]) {
            largest = left
        }

        if (right < headSize && array[right] > array[largest]) {
            largest = right
        }

        if (largest != i) {
            // 调换大元素
            swap(array, i, largest)
            // 逐级下降
            maxHeapify(array, largest, headSize)
        }
    }

    private fun swap(array: IntArray, i: Int, j: Int) {
        val tmp = array[i]
        array[i] = array[j]
        array[j] = tmp
    }

    private fun buildMaxHeap(array: IntArray) {
        for (i in array.size / 2 - 1 downTo 0) {
            maxHeapify(array, i, array.size)
        }
    }

}
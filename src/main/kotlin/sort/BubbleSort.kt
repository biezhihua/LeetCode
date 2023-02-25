package sort

object BubbleSort {

    fun bubbleSort(array: IntArray) {
        // 基本思想：通过不断交换相邻的元素，将最大的元素逐渐冒泡到最后面。
        // 算法需要执行n-1次，为何是n-1次？因为每次比较两个相邻的元素
        // 每次循环，都需要将一个元素冒泡到已排序的元素的位置前

        // 需要执行n-1次，才能排序完
        for (i in 0 until array.size - 1) {

            // 每次循环，都要将一个元素冒泡到最后已排序前的位置
            for (j in 0 until array.size - 1 - i) {

                // 比较元素，如果需要则冒泡
                if (array[j] > array[j + 1]) {
                    val tmp = array[j]
                    array[j] = array[j + 1]
                    array[j + 1] = tmp
                }
            }
        }
    }
}
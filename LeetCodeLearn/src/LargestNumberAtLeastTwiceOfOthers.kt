/**
 * https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1147/
 */
class LargestNumberAtLeastTwiceOfOthers {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val target = intArrayOf(1, 7, 3, 6, 5, 6)
            val index = dominantIndex(target)
            println(index)
        }

        private fun dominantIndex(nums: IntArray): Int {

            if (nums.size < 2) {
                return -1
            }

            // 1. 找到最大元素

            var largestNumberIndex = 0
            var largestNumber = nums[0]
            nums.forEachIndexed { index, value ->
                if (value > largestNumber) {
                    largestNumber = value
                    largestNumberIndex = index
                    return@forEachIndexed
                }
            }

            // 2. 对比其他元素

            nums.forEachIndexed { index, value ->
                if (index != largestNumberIndex && largestNumber < value * 2) {
                    return -1
                }
            }

            return largestNumberIndex
        }
    }
}
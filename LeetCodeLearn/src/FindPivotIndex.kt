class FindPivotIndex {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val target = intArrayOf(1, 7, 3, 6, 5, 6)
            println(pivotIndex(target))
        }

        private fun pivotIndex(nums: IntArray): Int {
            var leftIndexSum = 0
            var rightIndexSum = 0
            var lastIndexValue = 0

            nums.forEach {
                rightIndexSum += it
            }

            nums.forEachIndexed { index, value ->

                leftIndexSum += lastIndexValue
                rightIndexSum -= value
                lastIndexValue = value

                if (leftIndexSum == rightIndexSum) {
                    return index
                }
            }

            return -1
        }
    }
}
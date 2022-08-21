package array_and_string

/**
 * https://leetcode.com/explore/learn/card/array-and-string/201/introduction-to-array/1148/
 */
class PlusOne {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val digits = intArrayOf(1, 2, 3)
            println(plusOne(digits).contentToString())
        }

        private fun plusOne(digits: IntArray): IntArray {
            val digitsLength = digits.size
            var isNeedCarryBit = false

            for (digitIndex in (digitsLength - 1) downTo 0) {

                val digit = digits[digitIndex]

                // 不处理不用进位的情况 和 处理进位的情况
                if (digitIndex == digitsLength - 1 || isNeedCarryBit) {
                    isNeedCarryBit = false
                    if (digit < 9) {
                        digits[digitIndex] = digits[digitIndex] + 1
                        return digits
                    } else {
                        isNeedCarryBit = true
                        digits[digitIndex] = 0
                    }
                } else {
                    return digits
                }
            }

            // 处理超出状态
            if (isNeedCarryBit) {
                isNeedCarryBit = false
                val newDigitsArray = IntArray(digitsLength + 1)
                newDigitsArray[0] = 1
                digits.forEachIndexed { index, value ->
                    newDigitsArray[index + 1] = value
                }
                return newDigitsArray
            }
            return digits
        }
    }
}
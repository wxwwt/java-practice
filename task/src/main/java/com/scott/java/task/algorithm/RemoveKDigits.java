package com.scott.java.task.algorithm;

/**
 * @author scott
 * @time 2018-12-12 13:12:23
 */
public class RemoveKDigits {

    /**
     * first method
     * @param num
     * @param k
     * @return
     */
    public static String removeKDigits(String num, int k) {
        int newLength = num.length() - k;
        if (num.length() == k) {
            return "0";
        }
        char[] textArray = num.toCharArray();
        char[] newString = new char[textArray.length];
        int top = 0;
        for (int i = 0; i < textArray.length; i++) {
            while (top > 0 && newString[top - 1] > textArray[i] && k > 0) {
                newString[top - 1] = textArray[i];
                k--;
                top--;
            }
            newString[top] = textArray[i];
            top++;

        }
        int zeroIndex = 0;
        for (int i = 0; i < newString.length; i++) {
            if (newString[i] == '0') {
                zeroIndex++;
            } else {
                break;
            }
        }
        return newLength <= zeroIndex ? "0" : new String(newString, zeroIndex, newLength - zeroIndex);
    }


    /**
     * second method
     * @param num
     * @param k
     * @return
     */
    public static String removeKDigits2(String num, int k) {
        //新整数的最终长度 = 原整数长度 - k
        int newLength = num.length() - k;
        //创建一个栈，用于接收所有的数字
        char[] stack = new char[num.length()];
        int top = 0;
        for (int i = 0; i < num.length(); ++i) {
            //遍历当前数字
            char c = num.charAt(i);
            //当栈顶数字大于遍历到的当前数字，栈顶数字出栈（相当于删除数字）
            while (top > 0 && stack[top - 1] > c && k > 0) {
                top -= 1;
                k -= 1;
            }
            //遍历到的当前数字入栈
            stack[top++] = c;
        }
        // 找到栈中第一个非零数字的位置，以此构建新的整数字符串
        int offset = 0;
        while (offset < newLength && stack[offset] == '0') {
            offset++;
        }
        return offset == newLength ? "0" : new String(stack, offset, newLength - offset);
    }

    public static void main(String[] args) {
        System.out.println(removeKDigits("112", 1));
        System.out.println(removeKDigits("30200", 1));
        System.out.println(removeKDigits("10", 1));
        System.out.println(removeKDigits("1432219", 3));
        System.out.println(removeKDigits("1234567890", 9));

    }
}

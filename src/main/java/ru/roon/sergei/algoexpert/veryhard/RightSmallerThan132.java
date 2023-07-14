package ru.roon.sergei.algoexpert.veryhard;

public class RightSmallerThan132 {

    public int[] rightSmallerThan(int[] array) {
        if (array.length == 0) {
            return new int[0];
        }

        int[] rightSmallerCounts = new int[array.length];
        int lastIdx = array.length - 1;
        SpecialBST bst = new SpecialBST(array[lastIdx]);
        rightSmallerCounts[lastIdx] = 0;
        for (int i = array.length - 2; i >= 0; i-- ) {
            bst.insert(array[i], i, rightSmallerCounts, 0);
        }
        return rightSmallerCounts;
    }

    public static class SpecialBST {
        private final int value;
        private int leftSubtreeSize;
        private SpecialBST left;
        private SpecialBST right;
        public SpecialBST(int value) {
            this.value = value;
            this.leftSubtreeSize = 0;
            this.left = null;
            this.right = null;
        }

        public void insert(int value, int idx, int[] rightSmallerCounts, int numSmallerAtInsertTime) {
            if (value < this.value) {
                this.leftSubtreeSize += 1;
                if (this.left == null) {
                    this.left = new SpecialBST(value);
                    rightSmallerCounts[idx] = numSmallerAtInsertTime;
                } else {
                    this.left.insert(value, idx, rightSmallerCounts, numSmallerAtInsertTime);
                }
            } else {
                numSmallerAtInsertTime += this.leftSubtreeSize;
                if (value > this.value) {
                    numSmallerAtInsertTime += 1;
                }
                if (this.right == null) {
                    this.right = new SpecialBST(value);
                    rightSmallerCounts[idx] = numSmallerAtInsertTime;
                } else {
                    this.right.insert(value, idx, rightSmallerCounts, numSmallerAtInsertTime);
                }
            }
        }
    }
}

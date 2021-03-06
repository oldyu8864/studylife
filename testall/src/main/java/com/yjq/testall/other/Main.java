package com.yjq.testall.other;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Base64;

public class Main {

    public static void main(String[] args) throws IOException {
        String filePath = "E:\\tmp\\test.png";
        File file = new File(filePath);
        byte[] bytes = Files.readAllBytes(file.toPath());
        System.out.println(Arrays.toString(bytes));


    }

    public static void main5(String[] args) {
        String  str = "于峻权";
        byte[] sb = str.getBytes();
        System.out.println(Arrays.toString(sb));
        String  str2 = "于峻权";
        byte[] decode = Base64.getDecoder().decode(str2);
        System.out.println(Arrays.toString(decode));
        byte b = 1;
        byte b2 = 127;
        System.out.println(b2);
    }

    public static void main4(String[] args) throws Exception{
        Process start = new ProcessBuilder().start();
    }
    public static void main3(String[] args) {
        long t1 = System.nanoTime();
        while (true){
            long t2 = System.nanoTime();
            System.out.println((t2-t1)+"ns");
            t1 = t2;

        }
    }

    public static void main2(String[] args) {
        long l = 0L;
        System.out.println(l%2);
        System.out.println(l%288);
        System.out.println(l%100==0);
        System.out.println(l%288==0);
    }

    public static void main1(String[] args) {
        int krr[] = {1, 3, 4, 2, 7, 8, 9, 10, 14, 16};
        int arr[] = minK(krr, 4);
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);

    }


    public static int[] minK(int krr[], int k) {
        int arr[] = new int[k];
        for (int i = 0; i < k; i++)
            arr[i] = krr[i];
        buildHeap(arr);
        for (int j = k; j < krr.length; j++) {
            if (krr[j] < arr[0]) {
                arr[0] = krr[j];
                maxHeap(arr, 1, k);
            }
        }
        return arr;
    }

    /**
     * 建最大堆
     */
    public static void buildHeap(int arr[]) {
        int heapsize = arr.length;
        for (int i = arr.length / 2; i > 0; i--)
            maxHeap(arr, i, heapsize);
    }

    /**
     * 调整为最大堆
     */
    public static void maxHeap(int arr[], int i, int heapsize) {
        int largest = i;
        int left = 2 * i;
        int right = 2 * i + 1;
        if (left <= heapsize && arr[i - 1] < arr[left - 1])
            largest = left;
        if (right <= heapsize && arr[largest - 1] < arr[right - 1])
            largest = right;
        if (largest != i) {
            int temp = arr[i - 1];
            arr[i - 1] = arr[largest - 1];
            arr[largest - 1] = temp;
            maxHeap(arr, largest, heapsize);
        }
    }
}

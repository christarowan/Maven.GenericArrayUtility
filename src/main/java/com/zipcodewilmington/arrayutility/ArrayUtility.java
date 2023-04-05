package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by leon on 3/6/18.
 */

public class ArrayUtility <T> {

    private T[] array;
    public ArrayUtility(T[] array) {
        this.array = array;
    }

    public int countDuplicatesInMerge(T[]arrayToMerge, T valueToEvaluate) {


            int count = 0;
           for (T item : arrayToMerge) {
                if (item.equals(valueToEvaluate)) {
                    count++;
               }
            }
            for (T item : array) {
                if (item.equals(valueToEvaluate)) {
                    count++;
                }
            }
            return count;
        }


   public int getNumberOfOccurrences (T valueToEvaluate) {

       int count = 0;
       for (T item : array) {
           if (item.equals(valueToEvaluate)) {
               count++;
           }
       }
        return count;
    }
    public T getMostCommonFromMerge(T[] arrayToMerge) {
        int maxCount = 0;
        T maxItem = null;
        int count = 0;
        for (T e : array) {
            count = countDuplicatesInMerge(arrayToMerge,e);
            if (count > maxCount) {
                maxItem = e;
            }
        }
        return maxItem;

    }

    public T[] removeValue(T valueToRemove) {
        int numberToRemove = getNumberOfOccurrences(valueToRemove);
        int size = array.length - numberToRemove;
        Class<T> cl = (Class<T>) array[0].getClass();
        T[] result = (T[]) Array.newInstance(cl,size);
        int j = 0;
        for (int i=0; i<array.length; i++) {
            if (!array[i].equals(valueToRemove)) {
                result[j] = array[i];
                j++;
            }
        }
        return result;

    }
}

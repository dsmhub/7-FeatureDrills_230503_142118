import java.lang.reflect.Array;
import java.util.Arrays;

//look up generics

public class jt5 {

    /** arrays */

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        char[] arr2 = {'a', 'b', 'c', 'd'};
        String[] arr3= {"ab", "bc", "cd", "da"};
        Object[] arr4 = {1, 'b', "cd", "da"};
        int[] arr5 = new int[4];
        Object[][] arr6 = {{1,2,3},{"Mon", "Tue", "Wed"}};
        Object[][][] arrG = { {{1,2,3}, {'a','b',6}}, {{"Mon", "Tue", "Wed"}} };
        Object[][] arr7 = new Object[3][3];

        arr5[0] = 5;
        arr5[1] = 6;

        System.out.println(arr6.getClass().isArray());
        System.out.println(Array.getLength(arr6));

        for (int i=0;i<arr6.length;i++){
            System.out.println(arr6[i].length);
            System.out.println(arr6[0][i] +" "+ arr6[1][i]);
        }

        for(int itm: arr5){
            System.out.println(itm);
        }

        int dimensions = getDim(arrG);
        //printTable(arr6);

        /** creating copies */
        int[]arr1Cpy1 = arr1; //ref
        int[] arr1Cpy2 = new int[arr1.length]; //deep copy
        for(int i=0;i<arr1.length;i++){
            arr1Cpy2[i] = arr1[i]; //deep copy
        }
        int[] arr1Cpy3 = new int[arr1.length];
        System.arraycopy(arr1, 0, arr1Cpy3, 0, arr1.length); //deep copy ??
        int[] arr1Cpy4 = Arrays.copyOfRange(arr1, 0, arr1.length); //deep copy

        Object[][] arr6Cpy1 = new Object[arr6.length][];
        System.arraycopy(arr6,0,arr6Cpy1,0,arr6.length); //ref ??

        System.out.println("arr1: "+arr1[0]);
        System.out.println("arr1Cpy1: "+arr1Cpy1[0]);
        System.out.println("arr1Cpy2: "+arr1Cpy2[0]);
        System.out.println("arr1Cpy3: "+arr1Cpy3[0]);
        System.out.println("arr1Cpy4: "+arr1Cpy4[0]);
        System.out.println("arr6: "+arr6[1][2]);
        System.out.println("arr6Cpy1: "+arr6Cpy1[1][2]);



        arr1[0] = 10;
        arr6[1][2] = "Wednesday";

        System.out.println("");

        System.out.println("arr1: "+arr1[0]);
        System.out.println("arr1Cpy1: "+arr1Cpy1[0]);
        System.out.println("arr1Cpy2: "+arr1Cpy2[0]);
        System.out.println("arr1Cpy3: "+arr1Cpy3[0]);
        System.out.println("arr1Cpy4: "+arr1Cpy4[0]);
        System.out.println("arr6: "+arr6[1][2]);
        System.out.println("arr6Cpy1: "+arr6Cpy1[1][2]);

        System.out.println("");
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.deepToString(arr6));

    }


    public static int getDim(Object[] arr){
        int baseDepth = 1;
        int maxDepth = 0; //max rows

        for(int i=0;i<arr.length;i++){

            if(arr[i].getClass().isArray()){
                int elementDepth = getDim((Object[]) arr[i]);
                if(elementDepth>maxDepth) {maxDepth = elementDepth;}
            }
        }
        return baseDepth + maxDepth;
    }







    public static void printTable(Object[] arr){
        int i=0;
        int maxRows=1;

        do{
            for(int j=0; j<arr.length; j++){
                if (arr[j].getClass().isArray()) {
                    int l = Array.getLength(arr[j]);
                    Object[] itm =new Object[l];
                    int arrLength = Array.getLength(itm);
                    System.out.println(itm[0]);
                    if(maxRows<arrLength){maxRows=arrLength;}
                }else {
                    System.out.println(arr[j]);
                }
            }
            i++;
        }
        while(i<maxRows);
    }





}
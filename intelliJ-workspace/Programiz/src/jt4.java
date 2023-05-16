public class jt4 {

    /** loops */

    public static void main(String[] args) {
        String word = "abcd";
        int[] arr1 = {1, 2, 3, 4};
        char[] arr2 = {'a', 'b', 'c', 'd'};
        String[] arr3= {"ab", "bc", "cd", "da"};
        Object[] arr4 = {1, 'b', "cd", "da"};

        int account = 0;


        for (int i = 0; i < arr1.length; i++) {
            //System.out.println(arr1[i]);
        }

        //for each
        for (Object itm : arr2) {
            //System.out.println(itm);
        }

        int k =0;

        while(k<arr1.length){
            //System.out.println("account balance: "+account);
            account += arr1[k];
            k++;
        }

        account=0; k=0;

        do{
            //System.out.println("account balance: "+account);
            account += arr1[k];
            k++;
        } while(k<arr1.length);

        /**break & continue statements*/
        /** break statement - terminate loop */
        /** continue statement - skips current iteration of loop */
        label1:
        for(int x=1; x<=3; x++){
            System.out.println("");
            System.out.println("x: " + x);

            label2:
            for(int y=1; y<=5; y++){
                System.out.println("y: " + y);
                if(x==2){
                    //break label1;
                    continue label1;
                }
            }
        }


    }

}

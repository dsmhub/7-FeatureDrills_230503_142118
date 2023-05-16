public class jt1 {

    /** types */

    public static void main(String[] args) {

        /**primitive types
         * byte, short, int, long, float, double, boolean, char
         * */
        int n1 = 0b0; //0b = binary number
        int n2 = 0x0; //0x = hexadecimal number
        int n3 = 01; //0.. = octal number

        /** type conversion*/

        /**String to int*/
        int n4 = Integer.parseInt("42");

        /**char to Unicode, Unicode to char*/
        int n5 = (int)'A';
        char c1 = (char)65;

        /**char to String*/
        String s1 = "" + 'a' + 'b';
        String s2 = new StringBuilder().append('a').append('b').toString();


        /**literals
         * when decimal is present default type is double unless stated otherwise
         * 3.14f or 3.14F is a float, 3.14d or 3.14D is a double, 314l or 314L is a long
         * */

        /**Constants*/
        final double PI = 3.14159; //must be initialized when declared

        /**reference types*/
        //a collection of primitives
        int[] arr1 = new int[10];
        int arr2[] = new int[16];
        int testarr[] = new int[3];

        testarr[1] = 1;
        System.out.println(testarr);

    }

}

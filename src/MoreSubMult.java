import java.util.Arrays;

public class MoreSubMult {

    static int multiplication (int[] values){
        int product= 1;

        for (int i=0; i< values.length; i++){
            product *= values[i];
        }
        return product;
    }

    static int sub (int[] values){
        int result= values[0];
        for (int i=1; i< values.length; i++){
            result -= values[i];
        }
        return result;
    }
//    static float sum (int[] values){
//        int sum= 0;
//
//        for (int i=0; i< values.length; i++){
//            sum += values[i];
//        }
//        return sum;
//    }

//    static int division (int[] values){
//        int product= values[0];
//
//        for (int i=1; i< values.length; i++){
//            product /= values[i];
//        }
//        return product;
//    }
}

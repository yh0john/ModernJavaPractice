import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class LambdaEx6 {
    public static void main(String args[]){
        //기본형 함수형 인터페이스 사용 실습
        //직접 실무에 적용해 볼 만한 일이 있을지는 잘 모르겠다.
        IntSupplier s = ()->(int)((Math.random()*100)+1);
        IntConsumer c = i->System .out.println(i+", ");
        IntPredicate p = i->i%2==0;
        IntUnaryOperator op = i->i%10*10;   //i의 일의 자리를 없앤다.

        int[] arr = new int[10];
        makeRandomListEx6(s,arr);
        System.out.println(Arrays.toString(arr));
        printEvenNumEx6(p,c,arr);
        System.out.println(Arrays.toString(arr));
        int[] newArr = doSomethingEx6(op,arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void makeRandomListEx6(IntSupplier s,int[] arr){
        for(int i=0;i<10;i++){
            arr[i] = s.getAsInt();
        }
    }
    public static void printEvenNumEx6(IntPredicate p,IntConsumer c,int[] arr){
        System.out.print("[");
        for(int i:arr){
            if(p.test(i)){
                c.accept(i);
            }
        }
        System.out.println("]");
    }

    public static int[] doSomethingEx6(IntUnaryOperator op,int[] arr){
       int[] newArr = new int[arr.length];

       for(int i=0;i<newArr.length;i++){
           newArr[i] = op.applyAsInt(arr[i]);
       }
       return newArr;
    }



}

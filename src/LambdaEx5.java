//Java의 정석 Lambda실습!

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaEx5 {
    public  static  void main(String args[]){
        Supplier<Integer> s = ()->(int)((Math.random()*100)+1);
        Consumer<Integer> c = i->System .out.println(i+", ");
        Predicate<Integer> p = i->i%2==0;
        Function<Integer,Integer> f = i->i%10*10;   //i의 일의 자리를 없앤다.

        List<Integer> list = new ArrayList<>();
        makeRandomList(s,list);
        System.out.println(list);
        printEvenNum(p,c,list);
        System.out.println(list);
        List<Integer> newList = doSomething(f,list);
        System.out.println(list);
    }

    public static<T> void makeRandomList(Supplier<T> s,List<T> list){
        for(int i=0;i<10;i++){
            list.add(s.get());
        }
    }

    public static<T> void printEvenNum(Predicate<T> p,Consumer<T> c,List<T> list){
        System.out.print("[");
        for(T i:list){
            if(p.test(i)){
                c.accept(i);
            }
        }
        System.out.println("]");
    }
    public static<T> List<T> doSomething(Function<T,T> f,List<T> list){
        List<T> newList = new ArrayList<>();
        for(T t:list){
            newList.add(f.apply(t));
        }
        return newList;
    }
}

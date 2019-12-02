@FunctionalInterface
interface MyFunction2{
    void myMethod();
}
public class LambdaEx2 {
    public  static void main(String args[]){
        MyFunction2 f  = ()->{};
    }
}

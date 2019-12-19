import java.util.Arrays;
import java.util.stream.Stream;

public class StreamEx4 {
    public static void main(String[] args) {
        Stream<String[]> strArrstrm = Stream.of(new String[]{"abc","def","ghi"},new String[]{"ABC","DEF","HIG"});

        //이렇게 사용 할 경우 스트림의 스트림이 생성됨
        //Stream<Stream<String>> strStrmStrm = strArrstrm.map(Arrays::stream);
        Stream<String> strStrm = strArrstrm.flatMap(Arrays::stream);

        strStrm.map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);
        System.out.println();

        
    }
}

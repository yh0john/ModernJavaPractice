import java.io.File;
import java.util.stream.Stream;

public class StreamEx2 {
    public static void main(String args[]){
        File[] fileArr ={new File("Ex1.java"),
                new File("Ex1.bak"),
                new File("Ex2.java"),
                new File("Ex1"),
                new File("Ex1.txt"),};

        Stream<File> fileStream = Stream.of(fileArr);
        //map()으로 Stream<File>을 Stream<String>으로 변환
        Stream<String> filenameStream = fileStream.map(f->f.getName());
        filenameStream.forEach(System.out::println);

        //fileStream 재생성
        fileStream = Stream.of(fileArr);

        fileStream.map(f->f.getName())
                .filter(s->s.indexOf('.')!=-1) //확장자가 없는 것 제외
                .map(s->s.substring(s.indexOf('.')+1))  //확장자만 추출
                .map(String::toUpperCase)   //모두 대문자로 변환
                .distinct() //중복제거
                .forEach(System.out::print); //출력

    }
}

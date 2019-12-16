import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx3 {
    public static void main(String args[]){
        StudentEx3[] stuArr = {
                new StudentEx3("이자바",3,300),
                new StudentEx3("김자바",1,200),
                new StudentEx3("박자바",2,100),
                new StudentEx3("최자바",2,150),
                new StudentEx3("이자바",1,200),
                new StudentEx3("이자바",3,180)
        };
        Stream<StudentEx3> stuStream = Stream.of(stuArr);
        stuStream.sorted(Comparator.comparing(StudentEx3::getBan).thenComparing(Comparator.naturalOrder())).forEach(System.out::println);

        //Stream 재생성
        stuStream = Stream.of(stuArr);
        IntStream stuScoreStream = stuStream.mapToInt(StudentEx3::getTotalScore);

        IntSummaryStatistics stat = stuScoreStream.summaryStatistics();

        //결과값 찍어보기
        System.out.println("count="+stat.getCount());
        System.out.println("sum="+stat.getSum());
        System.out.println("average="+stat.getAverage());
        System.out.println("min="+stat.getMin());
        System.out.println("max="+stat.getMax());



    }
}

class StudentEx3 implements Comparable<StudentEx3>{
    String name;
    int ban;
    int totalScore;

    public StudentEx3(String name,int ban,int totalScore){
        this.totalScore = totalScore;
        this.name = name;
        this.ban = ban;
    }

    public String toString(){
        return String.format("%s %d %d",name,ban,totalScore).toString();
    }

    public String getName(){return name;}
    public int getBan(){return ban; }
    public int getTotalScore(){return totalScore;}


    @Override
    public int compareTo(StudentEx3 student) {
        //내림차순을 기본정렬로 한다.
        return student.totalScore - this.totalScore;
    }
}

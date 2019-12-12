import java.util.Comparator;
import java.util.stream.Stream;

public class StreamEx1 {
    public static void main(String args[]){
        Stream<Student> studentStream = Stream.of(new Student("Lee",3,300),
                new Student("Lee",1,200),
                new Student("Park",2,100),
                new Student("Ahn",2,150),
                new Student("Choi",1,200),
                new Student("So",3,290),
                new Student("Na",3,180));

        studentStream.sorted(Comparator.comparing(Student::getBan).thenComparing(Comparator.naturalOrder())).forEach(System.out::println);
    }
}

class Student implements Comparable<Student>{
    String name;
    int ban;
    int totalScore;

    public Student(String name,int ban,int totalScore){
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
    public int compareTo(Student student) {
        //내림차순을 기본정렬로 한다.
        return student.totalScore - this.totalScore;
    }
}

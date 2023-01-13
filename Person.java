package 상속실습예제;
// 인간(Person)이라는 클래스 생성
// -age : 나이 특성을 가짐(정수 값 사용, 게터/세터) - 몇살?
// -sleep : 잠자는 특성 (정수 값 사용, 게터/세터) - 몇시간 잠자는지?
// 인간으로 부터 직장인을 생성
// -work : 몇시간 일하는지? (정수, 게터/세터)
// 인간으로부터 학생을 생성
// - study : 공부하는 특성 (1로 입력 "열심히", 2 "적당히", 3 "놀면서"

import java.util.Scanner;

public class Person {
    protected int age;
    protected int sleep;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSleep(int sleep) {
        this.sleep = sleep;
        return sleep;
    }

    public void setSleep(int sleep) {
        this.sleep = sleep;
    }

    }

class Worker extends Person {
    int work;

    public int getWork() {
        return work;
    }

    public void setWork(int work) {
        this.work = work;
    }
}

class Student extends Person{
    int study;

    public int getStudy() {
        String[] studyStr = {"", "du"};

        return study;
    }

    public void setStudy(int study) {
        this.study = study;
    }







}






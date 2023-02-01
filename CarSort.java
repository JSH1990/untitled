package 클래스정렬예제1;
// 자동차 연식으로 정렬하기
public class CarSort implements Comparable<CarSort>{
    public CarSort(String modelName, int modelYear, String color) {
        this.modelName = modelName;
        this.modelYear = modelYear;
        this.color = color;
    }

    String modelName;
    int modelYear;
    String color;



    @Override
    public int compareTo(CarSort o) {
        if (this.modelYear == o.modelYear){
            return this.modelName.compareTo(o.modelName); //중복되어 값이 안나올때, 나오게 하는 조건문
        } //뒤에가 짧으면 양수 (매개 변수로 들어오는 객체와 비교해서 반환한다. 아스키코드로 비교한다 equal은 글자와 비교 한다)
        return this.modelYear - o.modelYear; //앞이 뒤보다 크면 정렬(오름 차순 정렬)
    }
}

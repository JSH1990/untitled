package generic.test.ex6;

/*
컴파일이 모두 끝나면 자바는 제네릭과 관련된 정보를 삭제한다. 이때 .class에 생성된 정보는 다음과 같다.

자바의 제네릭은 단순하게 생각하면 개발자가 직접 캐스팅하는 코드를 컴파일러가 대신 처리해주는것이다.
자바는 컴파일 시점에 제네릭을 사용한 코드에 문제가 없는지 완벽하게 검증하기 때문에 자바 컴파일러가 추가하는 다운캐스팅에는 문제가 발생하지않는다.

자바의 제네릭 타입은 컴파일 시점에만 존재하고, 런타임 시에는 제네릭 정보가 지워지는데 , 이것을 타입 이레이저라고 한다.
 */

public class GenericBox<T> {
    private T value;

    public void set(T value){
        this.value = value;
    }

    public T get(){
        return value;
    }
}

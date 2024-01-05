package com.lannstark.lec01

fun main(){
    // 코틀린에서 변수를 다루는 방법
    var number1 = 10L // 가변 Variable 타입추론 근데 이건 이제 자바도 지원해줌
    number1 = 5L;

    val number2 = 10L // 불변 value
    //number2 = 5L 오류 발생

    var number3: Long = 6L//타입지정

    // 초기값 지정 x 타입을 지정해줘야 함. 하지만 초기화 하지 않는다면 사용불가 var,val둘다.
    //var number4; 에러 발생
    //println(number4); //에러발생
    var number4:Long;
    //println(number4); 에러 발생

    //자바의 경우 ArrayList final로 선언해도 추가는 가능 코틀린도 마찬가지

    //자바의 경우 long과 Long구분되어 있지만 코틀린은 그런 구분 없음
    //코틀린이 상황에 따라 박신 언박싱 알아서 처리

    // null이 들어갈 수 있는을 다르게 표현
    var number5 = 100L;
    //number5 = null; 에러
    //null을 넣으려면 타입?를 붙여줘야함 var number5: Long? = 100L;

    var person = Person("정기석"); // 코틀린은 new 필요없음

    //작성한 코틀린 코드를 자바로 바꿔서 볼 수 있음 tools showbytecode decompile시 자바코드로 보여줌

}
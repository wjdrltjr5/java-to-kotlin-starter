package com.lannstark.lec16

/**
 * 코틀린에서 다양한 함수를 다루는 방법
 * 확장함수
 * infix함수
 * inline함수
 * 지역함수
 * */


//확장 함수
// 기본 자바코드위에 코틀린 코드를 추가할 수 없을까? 자바라이브러리 유지보수,확장할때 코틀린을 사용하고싶다.
// 어떤 클래스안에 있는 메소드처럼 호출할 수는 있지만 함수는 클래스 밖에 있도록
//바로 함수명이 아니라 확장할타입.함수명

//확장함수에서는 private or protecred 멤버를 가져올 수 없다.
//확장함수와 멤버함수의 시그니처(이름)이 동일하다면 멤버함수가 호출된다 (기존함수)
// 그렇기에 추후에 똑같은 이름을 가진 멤버함수가 생긴다면 오류가 발생할 수 있다.

//확장함수 오버라이드시 그타입의 확장함수 실행. 부모타입에 자식객체를 넣어도 부모타입 확장함수 실행
fun String.lastChar(): Char{
    return  this[this.length-1] //this를 수신객체 확장하려는 타입 수신객체타입이라 부름
}

//자바에서는 static함수를 사용하듯 확장함수를 사용
//StringUtilsKt.lastChar("abc"); Kt는 코틀린 뜻함

//확장 프로퍼티와도 연결됨 확장함수 + custom getter String.lastChar: Char
                                                //  get() = this[this.length - 1]

// 중위 함수 (함수를 호출하는 새로운 방법)
// 변수 함수이름 argument (원래는 변수.함수이름(argument))
// 함수 앞에 infix 붙이면됨 멤버함수에도 사용 가능
infix fun Int.add2(other: Int): Int{
    return this + other
}

//inline 함수 함수가 호출되는 대신 함수를 호출한 지점에 함수 본문을 그대로 복붙하고 싶은 경우
//함수를 파라미터로 전달할때 오버헤드를 줄일 수 있다.
// 하지만 성능 측정과 함께 신중히 사용할것
inline fun Int.add(other: Int): Int{
    return this + other
}

fun main(){
    // 실제로는 3+4가 생김
    3.add(4)
}

// 지역함수 함수안에 함수 중복부분 줄일때
// deps가 깊어지고 사실 코드가 그리 깔끔해 보이지도 않는다.
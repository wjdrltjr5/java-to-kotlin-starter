package com.lannstark.lec03

/**
 *  코틀린에서 타입을 다루는 방법
 *  기본타입 코틀린에서는 선언된 기본값을 보고 타입을 추론한다.
 *  타입캐스팅
 *  코틀린의 3가지 특이한 타입
 * */
// 정수는 L을 붙이면 Long 아니면 Int 실수는 f를 붙이면 Float 아니면 Double
// 자바는 기본타입간 변환은 암시적으로 이뤄지지만 코틀린은 명시적으로 해줘야함
// ex.java int+long 알아서 해줌
//kotlin
var number1 = 1;
var number2: Long = number1.toLong();//to기본타입 해줘야함.
//또 null이 들어갈 수 있는 타입이라면 세이프콜, 엘비스 연산도 해줘야함
var number4: Int? = 3;
var number5: Long = number4?.toLong() ?: 0L;

// 타입 캐스팅
fun printAgeIfPerson(obj: Any){
    // is = instanceof
    if(obj is Person){//obj !is Person = java(!(obj is Person))
//        val person = obj as Person// as = (Person) as? = safe call 다른타입이여도 예외가 아니라 null
//        println(person.age) // person?.age
        println(obj.age); // 코틀린에서는 if에서 타입체크를 해줄시 이렇게도 가능
    }
}

// Any = java의 Object  코틀린의 경우 기존자료형도 Any가 최상외 왜? long x Long라서
// Any 자체로는 null 포함 불가 Any?로 표현
// Any는 Object에 equals/ hashCode/ toString 처럼 존재

// Unit은 (자바의 void) 타입추론 때문에 생략 가능
// void와 다르게 Unit은 그자체로 타입인자 사용 가능 자바는 Void사용
// 함수형 프로그래밍에서 Unit은 단 하나의 인스턴스만 갖는 타입을 의미
// 즉 코트린의 Unit은 실제 존재하는 타입이라는 것을 표현

//Nothing은 함수가 정상적ㅇ로 끝나지 않았다는 사시을 표현하는 역할
// 무조건 예외를 반환하는 함수 / 무한 루프 함수 등
fun fail(message: String): Nothing{
    throw IllegalArgumentException(message);
}

//String interpolation / String indexing
// 자바에서 String.format  ${변수}로 사용 중괄호 생략가능 $name 그냥 중괄호를 사용하자.
val person = Person("정기석",100)
val log = "사람의 이름은${person.name} 이고 나이는 ${person.age}세 입니다."

//StringBuilder의 append 코틀린은 여러줄 출력할때 """내용으로 작성 """
var name = """
    awdawdawd
    awdawdwa
    ${person.name}
""".trimIndent() //출력할때는 .trimIndent()는 사라짐

// 자바의 배열처럼 문자열에 있는 특정 배열 가져올 수 있음
// java String str = "ABCDE"; char ch = str.chatAt(1);
val str = "ABCDE";
val str2 = str[0];
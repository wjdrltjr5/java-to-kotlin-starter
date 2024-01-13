package com.lannstark.lec19

import com.lannstark.lec17.Fruit
import com.lannstark.lec17.Fruit as FFFF
/**
 * 코틀린의 이모저모
 * Type Alias와 as import
 * 구조분해와 componentN 함수
 * Jump와 Label
 * Takelf 와 TakeUnless
 * */
//Type Alias
//긴 이름의 클래스 혹은 함수 타입이 있을때 축약하거나 더 좋은 이름을 쓰고 싶다
// sql 의 as 같은건가
//filter: (Fruit) -> Boolean의 파라미터가 너무 길다.
typealias FruitFilter = (Fruit) -> Boolean
fun filterFruit(fruits: List<Fruit>, filter: FruitFilter){
    println("a")
}
// 이런식으로 사용

// as import 어떤 클래스나 함수를 import할때 이름을 바꾸는 기능
// 다른 패키지의 같은 이름 함수를 동시에 가져오고 싶다면
//package1 a함수 package2 a함수가 있고 둘다 사용하고 싶다면 위 import 참고


// 구조분해 복합적인 값을 분해하여 여러 변수를 한 번에 초기화 하는 것 즉 componentN을 호출 ps.순서를 인식해서 가져온다면 안쓰겠는데?
// 일반 클래스에도 operator예약어를 사용 구현가능  (key, value) in map.entries도 구조분해 문법 사용
//Person 은 dataClass 는 componentN이라는 함수도 자동으로 만들어줌 1은 첫번째 프로퍼티,2는 두번째 프로퍼티....
//val person = Person("이름", 16)
//val (name, age) = person  // 이 한줄은 val name = person.component1() ; val age = person.component2();
//println("이름은 ${name} 나이는 ${age}")

//Jump 와 Label
// return break continue 자바와 동일
// 단 foreach에서 continue, break를 사용할 수 없음
// 굳이 break와 continue를 사용하고 싶다면
fun main(){
    val numbers = listOf(1,2,3)

    //break 효과
    run {
        numbers.forEach{number ->
        if(number == 2){
            return@run
        }}
    }
    //continue 효과
    numbers.forEach{number ->
        if(number == 2){
            return@forEach
        }}
    // 그냥 for문쓰자 이 forEach와 저 forEach는 다른듯
    for(number in numbers){
        if(number == 2){
            println("중지됨")
            break
        }
    }

    // 코틀린의 Label 특정 Expresson에 라벨이름@를 붙여 하나의 라벨로 간주 break,continue,return등을 사용하는 기능
    looptest@for(i in 1..100){
        for(j in 1..100){
            if(j == 2){
                break@looptest // j루프가 멈추는게 아니라 첫번째 i for문을 멈춰버림
            }
        }
    }

    //label을 사용한 jump는 사용하지 말것

    //TakeIf와 TakeUnless
    fun getNumberOrNull(number: Int): Int?{
        return if(number <= 0)
            null
        else
            number
    }
    // 코틀린에서 메소드체이닝을 위한 특이한 함수 제공
    //takeIf
    fun getNumberOrNull2(number: Int): Int?{
        return number.takeIf { number -> number > 0 } //주어진 조건을 만족하면 그값이 아니면 null이 반환
        // takeUnless는 반대 주어진 조건을 만족하지 않으면 그값이 반환 만족하면 null을 반환
    }
}

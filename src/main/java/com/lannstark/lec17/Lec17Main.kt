package com.lannstark.lec17

import java.util.*

/**
 * 익명함수....익명클래스....
 * 코틀린에서 람다를 다루는 방법
 * 자바에서 람다를 다루기 위한 노력
 * 코틀린에서의 람다
 * Closure
 * try with resource가 없고 use
 * */

//자바의 Lambda, Predicate, Consumer, Stream 등을 많이 만들어놓음
//코틀린에서의 람다는 자바와 다르게 함수가 그 자체로도 값이 될 수 있다.
//변수에 할당될 수도, 파라미터로 넘길 수도 있다.

fun main(){
    val fruits = listOf(
        Fruit("사과", 1000),
        Fruit("사과", 1200),
        Fruit("사과", 1200),
        Fruit("사과", 1500),
        Fruit("바나나", 3000),
        Fruit("바나나", 3200),
        Fruit("바나나", 2500),
        Fruit("수박", 10000)
    )
    //람다를 만드는 방법1 이름만 빠짐
    val isApple = fun(fruit: Fruit): Boolean{// val isApple: (Fruit) -> Boolean = fun.... 이렇게도 작성 Fruit를 받아 boolean을 반환한다는 뜻
        return fruit.name == "사과"
    }
    //람다를 만드는 방법2 함수에 직접 넣어줄때는 이방법 많이 사용
    val isApple2 = {fruit: Fruit -> fruit.name == "사과"} //val isApple2 (파라미터 타입) -> 반환타입 = ...
    //람다 호출방법 1
    isApple(fruits[0])
    //람다 호출방법 2
    isApple.invoke(Fruit("사과",20200))
    filterFruits(fruits, isApple)
    filterFruits(fruits, isApple2)
    filterFruits(fruits, fun(fruit: Fruit): Boolean{
        return fruit.name == "사과"
    } )
    //함수 파라미터가 마지막에 위치하고 있으면 중괄호를 소괄호 밖으로 뺼 수 있음
    filterFruits(fruits) {fruit: Fruit -> fruit.name == "사과"}

    // 익명함수 타입 추론이 가능할경우 (파라미터를 통해서 ) 함수 작성할때 :타입 생략가능
    // 또한 변수가 하나일경우 fruit -> fruit.name == "사과"가 아니라 it.name == "사과"로 생략가능
    filterFruits(fruits) {a -> a.name == "사과"}
    filterFruits(fruits) { it.name == "사과"}
    //람다를 여러줄 작성할경우 마지막 줄이 return값(명시안할시)
}


//자바의 filterFruits 옮기기

private fun filterFruits(fruits: List<Fruit>, filter: (Fruit) -> Boolean): List<Fruit>{
    val result = mutableListOf<Fruit>()
    for(fruite in fruits){
        if(filter(fruite))
            result.add(fruite)
    }
    return result
}

// Closure
//자바에서는 람다를 사용할때 변수에 제약이 있다. final or 실질적 final
// 코틀린에서는 그냥 동작 코틀린은 람다가 시작하는 지점에 참조하고있는 변수들을 모두 포획하여 그 정보를 가지고 있다.
// 그 포획한 데이터구조를 Closure라고 함


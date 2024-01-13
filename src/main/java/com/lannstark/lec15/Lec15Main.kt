package com.lannstark.lec15

/**
 * 코틀린에서 배열과 컬렉션을 다루는 방법
 * 배열
 * 컬렉션(list set map)
 * 컬렉션의 null 가능성, java와 함께 사용하기
 * */
// 배열 잘안씀 list나 쓰지

// java = int[] array = {100,200}
fun main(){
    var array = arrayOf(100, 200)
    //0~마지막index까지
    for(i in array.indices){
        println("${i} ${array[i]}")
    }
    //index와 value한번에 가져오기
    for((index, value) in array.withIndex()){
        println("${index} ${value}")
    }
    //배열에 값 추가 자바에 비해 쉬움
    array.plus(300)
    //컬렉션을 만들때 불변인지 가변인지 꼭 선언해줘야하함 tip.불변리스트를 만들고 필요한 경우 가변리스트로 바꾸자.
    //불변컬렉션 -> 컬렉션에 element를 추가, 삭제할 수 없음(단 참조타입 element의 필드는 바꿀 수 있음
    //가변(mutable)컬렉션 -> 컬렉션에 element를 추가, 삭제할 수 있음

    //List<Integer> numbers = Array.asList(100,200);
    val numbers = listOf(100,200); // 불변리스트임  가변은 mutableListOf(100, 200) numbers.add(300)
    val empayList = emptyList<Int>()// 비어있는 리스트는 타입 명시해줘야
    println(numbers[0]) // numbers.get(0)

    for(number in numbers){ //for(int number : numbers)
        println(number)
    }
    for((index, value)in numbers.withIndex()){
        println("${index}, ${value}")
    }

    //집합은 List랑 비슷
    var numberSet = setOf(1,2,3,4) // 기본적인 구현체  = LinkedHashSet
    for((index,value) in numberSet.withIndex()){}
    //map
    val oldMap = mutableMapOf<Int,String>()
    oldMap.put(1,"첫")
    oldMap[2] = "두"//이렇게도 가능
    val map = mapOf(1 to "첫", 2 to "두")//to 중위호출 = pair라는 클래스를 사용

    for(key in oldMap.keys){
        println(oldMap[key])
        println(oldMap.get(key))
    }
    for((key, value)in oldMap.entries){}

    //컬렉션의 널처리
    //List<Int?> element가 null일수 있지만 list자체는 null이아님
    //List<Int>? element는 null일 수 없고 list자체는 null일 수 있음
    //List<Int?>? element,list둘다 null일 수 있음

    //자바와 함께 사용할 때 주의점
    // 자바는 읽기전용컬렉션과 변경 가능 컬렉션을 구분하지 않음
    // 즉 코틀른의 불변컬렉션은 자바에서 사용시 변경가능  ?사용효과도 마찬가지
    // 즉항상 생각하고 사용 자바를 거칠 시 방어로직을 사용하던가  Collections.unmodifableXXX() 활용

    //반대로 코틀린에서 자바껄 가져와 사용할때는 반대상황 null 체크 여부 확인 불가 자바코드를 보면서 맥락 확인해서 사용
    //래핑해서 영향 최소화

}

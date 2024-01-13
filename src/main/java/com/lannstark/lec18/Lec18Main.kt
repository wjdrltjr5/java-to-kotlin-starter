package com.lannstark.lec18

import com.lannstark.lec17.Fruit

/**
 * 코틀린에서 컬렉션을 함수로 다루는 방법
 * 필터와 맵
 * 다양한 컬렉션 처리 기능
 * List를 Map으로
 *
 * */
fun main(){
    val fruits = listOf(
        Fruit(1,"사과",2020,4200),
        Fruit(2,"사과",2030,4400),
        Fruit(3,"사과",2020,4100),
        Fruit(4,"사과",2010,4200),
        Fruit(5,"사과",2020,4300),
        Fruit(6,"바나나",2020,4500),
        Fruit(7,"바나나",2050,4200),
        Fruit(8,"바나나",2060,4100),
        Fruit(9,"바나나",2010,4600),
        Fruit(10,"바나나",2200,4800),
    )
    val apples = fruits.filter {fruit -> fruit.name == "사과"}
    val apples2 = fruits.filterIndexed{idx, fruit -> println(idx)
        fruit.name == "사과"}
    val apples3 = fruits.filter { fruit -> fruit.name == "사과" }
        .map { fruit -> fruit.currentPrice }
    val apples4 = fruits.filter { fruit -> fruit.name == "사과" }
        .mapIndexed { idx,fruit -> println(idx)
            fruit.currentPrice }
    //val apples5 = fruits.filter { fruit -> fruit.name == "사과" }.mapNotNull { fruit -> fruit.nullOrValue() }

    // 그외 all (조건을 모두 만족하면 true, 아니면false) 모두 사과인가? false
    // none(조건을 모두 불만족하면 true, 아니면 false) 모두 사과인가? true
    // any(조건을 하나라도 만족하면 true) 사과가 하나라도 있는가? true
    // count()
    // sortedBy
    // distinctBy 중복제거
    //first 첫번쨰(null이아니여야 함), firstOrNull 첫번째 또는 null
    //last , lastOrNUll
    // groupBy
    val map: Map<String, List<com.lannstark.lec18.Fruit>> = fruits.groupBy { fruit -> fruit.name } // 키가 이름 값은 리스트
    val map2: Map<Long, com.lannstark.lec18.Fruit> = fruits.associateBy { fruit -> fruit.id }// 값이 단일 객체 중복되지 않는 키를 가지고 매핑
    val map3: Map<String, List<Long>> = fruits.groupBy ({ fruit -> fruit.name }, {fruit -> fruit.factoryPrice})
    // 기타 등등등
    // 중첩된 컬렉션 처리
    // faltMap, flatten(List<List<Fruit>> -> List<Fruit>중첩된 리스트 )
}



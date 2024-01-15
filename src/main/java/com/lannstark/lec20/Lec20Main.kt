package com.lannstark.lec20

import com.lannstark.lec03.str
import com.lannstark.lec09.Person
import com.lannstark.lec19.filterFruit

/**
 * 코틀린의 scope function
 * scope function 이란
 * scope function 의 분류
 * 언제 어떤 scope function 을 사용해야 할까
 * scope function과 가독성
 * */

// scope 영역 function 함수
//scopefunction : 일식적인 영역을 형성하는 함수 takeIf
/* fun printPerson(person: Person?){
    if(person != null){
    println(person.name)
    println(person.age)
   }
   ---- scope function 사용 리팩토링
 */
fun printPerson(person: Person?){
    person?.let { //let은 scope funtion 함수를 받아서 함수를 실행하는 함수
        println(it.name) // 람다안에서 it가능
        println(it.age)
    }
}
// 즉 scope function은 람다를 사용해 일시적인 영역을 만들고 코드를 더 간결하게 만들거나, method chaning에 활용하는 함수
// this = 생략이 가능한 대신 다른 이름을 붙일 수 없다.
// it = 생략이 불가능한 대신 다른 이름을 붙일 수 있다.
// 둘의 차이는 코틀린의 문법때문
//scope function 종류
//let 람다 결과 반환 it사용 함수를 파라미터로 받음
//run 람다 결과 반환 this사용 확장함수를 파라미터로 받음
//also 객체 반환 it 사용 함수를 파라미터로 받음
//apply 객체 반환   this사용 확장함수를 파라미터로 받음
//with(확장함수 아님) with(파ㅏ라미터, 람다) this사용 접근 생략가능

// 언제 어떤 scope function을 써야할까.

fun main() {
    // let은 하나 이상의 함수를 call chain 결과로 호출할때
    val strings = listOf("apple", "car")
    strings.map {it.length}
        .filter { it > 3 }
        .let { println(it) }
    //non-null값에 대해서만 code block을 실행시킬때 가장 많이
    val length = str?.let{
        println(it.uppercase())
        it.length
    }
    //일회성으로 제한된 영역에 지역 변수를 만들 때
    val numbers = listOf("one","two","three","four")
    val modifiedFirstItem = numbers.first()
        .let { firstItem -> if (firstItem.length >= 5) firstItem else "!${firstItem}!" }
        .uppercase()
    println(modifiedFirstItem)

    //run 객체 초기화와 반환 값의 계산을 동시에 해야 할 때
    // ex. 객체를 만들어 DB에 바로 저장하고, 그 인스턴스를 활용할 때
    //val person = Person("name",10).run(personRepository::save) 잘사용 x
    //val person = personRepository.save(Person("name",10)); 이게 더 편함
    //반복되는 생성후 처리는 생성자, 프로퍼티, init block로 넣는게 좋다.

    //apply 객체 그 자체가 반환되기 때문에 객체 설정을 할 떄에 객체를 수정하는 로직이 call chail중간에 필요할 떄
    // ex. Test Fixture를 만들때
    /*fun createPerson(name: String, age: Int, hobby: String): Person{
    return Person(
        name = name;
        age = age;
    ).apply{ this.hobby = hobby} 생성자에 hobby 가없을때
    }
    */

    //also  객체 그 자체가 반환되기 때문에 객체 설정을 할 떄에 객체를 수정하는 로직이 call chail중간에 필요할 떄
    //mutableListOf("one", "two", "three")
    //    .also { println("four 추가 이전 지금 값 ${it}" }
    //    .add("four")

    // with 특정 객체를 다른 객체로 변환해야 하는데, 모듈간의 의존성으로 인해 정적팩토리 혹은 toClass함수를 만들기 어려울때
    /* return(person){
        PersonDto(
            name = name,
            age = age,
        )
    }
    * */

    //근데 가독성이 좋은지는 잘 모르겠는데 그냥 java가 익숙해서 그런가...
    // 사용빈도가 적은 관용구는 가독성을 떨어트린다. 알아서 적절하게 사용할것.
}
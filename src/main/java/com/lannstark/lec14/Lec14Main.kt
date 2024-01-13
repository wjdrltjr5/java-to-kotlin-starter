package com.lannstark.lec14

import com.lannstark.lec01.Person

/**
 * 코틀린에서 다양한 클래스를 다루는 방법(일반 클래스, 추상클래스, 인터페이스 x)
 * Data Class
 * Enum Class
 * Sealed Class, Sealed Interface
 * */

//Data Class
// JavaPerson DTO 보통 필드  생성자와 getter equals, hashCode, toString
// IDE or lombok를 통해서 쉽게 만들 수 있지만 좀 장황해진다
// 코틀린에서 DTO를 쉽게 만들 수 있음
// data를 붙이면 equals, hashcode, toString을 자동으로 만들어줌 getter와 생성자는 자동이니
// named arguemnt를 사용하면 뭐 빌더패턴처럼

// 자바에서 jdk16부터 비슷한 recodeClass를 도입
data class PersonDTO(var name: String , val age: Int){
}

fun main(){
    val a = PersonDTO(age = 13, name = "es")
    val b = PersonDTO("es", 13);
    b.name = "awd"
    println(a)
    println(b)

    handleCountry(Country.KOREA)
}


enum class Country(private val code: String){
    KOREA("ko"),
    AMERICA("US")
}
// when 의경우 enum클래스와 Sealed클래스와 함께 사용할경우 진가를 발휘한다. - 5강
/*
  private static void handleCountry(JavaCountry country) {
    if (country == JavaCountry.KOREA) {
      // 로직 처리
    }

    if (country == JavaCountry.AMERICA) {
      // 로직 처리
    }
  }
* */
fun handleCountry(country: Country) {
    when(country){
        Country.KOREA -> println("korea")
        Country.AMERICA -> println("america")
    }// enum의 경우 else 생략가능
}

//Sealed Class의 생성이유 = 상속이 가능하도록 추상클래스를 만드는데 외부에서는 이 클래스를 상속받지 않았으면 좋겠다
//하위 클래스를 봉인하자. 컴파일 타임때 하위클래스 타입을 모두 기억한다. 런타임때 클래스 타입이 추가될 수 없다
//구현 클래스는 같은 패키지에 있어야 함
//Enum과 차이 = 클래스를 상속받을 수 있고 하위클래스는 싱글턴 객체가 아님

sealed class HyundaiCar(val name: String, val price: Int)
// when으로  사용할 때도 else사용 안해도됨
// 추상화가 필요한 엔티티 or DTO에 SealedClass 사용 jdk17에 비슷한 기능 추가
class Avante : HyundaiCar("아반떼",100)
class Sonata : HyundaiCar("소나타", 200)
class Grandeur : HyundaiCar("그랜져", 300)
package com.lannstark.lec10

/**
 * 코틀린에서 상속을 다루는 방법
 * 추상클래스
 * 인터페이스
 * 클래스 상속시 주의할점
 * 상속관련 지시어
 * */

abstract class Animal(protected val species: String,protected open val legCount: Int){
    abstract fun move()
}
// 상속 extends x : 사용 단 타입표시는 변수명: 타입이지만 상속은 _:_타입임 _는 띄우기
//                          super(species, 4)와 같음
class Cat(species: String) : Animal(species, 4){
    // 자바에서는 오버라이드 어노테이션이지만 코틀린은 예약어 필수로
    override fun move() {
        println("고양이가 사뿐 사뿐")
    }
}
// 코틀린에서 인터페이스 사용시 그냥 똑같이 : 사용
class Penguin(species: String) : Animal(species, 2), Swimable, Flyable{
    private val wingCount: Int = 2
    override fun move() {
        println("펭귄이 움직인다.")
    }
    //코틀린에서 필드는 기본적으로 오버라이드가 불가능 하기 떄문에
    //하위 클래스에서 프로퍼티를 오버라이드 하려면 상위 클래스 앞에 open울 붙여줘야 함(추상프로퍼티는 x)
    //상위 클래스 접근은 자바와 같이 super
    override val legCount: Int
        get() = super.legCount + this.wingCount
    // 자바의 경우 Swimable.super.act(); 코틀린은 super<Swimable>.act()
    override fun act() {
        super<Swimable>.act()
        super<Flyable>.act()
    }
}

//인터페이스
// 코틀린에서는 에서는 backing field가 없는 프로퍼티를 Interface에 만들 수 있다.
interface Flyable{
    //default를 쓰지않아도 default 함수를 만듬
    //바디가 없으면 추상메서드
    fun act(){
        println("파닥파닥")
    }
}
interface Swimable{
    fun act(){
        println("어푸어푸")
    }
}
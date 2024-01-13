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
    //하위 클래스에서 프로퍼티를 오버라이드 하려면 상위 클래스 앞에 open울 붙여줘야 함(추상멤버는  x)
    //상위 클래스 접근은 자바와 같이 super
    override val legCount: Int
        get() = super.legCount + this.wingCount
    // 자바의 경우 Swimable.super.act(); 코틀린은 super<Swimable>.act()
    override fun act() {
        super<Swimable>.act()
        super<Flyable>.act()
    }
    // 추상프로퍼티라 open필요없음
    override val swimAbility: Int
        get() = 3
}
//open의 추상멤버의 정의는 interface와 abstact class에 따라 달라짐
//인터페이스는 구현체가 없는 경우에 추상멤버.
// ex. fun do1() = 추상멤버 fun do2(){...} = 추상멤버 x
// 클래스의 경우 abstract가 붙어있는 경우 추상멤버
//인터페이스

interface Flyable{
    //default를 쓰지않아도 default 함수를 만듬
    //바디가 없으면 추상메서드
    fun act(){
        println("파닥파닥")
    }
}

interface Swimable{
    // 코틀린에서는 에서는 backing field가 없는 프로퍼티를 Interface에 만들 수 있다.
    // val이니까 getter만 구현 클래스에서 구현해줄걸 기대
    // 값을 get()을 활용해 넣어도 됨
    val swimAbility: Int
        get() = 3
    fun act(){
        println(swimAbility)
        println("어푸어푸")
    }
}

//클래스 상속시 주의 일반 클래스 상속(추상x) 는 일반 클래스에 open 붙여줘야함
//BaseClass
//0
//Derived Class
//상위 클래스의 생성자와 init블럭에서는 하위클래스의 field(프로퍼티)에 접근하면 안됨 (final은 x)
//상위 클래스를 설계할때 생성자 또는 초기화 블록에 사용되는 프로퍼티에는 open을 피해야 한다.


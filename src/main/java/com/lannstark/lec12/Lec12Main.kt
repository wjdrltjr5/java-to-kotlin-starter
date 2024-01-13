package com.lannstark.lec12

import com.lannstark.lec10.Swimable

/**
 * 코틀린에서 object 키워드를 다루는 방법 자바에는 없음
 * static 변수와 함수
 * 싱글턴
 * 익명클래스
 * */

class Person private constructor(var name: String, var age: Int){
    //코틀린은 static이 없음 대신 companionObject 블럭안에 사용
    companion object{// 클래스와 동행하는 유일한 오브젝트
        private const val MIN_AGE = 1 //static 변수  그냥 val은 런타임시 할당 const를 붙이면 컴파일시 할당 진짜 상수에 붙임
        fun newBaby(name: String): Person{ //static 메소드
            return Person(name, MIN_AGE)
        }
    }

}
// companion object 는 동반객체 즉 하나의 객체로 간주된다. 때문에 이름을 붙일 수도 있고 interface를 구현할 수도 있다.
//companion object에 유틸성 함수를 넣어도 되지만 최상단 파일을 활용하는 것이 좋다.
// 자바에서 코틀린의 companion을 사용하려면 이름이 없을떄는 Companion.변수 or 함수 (기본 이름이 companion이기 때문)아니면 이름.변수or함수
// Person.Companion.newBaby("test"); , Test.Factory.newBaby("test");
// 또는 코틀린의 companion object 에 @JvmStatic 어노테이션 붙여주면 Person.newBaby("test")로 바로 사용 가능
class Test private constructor(var name: String, var age: Int){
    companion object Factory : Swimable {
        private const val MIN_AGE = 1;

        fun newBaby(name: String): Test{
            return Test(name, MIN_AGE)
        }

    }
}

//싱글톤
//자바의 경우 생성자 private로 하고 뭐 처리를 하거나 동시성처리를 더하거나 enum을 활용
//코틀린의 경우 object 객체명 끝
object MySingleton{
    var a: Int = 0;
}
// 코틀린의 익명객체 사용법 object : 타입
fun main(){
    println(MySingleton.a)
    moveSomething(object : Movable{
        override fun move() {
            println("움직인다.")
        }

        override fun fly() {
            println("난다.")
        }
    })
}
// 익명 클래스
fun moveSomething(movable: Movable){
    movable.move()
    movable.fly()
}
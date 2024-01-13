package com.lannstark.lec11

/**
 * 코틀린에서 접근제어를 다루는 방법
 * 자바와 코틀린의 가시성 제어
 * 코틀린 파일의 접근제어
 * 다양한 구성요소의 접근제어
 * java와 kotlin을 함께 사용할 경우 주의할 점
 * */

// 자바는 4가지 public protected default private
// 코틀린은 default(public) protected(선언된 클래스 또는 하위 클래스에서만 접근가능(패키지 접근 x))
// 코틀린은 패키지를 가시성제어로 사용 x 그냥 정리 용도
// internal(같은 모듈에서만 접근 가능 모듈 = 한번에 컴파일 되는 Kotlin코드 maven, gradle..)
// private 동일

// 코틀린은 .kt파일에 변수, 함수, 클래스 여러개를 바로 만들 수 있다.
// 파일의 접근제어
// public 기본값 어디서든 접근 가능
// protected 파일에는 사용 불가. protected val a: String 불가
// internal(같은 모듈에서만 접근 가능)
// private 같은 패일 내에서만 접근

// 생성자에 접근 지시어를 붙이려면 constructor 명시해줘야함
// class Cat private constructor(){}
//class Cat public constructor(a: String, b: Int){}

// 자바에서 유틸성 코드를 만들때 추상 클래스 + private 생성자를 사용 인스턴스화 방지
// 코틀린에서도 가능 하지만 파일 최상단에 그냥 유틸함수 작성하는게 편함
fun isDirectoryPath(path: String): Boolean{
    return path.endsWith("/")
}

// 프로퍼티의 가시성
// internal이나 public 을 붙여서 getter,setter 한번에 접근 지시어를 정하는 방법
// getter 와 setter를 구분하는 방법은 custom getter나 custom getter 앞에 접근 제어자 작성
// 코틀린은 get set을 .으로 사용하니 private로 선언하면 getter,setter도 같은 클래스 내에서만 사용가능 (자바의 private String name, public setName(String name){} x
class Car(private val name: String,
          internal var owner: String,
          _price: Int){
    //이러면 setter에만 private
    var price = _price
        private set

}

//자바와 코틀린을 사용할때 주의
// internal은  바이트 코드상 public이 된다. 때문에 java코드에서는 코틀린 코드의 internal을 가져올 수 있다.
// 자바의 protected와 코틀린의 protected는 다르다 java는 같은 패키지의 코틀린 protected에 접근할 수 있다.
//
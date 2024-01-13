package com.lannstark.lec13

import com.lannstark.lec13.JavaHouse.LivingRoom

/***
 * 코틀린에서 중첩클래스를 다루는 법
 * 중첩클래스 종류
 * 코틀린의 중첩 클래스와 내부 클래스
 */
//자바의 경우 static을 사용하는 중첩클래스, 사용하지 않는 중첩클래스(내부 지역 익명)
//클래스안에 static을 붙인 클래스는 밖의 클래스 직접 참조 불가.
// 내부클래스는 외부 클래스 직접 참조 가능
// 지역클래스는 메소드 내부에 클래스를 정의
// 일회성클래스인 익명 클래스
// 보통 static 내부 클래스와 내부클래스 뜻함.
// java 코드는 JavaHouse참조

// 이펙티브 자바에선 static 내부 클래스를 사용하라고 했는데 코틀린이는 이를 참조함
// 그렇기에 내부에서 그냥 class를 사용하면 권장되는 static 클래스임
// 즉 바깥클래스와 연결정보를 가지고 있지 않는 내부클래스 생성

// 일반 내부클래스(바깥클래스를 참조할 수 있는 클래스 권장하지 않는) inner을 통해 생성
class House(private val address: String,private val livingRoom: LivingRoom){

    //class LivingRoom(private val area: Double)
    inner class LivingRoom(private val area: Double){
        val address: String
            get() = this@House.address  //java = JavaHouse.this.address
    }
}




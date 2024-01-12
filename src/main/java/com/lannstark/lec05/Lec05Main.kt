package com.lannstark.lec05

/**
 * 코틀린에서 조건문을 다루는 방법
 * if문
 * Expression과 Statement
 * switch 와 when
 * 
 * */
fun validateScoreIsNotNegative(score : Int){ //함수는 void 생략 함수 생성 fun
    if(score < 0) // if(조건){본문}
        throw IllegalArgumentException("${score} 는 0보다 작을 수 없습니다.")
}

//Expression은 Statment에 포함
//java에서 if-else는 Statement이지만 (프로그램의 문장, 하나의 값으로 도출되지 않는다.)
// Kotlin에서는 Expression이다.(하나의값으로 도출되는 문장.) 즉 if문을 이용 리런할 수 있음 자바의 3항연산자 처럼
fun getPassOrFail(score: Int): String{
    if(score >= 50){
        return "P";
    }else{
        return "F";
    }
}
//그래서 코틀린엔 3항연산자가 없음
fun getPassOrFail2(score: Int): String{
    return if(score >= 50){
        "P";
    }else{
        "F";
    }
}

fun getGrade(score: Int): String{
    return if (score >= 90){
        "A"
    }else if(score >=80){
        "B"
    }else if(score >= 70){
        "C"
    }else{
        "D"
    }
}
//자바의 if(0 <= score && score <= 100) 물론 코틀린에서 똑같이 사용 가능
// 하지만 if(score in 0..100)로도 사용가능

fun getGradeWithSwitch(score: Int): String{
    // 코틀린엔 switch case가 없고 when이 있음
//    return when(score / 10){
//        9 -> "A"
//        8 -> "B"
//        7 -> "C"
//        else -> "D"
//    }
    return when(score){
        in 90..99 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        else -> "D"
    }
}
/*when(값){
    조건부 -> 어떠한 구문
    조건부 -> 어떠한 구문
    else -> 어떠한 구문
    조건부에는 어떠한 expression이라도 들어갈 수 있다. ex. is 물론 값 통과시 if처럼 바로 사용가능 SmartCast
    여러개의 조건도 체크 가능 자바의 || && 사용할때
    1, 0, -1 -> println("어디서 많이 본 숫자입니다")
    else -> println("1, 0, -1이 아닙니다")

    when의 값에는 값자체가 없는 것도 가능
    when{ //값이 없다면 그냥 조건부를 판단
        number == 0 -> println("주어진 숫자는 0입니다.")
        number % 2 == 0 -> println("주어진 숫자는 짝수입니다.")
        else -> println("주어지는 숫자는 홀수 입니다.")
        }
    when은 EnumClass, Sealed Class화 함께 사용할때 시너지 큼

*/
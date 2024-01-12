package com.lannstark.lec06

/*
* 코틀린에서 반복문을 다루는 방법
*  for-each
*  for
*  Progression Range
*  while
* */
fun main(){
    val nubmers = listOf(1L, 2L, 3L) // List<Long> numbers = Arrays.asList(1L,2L,3L);
    for(number in nubmers){ // for(long number : numbers){}
        println(number);
    }
    //1~3 ..연산자는 범위를 뜻함(IntRange Class (Progression 클래스를 상속받아 만듬 등차수열))
    for(i in 1..3) {//for(int i = 1 ; i <= 3; i++)
        println(i)
    }
    //downTo, step는 함수임 중위함수(변수.함수이름(argument)가 아니라 변수 함수이름 argumnet)
    for(i in 3 downTo 1){//for(int i = 3; i >= 1 ; i--);
        println(i)
    }
    // 1..5는 등차수열 생성 step함수에 2를 넣어 실행 |등차수열.step(2)
    for(i in 1..5 step 2) {//for(int i = 1; i<=5; i+=2)
        println(i)
    }

    //while문와 do while문은 같음
    var i = 1;
    while(i <= 3){
        println(i)
        i++
    }
}
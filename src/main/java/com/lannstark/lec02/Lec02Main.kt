package com.lannstark.lec02
/*
 * 코틀린에서 null체크
 * Safe Call과 Elvis연산자
 * 널아님 단언
 * 플랫폼 타입
 * */
fun main(){
    var str: String? = "ABC";
    //str.length 에러발생 SafeCall 널이 들어갈 수 있는 변수에서는
    // 바로 .을 사용할 수 없음
    str?.length;// null이 아닌경우에만 발동 null이면 그냥 null

    // Elvis연산자 앞의 연산결과가 null 이면 뒤의 값을 사용
    str?.length ?: 0;// null 이면 0을 출력 null이아니면 길이 출력
    println( startWithA4(str));

    /*4. 코틀린에서 자바 코드를 가져다 쓸때 자바 어노테이션 정보를
     코틀린이 이해함 Person클래스의@Nullable때문에 null체크를 해줘야함
     Nullable 이나 non-nullable이 없다면 코틀린은 정보를 인지 못함
     컴파일과정에서 에러도 나지 않음(단 런타임시 오류가 발생할 수 있음)
     코틀린에서 자바 코드를 사용할때는 널타입을 명시하거나 널체크를 해줘야

     아니면 코틀린으로 래핑해서 사용

     */

    val persion = Person("개발자");
}
//fun startWithA1(str: String?): Boolean{
//    if(str == null){
//        throw IllegalArgumentException("null이 들어왔습니다.");
//    }
//    return str.startsWith("A");
//}
fun startWithA1(str: String?): Boolean{
    return str?.startsWith("A") ?: throw IllegalArgumentException("null이 들어왔습니다.");
}
//fun startWithA2(str: String?): Boolean?{
//    if(str == null){
//        return null;
//    }
//    return str.startsWith("A");
//}
fun startWithA2(str: String?): Boolean?{
    return str?.startsWith("A");
}

//코틀린은 null이 들어올수 있는 환경에서는 경고를 보냄(null체크를 해줘야)
//fun startWithA3(str: String?): Boolean{
//    if(str == null){
//        return false;
//    }
//    return str.startsWith("A");
//}
fun startWithA3(str: String?): Boolean{
    return str?.startsWith("A") ?: false;
}

// 코틀린에서 널이 가능한 타입을 완전히 다르게 취급한다.

//null 아님 단언 :nullable type이지만 아무리 생각해도 null이 될 수 없는 경우
//!! 사용
fun startWithA4(str: String?) :Boolean{
    return str!!.startsWith("A");
}



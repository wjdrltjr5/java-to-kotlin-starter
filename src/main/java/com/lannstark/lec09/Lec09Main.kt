package com.lannstark.lec09

/*
*   코틀린에서 클래스를 다루는 방법
*   클래스와 프로퍼티 주생성자는 필수
*   생성자와 init
*   커스텀 getter setter
*   backing field
* */
//코틀린은 디폴트가 public
// constructor 생략가능 class Person(name: String, age: Int)
class Person constructor(name:String, age: Int){//생성자를 여기에
    //프로퍼티 = 필드 + getter + setter
    // 코틀린은 필드만 만들면 getter,setter 자동으로 생성
    // 아래 두 필드는 생성자때문에 타입생략 가능
    val name: String = name // 불변
    var age: Int = age


}
//생성자에서 프로퍼티 생성도 가능
class Person1(val name: String = "디폴트", var age: Int)//바디역시 아무것도 없으면 생략 가능
class Person2(val name: String, var age: Int){
    //init 블록은 생성자가 호출되는 시점에 호출됨 값을 넣거나 검증하거나 하는 용도로 사용
    init {
        if(age <= 0){
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다.");
        }
    }
    constructor(name: String): this(name, 1); // 생성자 오버로딩 주생성자를 호출하기에 주생성자가 존재해야함
    //주생성자는 파라미터가 하나도 없다면 생략가능
    //부생성자는 최종적으로 주생성자를 호출함 바디도 가질 수 있음

    // 초기화 블록부터 첫번째생성자 바디 두번째생성자 바디 순으로 실행됨 2번째 부생성자로 객체를 생성하면
    // 커스텀 getter 1,2,3 방법은 다 같다.
    // 방법1 함수형식
    fun isAdult(): Boolean{
        return this.age >= 20;
    }
    // 방벙2 프로퍼티처럼
    val isAdult0: Boolean
        get() = this.age >= 20
    // 방법3
    val isAdult1: Boolean
        get(){
            return this.age >= 20
        }
}
//코틀린에서 .필드를 통해 getter와 setter사용 자바 클래스를 사용할때도 같은 방식으로 사용
fun main(){
    val person = Person("이름", 3)
    println(person.name)
    person.age = 20;
}

// 코틀린에서는 부생성자보단 default parameter를 권장하고 어쩔 수 없다면 정적 팩토리 메소드를 추천함

//name 기본 getter 생성방지 위해 val제거 (var,val 없으면 getter,setter 생성 x) val은 불변이라 setter 생성 x
//이 클래스는 name에 관한 기본 getter은 없고 custom getter만 있음
class Person3(name: String = "디폴트", var age: Int = 1){
    val name: String = name
        get() = field.uppercase() // 이름 대문자로 반환 
    //name이 아니라 field인건 name으로 호출시 get과 name의 무한루프 발생 
    //그래서 field예약어를 사용 -> backing field라고함
    //하지만 보통 위에 방식은 잘 사용 x
    
    //아래 두함수는 기본 getter가 있어야함 보통은 이런방식으로 많이 사용
    // 즉 생성자에 val name: String으로 선언해야.
    fun getUppercaseName123123(): String{
        return this.name.uppercase();
    }
    
    val uppercaseName: String
        get() = this.name.uppercase()
}
//setter 사용 예제
class Person4(name: String){
    var name: String = name
        set(value){//value는 들어오는 파라미터를 의미
            field = value.uppercase(); // field는 자기자신 의미
        }
}

//사실 setter자체를 잘 안쓰니까 뭐 customSetter도 잘 안씀
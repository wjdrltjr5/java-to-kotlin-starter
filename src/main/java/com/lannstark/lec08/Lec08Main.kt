package com.lannstark.lec08

/*
* 코틀린에서 함수를 다르는 방법
* 함수 선언 문법
* default parameter
* named argument(parameter)
* 같은타입의 여러 파라미터 받기 자바의 (String...a)
* */

//두정수를 받아 더 큰 정수를 반환하는 예제
/*
* public int max(int a, int b){
*   if(a > b){
*       return a;
*   }
*   return b;
* }
* */
//즉 함수가 하나의 결과값이라면 추가로 그냥 중괄호 대신 = 사용
// 코틀린의 접근지시어 public 은 생략 가능 반환타입 unit(자바의 void)도 생략 가능
// 또한 반환타입 둘모두 int타입이라 :Int도 생략 가능 코틀린이 타입추론함 (단 = 을 사용한 경우에만 {}사용시 불가능
// 함수는 클래스 안에 있을 수도, 파일 최상단에 있을 수도 한파일 안에 여러 함수들이 있을 수도 있다.
fun max(a: Int, b: Int): Int = if(a > b) a else b


/*
*  public void repeat(String str, int num, boolean useNewLine){
*   for(int i = 1; i <= num; i++){
*       if(useNewLine){
*           System.out.println(str);
*       }else{
*           System.out.println(str);
*       }
*   }
* }
*   자바의 오버로딩
*   public void repeat(String str, int num){
*       repeat(str, num, true);
* }
*    public void repeat(String str){
*       repeat(str, 3, true);
* }
*/
//  default parameter
// 명시된 값이 없으면 = 을 기본값으로 사용
fun repeat(str: String, num: Int = 3, useNewLine: Boolean = true){
    for(i in 1..num){
        if(useNewLine) {
            println(str)
        }else {
            println(str)
        }
    }
}

// named arguemnt
// repaet를 호출할때 num은 3을 그래도 쓰고 useNewLine은 false를 쓰고싶다
// 직접 명시해서 사용
// 빌더패턴 장점 가져올 수 있음(인자 순서 헷갈리지 않는것)
// 자바함수가져와 쓸때는 불가능함
fun main(){
    repeat("HelloWorld", useNewLine = false)

    printAll("A", "B", "C")
    // 배열을 사용하여 가변인자 넘겨줄때 *를 붙여야 함
    val array = arrayOf("A", "B", "C")
    printAll(*array)//스프레드 연산자 배열안에 내용을 , 쓰는 것처럼 꺼내준다.
}
// 같은타입 여러 파라미터 받기(가변인자) vararg사용
/*
*   public static void printAll(String... strings) {
    for (String str : strings) {
      System.out.println(str);
    }
  }
 * */
fun printAll(vararg strings: String){
    for(str in strings){
        println(str)
    }
}

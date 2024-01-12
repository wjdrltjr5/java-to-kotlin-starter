package com.lannstark.lec07

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

/*
*  코틀린에서 예외를 다루는 방법
*  try catch finally 구문
*  체크예외  언체크예외
*   try with resources
* */

//주어진 문자열을 정수로 변환하는 예제
/*
*  private int parseIntOrThrow(@NotNull String str){
*   try{
*       return Integer.parseInt(str);
*   }catch(NumberFormatException e{
*       throw new IllegalArgumentException(String.format("주어진 %s는 숫자가 아닙니다.",str));
*   }
* }
*  */
//try catch finally 문법 자체는 자바와 동일
fun parseIntOrThrow(str: String): Int{
    try{
     return str.toInt();
    }catch (e: NumberFormatException){
        throw IllegalArgumentException("주어진 ${str}은 숫자가 아닙니다.")
    }
}
//실패시 null 반환 try도 하나의 expression으로 판단 return 주목
fun parseIntOrThrowNull(str: String): Int?{
    return try{
        str.toInt();
    }catch (e: NumberFormatException){
        null
    }
}

//체크예외 언체크 예외
/*
  public void readFile(String path) throws IOException {
    File currentFile = new File(".");
    File file = new File(currentFile.getAbsolutePath() + "/a.txt");
    BufferedReader reader = new BufferedReader(new FileReader(path);
    System.out.println(reader.readLine());
    reader.close();
  }
* */

// 체크예외 이지만 예외처리빨간줄이 뜨지 않음 thorws구문이 없음
// 코틀린에서 체크예외 언체크예외 구분x 모두 언체크 예외로 간주
fun readFile(){
    val currentFile = File(".")
    val file = File(currentFile.absolutePath + "/a.txt")
    val reader = BufferedReader(FileReader(file));
    println(reader.readLine());
    reader.close()
}

//try with resource 코틀린에선 없다.
/*
*   public void readFile(String path) throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
      System.out.println(reader.readLine());
    }
  }*/

//use를 이용해서 대신 사용 코틀린의 언어적 특성을 이용
fun readFile(path: String){
    BufferedReader(FileReader(path)).use{
        reader -> println(reader.readLine())
    }
}
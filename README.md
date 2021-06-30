# Java-Problem
- [자바의 특징](#자바의-특징)
- [JVM](#jvm)
- [Variable](#variable)
- [기본형과 참조형](#기본형과-참조형)
- [배열](#배열)
- [Arrays](#arrays)

## 자바의 특징
- 객체지향
- 자동 메모리 관리
    - GC(Garbage Collector)
- Multi Thread 지원
- 다양한 Library 지원
- 운영체제에 독립적(수정 없이 타 OS에서 실행 가능)

## JVM
Java Virtual Machine : 자바 프로그램이 실행되는 가상 컴퓨터(VM)입니다. Java는 OS에서 실행 되는 것이 아닌 JVM에서 실행됩니다. (OS와의 독립성)

## 변수
하나의 값을 저장할 수 있는 메모리 공간. 죽, RAM을 뜻합니다.
- 선언 : data를 저장할 공간을 마련합니다.
- 초기화 : 처음으로 값을 저장합니다.
- 변수의 종류
    - 클래스 변수
    - 인스턴스 변수
    - 지역 변수 : 다른 변수들과 다르게 0으로 *자동 초기화*가 되지 않기 때문에 초기화가 필요합니다.
- 상수(constant) : `final int MAX = 100;`
- 리터럴 : 수학적 상수와 같은 개념입니다.

## 기본형과 참조형
기본형 : 총 8개로 실제 값을 저장합니다.
- boolean, char, byte, short, int, long, float, double <br />

참조형 : 기본형을 제외한 나머지(String, System 등)를 말합니다.
```java
Date today;         // 참조형 변수 today 선언
today = new Date(); // today에 객체의 주소 저장.
```
자동 형변환 : 기존의 값을 최대한 보존하며 컴파일러가 자동으로 추가합니다.
```java
float f = 1234;
float f = (float)1234;
```

## 배열
```java
public class Main {
    public static void main(String[] args) {
        int[] score;                        // 배열 score선언(참조 변수)
        score = new int[5];                 // 배열의 생성(int저장공간 x 5) 
        System.out.println(score.length);   // 배열의 길이

        // char배열인 경우만 아래 방법으로 요소 출력 가능.
        char[] cArr = {'a', 'b', 'c'};
        System.out.print(cArr);

        // 요소들을 String으로 치환 후 [a, b, c]로 출력된다.
        System.out.println(Arrays.toString(cArr));  
    }
}
```

## Arrays
Arrays는 하나의 클래스입니다. <hr />
배열의 비교와 출력 - toString(), equals()
- deepToString : toString()의 2차원 버전
```java
int [][] arr2D = {{11, 12}, {21, 22}};

// [[11, 12], [21, 22]]
System.out.println(Arrays.deepToString(arr2D)); 
```
- deepEquals : equals()의 2차원 버전
```java
String[] str2D = new String[][]{{"aaa", "bbb"}, {"aaa", "bbb"}};
String[] str2D2 = new String[][]{{"aaa", "bbb"}, {"aaa", "bbb"}};

System.out.println(Arrays.equals(str2D, str2D2));       // false
System.out.println(Arrays.deepEquals(str2D, str2D2));       // true
```
- copyOf(), copyOfRange()
```java
int[] arr = {0, 1, 2, 3, 4};
int[] arr2 = Arrays.copyOf(arr, arr.length);    // arr2 = [0, 1, 2, 3, 4]
int[] arr3 = Arrays.copyOf(arr, 7);             // arr3 = [0, 1, 2, 3, 4, 0, 0]
int[] arr4 = Arrays.copyOfRange(arr, 2, 4);     // arr4 = [2, 3]
```
- sort()
```java
int[] arr = {3, 2, 0, 1, 4};
Arrays.sort(arr);
System.out.println(Arrays.toString(arr));       // [0, 1, 2, 3, 4]
```

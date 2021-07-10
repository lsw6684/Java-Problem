# Java-Foundation
- [자바의 특징](#자바의-특징)
- [JVM](#jvm)
- [Variable](#variable)
- [기본형과 참조형](#기본형과-참조형)
- [배열](#배열)
- [Arrays](#arrays)
- [객체지향](#객체지향)
- [객체 배열](#객체-배열)

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

## 객체지향
절차지향 소프트웨어가 빠른 변화를 쫓아가지 못하여 `코드 재사용성 향상, 유지보수 용이, 중복 코드 제거` 등을 목적으로 등장합니다.
- 분석과 관찰을 통해 실제 세계(HW)를 SW로 만들어 컴퓨터로 실행시킵니다.

### 객체지향의 4가지 특성 (캡상추다)
- 캡슐화
- 상속
- 추상화
- 다형성

### 클래스, 객체, 인스턴스
- 클래스 - (설계도)
    - 객체를 정의해 놓은 것으로 객체를 생성하는데 사용됩니다.
- 객체 - (제품)
    - 모든 인스턴스를 대표하는 일반적 용어입니다.
    - 실제로 존재하는 것으로 사물 또는 개념입니다.
    - 기능(메서드)과 속성(변수)에 따라 다르게 사용됩니다.
        ```java
        // 속성(변수)
        String color;
        boolean power;
        int channel;

        // 기능(메서드)
        void power()        { power = !power;}
        void channelUp()    { channel++;}
        void channelDown()  { channel--;}
        ```
- 인스턴스
    - 특정 클래스로부터 생성된 객체로 객체와 거의 같은 개념이라 생각해도 무방합니다.

### 객체의 생성과 사용
- 생성
    ```java
    클래스명 변수명;
    변수명 = new 클래스명();

    Tv t;               // Tv클래스 타입의 참조변수 t 선언.
    t = new Tv();       // Tv인스턴스 생성 후, 생성된 Tv인스턴스 주소를 t에 저장. 
                        // 대입 연산자를 통해 참조변수와 객체를 연결합니다.

    // 합친 표현
    Tv t = new Tv();
    ```
- 사용
    ```java
    t.channel = 7;      // Tv인스턴스의 멤버변수 channel의 값을 7로
    t.channelDown();    // 메서드 호출
    ```
- GC, Garbage Collector <br />
Mark, Sweep, Impact 과정을 통해 동적할당 메모리 중, 필요 없는 영역을 해제합니다.

### 클래스의 정의
클래스 == 설계도 || 데이터 + 함수 || 사용자 정의 타입

- 비 객체지향적 클래스
    ```java
    int hour = 12;
    int minute = 34;
    int second = 56;
    ```
- 객체지향적 클래스
    ```java
    class Time {
        int hour;
        int minute;
        int second;
    }

    Time t = new Time();
    t.hour = 12;
    t.minute = 34;
    t.second = 56;
    ```

- 선언위치에 따른 변수의 종류
    ```java
    // 클래스 영역
    class Variables
    {
        int iv;             // 인스턴스 변수 - 개별 속성
        static int cv;      // 클래스 변수(static변수, 공유변수) - 공통 속성
        
        // 메서드 영역
        void method()
        {
            int lv = 0;     // 지역변수
        }
    }
    ```
- 클래스 변수와 인스턴스 변수
    ```java
    public class Main {
        public static void main(String[] args) {
            // (비 권장)Card의 Class variable 사용 
            Card c1 = new Card();
            c1.width = 23;

            // (권장)Card의 Class variable 사용 
            Card.width = 23;

            // Instance variable 사용
            Card c2 = new Card();
            c2.number = 2;

        }

    }
    class Card {
        // Instance variable
        String kind;
        int number;

        // Class variable
        static int width = 100;
        static int height = 250;
    }
    ```
### 메서드
중복 제거를 목적으로 문장들을 묶습니다.


## 객체 배열
객체 배열은 참조변수 배열을 의미합니다. 특정 객체들에 대한 참조 변수를 배열로써 정의합니다.<br />
`Tv tv1, tv2, tv3;`를 배열로 하면 `Tv[] tvArr = new Tv[3];`
```java
tvArr[0] = new Tv();
tvArr[1] = new Tv();
tvArr[2] = new Tv();

// 위와 같은 초기화를 한 번에 하면
Tv[] tvArr = { new Tv(), new Tv(), new Tv() };
```


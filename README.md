# Java-Foundation
- [자바의 특징](#자바의-특징)
- [JVM](#jvm)
- [Variable](#variable)
- [기본형과 참조형](#기본형과-참조형)
- [배열](#배열)
- [Arrays](#arrays)
- [객체지향](#객체지향)
- [객체 배열](#객체-배열)
- [호출 스택](#호출-스택)
- [매개변수](#매개변수)
- [static 메서드와 인스턴스 메서드](#static-메서드와-인스턴스-메서드)
- [오버로딩과 오버라이딩](#오버로딩과-오버라이딩)
    - [오버로딩 Overloading](#오버로딩-overloading)
    - [오버라이딩 Overriding](#오버라이딩-overriding)
- [생성자](#생성자)
    - [기본 생성자](#기본-생성자)
    - [생성자 this()](#생성자-this)
    - [참조변수 this](#참조변수-this)
    - [참조변수 this와 생성자 this](#참조변수-this와-생성자-this)
    - [참조변수 super](#참조변수-super)
    - [조상의 생성자 super()](#조상의-생성자-super)

- [초기화](#초기화)
- [클래스 간의 관계](#클래스-간의-관계)
    - [상속](#상속)
    - [포함](#포함)
- [패키지](#패키지)

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
중복 제거를 목적으로 문장들을 묶습니다. 객체지향에서 **클래스 안의 함수**를 지칭합니다.
- 메서드의 장점
    - 코드 중복 감소
    - 관리 수월
    - 재사용 가능
    - 이해 : 간단 명료

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

## 호출 스택
메서드 수행에 필요한 메모리가 제공되는 공간입니다.
<p align="center"><img src="images/cs.png" width="60%"></p>
<p align="center"><img src="images/cs2.png" width="60%"></p>

## 매개변수
- 기본형 매개변수 : 변수의 값을 읽기만 할 수 있습니다.(Read Only)
- 참조형 매개변수 : 변수의 값을 읽고 변경할 수 있습니다.(Read & Write)
    - 같은 클래스에 있거나 static method라면 참조 변수를 생략할 수 있습니다.
    - static method는 객체 생성없이 호출 가능합니다.

## static 메서드와 인스턴스
static이 붙고 안 붙고로 구분해도 좋습니다.
```java
class MyMath2 {
    long a, b;          // 인스턴스 변수

    long add() {        // 인스턴스 메서드
        return a + b;
    }

    static long add(long a, long b) {   // 클래스 메서드 (static메서드)
        return a + b;
    }
}
```
- 인스턴스 메서드
    - 인스턴스 생성 후, '참조변수.메서드이름()'으로 호출합니다.
    - 인스턴스 멤버(iv-instance value, im-instance method)와 관련된 작업을 하는 메서드입니다.
    - 메서드 내에서 **인스턴스 변수(iv) 사용 가능**합니다.

- static 메서드(클래스 메서드)
    - 객체생성없이 '클래스이름.메서드이름()'으로 호출합니다.
    - 인스턴스 멤버(iv, im)와 관련없는 작업을 하는 메서드입니다.
    - 메서드 내에서 **인스턴스 변수(iv) 사용 불가**합니다.
### 즉, iv를 사용하지 않을 때 static을 사용합니다.

<br />

- 메서드 간의 호출과 참조
    - static 메서드는 인스턴스 메서드를 호출할 수 없습니다. im은 iv를 필요로 하여 객체가 생성돼야 하기 때문입니다.
        ```java
        class TestClass {
            void instanceMethod() {}
            static void staticMethod() {}

            void instanceMethod2() {        // 인스턴스 메서드
                instanceMethod();           // 다른 im 호출 가능
                staticMethod();             // static method 호출 가능.
            }

            static void staticMethod2() {   // static method
                instanceMethod();           // Error!! im 호출 불가능
                staticMethod();             // static method 호출 가능.
            }
        }

        statc method는 static method를 호출할 수 있지만, iv사용이나 im호출은 객체(iv의 묶음)가 없을 수 있기 때문에 불가능 합니다.
        ```

## 오버로딩과 오버라이딩
### 오버로딩 Overloading
한 클래스 안에 같은 이름의 메서드를 여러 개 정의합니다.
```java
void println()
void println(boolean x)
void println(char x)
void println(char[] x)
void println(double x)
void println(float x)
void println(int x)
void println(long x)
void println(Object x)
void println(String x)
```
- 오버로딩 조건 3가지
1. 메서드 이름이 같습니다.
2. 매개변수의 개수 또는 타입이 다릅니다.
3. 반환 타입은 영향이 없습니다.
    - Ambiguous
        ```java
        long add(int a, long b) {
            return a + b;
        }

        long add(long a, int b) {
            return a - b;
        }
        ```
### 오버라이딩 Overriding
상속받은 조상의 메서드를 자신에 맞게 변형합니다. 메서드 오버라이딩이라 할 수 있으며 글자 그대로 *덮어쓰는 것*입니다.
```java
class Point {           // 2차원
    int x;
    int y;

    String getLocation() {
        return "x : " + x + ", y : " + y;
    }
}

class Point3D extends Point {
    int z;

    // 선언부는 변경 불가하며 내용만을 변경합니다.
    // 조상의 getLocation을 오버라이딩
    String getLocation() {
        return "x : " + x + ", y : " + y + ", z : " + z;
    }
}

public class OverrideTest {
    public static void main(String[] args) {
        MyPoint3D p = new MyPoint3D();
        p.x = 3;
        p.y = 5;
        p.z = 7;
        System.out.println(p.getLocation());
        // x : 3, y : 5, z : 7
    }
}
```
- 오버라이딩 조건 3가지
1. 선언부가 조상 클래스의 메서드와 일치해야 합니다.
2. 접근 제어자를 조상 클래스의 메서드보다 좁은 범위로 변경할 수 없습니다.
3. 예외는 조상 클래스의 메서드보다 많이 선언할 수 없습니다.

### 오버로딩 vs 오버라이딩
- 오버로딩은 기존에 없는 새로운 메서드(이름이 같은)를 정의하는 것입니다.(new)
    - 상속과 관계가 없습니다.
- 오버라이딩은 상속받은 메서드의 내용을 변경하는 것입니다.(change, modify)
    ```java
    class Parent {
        void parentMethod() {}
    }

    class Child extends Parent {
        void parentMethod() {}          // 오버라이딩 : 조상의 메서드를 자손에서 변경
        void parentMethod(int i) {}     // 오버로딩 : 이름이 같은 메서드를 매개변수만 변경하여 정의
        void childMethod() {}           // 메서드 정의
        void childMethod() {int i} {}   // 오버로딩 : 이름만 같은 메서드를 생성
        void childMethod() {}           // Error!! : 중복정의 
    }
    ```

## 생성자 
Constructor, 인스턴스가 생성될 때마다 호출되는 **인스턴스 초기화 메서드**로 초기화를 편리하게 합니다.
- 이름이 클래스 이름과 같아야 합니다.
- 리턴값이 없습니다.(void❌)
- 모든 클래스는 반드시 생성자를 가져야 합니다. 

### 기본 생성자 
Default constructor, 매개변수가 없는 생성자를 의미하며 선언되지 않을 경우, 컴파일러가 자동으로 추가합니다. **단, 하나도 없을 때만 자동 추가되며 항상 만들어 주는 것이 좋습니다.**

```java
클래스이름() {} // 기본 생성자
Point() {}      // Point클래스의 기본 생성자
-------------------------------------------
class Data_1 {
    int value;
}

class Data_2 {
    int value;
    // Error 해결 방안 1 : Data_2() {}
    Data_2(int x) { // 매개변수가 있는 생성자
        value = x;
    }
}

class main {
    public static void main(String[] args) {
        Data_1 d1 = new Data_1();
        Data_2 d2 = new Data_2();   // Compile error
    // Error 해결 방안 2 : Data_2 d2 = new Data_2(3); 매개변수 사용.
    }
}
-------------------------------------------
class car {
    String color;
    String gearType;
    int door;

    car() {}                            // 기본 생성자
    car(String c, String g, int d) {    // 매개변수가 있는 생성자
        color = c;
        gearType = g;
        door = d;
    }
}
1. 매개변수가 있는 생성자가 있을 경우
Car c = new Car("white", "auto", 4);

2. 없을 경우
Car c = new Car();
c.color = "white";
c.gearType = "auto";
c.door = 4;
```
### 생성자 this()
- 생성자에서 다른 생성자를 호출할 때 사용합니다.
- 다른 생성자 호출시 **첫 줄에서만 사용**합니다.
```java
class Car2{
    String color;
    String gearType;
    int door;

    // 1번 생성자
    Car2() {
        this("white", "auto", 4);
    }

    // 2번 생성자
    Car2(String color) {
        this(color "auto", 4);
    }

    // 3번 생성자
    Car2(String color, String gearType, int door) {
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }

    // 1번과 2번이 3번을 호출합니다.
}
```
### 참조변수 this
- 인스턴스 자신을 가리키는 참조변수입니다.
- 인스턴스 메서드(생성자 포함)에서 사용가능합니다.
- 지역변수(lv)와 인스턴스 변수(iv)를 구별할 때 사용합니다.
    ```java
    Car(String color, String gearType, int door) {
        // this.color = iv, color = lv
        this.color = color;
        this.gearType = gearType;
        this.door = door;
        // 동일 클래스 내에서 this는 생략 가능하지만, lv(매개변수)와 이름이 같을 때는 생략 불가능 합니다.
    }
    ```
### 참조변수 this와 생성자 this()
- this : **참조 변수**. 인스턴스 자신을 가리키는 참조변수로 인스턴스의 주소가 저장되어 있으며 모든 인스턴스메서드에 지역변수로, 숨겨진 채로 존재합니다.
- this(), this(매개변수) : **생성자**. 같은 클래스의 다른 생성자를 호출할 때 사용합니다.

위 두 가지는 완전히 다른 것입니다.
```java
class MyMath2 {
    long a, b;              // this가 생략된 형태로 원래 this.a, this.b

    MyMath2(int a, int b) { // 생성자
        this.a = a;
        this.b = b;         // this 생략 불가.
    }

    long add() {
        return a + b;       // return this.a + this
    }
}
```

### 참조변수 Super
- 객체 자신을 가리키는 참조변수로 this와 비슷합니다. 
- 인스턴스 메서드(생성자)내에서만 존재하여 static메서드 내에서 사용 불가합니다.
- this가 lv와 iv 구별에 사용된다면, **super는 조상 멤버를 자신의 멤버와 구별할 때 사용합니다.**
    ```java
    class Ex7_2 {
        public static void main(String args[]) {
            Child c = new Child();
            c.method();

            Child2 c2 = new Child2();
            c2.method();
        }
    }

    class Parent { int x = 10;}     // super.x
    class Child extends Parent {
        int x = 20;
        void method() {
            System.out.println("x = " + x);             // 20, 가까운 x
            System.out.println("this.x = " + this.x);   // 20
            System.out.println("super.x = " + super.x); // 10
        }
    }

    class Parent2 { int x = 10;}    // super.x와 this.x 둘 다 가능
    class Child2 extends Parent2 {
        void method() {
            System.out.println("x = " + x);             // 10
            System.out.println("this.x = " + this.x);   // 10
            System.out.println("super.x = " + super.x); // 10
        }
    }
    ```
### 조상의 생성자 super()
- 조상의 생성자를 호출할 때 사용합니다.
- 조상의 멤버는 조상의 생성자를 호출해서 초기화합니다.
    ```java
    class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    Point3D(int x, int y, int z) {
        super(x,y);     // 조상클래스의 생성자 Point(int x, int y)를 호출
        this.z = z;     // 자신의 멤버를 초기화
    }
    // 자손클래스가 초기화할 수 있지만, 올바른 방법은 아닙니다.
    ```
- 생성자의 첫 줄에는 **반드시** 생성자를 호출합니다. 그렇지 않으면 컴파일러가 생성자의 첫 줄에 super();를 삽입합니다. 아래는 삽입을 하지 않은 예입니다.
    ```java
    class Point {
        int x;
        int y;

        Point() {
            this(0, 0);
        }

        Point(int x, int y) {
            this.x = x;     
            this.y = y;
        }
    }
    // 컴파일러가 자동으로 super(); 생성. 
    class Point extends Object {    // 조상의 기본 생성자 상속?
        int x;
        int y;

        Point() {
            this(0, 0);
        }

        Point(int x, int y) {
            super();        // Object 생성
            this.x = x;
            this.y = y;
        }
    }
    // 즉, 첫 줄에 다른 생성자를 호출해야 예상치 못한 변화가 없습니다.
    // 기본 생성자 작성은 필수❗
    ```

## 초기화
- 지역변수(lv)는 수동으로 초기화 해야합니다.
- 멤버변수(ic, cv)는 자동으로 초기화 됩니다.
    ```java
    class InitTest {
        int x;              // iv      
        int y = x;          // iv

        void method1() {
            int i;          // lv
            int j = i;      // Error!! lv를 초기화하지 않고 사용했음.
        }
    }
    ```
### 멤버변수(iv, cv)의 초기화
1. 명시적 초기화(=)
    ```java
    class Car {
        int door = 4;               // 기본형 변수의 초기화
        Engine e = new Engine();    // 참조형 변수의 초기화
    }
    // 참조형 변수는 null, 객체주소를 가집니다.
    ```
2. 초기화 블럭
- 인스턴스(iv) 초기화 블럭 : {}
- 클래스(cv) 초기화 블럭 : static {}
    ```java
    class StaticBlockTest {
        static int[] arr = new int[10]; // 명시적 초기화

        static {
            for(int i = 0 ; i < arr.length; i++)
                arr[i] = (int)(Math.random()*10) + 1;
        }
    }
    ```
3. 생성자(iv 초기화)
    ```java
    Car(String color, String gearType, int door) {
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }
    ```
### 초기화 시점
- 클래스 변수 : 클래스가 처음 메모리에 올라 갈 때 한 번.
- 인스턴스 변수 : 인스턴스가 생성될 때 마다(객체를 만들 때 마다)

## 클래스 간의 관계
### 상속
- 기존의 클래스로 새로운 클래스를 작성하는 것입니다.(코드의 재사용)
- 두 클래스를 부모, 자식 관계로 맺어주는 것입니다.
- **부모클래스 ← 자식클래스**, 상속 표현으로 부모를 가리킵니다.
    ```java
    class 자식클래스 extends 부모클래스 {}
    ```
- 자손은 조상의 모든 멤버를 상속받습니다.**(생성자, 초기화블럭 제외)**
- 자손의 멤버 개수는 조상보다 적을 수 없습니다.**(그 이상)**
    <p align="center"><img src="images/inheritance.png" width="100%"></p>
- 자손의 변경은 조상에 영향을 미치지 않습니다.
    <p align="center"><img src="images/inheritance2.png" width="100%"></p>
- **extends**인 이유 : Parent를 확장하여 Child를 생성한다는 의미입니다.

### 포함
클래스의 멤버로 참조변수를 선언하는 것입니다.
```java
class Circle {
    int x;      // 원점의 x좌표
    int y;      // 원점의 y좌표
    int r;      // Radius
}
// 위 코드를 포함 관계로 하면
class Point {
    int x;
    int y;
}

class Circle {
    Point c = new Point();
    int r;      // Radius
}
```
### 클래스 간의 관계 결정
- 상속관계 : ~은 ~이다. **(is-a)**
- 포함관계 : ~은 ~을 가지고 있다. **(has-a)**
    - **원**은 **점**을 가지고 있다.

```java
class Inheritance {
    int x;
}
class Child extends Inheritance {
    int r;
}

class Composite {
    int x;
}
class CompositeTest {
    Composite c = new Composite();
    int r;
}

public class Main {
    public static void main(String[] args) {
        // Inheritance Test
        Child a = new Child();
        System.out.println(a.x);
        System.out.println(a.r);
        
        // Composite Test
        CompositeTest b = new CompositeTest();
        System.out.println(b.c.x);
        System.out.println(b.r);
    }
}
```
## 패키지
- 서로 관련된 클래스들의 묶음입니다.
- 클래스는 클래스 파일(*.class), 패키지는 폴더, 하위 패키지는 하위 폴더입니다.
- 클래스의 실제 이름(full name)은 패키지를 포함합니다.(String의 실제 이름 : java.lang.String)
- rt.jar는 클래스들을 압축한 파일(JDK설치경로\jre\lib에 위치), rt = runtime, jar = 클래스 파일 묶음(압축).
    - ***java9부터 rt.jar이 제외되고 module개념이 도입됩니다.***

### 패키지 선언
- 소스파일의 첫 번째 문장으로 단 한번 선언합니다.
- 같은 소스파일의 클래스들은 모두 같은 패키지에 속하게 됩니다.
- 패키지 선언이 없으면 이름없는 패키지에(default package) 속하게 됩니다.
    ```java
    package com.code.book;

    public class PackageTest {
        public static void main(String[] args) {
            System.out.println("Hello, World");
        }
    }
    ```
    - bin폴더 - 컴파일된 클래스 파일(*.class)이 있는 곳
        - CLI로 실행 시 bin 폴더까지 이동해야 하는데, 이러한 사항을 개선하기 위해 **classpath**가 존재합니다.
    - src폴더 - 소스 파일(*.java)이 있는 곳









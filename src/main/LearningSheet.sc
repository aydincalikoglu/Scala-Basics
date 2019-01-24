import java.lang
import java.lang.Math
import java.util.Date

import scala.language.postfixOps
import scala.util.Random


// ABOUT SCALA
// Multi paradigm programming
// design => express common programming patterns (concise elegant type-safe )
// Static Typing
// strict evaluation // can use lazy evaluation ( lazy val x )
// Run on JVM ( byte code )
// OOP, Dynamic features, Functional (concrence support)
// can use java code in scala
// Java patterns ( singleton(object) adapter(creates) decorator() visitor(matching) strategy(death in scala)
// Build tool => provide a facility to compile, run, test and package
// SBT ( Scala Build Tool ) ( the de facto build tool ) // Native support, REPL
// Compile Language
//Strong typing


/* Data Types
 Byte : 8 bit signed value. Range from -128 to 127
 Short : 16 bit signed value. Range -32768 to 32767
 Int : 32 bit signed value. Range -2147483648 to 2147483647
 Long : 64 bit signed value. -9223372036854775808 to 9223372036854775807
 Float : 32 bit IEEE 754 single-precision float
 Double : 64 bit IEEE 754 double-precision float
 Char : 16 bit signed Unicode character. Range from U+0000 to U+FFFF
 String : A sequence of Chars
 Boolean : Either the literal true or the literal false
 Unit: Corresponds to no value : void
 Null: null or empty reference
 Nothing : The subtype of every other type; includes no values
 Any: The supertype of any type; any object is of type Any : Java's Object class
 AnyRef: The supertype of any reference type
 */

// Worksheet ver.
// sbt : 1.2.8  && JDK 1.8 && Scala 2.12.8

// All Final int = ..
val a = 5 // type => value ( not change ) final or const we can say
var b = 4 // type => variable ( can change )


val i1:Int = 10
var i2 :Integer =1
val i3 = new Integer(5)

// a=5 Error => val type
b = 10

i1+i2
i1+i3
i2+i3

var maxByteNumber : Byte=127
var maxShortNumber : Short = 32767
var lognNumber = 1280000000000000000L
var doubleNum = 3.14
var flatNum : Float = 3.14F
var character:Char = 'c'
var found = true
var str = "String"
val valExp = { val a :Int = 10 ;  val b = 20 ; a+b} // last expression is return value

val valExpLine = {
  val a :Int = 10 ;
  val b = 20 ;
  a+b} // last expression is return value


2+5 // infix notation
5.+(3) // method add
2.-(2) // method sub

// lazy loading // on-demand loading
lazy val lazyLoadingValue = 20 ; // no in memory - initialized when its used - kullanılırsa hafıya yüklenecek

// String Interpolation
var price = 10
var priceType:String = " TL"
println("price : "+ price + priceType)
// s StringInterpolation
println(s"price : $price$priceType")
// f StringInterpolation
println(f"price : $price%f$priceType%s")

// IF STATEMENTS

if(price.equals(10)){
  print("Price is 10")
}

if(Random.nextInt()%2==0){
  "Even"
} else
  "Odd"

val ss = if(Random.nextInt()%2==0) "ssTrue" else "ssFalse"


// END IF STATEMENTS

// LOOPS
while (Random.nextInt()%2==0){
  println("run")
  price+=1
}

for(i <- 1 to 5){ // 1.until(5) -> print 1..4 // 1 until 5
  println(s"number:$i")
}


for(i <- 1 to 6; j <- 1.until(3)){
  println(s"numbers:$i $j")
}

val liste = List(1,2,5,10)
for(i <- liste){
  println(s"numbers:$i")
}
for(i <- liste ; if i < 8){
  println(s"numbers:$i")
}

val res = for(i <- liste
              if i < 8) yield {
  i * i
}
println(res)

// END OF LOOPS


// Match Expression
val valueMatch = 0

valueMatch match {
  case 10 => println("o10")
  case 20 => println("o20")
  case _ => println("default Value")
}

// Functions
def functionName(x:Int, y:Int):Int ={
  val returnValue=10
  println(returnValue)
  returnValue // Last Line be return value
}
println("func res: "+functionName(1,2))

// Full Applied func
def add(x:Int ,y:Int): Int = x+y
add(a,b)

// Class
object math{
  def add(x:Int ,y:Int): Int = x+y
  def sub(x:Int ,y:Int): Int = x-y
}
math.add(1,2)

println(a)

object demo{
  def +(x:Int ,y:Int): Int = x+y
  def **(x:Int): Int = x*x
}

val AFTestSquare = demo ** 10
val AFTestAdd = demo.+(10 , 10)

// Anonymous Functions
val sum = (x:Int ,y:Int) => x+y
sum(11,22)

// Higher Order Functions
def math(x:Double,y:Double,f:(Double,Double) => Double):Double = f(x,y)
var result = math(50,20,(x,y) => x min y )
def math2(x:Double,y:Double,z:Double,f:(Double,Double) => Double):Double = f(f(x,y),y)
result = math2(50,20,30, _+_ ) // _ max _
println(result)

// Partially Applied Functions
val sumPart = sum(20, _: Int)
sumPart(30)

def log(date : Date,message : String) ={
  println(date+" "+message)
}

val date = new Date()
val newLog = log(date,_:String)
newLog("this is message")

// Closures functions
// A closure is a function which uses one or more variables declared outside this function
// impure closure
var ten =  100
val add10 = (x:Int) => x + ten
def main()
{
  ten=10
  println(add10(5))
}
main()
// pure closure
val pten=10
val padd10 = (x:Int) => x + pten
def main2()
{
  // pten=10 can not change so pure
  println(padd10(5))
}
main2()

// Currying ( transforming a function that takes multiple argument into a function that takes single argument)

def addition(x:Int, y:Int) = x + y
def additionCurrying(x:Int) = (y:Int) => addition(x,y)
additionCurrying(10)(20)
val part1 = additionCurrying(10)
val part2 = part1(20)

def newAdditionCurryingFunc(x:Int) (y:Int)= x+y
//val p1 = newAdditionCurryingFunc(10) //  could not work
val p1 = newAdditionCurryingFunc(10)_
p1(20)
newAdditionCurryingFunc(10)(10)

// String
var str0:String="test"
str0.concat(" test")
printf("%s %f",str0,10.0f)

// Arrays
val arrStr:Array[String] = new Array[String](10)
val arrInt:Array[Int]=new Array[Int](10)
arrInt(0)=10
arrInt(9)=1
// arrInt(30) = 30 // ArrayIndexOutOfBoundsException

var f1 = for(i <- 0 until arrInt.length) yield{arrInt(i)}
var f2 = for(i <- arrInt) yield {i+i}


import Array._
concat(arrInt,arrInt)


// Lists
var newList:List[Int] = List(1,2,2,3,4,5)
var names :List[String] = List("a","b","c")
println(newList)
newList = 0::newList
println(newList)
println(Nil)
var intList = 1 :: 2 :: 3 :: 4 ::  Nil // Nill make them a list
var intListType:List[Int] = 1 :: 2 :: 3 :: 4 ::  Nil // Nill make them a list

var aList = 1 :: 2 :: 3 :: 4 :: "asd":: Nil
aList.head
aList.tail
aList.isEmpty
aList.reverse

List.fill(5)(2) // List(2, 2, 2, 2, 2)

// Streams
intList.max
intList.foreach(println)
var total = 0
intList.foreach(total += _ )

// Sets
          // cannot be dublicate value
          // All sets like being classic is immutable
// immutable set // object itself can not change inside it
var iSet:Set[Int] = Set(1,2,2,3,4,5,6,7,8,9)  // all values unique : Set(5, 1, 2, 3, 4)

var sSet :Set[String] = Set("a","b","c")

iSet + 10 // it self not change because immutable
iSet

// mutable set
var iSetMutable = scala.collection.mutable.Set(0,1,2,2,3,4,5)  // all values unique : Set(5, 1, 2, 3, 4)
iSetMutable + 10
iSetMutable

iSet(5) // it check 5 is present in list
iSet(0)
iSet.head // first element
iSet.tail // rest of the elements without head

iSet ++ (iSetMutable) // concat the sets // All element without duplicate
iSet & iSetMutable // common elements set
iSet intersect iSetMutable
iSet.max
iSet.min
iSet.foreach(println)
for (elem <- iSet) {

}

// Maps
val iiMap:Map[Int,Int] = Map(1->5,2->1)
// mutable

// immutable
val siMapGraduates: Map[String,Int] = Map("aydin"->100,"samet"->0)
val isMapIDProduct : Map[Int,String] = Map(1-> "ProductA",2->"ProductB")
println(isMapIDProduct)
println(isMapIDProduct(1))
println(isMapIDProduct.keys)
println(isMapIDProduct.values)
isMapIDProduct.foreach(key => println(key))
isMapIDProduct.contains(1)

isMapIDProduct.filter(element => element._1.equals(1) || element._2.equalsIgnoreCase("productA"))

isMapIDProduct ++ siMapGraduates // concat maps





// Tuples
val aTuple = (1, 2, "Hello", true)
aTuple._1

val a4Tuple = new Tuple4(1, 2, "Hello", true)
val a3Tuple = new Tuple3(1, 2, "Hello")
a3Tuple._3
a3Tuple.productIterator.foreach {
  i => println(i)
}

println(1 -> "tuple" -> 3)


// Options (Some or None)
var opt : Option[Int] = None
println(opt.isEmpty)
println(opt.isDefined)

var listOptionTest: List[Int] = List(1, 2, 3, 5, 22, 11)
listOptionTest.find(_ > 6)
listOptionTest.find(_ > 6).get
listOptionTest.find(_ > 6).isEmpty

var mapOptionTest: Map[Int, String] = Map(1 -> "PA", 2 -> "PB")
mapOptionTest.get(2)
mapOptionTest.get(2).get
mapOptionTest.get(5).isDefined
mapOptionTest.get(5).getOrElse("Not Element")

// Higher Order Methods flatMap, flatten, filter
var listHO: List[Int] = List(1, 2, 3, 5, 22, 11)
var mapHO: Map[Int, String] = Map(1 -> "PA", 2 -> "PB")
listHO.map(_ * 2) // make all element 2x
listHO.map(x => x*2)
listHO.map(x => "2X:"+x*2)
listHO.map(x => "hi"*x)
listHO.map(x=> "hi:"+x)
mapHO.mapValues(x=> x+"x")
"Hello".map(_ + "x")
"Hello".map(_.toUpper)

var listOfLists = List(List(1,2,3,4,5),List(4,5,6,7,8))
listOfLists.flatten

listHO.map(t => List(t,t+1))
listHO.flatMap(t => List(t,t+1))

listOfLists.flatten.filter(_ equals 4)
listOfLists.flatten.filter(x=>  x>4)
listOfLists.flatten.filter(_ > 4)


// Reduce - Fold - Scan (Left-Right)
var completeList:List[Int] = listOfLists.flatten
var listStr = mapHO.map(_._2)
completeList.reduceRight(_ + _)

completeList

// left right same for addition
completeList.reduceLeft(_ + _)
completeList.reduceRight(_ + _)

completeList.reduceLeft(_ - _)
completeList.reduceRight(_ - _)

// with start value
completeList.foldLeft(100)(_ + _)

// list of results
completeList.scanLeft(1)(_ + _)
listStr.scanLeft("new")(_ + _)

completeList.reduceLeft((x,y) => {println(s"$x , $y"); x+y;})
completeList.reduceRight((x,y) => {println(s"$x , $y"); x+y;})

completeList.foldLeft(3)((x,y) => {println(s"$x , $y"); x+y;})
completeList.scanLeft(1)((x,y) => {println(s"$x , $y"); x+y;})


// Classes (default var val private ) ( Objects are singleton ) classes give  us to create object

// Case Classes
// not inheritable
// can make a copy
// use if class is immutable
case class CaseClass(name:String,age:Int)
var caseClass = new CaseClass("a",1)
caseClass.name
println(caseClass)
var newCaseClass = caseClass.copy(name = "newName")
newCaseClass
caseClass


// default members
class UserClassMemberErr(name:String,age:Int) // No member name and age // specific member inside the class to use

// Primary constructor Class // variable members
class User(var name:String, var age:Int)

var userA = new User("Aydin",24)
var userB = new User("Samet",22)

userA.name
userA.name="newName"
userA.name
userB.name

// value members // not change outside
class UserConst(val name:String, val age:Int)
var userConstA = new User("Aydin",24)
userConstA.name
//userConstA.name="asd" // Error

class UserPrivate(private var name:String, age:Int){
  var fieldA:String=""
  def getName = {name}
  def printAge = { println(age) }
}


var userPrivateA = new UserPrivate("Aydin",24)
userPrivateA.getName
//userPrivateA.printAge

userPrivateA.fieldA


// Auxiliary Constructor
class UserConstructorClass(var name:String, var age:Int){
  def this(){
    this("Tom",10)
  }
  def this(name : String){
    this(name,10)
  }
}
new UserConstructorClass("A",0)
new UserConstructorClass()
new UserConstructorClass("A")



// Class Inheritance // extents

class Shape(){
  def area :Double = 0.0
  def printArea(){println(area)}
}

(new Shape).area
(new Shape).printArea()

class Triangle(x:Int,y:Int) extends Shape {
  override def area=x*y/2
}

class Rectangle(x:Int,y:Int) extends Shape {
  override def area=x*y
}

var triangleShape:Shape=new Triangle(10,20)
triangleShape.area

var rectangleShape:Shape=new Rectangle(10,20)
rectangleShape.area




// Abstract Class ( private class - protected class )
abstract class ShapeAbstact{
  def area:Double;
  def printArea(){println(area)}
}

class RectangleWithAbstruct(x:Int,y:Int) extends ShapeAbstact {
  override def area=x*y
}
new RectangleWithAbstruct(10,10).printArea()



// Trait // for multiple inheritance use trait with "with" // Note: Can not gave same method Names
trait Color{
  def color:String;
}
class TriangleWithTrait(x:Int,y:Int) extends ShapeAbstact with Color {
  override def area=x*y
  override def color = "blue"
}
// val colorTriangle:Color = new TriangleWithTrait(10,10).printArea() // not work
new TriangleWithTrait(10,10).color




// Lazy Evaluation
def method1(n:Int): Unit ={
  println("m1")
  println(n)
}
def method2(n: => Int): Unit ={ // Lazy one
  println("m2")
  println(n)
}

method1(1)
method2(2)


// require = Asset // not true throw illegalArgumentException
require(5<3) // IllegalArgumentException: requirement failed


/* Notes - Software development career
-- Learn at least one new language every year
-- Read a technical book each quarter
-- Read non-technival also
-- Take Classes
-- Participate in local groups or events
  ( software development events, speakers about it they experts on their domains ) ( attending them broaden your mind and language)

-- Continuous Integration
  tool : jenkins - test, compile, deploy, handle life cycles
  Travis CI
  Gitlab CI
-- Project management
   agile, scrum  etc. -> tool :Jira etc.
-- Version Control
   Github, BitBucket

Text Editor
  Intellij idea, Atom, Sublime



Why functional programming ?
naming variable
usability
off-by-one error

actually
its complexity
 */


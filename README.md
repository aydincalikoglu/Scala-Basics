# ScalaStarterProject

<p class="has-line-data" data-line-start="1" data-line-end="14">// ABOUT SCALA<br>
// Multi paradigm programming<br>
// design =&gt; express common programming patterns (concise elegant type-safe )<br>
// Static Typing<br>
// strict evaluation // can use lazy evaluation ( lazy val x )<br>
// Run on JVM ( byte code )<br>
// OOP, Dynamic features, Functional (concrence support)<br>
// can use java code in scala<br>
// Java patterns ( singleton(object) adapter(creates) decorator() visitor(matching) strategy(death in scala)<br>
// Build tool =&gt; provide a facility to compile, run, test and package<br>
// SBT ( Scala Build Tool ) ( the de facto build tool ) // Native support, REPL<br>
// Compile Language<br>
//Strong typing</p>
<p class="has-line-data" data-line-start="16" data-line-end="32">/* Data Types<br>
Byte : 8 bit signed value. Range from -128 to 127<br>
Short : 16 bit signed value. Range -32768 to 32767<br>
Int : 32 bit signed value. Range -2147483648 to 2147483647<br>
Long : 64 bit signed value. -9223372036854775808 to 9223372036854775807<br>
Float : 32 bit IEEE 754 single-precision float<br>
Double : 64 bit IEEE 754 double-precision float<br>
Char : 16 bit signed Unicode character. Range from U+0000 to U+FFFF<br>
String : A sequence of Chars<br>
Boolean : Either the literal true or the literal false<br>
Unit: Corresponds to no value : void<br>
Null: null or empty reference<br>
Nothing : The subtype of every other type; includes no values<br>
Any: The supertype of any type; any object is of type Any : Java’s Object class<br>
AnyRef: The supertype of any reference type<br>
*/</p>
<p class="has-line-data" data-line-start="33" data-line-end="35">// Worksheet ver.<br>
// sbt : 1.2.8  &amp;&amp; JDK 1.8 &amp;&amp; Scala 2.12.8</p>
<p class="has-line-data" data-line-start="36" data-line-end="39">// All Final int = …<br>
val a = 5 // type =&gt; value ( not change ) final or const we can say<br>
var b = 4 // type =&gt; variable ( can change )</p>
<p class="has-line-data" data-line-start="41" data-line-end="44">val i1:Int = 10<br>
var i2 :Integer =1<br>
val i3 = new Integer(5)</p>
<p class="has-line-data" data-line-start="45" data-line-end="47">// a=5 Error =&gt; val type<br>
b = 10</p>
<p class="has-line-data" data-line-start="48" data-line-end="51">i1+i2<br>
i1+i3<br>
i2+i3</p>
<p class="has-line-data" data-line-start="52" data-line-end="61">var maxByteNumber : Byte=127<br>
var maxShortNumber : Short = 32767<br>
var lognNumber = 1280000000000000000L<br>
var doubleNum = 3.14<br>
var flatNum : Float = 3.14F<br>
var character:Char = ‘c’<br>
var found = true<br>
var str = “String”<br>
val valExp = { val a :Int = 10 ;  val b = 20 ; a+b} // last expression is return value</p>
<p class="has-line-data" data-line-start="62" data-line-end="66">val valExpLine = {<br>
val a :Int = 10 ;<br>
val b = 20 ;<br>
a+b} // last expression is return value</p>
<p class="has-line-data" data-line-start="68" data-line-end="71">2+5 // infix notation<br>
5.+(3) // method add<br>
2.-(2) // method sub</p>
<p class="has-line-data" data-line-start="72" data-line-end="74">// lazy loading // on-demand loading<br>
lazy val lazyLoadingValue = 20 ; // no in memory - initialized when its used - kullanılırsa hafıya yüklenecek</p>
<p class="has-line-data" data-line-start="75" data-line-end="83">// String Interpolation<br>
var price = 10<br>
var priceType:String = &quot; TL&quot;<br>
println(“price : “+ price + priceType)<br>
// s StringInterpolation<br>
println(s&quot;price : $price$priceType”)<br>
// f StringInterpolation<br>
println(f&quot;price : $price%f$priceType%s”)</p>
<p class="has-line-data" data-line-start="84" data-line-end="85">// IF STATEMENTS</p>
<p class="has-line-data" data-line-start="86" data-line-end="89">if(price.equals(10)){<br>
print(“Price is 10”)<br>
}</p>
<p class="has-line-data" data-line-start="90" data-line-end="94">if(Random.nextInt()%2==0){<br>
“Even”<br>
} else<br>
“Odd”</p>
<p class="has-line-data" data-line-start="95" data-line-end="96">val ss = if(Random.nextInt()%2==0) “ssTrue” else “ssFalse”</p>
<p class="has-line-data" data-line-start="98" data-line-end="99">// END IF STATEMENTS</p>
<p class="has-line-data" data-line-start="100" data-line-end="105">// LOOPS<br>
while (Random.nextInt()%2==0){<br>
println(“run”)<br>
price+=1<br>
}</p>
<p class="has-line-data" data-line-start="106" data-line-end="109">for(i &lt;- 1 to 5){ // 1.until(5) -&gt; print 1…4 // 1 until 5<br>
println(s&quot;number:$i&quot;)<br>
}</p>
<p class="has-line-data" data-line-start="111" data-line-end="114">for(i &lt;- 1 to 6; j &lt;- 1.until(3)){<br>
println(s&quot;numbers:$i $j&quot;)<br>
}</p>
<p class="has-line-data" data-line-start="115" data-line-end="122">val liste = List(1,2,5,10)<br>
for(i &lt;- liste){<br>
println(s&quot;numbers:$i&quot;)<br>
}<br>
for(i &lt;- liste ; if i &lt; 8){<br>
println(s&quot;numbers:$i&quot;)<br>
}</p>
<p class="has-line-data" data-line-start="123" data-line-end="128">val res = for(i &lt;- liste<br>
if i &lt; 8) yield {<br>
i * i<br>
}<br>
println(res)</p>
<p class="has-line-data" data-line-start="129" data-line-end="130">// END OF LOOPS</p>
<p class="has-line-data" data-line-start="132" data-line-end="134">// Match Expression<br>
val valueMatch = 0</p>
<p class="has-line-data" data-line-start="135" data-line-end="140">valueMatch match {<br>
case 10 =&gt; println(“o10”)<br>
case 20 =&gt; println(“o20”)<br>
case _ =&gt; println(“default Value”)<br>
}</p>
<p class="has-line-data" data-line-start="141" data-line-end="148">// Functions<br>
def functionName(x:Int, y:Int):Int ={<br>
val returnValue=10<br>
println(returnValue)<br>
returnValue // Last Line be return value<br>
}<br>
println(&quot;func res: &quot;+functionName(1,2))</p>
<p class="has-line-data" data-line-start="149" data-line-end="152">// Full Applied func<br>
def add(x:Int ,y:Int): Int = x+y<br>
add(a,b)</p>
<p class="has-line-data" data-line-start="153" data-line-end="159">// Class<br>
object math{<br>
def add(x:Int ,y:Int): Int = x+y<br>
def sub(x:Int ,y:Int): Int = x-y<br>
}<br>
math.add(1,2)</p>
<p class="has-line-data" data-line-start="160" data-line-end="161">println(a)</p>
<p class="has-line-data" data-line-start="162" data-line-end="166">object demo{<br>
def +(x:Int ,y:Int): Int = x+y<br>
def *<em>(x:Int): Int = x</em>x<br>
}</p>
<p class="has-line-data" data-line-start="167" data-line-end="169">val AFTestSquare = demo ** 10<br>
val AFTestAdd = demo.+(10 , 10)</p>
<p class="has-line-data" data-line-start="170" data-line-end="173">// Anonymous Functions<br>
val sum = (x:Int ,y:Int) =&gt; x+y<br>
sum(11,22)</p>
<p class="has-line-data" data-line-start="174" data-line-end="180">// Higher Order Functions<br>
def math(x:Double,y:Double,f:(Double,Double) =&gt; Double):Double = f(x,y)<br>
var result = math(50,20,(x,y) =&gt; x min y )<br>
def math2(x:Double,y:Double,z:Double,f:(Double,Double) =&gt; Double):Double = f(f(x,y),y)<br>
result = math2(50,20,30, <em>+</em> ) // _ max _<br>
println(result)</p>
<p class="has-line-data" data-line-start="181" data-line-end="184">// Partially Applied Functions<br>
val sumPart = sum(20, _: Int)<br>
sumPart(30)</p>
<p class="has-line-data" data-line-start="185" data-line-end="188">def log(date : Date,message : String) ={<br>
println(date+&quot; &quot;+message)<br>
}</p>
<p class="has-line-data" data-line-start="189" data-line-end="192">val date = new Date()<br>
val newLog = log(date,_:String)<br>
newLog(“this is message”)</p>
<p class="has-line-data" data-line-start="193" data-line-end="213">// Closures functions<br>
// A closure is a function which uses one or more variables declared outside this function<br>
// impure closure<br>
var ten =  100<br>
val add10 = (x:Int) =&gt; x + ten<br>
def main()<br>
{<br>
ten=10<br>
println(add10(5))<br>
}<br>
main()<br>
// pure closure<br>
val pten=10<br>
val padd10 = (x:Int) =&gt; x + pten<br>
def main2()<br>
{<br>
// pten=10 can not change so pure<br>
println(padd10(5))<br>
}<br>
main2()</p>
<p class="has-line-data" data-line-start="214" data-line-end="215">// Currying ( transforming a function that takes multiple argument into a function that takes single argument)</p>
<p class="has-line-data" data-line-start="216" data-line-end="221">def addition(x:Int, y:Int) = x + y<br>
def additionCurrying(x:Int) = (y:Int) =&gt; addition(x,y)<br>
additionCurrying(10)(20)<br>
val part1 = additionCurrying(10)<br>
val part2 = part1(20)</p>
<p class="has-line-data" data-line-start="222" data-line-end="227">def newAdditionCurryingFunc(x:Int) (y:Int)= x+y<br>
//val p1 = newAdditionCurryingFunc(10) //  could not work<br>
val p1 = newAdditionCurryingFunc(10)_<br>
p1(20)<br>
newAdditionCurryingFunc(10)(10)</p>
<p class="has-line-data" data-line-start="228" data-line-end="232">// String<br>
var str0:String=“test”<br>
str0.concat(&quot; test&quot;)<br>
printf(&quot;%s %f&quot;,str0,10.0f)</p>
<p class="has-line-data" data-line-start="233" data-line-end="239">// Arrays<br>
val arrStr:Array[String] = new Array<a href="10">String</a><br>
val arrInt:Array[Int]=new Array<a href="10">Int</a><br>
arrInt(0)=10<br>
arrInt(9)=1<br>
// arrInt(30) = 30 // ArrayIndexOutOfBoundsException</p>
<p class="has-line-data" data-line-start="240" data-line-end="242">var f1 = for(i &lt;- 0 until arrInt.length) yield{arrInt(i)}<br>
var f2 = for(i &lt;- arrInt) yield {i+i}</p>
<p class="has-line-data" data-line-start="244" data-line-end="246">import Array._<br>
concat(arrInt,arrInt)</p>
<p class="has-line-data" data-line-start="248" data-line-end="257">// Lists<br>
var newList:List[Int] = List(1,2,2,3,4,5)<br>
var names :List[String] = List(“a”,“b”,“c”)<br>
println(newList)<br>
newList = 0::newList<br>
println(newList)<br>
println(Nil)<br>
var intList = 1 :: 2 :: 3 :: 4 ::  Nil // Nill make them a list<br>
var intListType:List[Int] = 1 :: 2 :: 3 :: 4 ::  Nil // Nill make them a list</p>
<p class="has-line-data" data-line-start="258" data-line-end="263">var aList = 1 :: 2 :: 3 :: 4 :: “asd”:: Nil<br>
aList.head<br>
aList.tail<br>
aList.isEmpty<br>
aList.reverse</p>
<p class="has-line-data" data-line-start="264" data-line-end="265">List.fill(5)(2) // List(2, 2, 2, 2, 2)</p>
<p class="has-line-data" data-line-start="266" data-line-end="271">// Streams<br>
intList.max<br>
intList.foreach(println)<br>
var total = 0<br>
intList.foreach(total += _ )</p>
<p class="has-line-data" data-line-start="272" data-line-end="277">// Sets<br>
// cannot be dublicate value<br>
// All sets like being classic is immutable<br>
// immutable set // object itself can not change inside it<br>
var iSet:Set[Int] = Set(1,2,2,3,4,5,6,7,8,9)  // all values unique : Set(5, 1, 2, 3, 4)</p>
<p class="has-line-data" data-line-start="278" data-line-end="279">var sSet :Set[String] = Set(“a”,“b”,“c”)</p>
<p class="has-line-data" data-line-start="280" data-line-end="282">iSet + 10 // it self not change because immutable<br>
iSet</p>
<p class="has-line-data" data-line-start="283" data-line-end="287">// mutable set<br>
var iSetMutable = scala.collection.mutable.Set(0,1,2,2,3,4,5)  // all values unique : Set(5, 1, 2, 3, 4)<br>
iSetMutable + 10<br>
iSetMutable</p>
<p class="has-line-data" data-line-start="288" data-line-end="292">iSet(5) // it check 5 is present in list<br>
iSet(0)<br>
iSet.head // first element<br>
iSet.tail // rest of the elements without head</p>
<p class="has-line-data" data-line-start="293" data-line-end="300">iSet ++ (iSetMutable) // concat the sets // All element without duplicate<br>
iSet &amp; iSetMutable // common elements set<br>
iSet intersect iSetMutable<br>
iSet.max<br>
iSet.min<br>
iSet.foreach(println)<br>
for (elem &lt;- iSet) {</p>
<p class="has-line-data" data-line-start="301" data-line-end="302">}</p>
<p class="has-line-data" data-line-start="303" data-line-end="306">// Maps<br>
val iiMap:Map[Int,Int] = Map(1-&gt;5,2-&gt;1)<br>
// mutable</p>
<p class="has-line-data" data-line-start="307" data-line-end="316">// immutable<br>
val siMapGraduates: Map[String,Int] = Map(“aydin”-&gt;100,“samet”-&gt;0)<br>
val isMapIDProduct : Map[Int,String] = Map(1-&gt; “ProductA”,2-&gt;“ProductB”)<br>
println(isMapIDProduct)<br>
println(isMapIDProduct(1))<br>
println(isMapIDProduct.keys)<br>
println(isMapIDProduct.values)<br>
isMapIDProduct.foreach(key =&gt; println(key))<br>
isMapIDProduct.contains(1)</p>
<p class="has-line-data" data-line-start="317" data-line-end="318">isMapIDProduct.filter(element =&gt; element._1.equals(1) || element._2.equalsIgnoreCase(“productA”))</p>
<p class="has-line-data" data-line-start="319" data-line-end="320">isMapIDProduct ++ siMapGraduates // concat maps</p>
<p class="has-line-data" data-line-start="325" data-line-end="328">// Tuples<br>
val aTuple = (1, 2, “Hello”, true)<br>
aTuple._1</p>
<p class="has-line-data" data-line-start="329" data-line-end="335">val a4Tuple = new Tuple4(1, 2, “Hello”, true)<br>
val a3Tuple = new Tuple3(1, 2, “Hello”)<br>
a3Tuple._3<br>
a3Tuple.productIterator.foreach {<br>
i =&gt; println(i)<br>
}</p>
<p class="has-line-data" data-line-start="336" data-line-end="337">println(1 -&gt; “tuple” -&gt; 3)</p>
<p class="has-line-data" data-line-start="339" data-line-end="343">// Options (Some or None)<br>
var opt : Option[Int] = None<br>
println(opt.isEmpty)<br>
println(opt.isDefined)</p>
<p class="has-line-data" data-line-start="344" data-line-end="348">var listOptionTest: List[Int] = List(1, 2, 3, 5, 22, 11)<br>
listOptionTest.find(_ &gt; 6)<br>
listOptionTest.find(_ &gt; 6).get<br>
listOptionTest.find(_ &gt; 6).isEmpty</p>
<p class="has-line-data" data-line-start="349" data-line-end="354">var mapOptionTest: Map[Int, String] = Map(1 -&gt; “PA”, 2 -&gt; “PB”)<br>
mapOptionTest.get(2)<br>
mapOptionTest.get(2).get<br>
mapOptionTest.get(5).isDefined<br>
mapOptionTest.get(5).getOrElse(“Not Element”)</p>
<p class="has-line-data" data-line-start="355" data-line-end="366">// Higher Order Methods flatMap, flatten, filter<br>
var listHO: List[Int] = List(1, 2, 3, 5, 22, 11)<br>
var mapHO: Map[Int, String] = Map(1 -&gt; “PA”, 2 -&gt; “PB”)<br>
listHO.map(_ * 2) // make all element 2x<br>
listHO.map(x =&gt; x<em>2)<br>
listHO.map(x =&gt; “2X:”+x</em>2)<br>
listHO.map(x =&gt; “hi”*x)<br>
listHO.map(x=&gt; “hi:”+x)<br>
mapHO.mapValues(x=&gt; x+“x”)<br>
“Hello”.map(_ + “x”)<br>
“Hello”.map(_.toUpper)</p>
<p class="has-line-data" data-line-start="367" data-line-end="369">var listOfLists = List(List(1,2,3,4,5),List(4,5,6,7,8))<br>
listOfLists.flatten</p>
<p class="has-line-data" data-line-start="370" data-line-end="372">listHO.map(t =&gt; List(t,t+1))<br>
listHO.flatMap(t =&gt; List(t,t+1))</p>
<p class="has-line-data" data-line-start="373" data-line-end="376">listOfLists.flatten.filter(_ equals 4)<br>
listOfLists.flatten.filter(x=&gt;  x&gt;4)<br>
listOfLists.flatten.filter(_ &gt; 4)</p>
<p class="has-line-data" data-line-start="378" data-line-end="382">// Reduce - Fold - Scan (Left-Right)<br>
var completeList:List[Int] = listOfLists.flatten<br>
var listStr = mapHO.map(_.<em>2)<br>
completeList.reduceRight(</em> + _)</p>
<p class="has-line-data" data-line-start="383" data-line-end="384">completeList</p>
<p class="has-line-data" data-line-start="385" data-line-end="388">// left right same for addition<br>
completeList.reduceLeft(_ + <em>)<br>
completeList.reduceRight(</em> + _)</p>
<p class="has-line-data" data-line-start="389" data-line-end="391">completeList.reduceLeft(_ - <em>)<br>
completeList.reduceRight(</em> - _)</p>
<p class="has-line-data" data-line-start="392" data-line-end="394">// with start value<br>
completeList.foldLeft(100)(_ + _)</p>
<p class="has-line-data" data-line-start="395" data-line-end="398">// list of results<br>
completeList.scanLeft(1)(_ + <em>)<br>
listStr.scanLeft(“new”)(</em> + _)</p>
<p class="has-line-data" data-line-start="399" data-line-end="401">completeList.reduceLeft((x,y) =&gt; {println(s&quot;$x , $y&quot;); x+y;})<br>
completeList.reduceRight((x,y) =&gt; {println(s&quot;$x , $y&quot;); x+y;})</p>
<p class="has-line-data" data-line-start="402" data-line-end="404">completeList.foldLeft(3)((x,y) =&gt; {println(s&quot;$x , $y&quot;); x+y;})<br>
completeList.scanLeft(1)((x,y) =&gt; {println(s&quot;$x , $y&quot;); x+y;})</p>
<p class="has-line-data" data-line-start="406" data-line-end="407">// Classes (default var val private ) ( Objects are singleton ) classes give  us to create object</p>
<p class="has-line-data" data-line-start="408" data-line-end="419">// Case Classes<br>
// not inheritable<br>
// can make a copy<br>
// use if class is immutable<br>
case class CaseClass(name:String,age:Int)<br>
var caseClass = new CaseClass(“a”,1)<br>
<a href="http://caseClass.name">caseClass.name</a><br>
println(caseClass)<br>
var newCaseClass = caseClass.copy(name = “newName”)<br>
newCaseClass<br>
caseClass</p>
<p class="has-line-data" data-line-start="421" data-line-end="423">// default members<br>
class UserClassMemberErr(name:String,age:Int) // No member name and age // specific member inside the class to use</p>
<p class="has-line-data" data-line-start="424" data-line-end="426">// Primary constructor Class // variable members<br>
class User(var name:String, var age:Int)</p>
<p class="has-line-data" data-line-start="427" data-line-end="429">var userA = new User(“Aydin”,24)<br>
var userB = new User(“Samet”,22)</p>
<p class="has-line-data" data-line-start="430" data-line-end="434"><a href="http://userA.name">userA.name</a><br>
userA.name=“newName”<br>
<a href="http://userA.name">userA.name</a><br>
<a href="http://userB.name">userB.name</a></p>
<p class="has-line-data" data-line-start="435" data-line-end="440">// value members // not change outside<br>
class UserConst(val name:String, val age:Int)<br>
var userConstA = new User(“Aydin”,24)<br>
<a href="http://userConstA.name">userConstA.name</a><br>
<a href="//userConstA.name=">//userConstA.name=</a>“asd” // Error</p>
<p class="has-line-data" data-line-start="441" data-line-end="446">class UserPrivate(private var name:String, age:Int){<br>
var fieldA:String=&quot;&quot;<br>
def getName = {name}<br>
def printAge = { println(age) }<br>
}</p>
<p class="has-line-data" data-line-start="448" data-line-end="451">var userPrivateA = new UserPrivate(“Aydin”,24)<br>
userPrivateA.getName<br>
<a href="//userPrivateA.printAge">//userPrivateA.printAge</a></p>
<p class="has-line-data" data-line-start="452" data-line-end="453">userPrivateA.fieldA</p>
<p class="has-line-data" data-line-start="455" data-line-end="467">// Auxiliary Constructor<br>
class UserConstructorClass(var name:String, var age:Int){<br>
def this(){<br>
this(“Tom”,10)<br>
}<br>
def this(name : String){<br>
this(name,10)<br>
}<br>
}<br>
new UserConstructorClass(“A”,0)<br>
new UserConstructorClass()<br>
new UserConstructorClass(“A”)</p>
<p class="has-line-data" data-line-start="470" data-line-end="471">// Class Inheritance // extents</p>
<p class="has-line-data" data-line-start="472" data-line-end="476">class Shape(){<br>
def area :Double = 0.0<br>
def printArea(){println(area)}<br>
}</p>
<p class="has-line-data" data-line-start="477" data-line-end="479">(new Shape).area<br>
(new Shape).printArea()</p>
<p class="has-line-data" data-line-start="480" data-line-end="483">class Triangle(x:Int,y:Int) extends Shape {<br>
override def area=x*y/2<br>
}</p>
<p class="has-line-data" data-line-start="484" data-line-end="487">class Rectangle(x:Int,y:Int) extends Shape {<br>
override def area=x*y<br>
}</p>
<p class="has-line-data" data-line-start="488" data-line-end="490">var triangleShape:Shape=new Triangle(10,20)<br>
triangleShape.area</p>
<p class="has-line-data" data-line-start="491" data-line-end="493">var rectangleShape:Shape=new Rectangle(10,20)<br>
rectangleShape.area</p>
<p class="has-line-data" data-line-start="497" data-line-end="502">// Abstract Class ( private class - protected class )<br>
abstract class ShapeAbstact{<br>
def area:Double;<br>
def printArea(){println(area)}<br>
}</p>
<p class="has-line-data" data-line-start="503" data-line-end="507">class RectangleWithAbstruct(x:Int,y:Int) extends ShapeAbstact {<br>
override def area=x*y<br>
}<br>
new RectangleWithAbstruct(10,10).printArea()</p>
<p class="has-line-data" data-line-start="510" data-line-end="520">// Trait // for multiple inheritance use trait with “with” // Note: Can not gave same method Names<br>
trait Color{<br>
def color:String;<br>
}<br>
class TriangleWithTrait(x:Int,y:Int) extends ShapeAbstact with Color {<br>
override def area=x*y<br>
override def color = “blue”<br>
}<br>
// val colorTriangle:Color = new TriangleWithTrait(10,10).printArea() // not work<br>
new TriangleWithTrait(10,10).color</p>
<p class="has-line-data" data-line-start="524" data-line-end="533">// Lazy Evaluation<br>
def method1(n:Int): Unit ={<br>
println(“m1”)<br>
println(n)<br>
}<br>
def method2(n: =&gt; Int): Unit ={ // Lazy one<br>
println(“m2”)<br>
println(n)<br>
}</p>
<p class="has-line-data" data-line-start="534" data-line-end="536">method1(1)<br>
method2(2)</p>
<p class="has-line-data" data-line-start="538" data-line-end="540">// require = Asset // not true throw illegalArgumentException<br>
require(5&lt;3) // IllegalArgumentException: requirement failed</p>
<p class="has-line-data" data-line-start="542" data-line-end="549">/* Notes - Software development career<br>
– Learn at least one new language every year<br>
– Read a technical book each quarter<br>
– Read non-technival also<br>
– Take Classes<br>
– Participate in local groups or events<br>
( software development events, speakers about it they experts on their domains ) ( attending them broaden your mind and language)</p>
<p class="has-line-data" data-line-start="550" data-line-end="558">– Continuous Integration<br>
tool : jenkins - test, compile, deploy, handle life cycles<br>
Travis CI<br>
Gitlab CI<br>
– Project management<br>
agile, scrum  etc. -&gt; tool :Jira etc.<br>
– Version Control<br>
Github, BitBucket</p>
<p class="has-line-data" data-line-start="559" data-line-end="561">Text Editor<br>
Intellij idea, Atom, Sublime</p>
<p class="has-line-data" data-line-start="564" data-line-end="568">Why functional programming ?<br>
naming variable<br>
usability<br>
off-by-one error</p>
<p class="has-line-data" data-line-start="569" data-line-end="572">actually<br>
its complexity<br>
*/</p>

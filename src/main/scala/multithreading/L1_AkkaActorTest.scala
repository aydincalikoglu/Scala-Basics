import akka.actor.{Actor, ActorRef, ActorSystem, Props}

// Void actors


class Player(val name:String) extends Actor {
  def this(name: Int) = this(name.toString)
  override def receive: Receive = {
    case s:String => println("String: "+s +" "+name)
    case i:Int => println("Int: "+i+" "+name)
    case any:Any => println("Wrong Type : " + any.getClass.toString)
  }
  def foo = println("Normally"+" "+name) // can not usa outside of class
  override def toString() = name
}

class TestCase(val name:String)


object Player{
  def props(name:String):Props=Props(new Player("YourName"))
  def props(name:Int):Props=Props(new Player(name))
}

object AkkaTest {
  def main(args: Array[String]): Unit = {
    println("Begin")
    //var player = .new Player("asd") // Can not create an object of Actor
    var testCase= new TestCase("test")

    val PlayerSystem = ActorSystem(name = "PlayerSystem")
    var p0 = PlayerSystem.actorOf(Props(new Player("Tester")))
    var p1 = PlayerSystem.actorOf(Player.props("YourName"))
    var p2 = PlayerSystem.actorOf(Player.props(2))
    var p3 = PlayerSystem.actorOf(Props(classOf[Player],3))
    p1 ! "hi there"
    p3 ! 42
    p0 ! 55
    p0 ! 'a'
    p0 ! testCase

    PlayerSystem.terminate()


  }
}

package multithreading

import akka.actor.SupervisorStrategy.{Restart, Resume, Stop}
import akka.actor.{Actor, ActorSystem, OneForOneStrategy, Props}
import akka.dispatch.sysmsg.Terminate

object L5_ActorSupervision {


  case object CreateChildActor

  case class SignalChildren(val message:String)

  case class PrintSignal(val message:String)

  case class divide(s1: Double,s2: Double)

  class ParentActor(val name: String) extends Actor {
    private var number = 0

    override def receive: Receive = {
      case CreateChildActor =>
        val act = context.actorOf(Props[ChildActor], "child_" + number)
        number += 1
        println("CreateChild: "+act)
      case SignalChildren(message:String) =>
        println("Parent : "+message)
        context.children.foreach(_ ! PrintSignal(message))
      case any: Any => println("Wrong Type : " + any.getClass.toString)
    }
    //supervisorStrategy = OneForOneStrategy
    // https://doc.akka.io/api/akka/2.4.1/#package
    override val supervisorStrategy = OneForOneStrategy(loggingEnabled = false ){
      case ex:ArithmeticException =>
        println("aeResume")
        Resume
      case ex:ArrayIndexOutOfBoundsException =>
        println("aRestart")
        Restart
      case ex:Exception =>
        println("eStop")
        Stop
    }

    override def preStart(): Unit = {
      super.preStart()
      println("example : open database connection")
    }

    override def postStop(): Unit = {
      super.postStop()
      println("example : close database connection")
    }

    override def preRestart(reason: Throwable, message: Option[Any]): Unit = {
      println("preRestart")
      super.preRestart(reason, message)
    }
    override def postRestart(reason: Throwable): Unit = {
      println("postRestart")
      super.postRestart(reason)

    }
  }



  class ChildActor(val name: String) extends Actor {
    def this() = { this("Default") }
    override def receive: Receive = {
      case PrintSignal(message:String) =>
        println("Child message : "+message)
        println("printSignal: "+self)
      case divide(s1: Double,s2: Double) => s1/s2
      case testExp:ArithmeticException => throw testExp
      case ex:ArrayIndexOutOfBoundsException => throw ex
      case testExp:Exception => throw testExp
      case any: Any => println("Wrong Type :: " + any.getClass.toString)
    }
  }

  def main(args: Array[String]): Unit = {
    println("Begin")

    val actorSystem = ActorSystem(name = "actorSystem")
    var parentActor = actorSystem.actorOf(Props(new ParentActor("ParentActor")))
    var parentActor2 = actorSystem.actorOf(Props(new ParentActor("ParentActor2")))
    parentActor ! CreateChildActor
    parentActor ! CreateChildActor

    val child0 = actorSystem.actorSelection("akka://actorSystem/user/$a/child_0")
    child0 ! PrintSignal("asd")
    child0 ! divide(1,2)
    child0 ! new ArithmeticException
    child0 ! new ArrayIndexOutOfBoundsException
    child0 ! new Exception
    Thread.sleep(1000)

    actorSystem.terminate()
  }
}

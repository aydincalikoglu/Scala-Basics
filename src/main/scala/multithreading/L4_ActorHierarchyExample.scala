package multithreading

import akka.actor.SupervisorStrategy.{Restart, Resume, Stop}
import akka.actor.{Actor, ActorRef, ActorSystem, OneForOneStrategy, Props}

/**
  * Actor of actors to have it made operation
  */
object ActorHierarchyExample {

  case object CreateChildActor

  case class SignalChildren(val message:String)

  case class PrintSignal(val message:String)

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
  }

  class ChildActor(val name: String) extends Actor {
    def this() = { this("Default") }
    override def receive: Receive = {
      case PrintSignal(message:String) =>
        println("Child message : "+message)
        println("printSignal: "+self)
      case any: Any => println("Wrong Type :: " + any.getClass.toString)
    }
  }

  def main(args: Array[String]): Unit = {
    println("Begin")
    val actorSystem = ActorSystem(name = "actorSystem")
    var parentActor = actorSystem.actorOf(Props(new ParentActor("ParentActor")))
    var parentActor2 = actorSystem.actorOf(Props(new ParentActor("ParentActor2")))

    parentActor ! CreateChildActor
/*
    parentActor ! CreateChildActor
    parentActor ! CreateChildActor
    parentActor ! CreateChildActor
    parentActor ! SignalChildren("asdasd")
    parentActor ! CreateChildActor
    parentActor ! CreateChildActor
    parentActor ! SignalChildren("aweqqew")
*/
    parentActor2 ! CreateChildActor

    val child0 = actorSystem.actorSelection("akka://actorSystem/user/$a/child_0")
    child0 ! PrintSignal("asd")



    Thread.sleep(1000)
    actorSystem.terminate()
  }




}

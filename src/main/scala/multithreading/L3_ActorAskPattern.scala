package multithreading

import akka.actor.{Actor, ActorSystem, Props}
import akka.util._
import akka.pattern._

import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

case object AskName // if you dont have any primitive then use case object instead of case class
case class NameResponse(name:String)
case class AskNameOf(askableActorRef: AskableActorRef)



class AskActor(val name:String) extends Actor {
  def this(name: Int) = this(name.toString)
  override def receive: Receive = {
    case AskName => sender ! NameResponse(name+" : add extra properties")
      println(self)
    case AskNameOf(other) =>
      println(self)
      implicit val timeout = Timeout(3.seconds)
      val f = other ? AskName
      f.onComplete{
        case Success(NameResponse(n)) =>
          println("They said their name was "+n)
        case Success(s) =>
          println("No name class"+s.getClass)
        case Failure(ex) => println(ex.printStackTrace())
      }
      val currentSender = sender
      Future{
        currentSender ! "messageTest"
      }
  }
}

object ActorAskPattern {

  def main(args: Array[String]): Unit = {
    val AskSystem = ActorSystem(name = "AskSystem")
    val askActor = AskSystem.actorOf(Props(new AskActor("askSome1")), "AskActor")
    val askActor2 = AskSystem.actorOf(Props(new AskActor("askSome2")), "AskActor2")

    implicit val timeout = Timeout(3.seconds)

    val answer: Future[Any] = askActor.ask(AskName)
    answer.onComplete(t=> println("Answer onComplete : "+t.get))
    answer.foreach(println)

    val askActorResponse: Future[Any] = askActor.ask(AskNameOf(askActor2))
    askActorResponse.foreach(println) // print message

    AskSystem.terminate()
  }
}

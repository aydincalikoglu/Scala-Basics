package multithreading

import akka.actor.{Actor, ActorSystem, Props}
import scala.concurrent.duration._

object L6_ActorScheduling {
  case object Count

  class ScheduleActor(var n:Int) extends Actor {
    override def receive: Receive = {
      case Count =>
        n+=1
        println(n)
      case i:Int => println("Int: "+i+" ")
      case any:Any => println("Wrong Type : " + any.getClass.toString)
    }
  }

  def main(args: Array[String]): Unit = {

    val actorSystem = ActorSystem(name = "actorSystem")
    var actor = actorSystem.actorOf(Props(new ScheduleActor(1)))
    implicit val ec = actorSystem.dispatcher
    actor ! Count // 2

    actorSystem.scheduler.scheduleOnce(2.second)(actor ! Count) // 4..

    actorSystem.scheduler.scheduleOnce(0.second)(actor ! Count) // 3

    actorSystem.scheduler.schedule(3.seconds,500.millis,actor,Count) // n...

    Thread.sleep(5000)
    actorSystem.terminate()
  }
}

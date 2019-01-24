import akka.actor.{Actor, ActorRef, ActorSystem, Props}

case class StartCounting(count: Int, actorRef: ActorRef)

case class IncreaseCount(n: Int)

case class Message(message: String, actorRef: ActorRef)


class ActorCounter() extends Actor {
  override def receive: Receive = {
    case startCounting: StartCounting =>
      println("initial : "+startCounting.count)
      startCounting.actorRef ! IncreaseCount(startCounting.count+1)
    case IncreaseCount(n: Int) =>
      if(n<10){
        println(self)
        println("increase : "+n)
        sender ! IncreaseCount(n+1)
      }
      else
        context.system.terminate()
    /*
    // two same action method to use
    case increaseCount: IncreaseCount => println(increaseCount.n)
    case IncreaseCount(n: Int) => println(n)
    */
    case message: Message => println(message)
    case _ => println("404")
  }
}

object ActorComminicating {
  def main(args: Array[String]): Unit = {
    val counterSystem = ActorSystem("ActorCounter")
    val actor = counterSystem.actorOf(Props[ActorCounter],"IncreaseActor")
    val actor2 = counterSystem.actorOf(Props[ActorCounter],"IncreaseActor2")
    val objectHelper = StartCounting(2,actor2)

    actor ! objectHelper

    // Make many actor working same time
    for(i <- 0 to 15) {
      // counterSystem.actorOf(Props[ActorCounter],"IncreaseActor"+i+i) ! IncreaseCount(i)
    }
    counterSystem.terminate()
  }
}

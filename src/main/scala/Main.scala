
class UserPrivate(private var name:String, var age:Int){
  def getName():String = name
}

object Main {
  def main(args: Array[String]): Unit = {
    var userPrivateA = new UserPrivate("Aydin",24)
    println(userPrivateA.getName())
  }
}

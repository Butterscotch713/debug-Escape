


abstract class Player {
  var mood=""
  var health=100

  def moodUpdate(newMood:String):Unit={
    mood=newMood
  }

  def healthUpdate(HPtaken:Int):Unit={
    health=health-HPtaken
    if(health==0){
      println("You died")
    }
  }



}

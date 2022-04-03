


class Enemy{
  def moodUpdate(NewMood:String): Unit = {
    Player.mood=NewMood
  }

  def healthUpdate(damage:Int): Unit ={
    Player.health=Player.health-damage
    if(Player.health<=0){
      println("You Died")
    }

  }
}

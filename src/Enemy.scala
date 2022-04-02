


class Enemy extends Player{
  override def moodUpdate(NewMood:String): Unit = {
    mood=NewMood
  }

  override def healthUpdate(damage:Int): Unit ={
    health=health-damage
    if(health<=0){
      println("You Died")
    }

  }
}

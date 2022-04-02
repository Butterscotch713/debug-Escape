class Recover extends Player {
  override def moodUpdate(NewMood: String): Unit ={
    mood=NewMood
  }

  override def healthUpdate(Regain: Int): Unit = {
    health+=Regain
    if(health>100){
      health=100
    }
  }
}

class Recover {
  def moodUpdate(NewMood: String): Unit ={
    Player.mood=NewMood
  }

  def healthUpdate(Regain: Int): Unit = {
    Player.health+=Regain
    if(Player.health>100){
      Player.health=100
    }
  }
}

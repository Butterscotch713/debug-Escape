import scala.io.StdIn.readLine

object Main{
  var name=""
  var location=""
  var decision=""
  var restspots=List("diner")
  def welcome():Unit={
    println("Hello! Who are you?")
    name=readLine()
    if (name.isEmpty || name.isBlank){
      name="player"
    }
    println(s"Nice to meet you $name!")
    Thread.sleep(1000)
    println(s"Welcome to our world. I'll be here to help you get around.")
    Thread.sleep(1000)
    println(s"We're just outside of the town, would you like to check it out?")
    var decision=readLine()
    if(decision.toLowerCase=="yes"){
      println(s"Great, let's go!")
      location="town1"
      decision=""
    }
    else if(decision.toLowerCase=="no"){
      println(s"Oh, alright, is there somewhere you would like to go?")
      Thread.sleep(2000)
      println(s"There's a lake, forest, beach, and mountain nearby.")
      Thread.sleep(2000)
      println(s"Would you like to go to any of those?")
      decision=readLine()
      if(decision.toLowerCase=="yes"){
        println("Great, which location would you like to go to?")
        location=readLine()
        decision=""
      }
      else if(decision.toLowerCase=="no"){
        println("I'm afraid I can't stay then, good luck on your adventure.")
        Thread.sleep(2000)
        println(s"be safe")
        location="alone"
        decision=""
      }
      else{
        println("please type yes or no")
        decision=readLine()
      }
    }
    else{
      println("please type yes or no")
      decision=readLine()

    }
  }

  def town():Unit={
    if(location=="town1") {
      println("Let's go to the diner and find out why you're here.")
      Thread.sleep(2000)
      println("I found you just a couple minutes before you awoke.")
      Thread.sleep(2000)
      println("No offense, but I don't think you're from around here. I know everyone in this town, and the next closest village is thousands of miles away.")
      Player.mood="Confused"
      Thread.sleep(2000)
      println(Console.BLUE + s"Mood:${Player.mood}, HP:${Player.health}")
      Thread.sleep(2000)
      println(Console.RESET + "Oh, you just noticed your health and mood display?")
      Thread.sleep(2000)
      println("Don't worry, they typically only appear when one of them changes or you're in danger.")
      println("When you're in danger, they will be red")
      Thread.sleep(3000)
      println("They must have appeared here since in the diner you can rest and recover health.")
      Thread.sleep(2000)
      println("Back to figuring out how you got here, you have no memory of anything before I found you? That's going to make it difficult to get you out of here.")
      Thread.sleep(2500)
      println("That's too bad. Luckily this isn't too bad of a place to be lost in. The townsfolk are such nice beings.")
      Thread.sleep(2000)
      println("I'm afraid it's getting late, I have to go, I'll meet you here in the morning.")
      Thread.sleep(2000)
      println("What's that? Where do you go? Unfortunately I can't take you with me, let me think of some spots.")
      Thread.sleep(3000)
      println("There's an inn in town, you might be able to haggle the innkeeper, or there is a hut hidden a bit inside the forest.")
      Thread.sleep(2000)
      println("Where would you like to go? The inn or hut?")
      location=readLine()
    }

  }



  def main(args:Array[String]):Unit={
   welcome()
    while(location.toLowerCase!="home"){
      if (location.contains("town")) {
        town()
      }
    }


  }
}

import scala.io.StdIn.readLine

object Main{
var name=""
var location=""
var decision=""
  def welcome():Unit={
    println("Hello! Who are you?")
    name=readLine()
    if (name.isEmpty){
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
      Thread.sleep(1000)
      println(s"There's a lake, forest, beach, and mountain nearby.")
      Thread.sleep(1000)
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
      Thread.sleep(1000)
      println("I doubt you remember anything from before you woke up here.")
      Thread.sleep(1000)
      println("I found you just a couple minutes before you awoke.")
      Thread.sleep(1000)
      println("No offense, but I don't think you're from around here. I know everyone in this town, and the next closest village is thousands of miles away.")
    }

  }



  def main(args:Array[String]):Unit={
   welcome()
    if(location.contains("town")){
      town()
    }

  }
}

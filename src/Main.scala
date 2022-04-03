import scala.io.StdIn.readLine


object Main{
  var name=""
  var location="awoke"
  var decision=""
  var restspots=List("diner")

  /**Mood update */

  def moodUpdate(NewMood:String): Unit = {
    Player.mood=NewMood
  }

  /** Damage Health */
  def healthDamage(damage:Int): Unit ={
    Player.health=Player.health-damage
    if(Player.health<=0){
      println("You Died")
    }

  }

  /**Recover Health */
  def healthUpdate(Regain: Int): Unit = {
    Player.health+=Regain
    if(Player.health>100){
      Player.health=100
    }
  }

  /** Welcome location */
  def welcome():Unit={
    println(Console.RESET+"Hello! Who are you?")
    name=readLine()
    healthUpdate(100)
    if (name.isEmpty || name.isBlank){
      name="player"
    }
    println(s"Nice to meet you $name!")
    Thread.sleep(1000)
    println(s"Welcome to our world. I can help you get around.")
    Thread.sleep(1000)
    println(s"Say, we're just outside of the town, would you like to check it out?")
    decision=readLine().toLowerCase
    while (decision!="yes"&&decision!="no"){
        println("please type yes or no")
        decision=readLine()
    }
    if(decision.toLowerCase=="yes"){
      println(s"Great, let's go!")
      location="town1"
      decision=""
    }
    else{
      println(s"Oh, alright, there's a few other spots I can take you.")
      Thread.sleep(1000)
      println(s"There's a lake, forest, beach, and mountain nearby.")
      Thread.sleep(2000)
      println(s"Would you like to go to any of those?")
      decision=readLine().toLowerCase
      while (decision!="yes"&&decision!="no"){
        println("please type yes or no")
        decision=readLine()
      }
      if(decision.toLowerCase=="yes"){
        println("Great, which location would you like to go to?")
        location=readLine().toLowerCase
        while (location!="lake"&&location!="forest"&&location!="mountain"&&location!="beach"){
          println("please type lake, mountain, beach, or forest")
          decision=readLine().toLowerCase
          location=decision
        }
        location=location+"1"
        decision=""
      }
      else{
        println("I'm afraid I can't stay then, good luck on your adventure.")
        Thread.sleep(2000)
        println(s"Be safe, do not be out after dark.")
        location="alone"
        decision=""
      }
    }

  }

  /** town location */
  def town():Unit={
    if(location=="town1") {
      Thread.sleep(2000)
      println("We'll head to the diner and find out why you're here.")
      Thread.sleep(2000)
      println("I found you just a couple minutes before you awoke.")
      Thread.sleep(2000)
      println("No offense, but I don't think you're from around here. I know everyone in this town, and the next closest village is thousands of miles away.")
      Player.mood="Confused"
      Thread.sleep(2000)
      println(Console.RED + s"Mood:${Player.mood}, HP:${Player.health}")
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
      location=readLine()+"1"
      println("Good luck. And whatever you do, don't go out after dark. I will meet you here tomorrow morning.")
      moodUpdate("Worried")
      println(Console.RED+s"Mood: ${Player.mood}, Health:${Player.health}")
    }
    if(location=="town2"){
      println(Console.RESET+"Hello, you look like you got some sleep.")
      Thread.sleep(2000)
      println("I did some digging last night, and I fear we're running out of time if there's any hope of you returning home.")
      Thread.sleep(3000)
      moodUpdate("Hungry")
      println(Console.RED+s"Mood: ${Player.mood}, Health:${Player.health}")
      Thread.sleep(2000)
      println(Console.RESET+"What's that? You're hungry? I'll go order some us some breakfast.")
      Thread.sleep(3000)
      println("We should have our food in a few minutes.")
      Thread.sleep(2000)
      println("While we wait, try closing your eyes and saying 'There's no place like home' 3 times")
      location="home"
    }

  }

  /**lake location */
  def lake():Unit={
    if(location.toLowerCase=="lake1"){
      println("You want to go to the lake? Okay! We'll head there now.")
      Thread.sleep(2000)
      println("While we walk, you don't happen to remember anything before you woke up, do you?")
      Thread.sleep(2000)
      println("Unfortunately, that's going to make it harder to get you back home.")
      Thread.sleep(2000)
      println("Watch your step there's a lot of ---")
      Thread.sleep(2000)
      println(Console.YELLOW + "*CRASH*")
      healthDamage(5)
      println(Console.RED + s"Health is now ${Player.health}")
      Thread.sleep(2000)
      println(Console.RESET +" -rocks stuck in the sand.")
      Thread.sleep(2000)
      println("It seems you lost a little health, you have to be careful here.")
      Thread.sleep(2000)
      println("And we made it. This lake stretches on for miles. Be careful if you go in, there's lots of hidden whirlpools, and its easy to get stuck underwater.")
      Thread.sleep(3000)
      println("I used to come to this lake all the time before... it happened.")
      Thread.sleep(2000)
      println("Sorry I got caught up in my head.")
      Player.mood="Concerned"
      Thread.sleep(2000)
      println(Console.RED + s"Mood: ${Player.mood}, Health ${Player.health}")
      Thread.sleep(2000)
      println(Console.RESET + "What's that look on your face? Is there danger nearby?")
      Thread.sleep(2000)
      println("The noise? That's just the lake, there are some interesting critters in there.")
      Thread.sleep(2000)
      println("It's getting dark, I need to get home.")
      Thread.sleep(2000)
      println("What's that? Where do you go?")
      Thread.sleep(3000)
      println("Hmmmm. Well I wouldn't recommend staying here. You could try to barter with the innkeeper in town, or there's a hut in the forest.")
      Thread.sleep(2000)
      println("Will it be the inn or hut?")
      location=readLine().toLowerCase+"1"
      println("Good luck. I will meet you at the diner in town tomorrow.")
      Thread.sleep(2000)
      println("One last thing. Don't go out after dark.")
      moodUpdate("Worried")
      println(Console.RED+s"Mood: ${Player.mood}, Health:${Player.health}")
    }

  }

/** forest location */
  def forest():Unit={
    if(location.toLowerCase=="forest1"){
      println("You want to go to the forest? That's one of my favorite spots.")
      Thread.sleep(2000)
      println("It's a little bit of a walk but if we move at a good pace we will have plenty of time before dark.")
      Thread.sleep(2000)
      println("As we approach, be careful of your step. There are lots of half buried roots on the forest floor.")
      Thread.sleep(2000)
      println("There's so many bugs here, it's disgusting")
      healthDamage(3)
      moodUpdate("Cautious")
      Thread.sleep(2000)
      println(Console.RED + s"Mood: ${Player.mood}, Health:${Player.health}")
      Thread.sleep(2000)
      println(Console.RESET + s"I told you those bugs are annoying. Darn bloodsuckers.")
      Thread.sleep(2000)
      println("Ah. here's the hut!")
      Thread.sleep(2000)
      println("Sorry it's a bit run down, one day the owner was just gone.")
      Thread.sleep(2000)
      println("Such a shame, whenever they made cookies they always brought me a few.")
      Thread.sleep(2000)
      println("Alas, life goes on.")
      Thread.sleep(2000)
      println(Console.YELLOW+"*You both start walking to the edge of the forest.*")
      println(Console.RESET+"Sorry, I started rambling again.")
      Thread.sleep(2000)
      println("Darn, it's getting dark. I need to get home.")
      Thread.sleep(2000)
      println("What? Where do you go?")
      Thread.sleep(3000)
      println("Well, I guess you could come back with me and barter with the innkeeper in town, or you could stay that hut tonight.")
      Thread.sleep(2000)
      println("Unfortunately, no, you cannot come home with me.")
      Thread.sleep(2000)
      println("Which will it be? The inn or the hut?")
      location=readLine().toLowerCase+"1"
      println("Good luck. We will meet in the diner in town tomorrow morning.")
      Thread.sleep(2000)
      println("One last thing..")
      Thread.sleep(2000)
      println("Whatever you do, do NOT go out after dark.")
      moodUpdate("Worried")
      println(Console.RED+s"Mood: ${Player.mood}, Health:${Player.health}")

    }

  }


  /** beach location */
    def beach():Unit={
      if(location=="beach1"){
        println("Really? The beach? Fine.")
        Thread.sleep(2000)
        println("Sorry, just never really liked the beach. Sand always gets everywhere.")
        Thread.sleep(2000)
        println("Luckily the beach is really close, its just hidden by the trees.")
        Thread.sleep(2000)
        println("See? We're here. It's a beach, I'm not sure what you expected.")
        Thread.sleep(2000)
        println(Console.YELLOW+"*The salty mist stings your eyes*")
        moodUpdate("Annoyed")
        healthDamage(1)
        println(Console.RED+ s"Mood: ${Player.mood}, Health:${Player.health}")
        Thread.sleep(2000)
        println(Console.RESET+"See, just being here sucks. The water is always too cold to swim in, there are sharp shells everywhere, the salty air burns.")
        Thread.sleep(2000)
        println("I'm heading home, I suggest you find somewhere to stay before it gets dark.")
        Thread.sleep(2000)
        println("Where can you go? There's an inn in town but you have no money, you could try to barter with the innkeeper.")
        println("Otherwise there's a small hut just inside the forest")
        Thread.sleep(2000)
        println("No, you cannot stay with me.")
        Thread.sleep(2000)
        println("Which will it be? Inn or hut?")
        location=readLine().toLowerCase+"1"
        println("Good luck. I will be waiting for you tomorrow morning at the diner in town.")
        Thread.sleep(2000)
        println("and whatever you do..")
        Thread.sleep(2000)
        println("under no circumstances should you go outside once night falls.")
        moodUpdate("Worried")
        println(Console.RED+s"Mood: ${Player.mood}, Health:${Player.health}")
      }
    }

/** Mountain Location */
  def mountain():Unit={
    if(location=="mountain1"){
      println("You want to go to the mountain? Alright, but we don't have time to climb it today.")
      Thread.sleep(2000)
      println("If you talk to some of the townsfolk, they'll tell you this mountain used to be an active volcano.")
      Thread.sleep(2000)
      println("But they don't know what they're talking about.")
      Thread.sleep(2000)
      println("Make sure you don't leave the path, there are hidden holes everywhere.")
      Thread.sleep(3000)
      println("You're keeping up well, you must've had some hiking experience.")
      Thread.sleep(2000)
      println("We'll stop here for a bit.")
      Thread.sleep(2000)
      println("It's strange, you seem familiar. But I know everyone within a few miles of our town.")
      Thread.sleep(2000)
      println("Oh well. We need to head back down so we have time before it gets dark.")
      Thread.sleep(2000)
      println(Console.YELLOW+"*You fall suddenly and hear a snap*")
      moodUpdate("Pain")
      healthDamage(25)
      Thread.sleep(2000)
      println(Console.RED+s"Mood: ${Player.mood}, Health:${Player.health}")
      Thread.sleep(2000)
      println(Console.RESET + "Oh f-, are you okay?")
      Thread.sleep(2000)
      println(Console.YELLOW+"*Your ankle definitely shouldn't bend that way*")
      Thread.sleep(2000)
      println(Console.RESET + "I'm gonna take your grimace as a no.")
      Thread.sleep(2000)
      println("I'll carry you to the inn, unfortunately I cannot take you to my house.")
      Thread.sleep(2000)
      println("We'll have to hurry, its getting dark")
      location="InnHurt"
    }
  }

  /** Inn location */
    def Inn():Unit={
      if(location.toLowerCase=="inn1"){
        println(Console.YELLOW+"*You slowly approach the inn, unsure of what you'll find inside.*")
        Thread.sleep(2000)
        println("*The innkeeper greets you warmly.*")
        Thread.sleep(2000)
        println(Console.RESET+"Welcome friend, it's been such a long time since we've had a visitor here.")
        Thread.sleep(2000)
        println("What can I do for you?")
        Thread.sleep(2000)
        println(Console.YELLOW+"*You explain that you need somewhere to stay*")
        Thread.sleep(2000)
        println(Console.RESET+"I see...Well you're welcome to stay here if you can do some errands for me.")
        Thread.sleep(2000)
        println(Console.YELLOW+"*Noticing the sun falling below the horizon and your guide's warning, you agree*")
        Thread.sleep(2000)
        println(Console.RESET+"Fantastic, don't worry, there's nothing too difficult.")
        Thread.sleep(2000)
        println("First, I need you to clean off those tables you see behind you.")
        Thread.sleep(2000)
        println(Console.YELLOW+"*You quickly clear off the dishes and wipe down the tables*")
        Thread.sleep(2000)
        println(Console.RESET+"Great, next could you sweep quick?")
        Thread.sleep(2000)
        println(Console.YELLOW+"*It's not that large of a space, so sweeping doesn't take long.")
        moodUpdate("Slightly Tired")
        Thread.sleep(2000)
        println(Console.RED+s"Mood: ${Player.mood}, Health:${Player.health}")
        Thread.sleep(2000)
        println(Console.RESET+"One last thing, could you bring the trash around back outside?")
        Thread.sleep(2000)
        println(Console.YELLOW+"*Your guide's words echo in your ear, but you're getting tired.")
        Thread.sleep(2000)
        println(Console.RESET+"Well, yes or no?")
        decision=readLine().toLowerCase
        if(decision.contains("yes")) {
          println("Fantastic, after this you're welcome to the room on the left")
          Thread.sleep(2000)
          println("By the way, sleeping is a great way to restore you health, but it takes time.")
          Thread.sleep(2000)
          println(Console.YELLOW + "*You thank the innkeeper and hurry outside.*")
          Thread.sleep(2000)
          println("*You notice the temperature dropped steeply, and while light shines through the windows, no shadows exist on the pitch black ground.*")
          Thread.sleep(3000)
          println("*You make it to the trash and throw the bag quickly over your shoulder.*")
          Thread.sleep(2000)
          println("*As you turn to leave, you hear a growl from behind the trash.*")
          moodUpdate("Scared")
          println(Console.RED + s"Mood: ${Player.mood}, Health:${Player.health}")
          Thread.sleep(2000)
          println(Console.YELLOW + "*Do you run, being quick but loud, or walk, being slow but quiet?*")
          decision = readLine().toLowerCase
          if (decision.contains("run")) {
            println("*You begin to run, and hear heavy footsteps behind you...far to loud to be human.*")
            Thread.sleep(2000)
            println("*Just as you approach the corner, you notice the footsteps stopped.*")
            Thread.sleep(2000)
            println("You slow, relieved")
            Thread.sleep(2000)
            moodUpdate("Exhausted")
            println(Console.RED + s"Mood: ${Player.mood}, Health:${Player.health}")
            Thread.sleep(2000)
            println(Console.YELLOW + "*Just before the door, something drops onto you from the roof, crushing and killing you before you know what happened*")
            Thread.sleep(2000)
            location = "awoke"
          }
        }
        else{
          println(Console.YELLOW+"*Remembering your guide's words, you shake your head no*")
          Thread.sleep(2000)
          println(Console.RESET+"That's alright, just do it in the morning before you leave.")
          Thread.sleep(2000)
          println(Console.YELLOW+"*Exhausted, you thank the innkeeper, and upon laying down you immediately pass out.*")
          location="Inn2"
          }
        }
      else if (location=="InnHurt"){
        Thread.sleep(2000)
        println(Console.RESET+"We made it")
        Thread.sleep(2000)
        println("I'm going to set you here for a minute while I talk to the innkeeper.")
        Thread.sleep(3000)
        println("Given the circumstances, they're letting you stay tonight for free.")
        Thread.sleep(2000)
        println("I'll see you at the diner in the morning.")
        Thread.sleep(2000)
        moodUpdate("Exhausted")
        println(Console.RED + s"Mood: ${Player.mood}, Health:${Player.health}")
        println(Console.YELLOW+"*You fall asleep immediately.*")
        location="Inn2"
      }
      else if(location=="Inn2"){
        moodUpdate("Refreshed")
        healthUpdate(100)
        Thread.sleep(2000)
        println(Console.RED + s"Mood: ${Player.mood}, Health:${Player.health}")
        println(Console.YELLOW+"You wake up, noticing any injuries you had are healed.*")
        Thread.sleep(2000)
        println("*You realize you heard some strange noises outside last night,and make a note to ask your friend about them.*")
        println("*You look a the time and hurry to meet your new friend at the diner.*")
        location="town2"
      }
    }

/**Hut Location */
  def hut():Unit={
    if(location=="hut1"){
      println(Console.YELLOW+"*You hurry to the forest, searching for some form of structure.*")
      Thread.sleep(2000)
      println("*After a few minutes, you see the outline of a small building.*")
      Thread.sleep(2000)
      println("*With your new friend's words echoing in you head, and the sun setting, you sprint to the door.*")
      Thread.sleep(2000)
      println("*You make it inside, and notice a chair, table, and small bed inside.*")
      Thread.sleep(2000)
      moodUpdate("Hungry")
      println(Console.RED + s"Mood: ${Player.mood}, Health:${Player.health}")
      Thread.sleep(2000)
      println(Console.YELLOW+"You realize you haven't eaten all day, and see some berry bushes outside.*")
      Thread.sleep(2000)
      println("*They look like raspberries you think to yourself*.")
      Thread.sleep(2000)
      println("*It's pitch black outside, do you risk it?*")
      decision=readLine().toLowerCase
      if(decision.contains("yes")){
        println("*You hurry outside and start rapidly picking berries.*")
        Thread.sleep(2000)
        println("*In your hurry, you didn't notice the door close behind you.*")
        Thread.sleep(2000)
        println("*You try to open the door, but it seems to weigh thousands of pounds.*")
        Thread.sleep(2000)
        println("*After a few more minutes of trying, you give up and start to head to the inn.*")
        Thread.sleep(2000)
        println("*You notice you seem to be walking for a while with still no end of the forest in sight.*")
        Thread.sleep(2000)
        moodUpdate("Panicked")
        println(Console.RED + s"Mood: ${Player.mood}, Health:${Player.health}")
        Thread.sleep(2000)
        println(Console.YELLOW+"*You begin to run, but the forest just seems to extend further and further with each step you take.*")
        Thread.sleep(2000)
        println("*After what feels like hours, you collapse, exhausted.*")
        Thread.sleep(2000)
        println("*As you fall to the ground, your friend's warning is your last thought.*")
        location="awoke"
      }
      else{
        println("*Trusting what your new friend told you, you decide you can wait till morning to eat.*")
        Thread.sleep(2000)
        println("*You head over to the bed and fall asleep almost immediately, but hear some scratching outside as you fall asleep.*")
        Thread.sleep(2000)
        moodUpdate("Refreshed")
        healthUpdate(100)
        Thread.sleep(2000)
        println(Console.RED + s"Mood: ${Player.mood}, Health:${Player.health}")
        println(Console.YELLOW+"You wake up, noticing any injuries you had are healed.*")
        Thread.sleep(2000)
        println("*You look a the time and hurry to meet your new friend at the diner.*")
        location="town2"
      }
    }


  }

  def main(args:Array[String]):Unit={
    println("Welcome to 'Escape'")
    Thread.sleep(2000)
    println("This is a simple text adventure game. You will type in your choices")
    Thread.sleep(2000)
    println("Characters speaking to you will appear with white text in the console.")
    Thread.sleep(2000)
    println(Console.YELLOW + "Events will appear in yellow and with '*' on both sides.")
    Thread.sleep(2000)
    println(Console.RED + "Your health and mood will be displayed in red, and only displayed when in danger or changed.")
    Thread.sleep(2000)
    println(Console.RESET + "Good luck, can you escape?")
    Thread.sleep(2000)
    println()
    while(location.toLowerCase!="home"){
      if(location=="awoke"){
        welcome()
      }
      if (location.toLowerCase.contains("town")) {
        town()
      }
      else if(location.toLowerCase.contains("lake")){
        lake()
      }
      else if(location.toLowerCase.contains("forest")){
        forest()
      }
      else if(location.toLowerCase.contains("beach")){
        beach()
      }
      else if (location.toLowerCase.contains("mountain")){
        mountain()
      }
      else if (location.toLowerCase.contains("inn")){
        Inn()
      }
      else if(location.toLowerCase.contains("hut")){
        hut()
      }

    }
    println(Console.YELLOW+"*You wake up in your normal bed, all past memories restored. You're amazed that worked*")
    Thread.sleep(2000)
    println(Console.MAGENTA+"Thanks for playing, more coming soon!")

  }
}

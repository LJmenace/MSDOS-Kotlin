import java.util.*

class Game : GameStart {
    private var playerHp : Int = 15
    private var ronaldHp : Int = 20
    private var playerWeapon : String = ""
    private var playerName : String = ""
    private var burgerKing = 0
    private var continueGame = true



    private fun playerIntro(){



        println(
            ("It’s the year **** and you are staying up late trying to finish your coding H.W..\n" +
                    "\nsadly it’s too much for you to handle in one night and you fall asleep at your computer when all of a sudden...\n" +
                    "\n" +
                    "You are teleported to a Forest \n" +
                    "\nYou have no idea how you got there but decide to make the most of it \n" +
                    "\nWho knows maybe this could be your very own Isekai!…\n" +
                    "\n" +
                    "Looking around you notice your inventory \n")
        )

        playerWeapon = "Sword"

        println("Your HP: $playerHp")

        println("Your Weapon: $playerWeapon\n")

        println("Please enter your name:")

        playerName = readln()

        println("\nWelcome $playerName to a viable minimal product (^_^)")


    }

    private fun villageRoad(){
        println("\n------------------------------------------------------------------\n")
        println(
            """
            So to set this journey off you decide to walk in a random direction
            
            Because well it's not like you'll get lost right...
            
            """.trimIndent()
        )
        println(
            """
            How wrong can you be??!! After walking for only 10 secs.. 
            
            You've come to an area in the forest with 4 paths to go through..
            
            """.trimIndent()
        )


        do {
            println("Village Road")
            println("\n------------------------------------------------------------------\n")
            println("1: Go north")
            println("2: Go east")
            println("3: Go south")
            println("4: Go west")
            println("\n------------------------------------------------------------------\n")

            println("Please enter a number choice")
            val decision: String = readln()

            when (decision) {
                "1" -> north()
                "2" -> east()
                "3" -> villageEntrance()
                "4" -> west()
                else -> println("Invalid Input")
            }
            if (!continueGame) {
                break
            }
        } while (this.continueGame)


    }

    private fun north(){
        println("\n------------------------------------------------------------------\n")
        println("There is a river. You drink the water and rest at the riverside.")
        println("Your HP is recovered.")
        playerHp += 5


        println("Your HP is $playerHp")


        if (playerHp >= 40) {
            playerHp -= 5
            println("Your are super bloated and cannot drink any more water... your HP is $playerHp")
        }


        println("\n\n1: Go to the crossroad")
        println("\n------------------------------------------------------------------\n")

        val decision: String = readln()
        if (decision.contains("1")) {
            villageRoad()
        } else {
            north()
        }

    }

    private fun east(){

        println("\n------------------------------------------------------------------\n")
        println("You walked into a clearing and find the Masamune!!!")
        playerWeapon = "Masamune!"
        println("Your Weapon is now the : $playerWeapon")
        println("\n------------------------------------------------------------------\n")
        println("\n\n1: Go to the crossroad")
        println("\n------------------------------------------------------------------\n")
        val decision: String = readln()

        if (decision.contains("1")) {
            villageRoad()
        } else {
            east()
        }

    }

    private fun west(){
        println("\n------------------------------------------------------------------\n")
        println("You encounter Ronald McDonald!!!\n")
        println("1: Fight")
        println("2: Run")
        println("\n------------------------------------------------------------------\n")

        val decision: String = readln()

        if (decision.contains("1")) fight() else if (decision.contains("2")) {
            villageRoad()
        }
    }

    private fun villageEntrance() : Boolean{

        while (true) {
            println("\n------------------------------------------------------------------\n")
            println("You are at the gate of the town.\n")
            println("An old Samurai is standing in front of you.")
            println("")
            println("What do you want to do?")
            println("")
            println("1: Talk to the Samurai?")
            println("2: Attack the Samurai?")
            println("3: Leave")
            println("\n------------------------------------------------------------------\n")

            val decision: String = readln()


            when {
                decision == "1" && burgerKing == 1 -> {
                    ending()
                    break
                }
                decision.contains("1") -> {

                    println("Hello there, stranger. So your name is $playerName...?")

                    println("Sorry but we cannot let a stranger enter into our town.")

                    println("Plus we are super hungry so come back another time..")

                    println("Press Enter to continue..")

                    readln()
                }
                decision.contains("2") -> {

                    println("Old Samurai: Hey don't be stupid $playerName...\n\nThe samurai hit you so hard...you gave up.\n(You receive 3 damage)\n")
                    playerHp -= 3
                    println("Your HP: $playerHp")
                    if (playerHp < 1) {
                        dead()
                    }

                    readln()
                }
                decision.contains("3") -> {
                    break
                }
            }
        }
        return false
    }

    private fun ending(){
        println("\n------------------------------------------------------------------\n")
        println(
            """
                Guard: Oh you killed Ronald McDonald!?? Great..He stole our Burger King
                
                That's why we've been so hungry..!
                
                """.trimIndent()
        )
        println("Guard: It seems you are a trustworthy person. Welcome to our town!")
        println("\n\n           THE END                    ")
        println("\n------------------------------------------------------------------\n")
        continueGame = false
    }

    private fun fight(){

        println("\n------------------------------------------------------------------\n")
        println("Your HP: $playerHp")
        println("Ronald's HP is : $ronaldHp")
        println("\n1: Attack")
        println("2: Run")
        println("\n------------------------------------------------------------------\n")

        val decision: String = readln()

        if (decision.contains("1")) {
            attack()
        } else if (decision.contains("2")) {
            villageRoad()
        }
    }

    private fun attack(){
        var playerDamage = 0


        if (playerWeapon == "Sword") {
            playerDamage = Random().nextInt(5)
        } else if (playerWeapon == "Masamune!") {
            playerDamage = Random().nextInt(8)
        }

        println("You attacked Ronald McDonald.. and gave $playerDamage damage!")

        ronaldHp -= playerDamage

        println("Ronald's HP: $ronaldHp")

        if (ronaldHp < 1) {
            win()
        } else {

            val monsterDamage: Int = Random().nextInt(4)

            println("Ronald attacked you and gave $monsterDamage damage!")

            playerHp -= monsterDamage

            println("Player HP :$playerHp")

            if (playerHp < 1) {
                dead()
            } else {
                fight()
            }
        }

    }

    private fun dead(){
        println("\n------------------------------------------------------------------\n")
        println("You are dead!!!")
        println("\n\nGAME OVER")
        println("\n------------------------------------------------------------------\n")
    }

    private fun win(){
        burgerKing = 1
        println("\n------------------------------------------------------------------\n")
        println("You killed Ronald McDonald!!!")
        println("Ronald dropped a bag full of Burger King!!")
        println("You obtained Burger King!\n\n")
        println("1: Go back to crossroads")
        println("\n------------------------------------------------------------------\n")
        val decision: String = readln()

        if (decision.contains("1")) {
            villageRoad()
        } else {
            win()
        }
    }


    override fun startGame() {
        playerIntro()
        villageRoad()
    }


}

import java.util.*


fun main() {
    val scanner = Scanner(System.`in`)
    val random = Random()
    val  mathGame = MathGame()
    val linkedList = LinkedList<Rank>()

    var wh = 1
    var t = 0
    var x = 0
while (true){
    println("1-> start game:");
    println("2->  rating");
    println("3-> users ");
    println("4-> quit game")
    println("5-> continute game")



    val a = scanner.nextInt();
    when(a){



    1->{
        System.out.println("enter name: ");
        val name = scanner.next();
     game(linkedList,name)
    }
       2-> {

        for (r in linkedList) {
            println("name: " + r.name)
            println("right answers: " + r.t)
            println(" wrong answers: " + r.x)
        }
    }
    3->{

        linkedList.sortByDescending { it.t }
        linkedList.forEach{rank ->
            System.out.println(rank.name+" "+rank.t);
        }
    }
        4->{
            break
        }
        5->{
            print("Enter name: ")
            val name = scanner.next()
            linkedList.forEach { rr->
                if (name.equals(rr.name)){

                    rr.name?.let { game( linkedList, it) }

                }
            }


        }
        

    }

}
}
fun game( linkedList: LinkedList<Rank>,name:String){
    val scanner = Scanner(System.`in`)
    val random = Random()
    val  mathGame = MathGame()


    var wh = 1
    var t = 0
    var x = 0


    for (i in 0..4) {
        val nums = random.nextInt(10)
        val nums2 = random.nextInt(10)
        val a = random.nextInt(4)

        println("$wh question")
        mathGame.Result(nums, nums2, a)
        val n = scanner.nextInt()
        if (n == mathGame.res) {
            t++


        } else {
            x++

        }
        wh++
    }
    wh=1
    try {


        linkedList.add(Rank(name, t, x))
    }catch (e:Exception){
        println()
    }
    t=0
    x=0
}


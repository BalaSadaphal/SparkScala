import scala.collection.mutable.ArrayBuffer

object xyz {
  val b=new ArrayBuffer[Char]()

  def main (args: Array[String]): Unit = {
    val l=List('a','b','b','c','d')
    duplicateN(5,l)
    println(b)

  }

  def duplicateN(n:Int,list:List[Char])={
    list.map({x=>
      for(i <- n-1 to 0 by -1){
        b.+=(x)
      }
    })

  }

}

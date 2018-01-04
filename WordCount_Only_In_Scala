scala> val x = "Hello World hi bye hello Hello hello world World"
x: String = Hello World hi bye hello Hello hello world World

scala> val y =x.split(" ").map(x=> (x.toUpperCase,1)).toList.groupBy(x=>x._1)
y: scala.collection.immutable.Map[String,List[(String, Int)]] = 
Map(HI -> List((HI,1)), 
WORLD -> List((WORLD,1), (WORLD,1), (WORLD,1)), 
HELLO -> List((HELLO,1), (HELLO,1), (HELLO,1), (HELLO,1)), 
BYE -> List((BYE,1)))

scala> def wordcount(list1:List[(String, Int)] ):Int ={
     | list1.reduce((x,y)=> (x._1,x._2+y._2))._2
     | }

scala> val z=y.map{case (key, value) => (key ,wordcount(value))}
z: scala.collection.immutable.Map[String,Int] = Map(HI -> 1, WORLD -> 3, HELLO -> 4, BYE -> 1)

scala> z.foreach(x => println (x._1 + "-->" + x._2))
HI-->1
WORLD-->3
HELLO-->4
BYE-->1


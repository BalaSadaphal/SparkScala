import fiddle.Fiddle, Fiddle.println
import scalajs.js

@js.annotation.JSExportTopLevel("ScalaFiddle")
object ScalaFiddle {
  
  val number=5;
  
  println("We have to calculate factorial of "+number)
  
  var factorial=number;
  
  for(i<- number-1 to 1 by -1){
    
    factorial=factorial*i;
    
    }
    println("Factorial of "+number + "="+factorial);
  
  
  // $FiddleEnd
}

//OR
  
import fiddle.Fiddle, Fiddle.println
import scalajs.js

@js.annotation.JSExportTopLevel("ScalaFiddle")
object ScalaFiddle {
  
  val number=5;
  
  println("We have to calculate factorial of "+number);
  
  var factorial=number;
  
  factorial=fact(number);
  println("Factorial of "+number + "="+factorial);
  
  def fact(number:Int):Int={
    for(i<- number-1 to 1 by -1)
    factorial*=i;
    return factorial;
    }
    

  }

  
  

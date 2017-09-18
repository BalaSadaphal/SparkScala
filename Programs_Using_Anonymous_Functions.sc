//Program 1: Sum of numbers in a range , squares of numbers in a range, cubes of numbers in a range and so on....

scala>  def sum(f:Int => Int,a:Int,b:Int):Int ={
          if(a>b) 0 else f(a) + sum(f,a+1,b)
        }

scala>  sum(x=>x,1,3)
res17: Int = 6

scala>  sum(x=>x*x,1,5)
res18: Int = 55

scala> sum(x=>x*x*x,1,5)
res20: Int = 225

//Program 2: Factorials of numbers

scala>  def factorial(a:Int):Int ={if(a==1) 1 else a*factorial(a-1)}

scala> sum(x=>x*x*x,1,5)
res20: Int = 225

scala> factorial(5)
res21: Int = 120

scala> factorial(6)
res22: Int = 720

scala> factorial(7)
res23: Int = 5040

// Program 3: nCr

scala> def nCr(n:Int, r:Int):Int={factorial(n)/(factorial(n-r)*factorial(r))}


scala> nCr(4,2)
res24: Int = 6

scala> nCr(10,2)
res25: Int = 45



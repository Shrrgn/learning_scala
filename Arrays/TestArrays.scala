
import Array._
import scala.collection.mutable.ArrayBuffer

object TestArrays {

	def arrays():Unit = {
		var myArray = Array(2,5,6,7,8,0,2,3)
		
		for (x <- myArray){
			println(x)
		}
		
		var total = 0
		for (i <- 0 to (myArray.length) - 1){
			total += myArray(i)
		}
		
		var average = total/myArray.length
		printf("ave = %s",average)
		
		var max = 0
		for (i <- 0 to (myArray.length) - 1){
			if (max < myArray(i)) max = myArray(i)
		}
		printf("\nmax = %s",max)
		println()
		
		var array1 = range(0,15)
		
		for (i <- array1){
			print(i + " ")
		}
		
		val ar = Array(1 to 10: _*)
		//val ar1 = ArrayBuffer[Int]
	}
	
	def cycles():Unit = {
		var myArray = Array(2,5,6,7,8,0,2,3)
		var s = 0
		
		for (i <- 1 to 8)
			s = s + i
		
		for (i <- 0 until myArray.length)
			s += myArray(i)
			
		var s1 = 0
		//for (i <- myArray)
			//s1 += myArray(i)
			
		for (i <- 1 to 3; j <- 1 to 3)
			println((10 * i + j) + " ")
			
		for (i <- 1 to 3; j <- 1 to 3 if i != j)
			println((10 * i + j) + " ")
			
		for (i <- 1 to 3; from = 4 - i; j <- from to 3)
			println((10 * i + j) + " ")
			
		println("Yield")
		print(for (i <- 1 to 10) yield i % 3)
		
		println(for (c <- "Hello"; i <- 0 to 1) yield (c + i).toChar)
		
		print(myArray.filter(_ % 2 == 0).map( 2 * _))
	}

	def fac(n:Int) = {   //в рекурсивных обязательно писать тип возвращаемого значения
		var r = 1
		for (i <- 1 to n)
			r = r * i
		r
	}
	
	def decorate(str:String, left:String = "<<", right:String = ">>") = left + str + right
	
	def mult(args:Int*) = {
		var res = 1 //lazy init
		//lazy val = 0
		for (i <- args) res *= i
		res
	}
	
	def recursiveSum(args:Int*):Int = {
		if (args.length == 0) 0
		else args.head + recursiveSum(args.tail:_*)
	}
	/*
	def check(n:Int) = {
		if (n >= 0) {n/2}
		else throw new IllegalArgumenException("n should be positive")
	}
	*/
	def countDown(n:Int):Unit = {
		var i = n
		while (i != 0){
			print(i)
			i = i - 1
		}
	}
	
	def pow(x:Int, n:Int) = {
		if (n == 0) 1
		else if (n == 1) x
		else if (n < 0) negPow(x,n)
		else if (n == 2) x*x
		else posPow(x,n)
		
	}
	
	def posPow(x:Int,n:Int):Int = {
		if (x == 0) 1
		else x * posPow(x, n - 1)
	}
	
	def negPow(x:Double,n:Int):Double = {
		if (n == 0) 1
		else (1/x) * negPow(x, n + 1)
	}
	
	def usingMap() = {
		val scores = Map("Alice" -> 10, "Bob" -> 3) //immutable
		val scor = scala.collection.mutable.Map("Alice" -> 10, "Bob" -> 3) //mutable
		val scor1 = scala.collection.mutable.HashMap[String,Int]() //empty
		
		val bobScore = scor.getOrElse("Bob", 0)
		scor("Artem") = 10
	}
	
	def usingCorteg() = {
		val t = (1, 2, "Fred")
		print(t._2)
	}
	
	def call() = {
		///arrays()
		//cycles()
		print(fac(5))
		println(decorate("Fuck"))
		print(mult(1 to 5: _*) + "\n") //инетерпертировать как последовательность
		print(recursiveSum(1 to 5: _*) + "\n")
		//countDown(5)
		print("Pow\n")
		print(pow(5,-2) + "\n")
		print(pow(5,0) + "\n")
		print(pow(5,1) + "\n")
		//print(pow(5,4) + "\n")
		val c = new Counter()
		c.inc()
		print(c.current + "\n")
		val c2 = new Counter()
		c2.inc()
		print(c.eq(c2) + "\n")
	} 
	
	def main(args:Array[String]):Unit = {
		call()
	}
}

class Counter {
	private var value = 1
	
	def inc() = {value = value + 10}
	
	def current = value
	
	def eq(other:Counter):Boolean = value == other.value
}

class User {
	private var userNick = "Something"
	
	private[this] var variable = 0 // can't do SomeObject.value
	
	def nick = userNick
	
	def nick_(value:String) = {
		if (value.length > 6)  userNick = value
	}
}
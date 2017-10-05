

object Runner {

	def call () : Unit = {
		print("Main\n")
		var user = new User("Shrrgn","hey")
		var per = new Person("Jack Murray",20)
		print(per.firstName + "\n")
		print(per.age + "\n")
		per.personAge = 22
		print(per.age + "\n")

		print(Accounts.id + "\n")		
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

class User(var userNick:String, var password:String, var description:String = "") {
	//private var userNick = "Something"
	
	private[this] var variable = 0 // can't do SomeObject.value
	
	def nick = userNick
	
	def nick_(value:String) = {
		if (value.length > 6)  userNick = value
	}
}

class Person (personName:String, var personAge:Int) {
	
	def age = this.personAge
	
	def personAge_(value:Int):Unit = {
		if (value < 0) this.personAge = 0
	}
	
	def firstName = personName.split(" ")(0)
	
	def secondName:String = {
		if (personName.split(" ").length == 1) 
			throw new Exception("String has only name")
		else
			personName.split(" ")(1)
	}
}

class Accounts {
	val id = Accounts.ids
}


object Accounts {     //singelton
	private var id = 0

	def ids = {id += 1; id}
}

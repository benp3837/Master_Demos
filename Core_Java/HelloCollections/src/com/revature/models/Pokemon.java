package com.revature.models;

	public class Pokemon {
	
		//private fields and getter/setter methods (below) are an example of ENCAPSULATION
		private String name;
		private String type;
	
		
		public void fight() {
			System.out.println(this.name + " attacked!");
		}
		
		
		//Some boilerplate code below----------------------------------------------------------------------
		//what do I mean by boilerplate?
		//boilerplate code is code that is repeated in multiple places with little to no variation.
		//In our case, our boilerplate code consists of constructors, getters/setters, hashcode, equals, and toString.
		
		
		public Pokemon() { //no args constructor
			super();
		}
	
	
		public Pokemon(String name, String type) { //all args constructor
			super();
			this.name = name;
			this.type = type;
		}
		
		//Overloaded Constructors are an example of POLYMORPHISM
		//Remember - overloading is whan you have the same method/constructor name, but different parameters
	
		//Hashcode will give each instantiated object a hash value 
		//(a unique value)	
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + ((type == null) ? 0 : type.hashCode());
			return result;
		}
	
		//Equals will let you compare your objects by their hashcode 
		//(That's why hashcode and equals are generated together)
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pokemon other = (Pokemon) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (type == null) {
				if (other.type != null)
					return false;
			} else if (!type.equals(other.type))
				return false;
			return true;
		}
	
		//toString returns a String representation of the object when we print 	
		@Override
		public String toString() {
			return "pokemon [name=" + name + ", type=" + type + "]";
		}



		//private fields and getter/setter methods are an example of ENCAPSULATION
		//getters and setters are how the fields can be accessed/modified despite the fields being private
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
		
		
		
}

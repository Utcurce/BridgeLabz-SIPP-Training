class Animal {
      String name;
      int age;

      Animal(String name,int age){
          this.name=name;
          this.age=age;
      }


    void makeSound() {
        System.out.println("Animal Sound");
    }
    void displayInfo(){
        System.out.println("Name: "+name+" Age: "+age);
    }

}

class Dog extends Animal {
    Dog(String name,int age){
        super(name,age);
    }
   @Override
    void makeSound() {
        System.out.println("Woof! Woof!");
    }
}

class Cat extends Animal {
    Cat(String name,int age){
        super(name,age);
    }
    @Override
    void makeSound() {
        System.out.println("Meow! Meow!");
    }
}
class Bird extends Animal {
    Bird(String name,int age){
        super(name,age);
    }
    @Override
    void makeSound() {
        System.out.println("Tweet! Tweet!");
    }
}


class Main{
    public static void main(String[] args) {
       Animal dog=new Dog("jakky",4);
       Animal cat=new Cat("Choko",2);
       Animal bird=new Bird("Swetty",2);

       dog.makeSound();
       dog.displayInfo();

       cat.makeSound();
       cat.displayInfo();

       bird.makeSound();
       bird.displayInfo();


    }

}

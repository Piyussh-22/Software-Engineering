public class NoSingleton{
  public NoSingleton(){
    System.out.println("Singleton constructor called. New object created.");
  }
  public static void main(String[] args){
    NoSingleton s1 = new NoSingleton();
    NoSingleton s2 = new NoSingleton();

    System.out.println(s1 == s2);
  }
}

// we created two object on a single class and both object are diffrent so this doesnt not follow singleton.

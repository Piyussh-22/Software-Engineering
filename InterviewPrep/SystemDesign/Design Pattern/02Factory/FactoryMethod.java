// Coffee Interface

import java.util.Scanner;

interface Coffee {
    void prepare();
}

// Concrete Coffee Implementations
class StarbucksEspresso implements Coffee {
    @Override
    public void prepare() {
        System.out.println("Preparing Starbucks Espresso...");
    }
}

class StarbucksLatte implements Coffee {
    @Override
    public void prepare() {
        System.out.println("Preparing Starbucks Latte...");
    }
}

class CCDEspresso implements Coffee {
    @Override
    public void prepare() {
        System.out.println("Preparing CCD Espresso...");
    }
}

class CCDLatte implements Coffee {
    @Override
    public void prepare() {
        System.out.println("Preparing CCD Latte...");
    }
}

// Coffee Factory Interface
interface CoffeeFactory {
    Coffee createCoffee(String type);
}

// Starbucks Factory
class StarbucksFactory implements CoffeeFactory {
    @Override
    public Coffee createCoffee(String type) {
        if (type.equalsIgnoreCase("espresso")) {
            return new StarbucksEspresso();
        } else if (type.equalsIgnoreCase("latte")) {
            return new StarbucksLatte();
        } else {
            System.out.println("Invalid coffee type!");
            return null;
        }
    }
}

// CCD Factory
class CCDFactory implements CoffeeFactory {
    @Override
    public Coffee createCoffee(String type) {
        if (type.equalsIgnoreCase("espresso")) {
            return new CCDEspresso();
        } else if (type.equalsIgnoreCase("latte")) {
            return new CCDLatte();
        } else {
            System.out.println("Invalid coffee type!");
            return null;
        }
    }
}

// Main Class
public class FactoryMethod {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter coffee shop (starbucks/ccd): ");
        String shop = input.nextLine();

        System.out.print("Enter coffee type (espresso/latte): ");
        String type = input.nextLine();

        CoffeeFactory myFactory;

        if (shop.equalsIgnoreCase("starbucks")) {
            myFactory = new StarbucksFactory();
        } else if (shop.equalsIgnoreCase("ccd")) {
            myFactory = new CCDFactory();
        } else {
            System.out.println("Invalid coffee shop!");
            input.close();
            return;
        }

        Coffee coffee = myFactory.createCoffee(type);

        if (coffee != null) {
            coffee.prepare();
        }

        input.close();
    }
}


/*
==========================================================
NOTES
==========================================================

Coffee Interface
----------------
- Defines a common contract for all coffee classes.
- Ensures every coffee has a prepare() method.

StarbucksEspresso / StarbucksLatte
----------------------------------
- Concrete coffee classes for Starbucks.
- Implements the Coffee interface.

CCDEspresso / CCDLatte
----------------------
- Concrete coffee classes for CCD.
- Implements the Coffee interface.

prepare()
---------
- Implements the behavior declared in the interface.
- Defines how each coffee is prepared.

CoffeeFactory Interface
-----------------------
- Declares the factory method.
- Every coffee shop factory must implement createCoffee().

StarbucksFactory / CCDFactory
-----------------------------
- Concrete factory classes.
- Each factory creates only its own coffee objects.

createCoffee(String type)
-------------------------
- Factory Method responsible for object creation.
- Returns a Coffee reference for loose coupling.

if-else inside Factory
----------------------
- Decides which coffee object to create.
- This is the decision-making logic of the Factory Method.

return new StarbucksEspresso()
------------------------------
- Creates the required object.
- Returns it as a Coffee reference.

Scanner
-------
- Reads user input at runtime.
- Makes the program dynamic.

CoffeeFactory myFactory;
------------------------
- Stores a reference to a factory.
- Can point to any concrete factory.

myFactory = new StarbucksFactory();
----------------------------------
- Creates the Starbucks factory.
- Client decides which factory to use.

myFactory = new CCDFactory();
----------------------------
- Creates the CCD factory.
- Client can switch factories without changing the remaining code.

Coffee coffee = myFactory.createCoffee(type);
--------------------------------------------
- Client requests a coffee from the selected factory.
- Client receives a Coffee reference, not a concrete class.

if(coffee != null)
------------------
- Prevents NullPointerException.
- Continues only if a valid coffee object is returned.

coffee.prepare();
----------------
- Executes the object's behavior.
- Runtime polymorphism calls the correct prepare() method.

input.close();
--------------
- Releases the Scanner resource.
- Good programming practice.

==========================================================
*/
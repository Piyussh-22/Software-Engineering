// Laptop Interface

import java.util.Scanner;

interface Laptop {
    void assemble();
}

// Dell Laptop Models
class DellInspiron implements Laptop {
    @Override
    public void assemble() {
        System.out.println("Assembling Dell Inspiron...");
    }
}

class DellXPS implements Laptop {
    @Override
    public void assemble() {
        System.out.println("Assembling Dell XPS...");
    }
}

// HP Laptop Models
class HPPavilion implements Laptop {
    @Override
    public void assemble() {
        System.out.println("Assembling HP Pavilion...");
    }
}

class HPSpectre implements Laptop {
    @Override
    public void assemble() {
        System.out.println("Assembling HP Spectre...");
    }
}


// Charger Interface

interface Charger {
    void pack();
}

// Dell Chargers
class Dell65WCharger implements Charger {
    @Override
    public void pack() {
        System.out.println("Packing Dell 65W Charger...");
    }
}

class Dell90WCharger implements Charger {
    @Override
    public void pack() {
        System.out.println("Packing Dell 90W Charger...");
    }
}

// HP Chargers
class HP65WCharger implements Charger {
    @Override
    public void pack() {
        System.out.println("Packing HP 65W Charger...");
    }
}

class HP90WCharger implements Charger {
    @Override
    public void pack() {
        System.out.println("Packing HP 90W Charger...");
    }
}


// Abstract Factory

interface LaptopFactory {
    Laptop createLaptop(String model);
    Charger createCharger(String type);
}


// Dell Factory

class DellFactory implements LaptopFactory {

    @Override
    public Laptop createLaptop(String model) {

        if (model.equalsIgnoreCase("inspiron")) {
            return new DellInspiron();
        } else if (model.equalsIgnoreCase("xps")) {
            return new DellXPS();
        } else {
            System.out.println("Invalid Dell Laptop Model!");
            return null;
        }
    }

    @Override
    public Charger createCharger(String type) {

        if (type.equalsIgnoreCase("65w")) {
            return new Dell65WCharger();
        } else if (type.equalsIgnoreCase("90w")) {
            return new Dell90WCharger();
        } else {
            System.out.println("Invalid Dell Charger!");
            return null;
        }
    }
}


// HP Factory

class HPFactory implements LaptopFactory {

    @Override
    public Laptop createLaptop(String model) {

        if (model.equalsIgnoreCase("pavilion")) {
            return new HPPavilion();
        } else if (model.equalsIgnoreCase("spectre")) {
            return new HPSpectre();
        } else {
            System.out.println("Invalid HP Laptop Model!");
            return null;
        }
    }

    @Override
    public Charger createCharger(String type) {

        if (type.equalsIgnoreCase("65w")) {
            return new HP65WCharger();
        } else if (type.equalsIgnoreCase("90w")) {
            return new HP90WCharger();
        } else {
            System.out.println("Invalid HP Charger!");
            return null;
        }
    }
}


// Main Class

public class AbstractFactory {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter Brand (Dell/HP): ");
        String brand = input.nextLine();

        LaptopFactory myFactory;

        if (brand.equalsIgnoreCase("Dell")) {
            myFactory = new DellFactory();

            System.out.print("Enter Laptop Model (Inspiron/XPS): ");
            String laptopModel = input.nextLine();

            System.out.print("Enter Charger (65W/90W): ");
            String chargerType = input.nextLine();

            Laptop laptop = myFactory.createLaptop(laptopModel);
            Charger charger = myFactory.createCharger(chargerType);

            if (laptop != null)
                laptop.assemble();

            if (charger != null)
                charger.pack();

        } else if (brand.equalsIgnoreCase("HP")) {

            myFactory = new HPFactory();

            System.out.print("Enter Laptop Model (Pavilion/Spectre): ");
            String laptopModel = input.nextLine();

            System.out.print("Enter Charger (65W/90W): ");
            String chargerType = input.nextLine();

            Laptop laptop = myFactory.createLaptop(laptopModel);
            Charger charger = myFactory.createCharger(chargerType);

            if (laptop != null)
                laptop.assemble();

            if (charger != null)
                charger.pack();

        } else {
            System.out.println("Invalid Brand!");
        }

        input.close();
    }
}


/*
==========================================================
NOTES
==========================================================

Laptop Interface
----------------
- Defines a common contract for all laptop classes.
- Ensures every laptop has an assemble() method.

DellInspiron / DellXPS
----------------------
- Concrete laptop classes for Dell.
- Implements the Laptop interface.

HPPavilion / HPSpectre
----------------------
- Concrete laptop classes for HP.
- Implements the Laptop interface.

assemble()
----------
- Implements the behavior declared in the interface.
- Defines how each laptop is assembled.

Charger Interface
-----------------
- Defines a common contract for all charger classes.
- Ensures every charger has a pack() method.

Dell65WCharger / Dell90WCharger
-------------------------------
- Concrete charger classes for Dell.
- Implements the Charger interface.

HP65WCharger / HP90WCharger
---------------------------
- Concrete charger classes for HP.
- Implements the Charger interface.

pack()
------
- Implements the behavior declared in the interface.
- Defines how each charger is packed.

LaptopFactory
-------------
- Abstract Factory interface.
- Declares methods for creating related products.

createLaptop(String model)
--------------------------
- Factory method for laptop creation.
- Returns a Laptop reference.

createCharger(String type)
--------------------------
- Factory method for charger creation.
- Returns a Charger reference.

DellFactory / HPFactory
-----------------------
- Concrete factories.
- Each factory creates a matching family of products.

if-else inside Factory
----------------------
- Decides which concrete object to create.
- This is the object creation logic.

return new DellInspiron()
-------------------------
- Creates the required object.
- Returns it as a Laptop reference.

Scanner
-------
- Reads user input at runtime.
- Makes the program dynamic.

LaptopFactory myFactory;
-----------------------
- Stores a reference to a factory.
- Can point to any concrete factory.

myFactory = new DellFactory();
-----------------------------
- Creates the Dell factory.
- Produces only Dell products.

myFactory = new HPFactory();
---------------------------
- Creates the HP factory.
- Produces only HP products.

Laptop laptop = myFactory.createLaptop(...)
-------------------------------------------
- Client requests a laptop from the factory.
- Receives a Laptop reference.

Charger charger = myFactory.createCharger(...)
---------------------------------------------
- Client requests a charger from the factory.
- Receives a Charger reference.

if(laptop != null)
------------------
- Prevents NullPointerException.
- Continues only if a valid object is returned.

if(charger != null)
-------------------
- Prevents NullPointerException.
- Continues only if a valid object is returned.

laptop.assemble();
-----------------
- Executes the laptop's behavior.
- Runtime polymorphism calls the correct assemble() method.

charger.pack();
---------------
- Executes the charger's behavior.
- Runtime polymorphism calls the correct pack() method.

input.close();
--------------
- Releases the Scanner resource.
- Good programming practice.

Why is this Abstract Factory?
-----------------------------
- One factory creates multiple related products.
- DellFactory creates Dell laptops and Dell chargers.
- HPFactory creates HP laptops and HP chargers.
- The client switches the entire product family by changing only the factory.

==========================================================
*/
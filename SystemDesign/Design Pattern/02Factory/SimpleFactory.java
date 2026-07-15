// Notification Interface

import java.util.Scanner;

interface Notification {
    void send();
}

// Concrete Notification Implementations
class EmailNotification implements Notification {
    @Override
    public void send() {
        System.out.println("Sending Email Notification...");
    }
}

class PushNotification implements Notification {
    @Override
    public void send() {
        System.out.println("Sending Push Notification...");
    }
}

// Notification Factory
class NotificationFactory {
    public Notification createNotification(String type) {
        if (type.equalsIgnoreCase("email")) {
            return new EmailNotification();
        } else if (type.equalsIgnoreCase("push")) {
            return new PushNotification();
        } else {
            System.out.println("Invalid notification type!");
            return null;
        }
    }
}

// Main Class
public class SimpleFactory {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter notification type either email or push: ");
        String type = input.nextLine();

        NotificationFactory myNotificationFactory = new NotificationFactory();

        Notification notification =
                myNotificationFactory.createNotification(type);

        if (notification != null) {
            notification.send();
        }
        input.close();
    }
}


/*
==========================================================
NOTES
==========================================================

Notification Interface
----------------------
- Defines a common contract for all notification classes.
- Ensures every notification has a send() method.

EmailNotification / PushNotification
------------------------------------
- Concrete implementations of the Notification interface.
- These are the actual objects created by the factory.

send()
------
- Implements the behavior declared in the interface.
- Defines how each notification is sent.

NotificationFactory
-------------------
- Encapsulates object creation in one place.
- Client requests objects from the factory instead of using new.

createNotification(String type)
-------------------------------
- Factory method responsible for object creation.
- Returns a Notification reference for loose coupling.

if-else
-------
- Decides which concrete class to instantiate.
- This is the decision-making logic of the Simple Factory.

return new EmailNotification()
------------------------------
- Creates the required object.
- Returns it as a Notification reference.

Scanner
-------
- Reads user input at runtime.
- Makes the program dynamic.

NotificationFactory myNotificationFactory = new NotificationFactory();
---------------------------------------------------------------------
- Creates the factory object.
- Factory will create notification objects.

Notification notification =
myNotificationFactory.createNotification(type);
------------------------------------------------
- Client requests an object from the factory.
- Client receives a Notification, not a concrete class.

if(notification != null)
------------------------
- Prevents NullPointerException.
- Continues only if a valid object is returned.

notification.send();
--------------------
- Executes the object's behavior.
- Runtime polymorphism calls the correct send() implementation.

input.close();
--------------
- Releases the Scanner resource.
- Good programming practice.

==========================================================
*/
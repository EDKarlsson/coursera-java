# Inheritance and Polymorphism in Java
## abstract classes and interfaces.
#### Objectives

* what it means to be an abstract class or an interface, and how to use
* keywords like abstract or interface.
* Comparing inheritance of implementation against inheritance of interface.
Help decide between abstract class, or an interface,
when designing your class hierarchy.

Hypothetical with our Person class.
So now we're still working in the university, but let's change things a bit.
Let's change it so we're working for the accounting department.
And here we're essentially responsible for handling bills and paychecks.
Now in this context, it does not really make sense to have a generic Person object any more. Right, we're only gonna be working either with students or faculty.
And we're also going to change the context in the sense that I want to be able to send out monthly statements.
We want a method in the Person class, which sends out a monthly statement to either students or faculty.
The features desired is to be able to force my subclasses, both student and faculty class, to override this method.
Remove the Person objects, because they don't make sense in this context anymore but keep the Person references.
Keep that common code we had, like the name of the person. This indicates to use an abstract class.
The way to define an abstract class is essentially just to use the keyword abstract.
Stating

    public abstract class Person


Abstract will not allow an instance of this class to be created.
Can't actually create an object of type Person, but now are able to create an objects of derived classes, which are concrete.
If any method defined within this class is abstract then the whole class is required to be abstract.
But what I can do then is say, have a public abstract void monthlyStatement.
I can say, my derived classes have to override this method.
It's a nice way of forcing the subclasses to have methods.
With an abstract class, you get two things.

* You get to inherit both implementation and interface. And what I mean by that is that with an implementation you get instance variables or methods, which essentially define that common behavior that any person should have.
* Also get an interface. You say what methods and interests have to be overridden in my subclasses.
There are times where both will not be wanted, may just want the interface.
If you want just the interface, then you're gonna use interfaces.

And if we go back to our example, I really believe an abstract class is appropriate for the hypothetical that we were just talking about.

But let's say that you had no common code in the Person class.
If there's something common there, then you just use an interface.
And an interface will give us the ability to force subclasses to have a method, to stop having actual Person objects, and will allow us to keep having Person references.
Now interfaces only define the methods that are required, and classes can inherit actually from multiple interfaces.
So you can inherit from an abstract class and also inherit from multiple interfaces, all within one class.
So let's look at an example of an interface.
So the most common one discussed is the comparable interface.
Now comparable gives you the ability to compare an object to another object of that same type.
You're gonna notice some terminology here, those brackets with the E, that refers to Generics.
We'll discuss those a bit more later.
This allows us to compare two objects.
Now why would I want an interface like this? Take a few seconds to think about it, I'll come back.
All right.
If you're thinking it's useful to be able to compare objects in case you, say, wanna sort them, that's exactly the purpose for having Comparable.
So if you wanna have a data structure and know some way of storing and ordering among those objects, comparable's exactly what you wanna do for the objects.
And the way that we would do this for say the Person class, is to say, have the Person class implement a Comparable interface.
And then within that all I have to do is override that one method, compareTo, and then define the behavior I want.
In this case, I define the behavior to be a comparison of the strings using the compareTo method in the string class, because the string class implements the Comparable interface.
So if you're trying to design a class hierarchy, you're often gonna be wondering, should I be making this an interface or an abstract class? And the general rule of thumb is, if you just want to require methods, that's an interface.
If you want to potentially require methods, you don't have to, but if you potentially want to require methods, and you wanna require a common behavior, that's where an abstract class comes in.

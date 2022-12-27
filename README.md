# object_oriented_programming1
implements observer pattern

## Observer Design Pattern
The observer pattern is a software design pattern in which an object, named the subject, maintains a list of its dependents, called observers, and notifies them automatically of any state changes, usually by calling one of their methods.


## Overall View
In this task we use observer pattern to update specific text .
We use a few classes: GroupAdmin and ConcreteMember in accordance with the traditional classes of observer pattern: subject and observer.
In the following file we will explain each class and his references.

### Group Admin Class:
This class implements the Sender interface which parallel the subject class in the observer pattern.
It has two references :
1.UndoableStringBuilder- who contains the text we want to update.
2.Members- an ArrayList of members in this group.
Generally, this class is responsible for the observers and in addition it has its own text.

### Concrete Member Class:
This class implements the Member interface which parallel the observer class in the observer pattern.
It has one reference :
UndoableStringBuilder- who contains the text we want to update.
Generally, this class is responsible for a specific member in this group.

#### Tests:
In this class we test our program by the size of the object in memory using the JvmUtilities class and its methods.


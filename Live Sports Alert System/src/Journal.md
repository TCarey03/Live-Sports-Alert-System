Live Sports Alert System Journal
Phase 1 — The Data Store
Journal Prompt

Why is keeping data management separate from notification logic a good design practice in software architecture?

Keeping data management separate from notification logic is a good design practice because it makes the program easier to understand, maintain, and modify. The GameTicker is responsible for storing game updates and retrieving the latest update, while notification logic can be handled by other classes later in the project.

This separation also helps reduce coupling between different parts of the program. If the way game updates are stored changes in the future, I would not have to rewrite the notification classes. It also makes the code easier to test because I can test the GameTicker separately from the notification system.

My Approach

I used an ArrayList<String> to store the history of game updates. The addUpdate() method adds new events to the list, while getLatestUpdate() retrieves the most recent event by accessing the last item in the list.

Questions / Challenges

One thing I had to think about was what should happen if getLatestUpdate() is called before any updates have been added. I decided to return "No updates available." instead of trying to access an empty list.

----------------------------------------------------------------

Phase 2 — The Infrastructure
Journal Prompt

Explain how these interfaces decouple the notification system from specific classes like SocialMediaBot.

The Subject and Observer interfaces help decouple the notification system because they define what each object must be able to do without requiring the classes to know the details of each other.

The Subject interface provides methods for registering, removing, and notifying observers. The Observer interface requires any observer to have an update() method.

For example, the GameTicker will be able to work with any class that implements Observer. It does not need to specifically know that an observer is a SocialMediaBot. This means I could add a new type of notification later without changing the basic notification system.

This makes the program more flexible and easier to maintain because the classes depend on interfaces instead of specific implementations.

My Approach

I created an Observer interface with an update() method. I also created a Subject interface with register(), remove(), and notifyObservers() methods.

At this stage, the interfaces only define the required behavior. The actual implementation will be added to GameTicker in Phase 3.

Questions / Challenges

The main concept I had to understand was that an interface defines a contract rather than providing the actual implementation. The interfaces tell the classes what methods they must have, while the concrete classes will determine how those methods work.

-------------------------------------------------------------------

Phase 3 — The Concrete Subject
Journal Prompt

Describe the logic inside your notifyObservers loop. How does looping over the Observer interface type allow your ticker to broadcast updates without knowing what kind of displays are listening?

The notifyObservers() method loops through the list of registered observers. For each observer, it calls the update() method defined by the Observer interface.

The ticker does not need to know what specific type of object each observer is. It only needs to know that the object implements the Observer interface and therefore has an update() method.

This allows the ticker to notify many different types of objects without being tightly coupled to them. For example, a mobile notification, stadium display, and social media bot can all receive the same notification even though they perform different actions.

My Approach

I modified GameTicker so that it implements the Subject interface. I added an ArrayList<Observer> to keep track of registered observers.

I implemented register() to add observers, remove() to remove observers, and notifyObservers() to loop through all registered observers and call their update() methods.

I also modified addUpdate() so that observers are automatically notified whenever a new game update is added.

Questions / Challenges

The biggest concept I had to understand was why the GameTicker stores Observer objects instead of specific classes. Using the interface allows different types of observers to be stored in the same list and notified using the same update() method.

-------------------------------------------------------------------------

Phase 4 — The Concrete Observers
Journal Prompt

You’ll need to do something to get the data to these observers, which may include modifying the update() method. Are you using the Push or Pull method of data sending here?

I am using the Pull method of data sending. When the GameTicker receives a new update, it calls the update() method on each registered observer. The ticker does not directly send the game update to the observer.

Instead, each observer has a reference to the GameTicker and calls getLatestUpdate() inside its update() method. This means the observer pulls the current information from the ticker when it receives a notification.

For example, the MobilePushNotification calls ticker.getLatestUpdate() and then prints the result as a push alert. The StadiumDisplay and SocialMediaBot do the same thing but format the information differently.

My Approach

I created three concrete observer classes: MobilePushNotification, StadiumDisplay, and SocialMediaBot.

Each class implements the Observer interface and therefore must provide an update() method. Each observer receives a reference to the GameTicker through its constructor so it can retrieve the latest update.

The three observers display the same game information in different ways. The mobile notification prints PUSH ALERT, the stadium display prints SCREEN UPDATE, and the social media bot prints TWEET followed by #GameDay.

Questions / Challenges

I had to understand the difference between notifying an observer and actually sending data to an observer. The GameTicker only calls update(), while the observers retrieve the information themselves. This helped me understand why this implementation is considered the Pull method.

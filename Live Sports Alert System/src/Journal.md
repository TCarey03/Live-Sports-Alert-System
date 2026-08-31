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

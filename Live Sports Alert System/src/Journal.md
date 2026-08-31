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
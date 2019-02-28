# petrol-station-simulation
a petrol station simulation program using #Java #threading and #semaphore
Description
The petrol station should be designed to have n pumps; only one client can be served on a single pump at a time validating the following rules.
- The petrol station is initially empty.
- If a client arrives (print a message that a client has arrived) and if a free pump exists, the client should
 Occupy pump
 Get served.
 Pay
 Leave
Note: these actions will be represented by printed messages, such that there is a random waiting time between the printed messages when a client arrives, gets served, pays and leaves
- If a client arrives and all pumps are occupied, he must wait until one of the currently available clients finishes his service and leave.
- After finishing a client finishes his service, a client leaves and one of the waiting clients (if exist) will enter that pump.
Program Input:
 N: Number of pumps inside the petrol station.
 TC: total number of clients with their names (ex: C1, C2, C3…)
Program Output:
The execution order of the Clients’ threads and the printed messages of each client

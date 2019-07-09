1. Runnable -> define a task  
simple call runnable.run() will use the current thread, not starting a separate thread

2.use Thread constructor to start a separate thread. 
thread.start() will do the necessary initialization and start the task in a separate thread 

Thread will register itself so even you do not have the reference, the reference will be kept. gc cannot clean it up until the task exits its run() and dies. 

3.Use executor service
creating and destroying thread has overhead. Excutor service is preferred.

4. types of thread pool
CachedThreadPool
FixedThreadPool
SingleThreadPool
ScheduleThreadPool

singleThreadPool suitable for long-live task, such as socket. task will be queued. 

5. runnable does not return value 
callable can have return value. 

use executorService.submit() to invoke.
executorService.submit() will produce a Future object. 
isDone() -> check if completed.
get() -> fetch result

Thread.yield()
Thead.sleep(): stop task execution for a given time period. 

6.Priority of Threads
High priority threads run more often
getPriority()
setPriority()
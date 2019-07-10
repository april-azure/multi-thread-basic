### Runnable -> define a task  
simple call runnable.run() will use the current thread, not starting a separate thread

### use Thread constructor to start a separate thread. 
thread.start() will do the necessary initialization and start the task in a separate thread 
Thread will register itself so even you do not have the reference, the reference will be kept. gc cannot clean it up until the task exits its run() and dies. 

### Use executor service
creating and destroying thread has overhead. Excutor service is preferred.

### types of thread pool
- CachedThreadPool
- FixedThreadPool
- SingleThreadPool
- ScheduleThreadPool

singleThreadPool suitable for long-live task, such as socket. task will be queued. 

### runnable does not return value 
callable can have return value. 

use executorService.submit() to invoke.
executorService.submit() will produce a Future object. 

isDone() -> check if completed.
get() -> fetch result
Thread.yield()
Thead.sleep(): stop task execution for a given time period. 

### Priority of Threads
High priority threads run more often (probably)
getPriority()
setPriority()

### daemon threads
ÊØ»¤½ø³Ì
Background service 
a program can not be terminated if non-threads are running

### extends Thread class 
able to start the thread in constructor -> not good. 

### join thread
`join()` on another thread to wait for the second thread to complete before proceeding.  
A calls t.join(), A will wait until t finishes
join() can be aborted using `interrupt()` 

### exception in a thread cannot be caught normally in other thread.
Thread.UncaughtExceptionHandler.uncaughtException() 
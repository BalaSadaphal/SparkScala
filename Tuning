
Properties

Essentials:

spark.executor.memory – specifies the executor’s process memory heap (default 1 GB), In this case assume 7 GB
spark.driver.memory – specifies the driver’s process memory heap (default 1 GB)
spark.memory.fraction – a fraction of the heap space (minus 300 MB * 1.5) reserved for execution and storage regions (default 0.6)


Off-heap:(Available for execution since Spark 1.6 and available for storage since Spark 2.0)

spark.memory.offHeap.enabled – the option to use off-heap memory for certain operations (default false)
spark.memory.offHeap.size – the total amount of memory in bytes for off-heap allocation. 
It has no impact on heap memory usage, so make sure not to exceed your executor’s total limits (default 0)


Total Memory 	= Executor Memory(Executor Heap Memory)
		= Reserved Memoory + User Memory + Spark Memory(Storage Mem + Execution Mem)
7 GB		= 0.3 GB	   + 2.7 GB	 + 		4.02 GB

Reserved Memory	= 300 MB

User Memory 	= (7 GB-300MB)* (1.0 – spark.memory.fraction(0.6))
reserved for storing various meta-data, user data structures, safeguarding against OOM errors
		= 2.7 GB

Spark Memory 	=  (“Java Heap” – “Reserved Memory”) * spark.memory.fraction
		= 4.02 GB

Spark Memory 	= Storage Mem + Execution Mem

spark.memory.storageFraction = 0.5 default (but this parameter is dynamic) changes as per the application need

Storage Memory 	= Cached data + temporary space serialized data “unroll” + broadcast variables

Execution Memory= Memory used for shuffles, joins, sorts and aggregation. 
		  This pool is used for storing the objects required during the execution of Spark tasks.
Dynamic setting of memory pools for Storage and Execution memory forces Storage to Disk in either way.
i.e. If Storage uses Execution Mem, and no further space, then LRU data from Storage Memory will be spilled(evicted) to disk
OR vice a versa, if Execution uses Storage Memory and no further space then also LRU data from Storage Memory will be spilled(evicted) to disk


Some tricks:

1. Enable Dynamic Resource Allocation if not.
2. Enable Off Heap Memory Usage for reducing GC pauses
3. Goto Spark UI => Open One Stage => Sort the tasks by Duration in desc order, Look for the GC time.
4. Detect short=lived tasks(<20 ms) and use coalesce or epartition oprator to shrink the partitions especially after filtering.
5. Detecting skew: See avg. response time of task vs max. response time of task, If diffrence is > 100 X then there is skew.
	Two types of Skew:
	1) Data Skew
	If a problem such as data skew occurs. for e.g city wise revenue and if one of the city is largest city and has huge 
	number of records than other, then you would have to do partial aggregations followed by global one. that is change the logic
	of the program.
	
	2) Worker skew: Some slow executers on one particular node
	Identify if all the slow executers belong to the same node?
	Set spark.speculation = true
	Remove slow nodes over time

6. Not setting spark.local.dir
	spark.local.dir is where the shuffle files are written if OS cache(buffer) is not enough to accomodate the shuffle data
	ideally a dedicated disk or sets of disks should be given to this parameter
	spark.local.dir=/mnt1/spark, /mnt2/spark , mnt3/spark

7. Not setting the number of reducers
	Default behaviour: inherits # of reducers from parent RDD
	Too many reducers:
	-> Tasks launching overhead becomes the issue(will see many small tasks)
	Too few reducers:
	-> Limits the parallelism in cluster.

8. JVM Utilities:
	jstack <pid> =>jvm stack trace
	jmap -histo:live <pid> =>heap summary

9. System Utilities:
	dstat =>io and CPU stats
	iostat => disk stats
	lsof -p <pid> => tracks open files

10. By default, spark.executor.memory = 1g
	1g allows small jobs to finish out of the box, Spark assumes you'll increase this parameter

11. Cheat sheet Perf Tuning => http://techsuppdiva.github.io/spark1.6.html

References :: 
https://databricks.com/session/deep-dive-apache-spark-memory-management

Deep Drive into Project Tungsten: Bringing Spark closer to Bare Metal
https://www.youtube.com/watch?v=5ajs8EIPWGI

Spark Performance: What's next
https://www.youtube.com/watch?v=JX0CdOTWYX4

Unified Memory Management
https://issues.apache.org/jira/browse/SPARK-10000


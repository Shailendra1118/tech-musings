## Important concepts

# JVM helpful flags and parameters 
```
-XX:+HeapDumpOnOutOfMemoryError and -XX:HeapDumpPath=/dumps/oom.bin
```
If K8 restart the containers it might also clear up this heapdump file created with this flag, so as a work around create an empty mounted directory and instruct to create a dump file there. So when pod restarts it will not clears the this directory and dump from previous run will be there.

# JVM 11 changes 
-XX:+PrintGCDetails and other GC related commands are not supported in JVM 11 and replaced with -Xlog:gc*

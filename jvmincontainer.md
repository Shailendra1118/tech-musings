## Important concepts

# JVM helpful flags and parameters 
```
-XX:+HeapDumpOnOutOfMemoryError and -XX:HeapDumpPath=/dumps/oom.bin
```
If K8 restart the containers it might also clear up this heapdump file created with this flag, so as a work around create an empty mounted directory and instruct to create a dump file there. So when pod restarts it will not clears the this directory and dump from previous run will be there.

# JVM 11 changes 
-XX:+PrintGCDetails and other GC related commands are not supported in JVM 11 and replaced with -Xlog:gc*

## JVM in container

### Docker memory
- JVM running in a container can see available memeory of the machine instead of available in a docker container (set in yaml file) - This can result into pod/container OOMKilled by OOM-Killer because it tries to use amount of memeory that exceeds limit of docker container

- To be able to make JVM aware of memory available to docker container, we can use parameters 
```
-XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -XX:MaxRAMFraction=1 (-XX:MaxRAMPercentage=70.0 can be used directly on JDK 10 above and UseContainerSupport flag is activated by default)
```
These are available to JDK 9 and above and backported to JDK 8 using flag UnlockExperimentalVMOptions.
- It is important to notify JVM (that is done by -XMx or dynamically UseCGroupMemoryLimitForHeap) when memory usage is approaching its limit so it should free up some space. If not so JVM may try to hit the limit without freeing up memeory and in turn will be killed.

### Docker CPU 
- JDK 9 onwwords the JVM is Docker-aware with respect to Docker CPU limits transparently. That means if -XX:ParalllelGCThreads, or -XX:CICompilerCount are not specified as command line options, the JVM will apply the Docker CPU limit as the number of CPUs the JVM sees on the system. The JVM will then adjust the number of GC threads and JIT compiler threads just like it would as if it were running on a bare metal system with number of CPUs set as the Docker CPU limit

## Create heap dump of OOM
- By default the heap dump is created in a file called java_pid.hprof in the working directory of the VM. 
- Make sure that the java process has write access to the directory where the heap dump is written.
- Your working directory can be found via the pwdx <PID> command. The pid number for the Java program process is with the greatest probability 1 but you can find out with the command ps -ef | grep java. Then run pwdx <PID> and it will tell you the working directory.
```
-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/dumps/oom.bin
```



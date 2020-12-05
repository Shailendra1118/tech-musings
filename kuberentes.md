## Minikube setup and start
```
minikube start --driver=hyperkit (will download docker-machine-driver-hyperkit if driver is not there)
minikube start --vm-driver=hyperkit --memory 4092
$ eval $(minikube docker-env) | <undo> eval $(docker-env -u)
minikube detele
```

## Docker commands
```
docker build --tag myapp:1.0 . (finds Dockerfile in current directory)

docker run --name batch-mq -d -p 8080:8080 batch-mq:latest
-d start container in detached mode
-p expose container internal port

docker container ls | list docker containers

docker container rm <containerID> 

docker logs <containerID> | show logs of mentioned container

docker container logs <containerID>

docker rmi <imageID> | remove docker image

docker stop containerID

docker exec -it containerID /bin/sh
```

## Kubectl commands
```
kubectl -n <namespace> od-1234 port-forward <Pod> [localport:remoteport]

kubectl -n <namespace> get pods | list all pods

kubectl -n <namespace> get svc

kubectl apply -f mysql.yaml | create K8 resources, -f=filename

kubectl describe deployment mysql

kubectl logs nginx

kubectl logs -p -c ruby web-1 | return snapshot of previously terminated ruby container logs from pod web-1, -p=previous

kubectl logs -f -c ruby web-2 | streaming of logs, -f=follow

kubectl logs --tail=20 nginx | last 20 lines from pod nginx

kubectl logs --since=1h nginx

kubectl rollout SUBCOMMAND | manages a deployment using subcommand e.g. kubectl rollout undo deployment/abc
```

## Resource Units in K8
- One cpu unit is equivalent to 1 vCPU/Core for cloud providers and 1 hyperthread on bare-metal Intel processors.
```
resources:
  requests:
    memory: 50Mi
    cpu: 50m
  limits:
    memory: 100Mi
    cpu: 100m
```
The unit suffix m stands for “thousandth of a core,” so this resources object specifies that the container process needs 50/1000 of a core (5%) and is allowed to use at most 100/1000 of a core (10%).

- The cpu control group and docker both divide a core into 1024 shares, whereas kubernetes divides it into 1000

## Troubleshootig tips
```
kubectl top pod <pod_name>  -n kube-system | show resource usage for this pod like docker stats <container_id>
```
- kubectl top pod command refere container_memory_working_sets_byte, a prometheus metric exposed by cAdviser from K8.
I would suggest using the one from kubectl top, because it is the one showed in Prometheus charts and also because working_set_bytes is what OOMKiller is watching for to decide if a container must be killed.
- Docker stats instead collects metric directly from operating system and specifically from the /sys/fs/cgroup/memory special files.


## Port kill util on MacOS
```
npx kill-port 5005 5006 5007
```

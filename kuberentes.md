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


## Port kill util on MacOS
```
npx kill-port 5005 5006 5007
```

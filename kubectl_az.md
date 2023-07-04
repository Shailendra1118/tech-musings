## Handy commands while working with Kubernetes/ AKS

### Testing ClusterIP type of service -
- `kubectl port-forward <pod_name> <your_local_port>:<container_por>`
- You can access your app by hitting http://localhost:<local_port>/api_end_point



### Helm charts
- `helm install <app-name> <directory_name>/`
- `helm list`
- `helm uninstall <name>`
- `helm upgrad -i <app_name> <directory_name>/`

### Working with AKS
- Install `kubectl` and `azure-cli`
- Install `kubelogin` and add it in PATH (e.g. in Windows, `PATH=C:\Program~1\kubelogin\bin\windows_amd64` etc)
- Run `az login`
- Run `az account set --subscription <subscriptionID>`
- Run `az aks get-credentials --resource-group <resource_group_name> --name <k8_service_cluster>` (--file .kubeconfig, this could be automatically generated or merged with existing context and you might get a message like `merged "kdxxxxx" as the current context in C:\Users\user1234\.kube\config`)
- Set KUBECONFIG in the env variable
- Run `kubectl config set-context <context_name_in_kubeconfig_file>`
- Maybe also `kubectl config use-context <context_name>`. Use this if you already have some other context present like Rancher locally.

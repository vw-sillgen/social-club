# Tanzu
* [install tanzu and requirements](https://docs.vmware.com/en/VMware-Tanzu-Kubernetes-Grid/1.6/vmware-tanzu-kubernetes-grid-16/GUID-install-cli.html#download-and-unpack-the-tanzu-cli-and-kubectl-1)
* [create a management cluster](https://docs.vmware.com/en/VMware-Tanzu-Kubernetes-Grid/1.6/vmware-tanzu-kubernetes-grid-16/GUID-mgmt-clusters-deploy-management-clusters.html)
```
tanzu mc create --ui --file tanzu/social-management-cluster.yaml
```
* [create a workload cluster](https://docs.vmware.com/en/VMware-Tanzu-Kubernetes-Grid/1.6/vmware-tanzu-kubernetes-grid-16/GUID-tanzu-k8s-clusters-index.html)
```
tanzu cluster create social-workload-cluster -f tanzu/social-aws-tkc.yaml
tanzu cluster get social-workload-cluster
```
* [deploy and access application to the workload cluster](https://docs.vmware.com/en/VMware-Tanzu-Kubernetes-Grid/1.6/vmware-tanzu-kubernetes-grid-16/GUID-tanzu-k8s-clusters-tutorial.html)
```
kubectl apply -f social-application.yaml
kubectl expose deployment hello-world --type=LoadBalancer --name=my-service
kubectl describe services my-service
```
* in a browser navigate to https://IP:PORT where
    * IP .. LoadBalancer Ingress
    * PORT .. TargetPort
    * example: ``http://a9b026dcd488c495cb4994c7d31f0ac3-1663560177.eu-west-1.elb.amazonaws.com:8080/``
* delete a workload cluster and management cluster
```
tanzu cluster delete social-workload-cluster
tanzu mc delete social-management-cluster
```

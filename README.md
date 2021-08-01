[![CircleCI](https://circleci.com/gh/snowdrop/rest-http-example/tree/master.svg?style=shield)](https://circleci.com/gh/snowdrop/rest-http-example/tree/master)

https://appdev.openshift.io/docs/spring-boot-runtime.html#mission-http-api-spring-boot

### Move to SIT

oc new-project common-sit

oc policy add-role-to-user system:image-puller system:serviceaccount:common-sit:default -n common

oc -n common tag common/services:latest common-sit/services:latest

oc apply -f configmap-sit.yaml 

oc apply -f deployment-sit.yaml 

oc expose deployment/services

oc expose svc services
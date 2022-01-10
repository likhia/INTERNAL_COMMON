[![CircleCI](https://circleci.com/gh/snowdrop/rest-http-example/tree/master.svg?style=shield)](https://circleci.com/gh/snowdrop/rest-http-example/tree/master)

https://appdev.openshift.io/docs/spring-boot-runtime.html#mission-http-api-spring-boot

### DEV

* Create a new project called database 

* Install MySQL database.   Go to  `Developer` mode.   Click on +Add.  Click on `Database`.

* Select `MySQL'.  Choose the one that is not ephemeral. 

* Set username as `admin` and all password as `redhat` and set MySQL Database Name as `cars`.  Click on [Create]

* oc login,  oc project database

* oc apply -f create-lb-service-mysql.yaml

* Go to OCP console to get the external lb host name and replace `spring.datasource.url` property in application.properties and jkube/configmap.yaml

* oc new-project common

* Click on `Deploy to Openshift`

### Move to SIT

* oc new-project database-sit 

* Install MySQL database.   Go to  `Developer` mode.   Click on +Add.  Click on `Database`.

* Select `MySQL'.  Choose the one that is not ephemeral. 

* Set username as `admin` and all password as `password` and set MySQL Database Name as `cars`.  Click on [Create]

* Delete the 2 default network policies and create another 2 network policies.

```
kind: NetworkPolicy
apiVersion: networking.k8s.io/v1
metadata:
  name: deny-by-default
  namespace: database-sit
spec:
  podSelector: {}
  policyTypes:
    - Ingress

```

```
kind: NetworkPolicy
apiVersion: networking.k8s.io/v1
metadata:
  name: allow-sit-services
spec:
  podSelector:
    matchLabels:
      name: mysql
  ingress:
    - from:
      - namespaceSelector:
          matchLabels:
            env: sit

```

* oc new-project common-sit

* oc label namespace common-sit  env=sit

* oc policy add-role-to-user system:image-puller system:serviceaccount:common-sit:default -n common

* oc -n common tag common/services:latest common-sit/services:latest

* change `spring.datasource.url` in configmap-sit.yaml to point to db in SIT 

* oc apply -f configmap-sit.yaml 

* oc apply -f deployment-sit.yaml 

* oc expose deployment/services

* oc expose svc services

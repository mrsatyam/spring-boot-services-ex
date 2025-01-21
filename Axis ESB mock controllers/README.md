# Limit

For Limit Service

# How to deploy?

To Limit the folllowing code in docker create a build using

```
  mvn clean install
```

a jar will be created in .target.

Use the following command to build the docker image.

```
  docker build --tag=limit-service:latest .
```

To run the webservice use following command

```
  docker run -p 8086:8086 limit-service:latest
```

To commit the image

```
  docker commit <image name>
 ``` 

To Push the image

  ```
 docker push username/reponame:limit-service
```
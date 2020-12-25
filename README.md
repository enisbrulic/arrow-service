## example project built with Quarkus and extensions, metrics, health and openshift

```shell
mvn io.quarkus:quarkus-maven-plugin:1.10.5.Final:create \
    -DprojectGroupId=io.arrowhacks.archery-shop \
    -DprojectArtifactId=arrow-service \
    -DclassName="io.arrowhacks.archeryshop.arrowservice.boundary.ArrowResource" \
    -Dpath="/speed" \
    -Dextensions="smallrye-metrics, smallrye-health, openshift"
```
-> [Quarkus - building application with maven]

## run local
```shell
mvn clean compile quarkus:dev
```

## invoke
```shell
http :8080/speed

HTTP/1.1 200 OK
Content-Length: 29
Content-Type: text/plain;charset=UTF-8

arrow speed measured: 327 fps
```

## check metrics
```shell
http :8080/metrics

HTTP/1.1 200 OK
Access-Control-Allow-Credentials: true
Access-Control-Allow-Headers: origin, content-type, accept, authorization
Access-Control-Allow-Methods: GET, POST, PUT, DELETE, OPTIONS, HEAD
Access-Control-Allow-Origin: *
Access-Control-Max-Age: 1209600
Content-Type: text/plain
content-length: 8791

# HELP application_io_arrowhacks_archeryshop_arrowservice_boundary_ArrowResource_speed_service_performed_total count the service invokes.
# TYPE application_io_arrowhacks_archeryshop_arrowservice_boundary_ArrowResource_speed_service_performed_total counter
application_io_arrowhacks_archeryshop_arrowservice_boundary_ArrowResource_speed_service_performed_total 2.0
# HELP base_classloader_loadedClasses_count Displays the number of classes that are currently loaded in the Java virtual machine.
# TYPE base_classloader_loadedClasses_count gauge
base_classloader_loadedClasses_count 8924.0
# HELP base_classloader_loadedClasses_total Displays the total number of classes that have been loaded since the Java virtual machine has started execution.
# TYPE base_classloader_loadedClasses_total counter
base_classloader_loadedClasses_total 8924.0
[...]
```

## check health
```shell
http :8080/health

HTTP/1.1 200 OK
content-length: 46
content-type: application/json; charset=UTF-8

{
    "checks": [],
    "status": "UP"
}
```


[//]:  # (hidden section)

[Quarkus - building application with maven]: https://quarkus.io/guides/maven-tooling


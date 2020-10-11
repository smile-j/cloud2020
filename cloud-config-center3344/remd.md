http://localhost:3344/master/config-dev.yml

curl -X POST "http://localhost:3344/actuator/bus-refresh"
curl -X POST "http://localhost:3344/actuator/bus-refresh/config-client:3355,3366"


公式：http://localhost:配置中心的端口号/actuator/bus-refresh/{destination}
执行命令：


java -javaagent:../elastic-apm-agent-1.17.0.jar -Delastic.apm.service_name=gupao-javaapm01 -Delastic.apm.server_urls=http://192.168.199.217:8200 -Delastic.apm.secret_token= -Delastic.apm.application_packages=com.liuyan -jar gupaoedu-javaapmdemo-1.0.jar


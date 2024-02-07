#### First thanks Sergey Kargopolov's article 'https://www.appsdeveloperblog.com/micrometer-and-zipkin-in-spring-boot/' solved my problem
<h4>I was tortured by how to use micrometer to trace request, like versions' compatibility. I have tried 10 hours for this shit. 

#### To trace the request for debugging microservices, we only need 2 dependencies below:
<b>micrometer-observation and micrometer-tracing-bridge-brave</b>  
For tracing the request with open-feign, you have to add Capability bean in the Config class, otherwise, each service will show 
different traceId, and trace parent will be null which really confused me.
And you have to use RestTemplateBuilder to create restTemplateBean to trace the request going through restTemplate

#### OPEN API: http://localhost:port/swagger-ui/index.html

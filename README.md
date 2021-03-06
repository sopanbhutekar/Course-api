# Course-api
This is sample spring boot project from scratch, starting as maven project

# Database: Embeded Apache derby

# Topics API:
1. fetch all topics GET {endpoint}/topics  
2. Create new Topic POST {endpoint}/topics 
3. Update Existing Topic PUT {endpoint}/topics/{topicId}
4. Delete Existing Topic DELETE {endpoint}/topics/{topicId}
5. Get topic by Id GET {endpoint}/topics/{topicId}

# Course API:
1. Fetch all Courses in topic GET {endpoint}/topics/{topicId}/courses
2. Fetch Course by Id in Topic GET {endpoint}/topics/{topicsId}/courses/{courseId}
3. Create Course in Topic POST {endpoint}/topics/{topicsId}/courses
4. Update Existing Course in Topic PUT {endpoint}/topics/{topicId}/courses/{courseId}
5. Delete Existing COurse in topic DELETE {endpoint}/topics/{topicId}/courses/{courseId}

# Actuator API:
1. get exposed endpoints {endpoint}/actuator
2. get health {endpoint}/actuator/health
3. get beans {endpoint}/actuator/beans
4. get threaddump {endpoint}/actuator/threaddump

# Exception Handling:
1. Custom Exception Handling like TopicNotFoundException and CourseNotFoundException 
2. HttpMessageNotReadableException and HttpRequestMethodNotSupportedException by overriding methods from ResponseEntityExceptionHandler

#Swagger UI:
{endpoint}/swagger-ui.html

#Swagger2 Docs:
{endpoint}/v2/api-docs
# use log-plug-in 
##1、Import jar
```xml

```
##2、Implement log service interface
```java
public class LogSaveServiceImpl implements LogOperationsService{

    @Override
    public void save(LogzlVO vo) {
        //获取到日志数据
    }

    @Override
    public void saveOrUpdate(LogzlVO vo) {
        //设置了results返回结果，获取到日志数据
    }
}
```
##3、add annotation at controller
@LogTag(name="",title="")

# stop log

```properties
#Default true
aspect.logTag-enable=false
```


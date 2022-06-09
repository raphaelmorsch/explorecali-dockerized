# explorecali-dockerized
Continuation of Microservices with SpringBoot (now Dockerized and Secured)


More info soon
- Never use Springboot under 2.5.0 with Java 17 (it leads to a java.lang.reflect.InaccessibleObjectException)
~~~
Caused by: java.lang.reflect.InaccessibleObjectException: Unable to make protected final java.lang.Class java.lang.ClassLoader.defineClass(java.lang.String,byte[],int,int,java.security.ProtectionDomain) throws java.lang.ClassFormatError accessible: module java.base does not "opens java.lang" to unnamed module @39aeed2f
    at java.base/java.lang.reflect.AccessibleObject.checkCanSetAccessible(AccessibleObject.java:357)
    at java.base/java.lang.reflect.AccessibleObject.checkCanSetAccessible(AccessibleObject.java:297)
    at java.base/java.lang.reflect.Method.checkCanSetAccessible(Method.java:199)
    at java.base/java.lang.reflect.Method.setAccessible(Method.java:193)
    at net.sf.cglib.core.ReflectUtils$1.run(ReflectUtils.java:61)
    at java.base/java.security.AccessController.doPrivileged(AccessController.java:554)
    at net.sf.cglib.core.ReflectUtils.<clinit>(ReflectUtils.java:52)
    at net.sf.cglib.core.KeyFactory$Generator.generateClass(KeyFactory.java:243)
    at net.sf.cglib.core.DefaultGeneratorStrategy.generate(DefaultGeneratorStrategy.java:25)
    at net.sf.cglib.core.AbstractClassGenerator.generate(AbstractClassGenerator.java:332)
~~~

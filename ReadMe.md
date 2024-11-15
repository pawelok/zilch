### Run api Tests:

Ensure maven and java 11+ is installed

```bash
mvn -Dtest=ApiTests test
```

### Run mobile tests (Android only)

Req:

- maven
- java 11
- Appium server 1.23+
- Android platofrom
- Android API
- Ensure ANDROID_HOME and JAVA_HOME is in your env/sys variables
- Ensure uiautomator2 driver is installed in appium

1. run appium

```bash
appium &
````

2. set env variables

```bash
set APP_ID=com.payzilch.app;
set APP_ACTIVITY=com.payzilch.app.MainActivity
set PLATFORM=android;
set DEVICE_UDID={provide device udid};
```

if using mac replace 'set' with 'export'

3. Execute tests

```bash
mvn -Dtest=mobile.initial.** test
```
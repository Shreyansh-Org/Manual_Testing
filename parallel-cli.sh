#!/bin/bash

# Parallel job 1
(
  cd /Users/shreyanshc/Documents/Automation-Manual/ManualTestingJava || exit
  export PROJECT_TOKEN='33627706#01KCKZ854RTC8QV17VX6QMVNJX#BuildNumber_issue_03'
  export SMARTUI_CLIENT_API_URL='https://stage-api.lambdatestinternal.com/visualui/1.0'
  export JAVA_HOME=$(/usr/libexec/java_home -v 23)
  npx smartui exec -- mvn test -Dsuite=sdk-local.xml
) &

# Parallel job 2
(
  cd /Users/shreyanshc/Documents/Automation-Manual/ManualTestingJava || exit
    export PROJECT_TOKEN='33627706#01KCKZ854RTC8QV17VX6QMVNJX#BuildNumber_issue_03'
    export SMARTUI_CLIENT_API_URL='https://stage-api.lambdatestinternal.com/visualui/1.0'
    export JAVA_HOME=$(/usr/libexec/java_home -v 23)
    npx smartui exec -- mvn test -Dsuite=sdk-local.xml
) &

# Parallel job 3
(
 cd /Users/shreyanshc/Documents/Automation-Manual/ManualTestingJava || exit
   export PROJECT_TOKEN='33627706#01KCKZ854RTC8QV17VX6QMVNJX#BuildNumber_issue_03'
   export SMARTUI_CLIENT_API_URL='https://stage-api.lambdatestinternal.com/visualui/1.0'
   export JAVA_HOME=$(/usr/libexec/java_home -v 23)
   npx smartui exec -- mvn test -Dsuite=sdk-local.xml
) &

# Parallel job 4
(
  cd /Users/shreyanshc/Documents/Automation-Manual/ManualTestingJava || exit
    export PROJECT_TOKEN='33627706#01KCKZ854RTC8QV17VX6QMVNJX#BuildNumber_issue_03'
    export SMARTUI_CLIENT_API_URL='https://stage-api.lambdatestinternal.com/visualui/1.0'
    export JAVA_HOME=$(/usr/libexec/java_home -v 23)
    npx smartui exec -- mvn test -Dsuite=sdk-local.xml
) &

(
  cd /Users/shreyanshc/Documents/Automation-Manual/ManualTestingJava || exit
  export PROJECT_TOKEN='33627706#01KCKZ854RTC8QV17VX6QMVNJX#BuildNumber_issue_03'
  export SMARTUI_CLIENT_API_URL='https://stage-api.lambdatestinternal.com/visualui/1.0'
  export JAVA_HOME=$(/usr/libexec/java_home -v 23)
  npx smartui exec -- mvn test -Dsuite=sdk-local.xml
) &

(
  cd /Users/shreyanshc/Documents/Automation-Manual/ManualTestingJava || exit
  export PROJECT_TOKEN='33627706#01KCKZ854RTC8QV17VX6QMVNJX#BuildNumber_issue_03'
  export SMARTUI_CLIENT_API_URL='https://stage-api.lambdatestinternal.com/visualui/1.0'
  export JAVA_HOME=$(/usr/libexec/java_home -v 23)
  npx smartui exec -- mvn test -Dsuite=sdk-local.xml
) &

(
  cd /Users/shreyanshc/Documents/Automation-Manual/ManualTestingJava || exit
  export PROJECT_TOKEN='33627706#01KCKZ854RTC8QV17VX6QMVNJX#BuildNumber_issue_03'
  export SMARTUI_CLIENT_API_URL='https://stage-api.lambdatestinternal.com/visualui/1.0'
  export JAVA_HOME=$(/usr/libexec/java_home -v 23)
  npx smartui exec -- mvn test -Dsuite=sdk-local.xml
) &

(
  cd /Users/shreyanshc/Documents/Automation-Manual/ManualTestingJava || exit
  export PROJECT_TOKEN='33627706#01KCKZ854RTC8QV17VX6QMVNJX#BuildNumber_issue_03'
  export SMARTUI_CLIENT_API_URL='https://stage-api.lambdatestinternal.com/visualui/1.0'
  export JAVA_HOME=$(/usr/libexec/java_home -v 23)
  npx smartui exec -- mvn test -Dsuite=sdk-local.xml
) &

(
  cd /Users/shreyanshc/Documents/Automation-Manual/ManualTestingJava || exit
  export PROJECT_TOKEN='33627706#01KCKZ854RTC8QV17VX6QMVNJX#BuildNumber_issue_03'
  export SMARTUI_CLIENT_API_URL='https://stage-api.lambdatestinternal.com/visualui/1.0'
  export JAVA_HOME=$(/usr/libexec/java_home -v 23)
  npx smartui exec -- mvn test -Dsuite=sdk-local.xml
) &

(
  cd /Users/shreyanshc/Documents/Automation-Manual/ManualTestingJava || exit
  export PROJECT_TOKEN='33627706#01KCKZ854RTC8QV17VX6QMVNJX#BuildNumber_issue_03'
  export SMARTUI_CLIENT_API_URL='https://stage-api.lambdatestinternal.com/visualui/1.0'
  export JAVA_HOME=$(/usr/libexec/java_home -v 23)
  npx smartui exec -- mvn test -Dsuite=sdk-local.xml
) &

wait   # Wait for all jobs to finish
echo "All jobs done!"

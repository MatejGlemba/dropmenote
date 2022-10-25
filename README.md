# dropmenote
dropmenote server + db + webview

# build server

- clone repo to local machine
- mvn clean install
- find war file in dropmenote-server-DB/dropmenote-ws/target

# deploy

- Pre spustenie je potrebné dropmenote-ws-1.0-SNAPSHOT.war prekopírovať do apache-tomcat-9/webapps, takisto aj zložku dropmenote-webview.
- Následné je potrebné spustiť server z adresára apache-tomcat-9/bin/startup 


# references
DPM server + db code used from https://bobrik_starbug@bitbucket.org/starbugcompany/starbug-dropmenote-ws.git

matrix java sdk used from https://github.com/kamax-matrix/matrix-java-sdk

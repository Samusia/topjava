call mvn -B -s settings.xml -DskipTests=true clean install
call java -Dspring.profiles.active="datajpa,heroku" -DDATABASE_URL="postgres://user:user@localhost:5432/topjava" -jar target/dependency/webapp-runner.jar target/*.war

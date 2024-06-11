# Demystifying Spring Session
## Introduction
* Youtube: https://www.youtube.com/watch?v=k62bO-W6Sb0
* The program can run on VS Code by clicking play button when Application.java is being open ![](.md/img/s0.vscode.run.png)
* Tips:
  * Update Maven project `mvn clean install -U` 
  * redis-cli: `docker exec -it redis-session-redis-1 redis-cli`
## Step by step
### Step 1: Temporarily disable Redis
You will see Spring Security default login page (http://localhost:8080/login)

![](.md/img/s01.no.redis.login.png)
### Step 2: How to use generated security password?
* Get the generated security password from log: ![](.md/img/s2.gen.pwd.png)
* Login with `user/<generated_password>` ![](.md/img/s2.gen.pwd.login.png)
* See the home page ![](.md/img/s2.logged.in.png)

Further discussion:
* After logged in, we get a `JSESSIONID` in Cookies ![](.md/img/s2.jsid.cookie.png)
* This cookie item is not deleted when you access `/logout` + confirm, it changes to another value instead
* This cookie will change if you access `/login` and log in again

Problems:
* If you restart the server, the new server does not know your session id
* If you scale up the system, add more server and connect to them through load balancer, the randomly new server does not know your session id

This is where Spring Session comes in
### Step 3: Add Redis && Add docker-compose.yml to support redis
* When Redis-based session is applied, the session name in cookies is `SESSION`, not `JSESSIONID` ![](.md/img/s3.cookie.png)
### Step 4: Test Redis & Test session's key-value feature
* In application.properties, set `spring.docker.compose.lifecycle-management=start_only` to start the redis container on start only (do not stop the redis container on stop)
* Use `keys *` to get all the keys ![](.md/img/s4.redis.cli.keys.png)
* You can set & get attributes using key-value
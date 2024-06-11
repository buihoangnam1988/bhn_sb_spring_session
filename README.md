# Demystifying Spring Session
## Introduction
* Youtube: https://www.youtube.com/watch?v=k62bO-W6Sb0
* The program can run on VS Code by clicking play button when Application.java is being open ![](.md/img/s0.vscode.run.png)
* Update Maven project `mvn clean install -U` 
## Step by step
### Step 1: Temporarily disable Redis
You will see Spring Security default login page (http://localhost:8080/login)

![](.md/img/s01.no.redis.login.png)
### Step 2: How to used generated security password
* Get the generated security password from log: ![](.md/img/s2.gen.pwd.png)
* Login with `user/<generated_password>` ![](.md/img/s2.gen.pwd.login.png)
* See the home page ![](.md/img/s2.logged.in.png)

Further discussion:
* After logged in, we get a JSESSIONID in Cookies ![](.md/img/s2.jsid.cookie.png)
* This session is not deleted when you access /logout + confirm, it changes to another value instead
* This session will change if you access /login and log in again

Problem:
* If you restart the server, the new server does not know your session id
* If you scale up the system, add more server and connect to them through load balancer, the randomly new server does not know your session id
* This is where Spring Session comes in
### Step 3: Add Redis && Add docker-compose.yml to support redis
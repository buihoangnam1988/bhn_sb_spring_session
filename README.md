# Demystifying Spring Session
## Introduction
* Youtube: https://www.youtube.com/watch?v=k62bO-W6Sb0
* The program can run on VS Code by clicking play button when Application.java is being open ![](.md/img/s0.vscode.run.png)
## Step by step
### Step 1: Temporarily disable Redis
You will see Spring Security default login page (http://localhost:8080/login)

![](.md/img/s01.no.redis.login.png)
### Step 2: How to used generated security password
* Get the generated security password from log: ![](.md/img/s2.gen.pwd.png)
* Login with `user/<generated_password>` ![](.md/img/s2.gen.pwd.login.png)
* See the home page ![](.md/img/s2.logged.in.png)
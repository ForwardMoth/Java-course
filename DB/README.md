## Connection and setting database in Java


### 1. Go to psql console
```bash
sudo -u postgres psql
``` 

### 2. Create user with password
```psql
CREATE ROLE "java" WITH LOGIN PASSWORD '1111';
```

### 3. Create database
```psql
create database javadb;
```

### 4. Get privileges on database
```psql 
grant all privileges on database javadb to "java";
```

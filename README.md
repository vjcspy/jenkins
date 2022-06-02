# Personal Jenkins Configurations

## Integrate Jenkins and docker

### Option 1:

```yaml
version: "3.7"

services:
  jenkins:
    image: jenkins/jenkins:lts
    user: root
    container_name: jenkins
    ports:
      - 8080:8080
      - 50000:50000
    volumes:
      - ./jenkins:/var/jenkins_home
      - /usr/bin/docker:/usr/bin/docker
      - /var/run/docker.sock:/var/run/docker.sock
```

Cách này đơn giản, dễ hiểu. Tuy nhiên trên macos không mount được `/usr/bin/docker` vào container. Từ đó mac phải sử dụng option2

### Option2

```dockerfile
FROM jenkins/jenkins:lts
USER root

RUN mkdir -p /tmp/download && \
 curl -L https://download.docker.com/linux/static/stable/x86_64/docker-18.03.1-ce.tgz | tar -xz -C /tmp/download && \
 rm -rf /tmp/download/docker/dockerd && \
 mv /tmp/download/docker/docker* /usr/local/bin/ && \
 rm -rf /tmp/download && \
 groupadd -g 999 docker && \
 usermod -aG staff,docker jenkins

USER jenkins
```

Lưu ý line 9 là tạo group mới thì check lại trên host xem docker group là bao nhiêu. Bằng cách

`cat /etc/group | grep docker`


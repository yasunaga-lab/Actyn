### Prepare ansible on Mac
```sh
brew install ansible
brew install hudochenkov/sshpass/sshpass
```

### Deployment
#### Run shell script
```sh
cd Actyn
./deployment.sh
```

#### Run ansible playbook
```sh
cd ansible
ansible-playbook -i inventory/actyn_hosts -k actyn-playbook.yml
```

#### future
Ansible current user is root, but replace with exclusive　Actyn user on web server.
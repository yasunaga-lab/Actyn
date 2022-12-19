### Ansible version
ansible [core 2.13.6]
  config file = None
  configured module search path = ['/Users/honda/.ansible/plugins/modules', '/usr/share/ansible/plugins/modules']
  ansible python module location = /usr/local/Cellar/ansible/6.6.0/libexec/lib/python3.10/site-packages/ansible
  ansible collection location = /Users/honda/.ansible/collections:/usr/share/ansible/collections
  executable location = /usr/local/bin/ansible
  python version = 3.10.8 (main, Oct 13 2022, 10:17:43) [Clang 14.0.0 (clang-1400.0.29.102)]
  jinja version = 3.1.2
  libyaml = True


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
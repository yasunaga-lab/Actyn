
# build client
cd yacm_cl
rm -rf .angular
ng build --base-href=/ --configuration=production

# copy client to webserver
cd ../
rm -rf yacm_ws/src/main/resources/static/*
mv yacm_cl/dist/yacm_cl/* yacm_ws/src/main/resources/static/

# build actyn web server
cd yacm_ws/
./mvnw package -DskipTests=true
cd ../

# build actyn ldap node server
cd yacm_ws_ldap/
./mvnw package -DskipTests=true
cd ../

# deployment by ansible toward each server.
ansible-playbook -i inventory/actyn_hosts -k actyn-playbook.yml

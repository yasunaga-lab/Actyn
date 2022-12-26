
# build client
cd yacm_cl
rm -rf .angular
ng build --base-href=/ --configuration=production

# copy client to webserver
cd ../
rm -rf yacm_ws/src/main/resources/static/*
cp -R yacm_cl/dist/yacm_cl/* yacm_ws/src/main/resources/static/

# build actyn web server
cd yacm_ws/
./mvnw package -DskipTests=true
cd ../

# build actyn ldap node server
cd yacm_ws_ldap/
./mvnw package -DskipTests=true
cd ../

# deployment by ansible toward each server.
echo ""
echo "### Password for deployment by ansible is \"easy password (from k)\". ###"
ansible-playbook -i ansible/inventory/actyn_hosts.yml -e @ansible/inventory/actyn_vault.yml ansible/actyn-playbook.yml --ask-vault-pass

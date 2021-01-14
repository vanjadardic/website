#!/bin/bash

# this script will be called from SSH session, this is an easy way to get client's IP address
remote_ip=$(echo $SSH_CLIENT | cut -d' ' -f1)
tmp_file=$(mktemp /tmp/etc-hosts.XXXXXX)

hosts_count=$(wc -l /etc/hosts | cut -d' ' -f1)
sed "s/.*\sbackend.dardic.net$/${remote_ip}\tbackend.dardic.net/" /etc/hosts > "${tmp_file}"
new_hosts_count=$(wc -l ${tmp_file} | cut -d' ' -f1)
if [ "${hosts_count}" == "${new_hosts_count}" ]; then
  cat "${tmp_file}" > /etc/hosts
  echo "OK"
else
  echo "Error"
fi

rm "${tmp_file}"

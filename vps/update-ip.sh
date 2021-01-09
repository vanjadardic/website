#!/bin/bash

# this script will be called from SSH session, this is an easy way to get client's IP address
remote_ip=$(echo $SSH_CLIENT | cut -d' ' -f1)
tmp_file=$(mktemp /tmp/etc-hosts.XXXXXX)

sed "s/.*\sbackend.dardic.net$/${remote_ip}\tbackend.dardic.net/" /etc/hosts > "${tmp_file}"
cat "${tmp_file}" > /etc/hosts
rm "${tmp_file}"

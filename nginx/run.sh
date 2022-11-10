#!/bin/bash

cp ./*.conf /etc/nginx/conf.d/
nginx -t && nginx -s reload

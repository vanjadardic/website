# Setup

Change default SSH port.

Set timezone to UTC.

Install docker and docker-compose.

Set sshconfig.

Set crontab. Create sshpass.txt file.

Set CERTBOT_EMAIL env. variable.

# Run

Setup taken from: https://medium.com/@pentacent/nginx-and-lets-encrypt-with-docker-in-less-than-5-minutes-b4b8a60d3a71.

When running for the first time:

`sh init-letsencrypt.sh`

For subsequent runs/restarts:

`docker-compose build && docker-compose down && docker-compose up -d`

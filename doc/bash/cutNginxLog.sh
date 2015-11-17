#!/bin/sh

time=$(date -d"1 days ago"  "+%Y-%m-%d")

cd /usr/local/nginx/logs/
ls *.access.log|xargs -I{} mv {} {}.$time
kill -USR1 $(cat /usr/local/nginx/logs/nginx.pid)
exit 0

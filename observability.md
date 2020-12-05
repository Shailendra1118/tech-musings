## Install grafana 
```
docker run -d -p 3000:3000 grafana/grafana
```

## Install prometheus
```
docker run -d --name=prometheus -p 9090:9090 -v /Users/shailendra.yadav/Documents/workspace/project/prometheus.yml:/etc/prometheus/prometheus.yml prom/prometheus --config.file=/etc/prometheus/prometheus.yml
```

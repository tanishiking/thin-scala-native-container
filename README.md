```sh
$ docker build -t thinscalanative .

$ docker image inspect thinscalanative | jq '.[0].Size'
1451396

$ time docker run --rm -it thinscalanative
Hello world!
docker run --rm -it thinscalanative  0.02s user 0.01s system 5% cpu 0.589 total
```

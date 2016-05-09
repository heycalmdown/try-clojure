# try-clojure

## Docker로 개발 환경 만들기

```bash
$ docker run -it --rm -v "$PWD":/usr/src/app -w /usr/src/app clojure lein new clj-helloworld
$ cd clj-helloworld
$ vi project.clj
$ vi src/clj_helloworld/core.clj
$ docker run -it --rm -v "$PWD":/usr/src/app -w /usr/src/app clojure lein run
```

이렇게 하면 개발 환경 만들기 쉽다.


## Docker와 Atom과 nREPL

```bash
$ docker run -it --rm -p 12345:12345 clojure lein repl :headless :host 0.0.0.0 :port 12345
```

Atom에서 [proto-repl](https://atom.io/packages/proto-repl)을 설치한다. Remote Nrepl Connection 설정을 해준다.

# cljs-todo

Simple todo app used in educational purposes.

## Prerequisites

* Install [Leiningen](http://leiningen.org/#install)

* You need java runtime installed: `sudo apt-get install default-jre`

## Setup

To get an interactive development environment run:

    lein figwheel dev

and open your browser at [localhost:3449](http://localhost:3449/).
This will auto compile and send all changes to the browser without the
need to reload. After the compilation process is complete, you will
get a Browser Connected REPL. An easy way to try it is:

    (js/alert "Am I connected?")

and you should see an alert in the browser window.

To clean all compiled files:

    lein clean

To create a production build run:

    lein do clean, cljsbuild once min

And open your browser in `resources/public/index.html`. You will not
get live reloading, nor a REPL.

## Nginx + SSL

In order to make it work with SSL you have to enable secure websockets support:

    location / {
        # WebSocket support
		proxy_http_version 1.1;
		proxy_set_header Upgrade $http_upgrade;
		proxy_set_header Connection "upgrade";
		if (!-f $request_filename) {
		  proxy_pass http://127.0.0.1:3449;
		  break;
		}
	}


## License

Copyright ©2016 Nikolay Konovalov

Distributed under the Eclipse Public License version 1.0.

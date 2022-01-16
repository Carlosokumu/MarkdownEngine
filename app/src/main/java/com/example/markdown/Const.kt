package com.example.markdown

object Const {


    const val  MD_SAMPLE = "# Solution to  Junior  Developer role -Http server\n" +
            "\n" +
            "\n" +
            "Writing an Http Server  in Golang.\n" +
            "\n" +
            "\n" +
            "The server serves like below:\n" +
            "\n" +
            "\n" +
            "![Server Demo](demo/tcpwalk.gif)\n" +
            "\n" +
            "\n" +
            "**Background**\n" +
            "\n" +
            "     Design a basic HTTP web-server application which can listen on a configurable TCP port and serve both static HTML and \n" +
            "     dynamically generated HTML by means of a chosen programming language, such as in the way Apache uses PHP. \n" +
            "     It is acceptable for this server application to support only a restricted subset of HTTP, such as GET or POST requests, \n" +
            "     and the only headers it must support are Content-Type and Content-Length.\n" +
            "\n" +
            "**Prerequisite**\n" +
            "\n" +
            "You need to have the following to run the server in your machine:\n" +
            "- A basic Understanding of [Golang](https://go.dev/) and how to set up your [Go workspace.](https://go.dev/doc/gopath_code)\n" +
            "- Go installed in your machine\n" +
            "\n" +
            "\n" +
            "**Environment Setup**\n" +
            "\n" +
            "To ensure you have all the dependencies needed to run the application,run the following command\n" +
            "from the root folder of the project\n" +
            "\n" +
            "        go mod tidy\n" +
            "\n" +
            " ## Building an Http Web server on a configurable tcp port  \n" +
            " The server is basically started by running the command `go run main.go port`\n" +
            "\n" +
            " > Port here is a valid port number where the tcp server will listen to connections made.\n" +
            "\n" +
            " Once the client makes the connection to the right port,the http server starts serving \n" +
            " the required static html and dynamically generated html.\n" +
            "\n" +
            " A  [mux router](https://github.com/gorilla/mux) is encoded by the client then decoded by the connection handler then used to handle different requests.  \n" +
            " \n" +
            "        > Client\n" +
            "        func Client(port string) {\n" +
            "\n" +
            "\t        c, err := net.Dial(\"tcp\", port)\n" +
            "\n" +
            "\t        if err != nil {\n" +
            "\t\t      fmt.Println(err)\n" +
            "\t\t      fmt.Println(\"Here now\")\n" +
            "\n" +
            "\t     }\n" +
            "\n" +
            "\t     //Inialize an instance of the Mux Router and encode it as A pointer\n" +
            "\t      r := mux.NewRouter()\n" +
            "\t     gob.NewEncoder(c).Encode(*r)\n" +
            "\t     c.Close()\n" +
            "\n" +
            "        }\n" +
            "\n" +
            "        > Handler\n" +
            "        func HandleServerConnection(c net.Conn) {\n" +
            "\n" +
            "\t        var r *mux.Router\n" +
            "\t        err := gob.NewDecoder(c).Decode(&r)\n" +
            "\n" +
            "\t        if err != nil {\n" +
            "\t\t         fmt.Println(err)\n" +
            "\t        } else {\n" +
            "\n" +
            "\t\t        //Static file(s) configuration\n" +
            "\t\t        staticFileDirectory := http.Dir(\"./assets/\")\n" +
            "\t\t        staticFileHandler := http.StripPrefix(\"/assets/\", http.FileServer(staticFileDirectory))\n" +
            "\n" +
            "\t\t        //Get requests\n" +
            "\t\t        r.PathPrefix(\"/assets/\").Handler(staticFileHandler).Methods(\"GET\")\n" +
            "\t\t        r.HandleFunc(\"/bird\", GetConfirmation).Methods(\"GET\")\n" +
            "\n" +
            "\t\t        //Server Configurations\n" +
            "\t\t         srv := &http.Server{\n" +
            "\t\t\t        Handler:      r,\n" +
            "\t\t\t        Addr:         \"127.0.0.1:8000\",\n" +
            "\t\t\t        WriteTimeout: 15 * time.Second,\n" +
            "\t\t\t        ReadTimeout:  15 * time.Second,\n" +
            "\t\t    }\n" +
            "\n" +
            "\t\t  //Securing the server with a self-Signed Certificate\n" +
            "\t\t   srv.ListenAndServeTLS(\"go-server.crt\", \"go-server.key\")\n" +
            "\t        }\n" +
            "\t         c.Close()\n" +
            "\n" +
            "          }\n" +
            "\n" +
            "## Securing your Http Server with a self signed Certificate\n" +
            "Use the openssl command below to create a private key (go-server.key) and a self-signed certificate (go-server.crt) valid for 365 days with a key size of 2,048 bits.\n" +
            "Please note that this should be run from the root directory of the project.\n" +
            "\n" +
            "       openssl req -x509 -nodes -days 365 -newkey rsa:2048 -keyout go-server.key -out go-server.crt\n" +
            "\n" +
            "\n" +
            "Depending on your organization name and current location, respond to each question appropriately. Make sure you've provided the correct public IP address or domain name when prompted to enter.\n" +
            "\n" +
            "If everything went well,you should now see the `go-server.crt` and `go-server.key` files on the file list in your project.\n" +
            "\n" +
            "Now visiting the server without a secure connection,you should see the message on your browser as below:\n" +
            "\n" +
            "![Http Exception](demo/httpserr.PNG)"
}
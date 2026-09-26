# Low Latency Architecture
`status: work-in-progress`

An in-memory storage for fast data access with caching, built in Java with a custom TCP protocol. 
Supports string key-value operations.

<sub> Note: Due to being written in Java, this might be slower than other programs similarly written in low-level 
languages which have direct access to the OS, such as C. Java runs on the JVM which takes longer due to overhead, 
and would usually take longer to compile. This is only by a slight scale however, with millisecond differences 
with its latency. </sub>

## Features
- [ ] In-memory key-value storage for fast data access
- [ ] Supports string values (`SET`, `GET`, `DEL`)
- [x] Custom TCP protocol for client-server communication
- [x] Simple client and server architecture (separate programs)
- [x] Line-based command parsing using buffered I/O
- [ ] Multi-client support (concurrent connections)
- [ ] Key expiration (TTL)
- [ ] Additional data types (lists, hashes, sets)
- [ ] Persistence (save/reload from disk)
- [ ] Improved error handling for malformed commands

## Current project structure
```
├── TCPechoServer/
│   └── src/
│       └── tcpClient/
│           └── Client.java
└── TCPechoHost/
    └── src/
        └── tcpServer/
            └── Server.java
```

## TCP client-server communication
- `Server.java` goes through ServerSocket while `Client.java` runs with a Socket for port connection.
  Uses buffers (BufferedReader and BufferedWriter) for faster access to the string input.
- **Testing:** Simply rerun the Client class. For the server, re-running may require to kill the existing port. Run
  `kill -9 $(lsof -t -i :<port>)` on bash to restart.
   [Or simply run this script.](https://github.com/bearbau/bearbash/blob/main/portkiller.sh)
  
![tcp](https://imglink.cc/cdn/AqO4BgXykm.png)
